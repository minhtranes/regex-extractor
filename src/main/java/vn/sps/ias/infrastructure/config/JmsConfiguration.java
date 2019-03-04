package vn.sps.ias.infrastructure.config;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQConnectionFactoryCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.jms.JmsInboundGateway;
import org.springframework.integration.jms.dsl.Jms;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.messaging.MessageChannel;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import vn.sps.ias.constant.Channels;
import vn.sps.ias.domain.Request;
import vn.sps.ias.infrastructure.properties.DetailJmsProperties;
import vn.sps.ias.infrastructure.properties.DetailJmsProperties.Listener;
import vn.sps.ias.infrastructure.properties.DetailJmsProperties.Template;

/**
 * The Class JmsConfiguration.
 */
@Configuration
public class JmsConfiguration {

    /**
     * Listener container properties.
     *
     * @return the listener container properties
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.jms")
    DetailJmsProperties listenerContainerProperties() {
        return new DetailJmsProperties();
    }

    /**
     * Processing input channel.
     *
     * @return the message channel
     */
    @Bean(Channels.INPUT_CHANNEL)
    MessageChannel processingInputChannel() {
        return new DirectChannel();
    }

    /**
     * Processing output channel.
     *
     * @return the message channel
     */
    @Bean(Channels.OUTPUT_CHANNEL)
    MessageChannel processingOutputChannel() {
        return new DirectChannel();
    }

    /**
     * Jms message listener container.
     *
     * @param connectionFactory the connection factory
     * @param properties the properties
     * @return the abstract message listener container
     */
    @Bean("jms-message-listener")
    DefaultMessageListenerContainer jmsMessageListenerContainer(
        ConnectionFactory connectionFactory,
        DetailJmsProperties properties) {
        final Listener listener = properties.getListener();
        return Jms
            .container(connectionFactory, listener.getDestination())
            .concurrentConsumers(listener.getConcurrency())
            .maxConcurrentConsumers(listener.getMaxConcurrency())
            .maxMessagesPerTask(listener.getMaxMessagesPerTask())
            .idleConsumerLimit(listener.getIdleConsumerLimit())
            .idleTaskExecutionLimit(listener.getIdleTaskExecutionLimit())
            .receiveTimeout(listener.getReceiveTimeout())
            .sessionTransacted(listener.isSessionTransacted())
            .sessionAcknowledgeModeName(listener.getAcknowledgeModeName())
            .get();
    }

    /**
     * JMS in-bound gateway.
     *
     * @param errorChannel                the error channel
     * @param jmsMessageListenerContainer the JMS message listener container
     * @param properties                  the properties
     * @return the JMS in-bound gateway
     */
    @Bean
    JmsInboundGateway jmsInboundGateway(
        MessageChannel errorChannel,
        DefaultMessageListenerContainer jmsMessageListenerContainer,
        DetailJmsProperties properties) {

        final Listener listener = properties.getListener();
        final Template template = properties.getTemplate();

        return Jms
            .inboundGateway(jmsMessageListenerContainer)
            .replyTimeout(listener.getReplyTimeout())
            .requestChannel(processingInputChannel())
            .replyChannel(processingOutputChannel())
            .defaultReplyQueueName(template.getDefaultQueueName())
            .jmsMessageConverter(json2MessageConverter())
            .errorChannel(errorChannel)
            .get();
    }

    @Bean
    public MessageConverter json2MessageConverter() {
        final ObjectMapper objectMapper = new ObjectMapper();
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter() {
            @Override
            protected JavaType getJavaTypeForMessage(Message message) throws JMSException {
                return objectMapper.getTypeFactory().constructType(Request.class);
            }
        };

        converter.setObjectMapper(objectMapper);
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName(JmsHeaders.TYPE);

        return converter;
    }

    @Configuration
    static class ConnectionFactoryCustomizer implements ActiveMQConnectionFactoryCustomizer {

        /**
         * ActiveMQ re-delivery policy.
         *
         * @return the re-delivery policy
         */
        @Bean
        @ConfigurationProperties(prefix = "activemq.redelivery")
        RedeliveryPolicy activemqRedeliveryPolicy() {
            return new RedeliveryPolicy();
        }

        /**
         * {@inheritDoc}
         * 
         * @see org.springframework.boot.autoconfigure.jms.activemq.ActiveMQConnectionFactoryCustomizer#customize(org.apache.activemq.ActiveMQConnectionFactory)
         */
        @Override
        public void customize(ActiveMQConnectionFactory factory) {
            factory.setRedeliveryPolicy(activemqRedeliveryPolicy());
        }

    }
}

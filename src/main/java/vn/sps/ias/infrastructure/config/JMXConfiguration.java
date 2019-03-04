package vn.sps.ias.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import vn.sps.ias.infrastructure.jmx.MessageListenerContainerJMX;
import vn.sps.ias.infrastructure.jmx.ThreadPoolTaskExecutorJMX;
import vn.sps.ias.infrastructure.jmx.ThreadPoolTaskExecutorJMXMBean;

//@Configuration
//@EnableMBeanExport
public class JMXConfiguration {
    
    /**
     * JMS message listener container control.
     *
     * @param jmsMessageListenerContainer the JMS message listener container
     * @return the JMS message listener container control
     */
    @Bean("JmsMessageListenerContainer")
    MessageListenerContainerJMX jmsMessageListenerContainerJMX(
        DefaultMessageListenerContainer jmsMessageListenerContainer) {
        return new MessageListenerContainerJMX(jmsMessageListenerContainer);
    }

    @Bean("FileServiceThreadPoolTaskExecutorJMX")
    ThreadPoolTaskExecutorJMXMBean fileServiceExecutorJMX(ThreadPoolTaskExecutor fileServiceExecutor) {
        return new ThreadPoolTaskExecutorJMX(fileServiceExecutor);
    }
}

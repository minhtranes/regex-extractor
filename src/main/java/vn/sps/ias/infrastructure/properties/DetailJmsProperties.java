package vn.sps.ias.infrastructure.properties;

import javax.jms.Session;

import org.springframework.boot.autoconfigure.jms.JmsProperties.DeliveryMode;
import org.springframework.core.Constants;

/**
 * The Class ListenerContainerProperties.
 */
public class DetailJmsProperties {

    /**
     * The Class Listener.
     */
    public static class Listener {
        /** The acknowledge mode name. */
        private String acknowledgeModeName;

        /** The auto startup. */
        private boolean autoStartup;

        /** The bean name. */
        private String beanName;

        /** The concurrency. */
        private int concurrency;

        /** The destination. */
        private String destination;

        /** The idle consumer limit. */
        private int idleConsumerLimit;

        /** The idle task execution limit. */
        private int idleTaskExecutionLimit;

        /** The max concurrency. */
        private int maxConcurrency;

        /** The max messages per task. */
        private int maxMessagesPerTask;

        /** The receive timeout. */
        private long receiveTimeout;

        /** The recovery interval. */
        private long recoveryInterval;

        /** The reply timeout. */
        private long replyTimeout;

        /** The session transacted. */
        private boolean sessionTransacted;

        /**
         * Gets the acknowledge mode name.
         * <p>
         * This is also the value of <code>JmsProperties.acknowledgeMode</code>
         * <br>
         * Default value: <code>AUTO_ACKNOWLEDGE</code>
         *
         * @return the acknowledge mode name
         */
        public String getAcknowledgeModeName() {
            return this.acknowledgeModeName;
        }

        /**
         * Gets the bean name.
         *
         * @return the bean name
         */
        public String getBeanName() {
            return this.beanName;
        }

        /**
         * Gets the concurrency.
         *
         * @return the concurrency
         */
        public int getConcurrency() {
            return this.concurrency;
        }

        /**
         * Gets the destination.
         *
         * @return the destination
         */
        public String getDestination() {
            return this.destination;
        }

        /**
         * Gets the idle consumer limit.
         *
         * @return the idle consumer limit
         */
        public int getIdleConsumerLimit() {
            return this.idleConsumerLimit;
        }

        /**
         * Gets the idle task execution limit.
         *
         * @return the idle task execution limit
         */
        public int getIdleTaskExecutionLimit() {
            return this.idleTaskExecutionLimit;
        }

        /**
         * Gets the max concurrency.
         *
         * @return the max concurrency
         */
        public int getMaxConcurrency() {
            return this.maxConcurrency;
        }

        /**
         * Gets the max messages per task.
         *
         * @return the max messages per task
         */
        public int getMaxMessagesPerTask() {
            return this.maxMessagesPerTask;
        }

        /**
         * Gets the receive timeout.
         *
         * @return the receive timeout
         */
        public long getReceiveTimeout() {
            return this.receiveTimeout;
        }

        /**
         * Gets the recovery interval.
         *
         * @return the recovery interval
         */
        public long getRecoveryInterval() {
            return this.recoveryInterval;
        }

        /**
         * Gets the reply timeout.
         *
         * @return the reply timeout
         */
        public long getReplyTimeout() {
            return this.replyTimeout;
        }

        /**
         * Checks if is auto startup.
         *
         * @return true, if is auto startup
         */
        public boolean isAutoStartup() {
            return this.autoStartup;
        }

        /**
         * Checks if is session transacted.
         *
         * @return true, if is session transacted
         */
        public boolean isSessionTransacted() {
            return this.sessionTransacted;
        }

        /**
         * Sets the acknowledge mode name.
         * <p>
         * The value of this should be one in <code>javax.jms.Session</code>
         *
         * @param acknowledgeModeName the new acknowledge mode name
         */
        public void setAcknowledgeModeName(final String acknowledgeModeName) {
            final Constants constants = new Constants(Session.class);
            constants.asNumber(acknowledgeModeName);
            this.acknowledgeModeName = acknowledgeModeName;
        }

        /**
         * Sets the auto startup.
         *
         * @param autoStartup the new auto startup
         */
        public void setAutoStartup(final boolean autoStartup) {
            this.autoStartup = autoStartup;
        }

        /**
         * Sets the bean name.
         *
         * @param beanName the new bean name
         */
        public void setBeanName(final String beanName) {
            this.beanName = beanName;
        }

        /**
         * Sets the concurrency.
         *
         * @param concurrency the new concurrency
         */
        public void setConcurrency(final int concurrency) {
            this.concurrency = concurrency;
        }

        /**
         * Sets the destination.
         *
         * @param destination the new destination
         */
        public void setDestination(final String destination) {
            this.destination = destination;
        }

        /**
         * Sets the idle consumer limit.
         *
         * @param idleConsumerLimit the new idle consumer limit
         */
        public void setIdleConsumerLimit(final int idleConsumerLimit) {
            this.idleConsumerLimit = idleConsumerLimit;
        }

        /**
         * Sets the idle task execution limit.
         *
         * @param idleTaskExecutionLimit the new idle task execution limit
         */
        public void setIdleTaskExecutionLimit(final int idleTaskExecutionLimit) {
            this.idleTaskExecutionLimit = idleTaskExecutionLimit;
        }

        /**
         * Sets the max concurrency.
         *
         * @param maxConcurrency the new max concurrency
         */
        public void setMaxConcurrency(final int maxConcurrency) {
            this.maxConcurrency = maxConcurrency;
        }

        /**
         * Sets the max messages per task.
         *
         * @param maxMessagesPerTask the new max messages per task
         */
        public void setMaxMessagesPerTask(final int maxMessagesPerTask) {
            this.maxMessagesPerTask = maxMessagesPerTask;
        }

        /**
         * Sets the receive timeout.
         *
         * @param receiveTimeout the new receive timeout
         */
        public void setReceiveTimeout(final long receiveTimeout) {
            this.receiveTimeout = receiveTimeout;
        }

        /**
         * Sets the recovery interval.
         *
         * @param recoveryInterval the new recovery interval
         */
        public void setRecoveryInterval(final long recoveryInterval) {
            this.recoveryInterval = recoveryInterval;
        }

        /**
         * Sets the reply timeout.
         *
         * @param replyTimeout the new reply timeout
         */
        public void setReplyTimeout(final long replyTimeout) {
            this.replyTimeout = replyTimeout;
        }

        /**
         * Sets the session transacted.
         *
         * @param sessionTransacted the new session transacted
         */
        public void setSessionTransacted(final boolean sessionTransacted) {
            this.sessionTransacted = sessionTransacted;
        }
    }

    /**
     * The Class Template.
     */
    public static class Template {

        /**
         * Default destination to use on send/receive operations that do not have a
         * destination parameter.
         */
        private String defaultDestination;

        private String defaultQueueName;

        /**
         * Delivery delay to use for send calls in milliseconds.
         */
        private Long deliveryDelay;

        /**
         * Delivery mode. Enable QoS when set.
         */
        private DeliveryMode deliveryMode;

        /**
         * Priority of a message when sending. Enable QoS when set.
         */
        private Integer priority;

        /**
         * Enable explicit QoS when sending a message. When enabled, the delivery mode,
         * priority and time-to-live properties will be used when sending a message. QoS
         * is automatically enabled when at least one of those settings is customized.
         */
        private Boolean qosEnabled;

        /**
         * Timeout to use for receive calls in milliseconds.
         */
        private Long receiveTimeout;

        /**
         * Time-to-live of a message when sending in milliseconds. Enable QoS when set.
         */
        private Long timeToLive;

        /**
         * Determine qos enabled.
         *
         * @return true, if successful
         */
        public boolean determineQosEnabled() {
            if (this.qosEnabled != null) {
                return this.qosEnabled;
            }
            return ((this.getDeliveryMode() != null) || (this.getPriority() != null) || (this.getTimeToLive() != null));
        }

        /**
         * Gets the default destination.
         *
         * @return the default destination
         */
        public String getDefaultDestination() {
            return this.defaultDestination;
        }

        public String getDefaultQueueName() {
            return this.defaultQueueName;
        }

        /**
         * Gets the delivery delay.
         *
         * @return the delivery delay
         */
        public Long getDeliveryDelay() {
            return this.deliveryDelay;
        }

        /**
         * Gets the delivery mode.
         *
         * @return the delivery mode
         */
        public DeliveryMode getDeliveryMode() {
            return this.deliveryMode;
        }

        /**
         * Gets the priority.
         *
         * @return the priority
         */
        public Integer getPriority() {
            return this.priority;
        }

        /**
         * Gets the qos enabled.
         *
         * @return the qos enabled
         */
        public Boolean getQosEnabled() {
            return this.qosEnabled;
        }

        /**
         * Gets the receive timeout.
         *
         * @return the receive timeout
         */
        public Long getReceiveTimeout() {
            return this.receiveTimeout;
        }

        /**
         * Gets the time to live.
         *
         * @return the time to live
         */
        public Long getTimeToLive() {
            return this.timeToLive;
        }

        /**
         * Sets the default destination.
         *
         * @param defaultDestination the new default destination
         */
        public void setDefaultDestination(final String defaultDestination) {
            this.defaultDestination = defaultDestination;
        }

        public void setDefaultQueueName(final String defaultQueueName) {
            this.defaultQueueName = defaultQueueName;
        }

        /**
         * Sets the delivery delay.
         *
         * @param deliveryDelay the new delivery delay
         */
        public void setDeliveryDelay(final Long deliveryDelay) {
            this.deliveryDelay = deliveryDelay;
        }

        /**
         * Sets the delivery mode.
         *
         * @param deliveryMode the new delivery mode
         */
        public void setDeliveryMode(final DeliveryMode deliveryMode) {
            this.deliveryMode = deliveryMode;
        }

        /**
         * Sets the priority.
         *
         * @param priority the new priority
         */
        public void setPriority(final Integer priority) {
            this.priority = priority;
        }

        /**
         * Sets the qos enabled.
         *
         * @param qosEnabled the new qos enabled
         */
        public void setQosEnabled(final Boolean qosEnabled) {
            this.qosEnabled = qosEnabled;
        }

        /**
         * Sets the receive timeout.
         *
         * @param receiveTimeout the new receive timeout
         */
        public void setReceiveTimeout(final Long receiveTimeout) {
            this.receiveTimeout = receiveTimeout;
        }

        /**
         * Sets the time to live.
         *
         * @param timeToLive the new time to live
         */
        public void setTimeToLive(final Long timeToLive) {
            this.timeToLive = timeToLive;
        }

    }

    /** The listener. */
    private final Listener listener = new Listener();

    /** The template. */
    private final Template template = new Template();

    /**
     * Gets the listener.
     *
     * @return the listener
     */
    public Listener getListener() {
        return this.listener;
    }

    /**
     * Gets the template.
     *
     * @return the template
     */
    public Template getTemplate() {
        return this.template;
    }
}

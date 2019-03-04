package vn.sps.ias.infrastructure.jmx;

import org.springframework.jms.listener.DefaultMessageListenerContainer;

/**
 * The Class JmsMessageListenerContainerControl.
 */
public class MessageListenerContainerJMX implements MessageListenerContainerJMXMBean{

    /** The container. */
    private final DefaultMessageListenerContainer container;

    /**
     * Instantiates a new JMS message listener container control.
     *
     * @param container the container
     */
    public MessageListenerContainerJMX(final DefaultMessageListenerContainer container) {
        this.container = container;
    }

    /**
     * Gets the active consumer count.
     *
     * @return the active consumer count
     */
    public int getActiveConsumerCount() {
        return this.container.getActiveConsumerCount();
    }

    /**
     * Gets the concurrent consumers.
     *
     * @return the concurrent consumers
     */
    public int getConcurrentConsumers() {
        return this.container.getConcurrentConsumers();
    }

    /**
     * Gets the idle consumer limit.
     *
     * @return the idle consumer limit
     */
    public int getIdleConsumerLimit() {
        return this.container.getIdleConsumerLimit();
    }

    /**
     * Gets the idle task execution limit.
     *
     * @return the idle task execution limit
     */
    public int getIdleTaskExecutionLimit() {
        return this.container.getIdleTaskExecutionLimit();
    }

    /**
     * Gets the max concurrent consumers.
     *
     * @return the max concurrent consumers
     */
    public int getMaxConcurrentConsumers() {
        return this.container.getMaxConcurrentConsumers();
    }

    /**
     * Gets the max messages per task.
     *
     * @return the max messages per task
     */
    public int getMaxMessagesPerTask() {
        return this.container.getMaxMessagesPerTask();
    }

    /**
     * Gets the scheduled consumer count.
     *
     * @return the scheduled consumer count
     */
    public int getScheduledConsumerCount() {
        return this.container.getScheduledConsumerCount();
    }

    /**
     * Sets the max concurrent consumers.
     *
     * @param maxConcurrentConsumers the new max concurrent consumers
     */
    public void changeMaxConcurrentConsumers(final int maxConcurrentConsumers) {
        this.container.setMaxConcurrentConsumers(maxConcurrentConsumers);

    }

    /**
     * Sets the max messages per task.
     *
     * @param maxMessagesPerTask the new max messages per task
     */
    public void changeMaxMessagesPerTask(final int maxMessagesPerTask) {
        this.container.setMaxMessagesPerTask(maxMessagesPerTask);
    }
}

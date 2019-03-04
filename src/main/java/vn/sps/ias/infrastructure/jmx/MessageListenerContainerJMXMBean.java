package vn.sps.ias.infrastructure.jmx;

/**
 * The Interface MessageListenerContainerJMXMBean.
 */
public interface MessageListenerContainerJMXMBean {

    /**
     * Change max concurrent consumers.
     *
     * @param maxConcurrentConsumers the max concurrent consumers
     */
    void changeMaxConcurrentConsumers(int maxConcurrentConsumers);

    /**
     * Sets the max messages per task.
     *
     * @param maxMessagesPerTask the new max messages per task
     */
    void changeMaxMessagesPerTask(int maxMessagesPerTask);

    /**
     * Gets the concurrent consumers.
     *
     * @return the concurrent consumers
     */
    int getConcurrentConsumers();

    /**
     * Gets the max messages per task.
     *
     * @return the max messages per task
     */
    int getMaxMessagesPerTask();

    /**
     * Gets the idle consumer limit.
     *
     * @return the idle consumer limit
     */
    int getIdleConsumerLimit();

    /**
     * Gets the idle task execution limit.
     *
     * @return the idle task execution limit
     */
    int getIdleTaskExecutionLimit();

    /**
     * Gets the scheduled consumer count.
     *
     * @return the scheduled consumer count
     */
    int getScheduledConsumerCount();

    /**
     * Gets the active consumer count.
     *
     * @return the active consumer count
     */
    int getActiveConsumerCount();

    /**
     * Gets the max concurrent consumers.
     *
     * @return the max concurrent consumers
     */
    int getMaxConcurrentConsumers();
}

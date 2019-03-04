package vn.sps.ias.infrastructure.jmx;

/**
 * The interface Thread pool task executor jmxm bean.
 */
public interface ThreadPoolTaskExecutorJMXMBean {

    /**
     * Change keep alive.
     *
     * @param keepAliveSeconds the keep alive second
     */
    void changeKeepAliveTime(int keepAliveSeconds);

    /**
     * Change pool size.
     *
     * @param corePoolSize the core pool size
     * @param maxPoolSize  the max pool size
     */
    void changePoolSize(int corePoolSize, int maxPoolSize);

    /**
     * Gets the active count.
     *
     * @return the active count
     */
    int getActiveCount();

    /**
     * Gets the core pool size.
     *
     * @return the core pool size
     */
    int getCorePoolSize();

    /**
     * Gets the keep alive seconds.
     *
     * @return the keep alive seconds
     */
    int getKeepAliveSeconds();

    /**
     * Gets the max pool size.
     *
     * @return the max pool size
     */
    int getMaxPoolSize();

    /**
     * Gets the pool size.
     *
     * @return the pool size
     */
    int getPoolSize();

    /**
     * Gets the queueing count.
     *
     * @return the queueing count
     */
    int getQueueingCount();

    /**
     * Gets the thread name prefix.
     *
     * @return the thread name prefix
     */
    String getThreadNamePrefix();
}

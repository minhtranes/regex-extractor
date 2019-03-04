package vn.sps.ias.infrastructure.jmx;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ThreadPoolTaskExecutorJMX implements ThreadPoolTaskExecutorJMXMBean {

    /**
     * The executor.
     */
    private final ThreadPoolTaskExecutor executor;

    /**
     * Instantiates a new Abstract thread pool task executor jmx.
     *
     * @param executor the executor
     */
    public ThreadPoolTaskExecutorJMX(final ThreadPoolTaskExecutor executor) {
        this.executor = executor;
    }

    /**
     * {@inheritDoc}
     *
     * @see ThreadPoolTaskExecutorJMXMBean#changeKeepAliveTime(int)
     */
    @Override
    public void changeKeepAliveTime(final int keepAliveSeconds) {
        executor.setKeepAliveSeconds(keepAliveSeconds);
    }

    /**
     * {@inheritDoc}
     *
     * @see ThreadPoolTaskExecutorJMXMBean#changePoolSize(int, int)
     */
    @Override
    public void changePoolSize(final int corePoolSize, final int maxPoolSize) {
        if (corePoolSize <= maxPoolSize) {
            this.executor.setCorePoolSize(corePoolSize);
            this.executor.setMaxPoolSize(maxPoolSize);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see ThreadPoolTaskExecutorJMXMBean#getActiveCount()
     */
    @Override
    public int getActiveCount() {
        return this.executor.getActiveCount();
    }

    /**
     * {@inheritDoc}
     *
     * @see ThreadPoolTaskExecutorJMXMBean#getCorePoolSize()
     */
    @Override
    public int getCorePoolSize() {
        return this.executor.getCorePoolSize();
    }

    /**
     * {@inheritDoc}
     *
     * @see ThreadPoolTaskExecutorJMXMBean#getKeepAliveSeconds()
     */
    @Override
    public int getKeepAliveSeconds() {
        return this.executor.getKeepAliveSeconds();
    }

    /**
     * {@inheritDoc}
     *
     * @see ThreadPoolTaskExecutorJMXMBean#getMaxPoolSize()
     */
    @Override
    public int getMaxPoolSize() {
        return this.executor.getMaxPoolSize();
    }

    /**
     * {@inheritDoc}
     *
     * @see ThreadPoolTaskExecutorJMXMBean#getPoolSize()
     */
    @Override
    public int getPoolSize() {
        return this.executor.getPoolSize();
    }

    /**
     * {@inheritDoc}
     *
     * @see ThreadPoolTaskExecutorJMXMBean#getQueueingCount()
     */
    @Override
    public int getQueueingCount() {
        return this.executor.getThreadPoolExecutor().getQueue().size();
    }

    /**
     * {@inheritDoc}
     *
     * @see ThreadPoolTaskExecutorJMXMBean#getThreadNamePrefix()
     */
    @Override
    public String getThreadNamePrefix() {
        return this.executor.getThreadNamePrefix();
    }
}

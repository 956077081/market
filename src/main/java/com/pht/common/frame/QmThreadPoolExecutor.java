package com.pht.common.frame;

import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.*;


public class QmThreadPoolExecutor extends ThreadPoolTaskExecutor {
    public QmThreadPoolExecutor() {
        super();
    }

    @Override
    public void setCorePoolSize(int corePoolSize) {
        super.setCorePoolSize(corePoolSize);
    }

    @Override
    public int getCorePoolSize() {
        return super.getCorePoolSize();
    }

    @Override
    public void setMaxPoolSize(int maxPoolSize) {
        super.setMaxPoolSize(maxPoolSize);
    }

    @Override
    public int getMaxPoolSize() {
        return super.getMaxPoolSize();
    }

    @Override
    public void setKeepAliveSeconds(int keepAliveSeconds) {
        super.setKeepAliveSeconds(keepAliveSeconds);
    }

    @Override
    public int getKeepAliveSeconds() {
        return super.getKeepAliveSeconds();
    }

    @Override
    public void setQueueCapacity(int queueCapacity) {
        super.setQueueCapacity(queueCapacity);
    }

    @Override
    public void setAllowCoreThreadTimeOut(boolean allowCoreThreadTimeOut) {
        super.setAllowCoreThreadTimeOut(allowCoreThreadTimeOut);
    }

    @Override
    public void setTaskDecorator(TaskDecorator taskDecorator) {
        super.setTaskDecorator(taskDecorator);
    }

    @Override
    protected ExecutorService initializeExecutor(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return super.initializeExecutor(threadFactory, rejectedExecutionHandler);
    }

    @Override
    protected BlockingQueue<Runnable> createQueue(int queueCapacity) {
        return super.createQueue(queueCapacity);
    }

    @Override
    public ThreadPoolExecutor getThreadPoolExecutor() throws IllegalStateException {
        return super.getThreadPoolExecutor();
    }

    @Override
    public int getPoolSize() {
        return super.getPoolSize();
    }

    @Override
    public int getActiveCount() {
        return super.getActiveCount();
    }

    @Override
    public void execute(Runnable task) {
        super.execute(task);
    }

    @Override
    public void execute(Runnable task, long startTimeout) {
        super.execute(task, startTimeout);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(task);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return super.submit(task);
    }

    @Override
    public ListenableFuture<?> submitListenable(Runnable task) {
        return super.submitListenable(task);
    }

    @Override
    public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
        return super.submitListenable(task);
    }

    @Override
    protected void cancelRemainingTask(Runnable task) {
        super.cancelRemainingTask(task);
    }
}

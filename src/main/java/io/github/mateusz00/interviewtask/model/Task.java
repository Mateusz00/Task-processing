package io.github.mateusz00.interviewtask.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private final AtomicInteger progress;
    private final double base;
    private final double exponent;
    private volatile TaskStatus status;
    private volatile Double result;

    public Task(double base, double exponent) {
        this.progress = new AtomicInteger(0);
        this.base = base;
        this.exponent = exponent;
        this.status = TaskStatus.QUEUED;
    }

    public void run() {
        if (this.status == TaskStatus.RUNNING || this.status == TaskStatus.FINISHED) {
            return;
        }

        this.status = TaskStatus.RUNNING;
        this.progress.set(0);
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                this.status = TaskStatus.ABORTED;
                return;
            }
            progress.incrementAndGet();
        }
        this.result = Math.pow(base, exponent);
        this.status = TaskStatus.FINISHED;
    }

    public int getProgress() {
        return progress.get();
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Double getResult() {
        return result;
    }
}

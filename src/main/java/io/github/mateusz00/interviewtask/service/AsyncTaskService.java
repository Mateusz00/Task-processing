package io.github.mateusz00.interviewtask.service;

import io.github.mateusz00.interviewtask.dto.TaskInfo;
import io.github.mateusz00.interviewtask.model.Task;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AsyncTaskService implements TaskService {
    private final ConcurrentHashMap<Long, Task> taskConcurrentHashMap;
    private final AtomicLong idCounter;

    public AsyncTaskService() {
        this.taskConcurrentHashMap = new ConcurrentHashMap<>();
        this.idCounter = new AtomicLong(1L);
    }

    @Override
    public long createTask(double base, double exponent) {
        long newTaskId = idCounter.getAndIncrement();
        taskConcurrentHashMap.put(newTaskId, new Task(base, exponent));
        return newTaskId;
    }

    @Override
    @Async
    public void runTask(long id) {
        Task task = taskConcurrentHashMap.get(id);
        if (task != null) {
            task.run();
        }
    }

    @Override
    public Optional<TaskInfo> getTaskInfo(long id) {
        Task task = taskConcurrentHashMap.get(id);
        if (task == null) {
            return Optional.empty();
        }
        return Optional.of(new TaskInfo(id, task.getStatus(), task.getProgress(), task.getResult()));
    }

    @Override
    public List<TaskInfo> getAllTasksInfo() {
        return taskConcurrentHashMap.entrySet().stream().map(e -> {
            Task task = e.getValue();
            return new TaskInfo(e.getKey(), task.getStatus(), task.getProgress(), task.getResult());
        }).toList();
    }
}

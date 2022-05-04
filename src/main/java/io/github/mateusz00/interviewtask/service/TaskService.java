package io.github.mateusz00.interviewtask.service;

import io.github.mateusz00.interviewtask.dto.TaskInfo;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    long createTask(double base, double exponent);
    void runTask(long id);
    Optional<TaskInfo> getTaskInfo(long id);
    List<TaskInfo> getAllTasksInfo();
}

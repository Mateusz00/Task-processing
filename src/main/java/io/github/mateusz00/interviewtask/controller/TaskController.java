package io.github.mateusz00.interviewtask.controller;

import io.github.mateusz00.interviewtask.dto.TaskDto;
import io.github.mateusz00.interviewtask.dto.TaskInfo;
import io.github.mateusz00.interviewtask.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Long> createTask(@Valid @RequestBody TaskDto task) {
        long taskId = taskService.createTask(task.base(), task.exponent());
        taskService.runTask(taskId);
        return new ResponseEntity<>(taskId, HttpStatus.CREATED);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskInfo> getTask(@PathVariable Long id) {
        TaskInfo task = taskService.getTaskInfo(id).orElseThrow();
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskInfo>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasksInfo(), HttpStatus.OK);
    }
}

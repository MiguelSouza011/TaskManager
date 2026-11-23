package io.miguelsouza.taskmanager.application;

import io.miguelsouza.taskmanager.domain.TaskId;
import io.miguelsouza.taskmanager.domain.TaskNotFoundException;
import io.miguelsouza.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskUseCase {
    private final TaskRepository repository;

    public DeleteTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public void execute(TaskId taskId) {
        if (repository.findById(taskId).isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }

        repository.delete(taskId);
    }
}

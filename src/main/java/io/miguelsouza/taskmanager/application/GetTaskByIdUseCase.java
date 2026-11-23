package io.miguelsouza.taskmanager.application;

import io.miguelsouza.taskmanager.application.output.TaskOutput;
import io.miguelsouza.taskmanager.domain.TaskId;
import io.miguelsouza.taskmanager.domain.TaskNotFoundException;
import io.miguelsouza.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id) {
        return repository.findById(id).map(TaskOutput::from).orElseThrow(() -> new TaskNotFoundException(id));
    }
}

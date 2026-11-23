package io.miguelsouza.taskmanager.application;

import io.miguelsouza.taskmanager.application.input.UpdateTaskInput;
import io.miguelsouza.taskmanager.application.output.TaskOutput;
import io.miguelsouza.taskmanager.domain.TaskId;
import io.miguelsouza.taskmanager.domain.TaskNotFoundException;
import io.miguelsouza.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id, UpdateTaskInput input) {
        var task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        task.update(input.title(), input.description(), input.status());
        var updated = repository.save(task);
        return TaskOutput.from(updated);
    }
}

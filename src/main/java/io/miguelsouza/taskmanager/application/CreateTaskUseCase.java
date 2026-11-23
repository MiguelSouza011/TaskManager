package io.miguelsouza.taskmanager.application;

import io.miguelsouza.taskmanager.application.input.CreateTaskInput;
import io.miguelsouza.taskmanager.application.output.TaskOutput;
import io.miguelsouza.taskmanager.domain.Task;
import io.miguelsouza.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {
    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input) {
        var task = new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutput.from(saved);
    }
}

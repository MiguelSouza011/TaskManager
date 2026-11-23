package io.miguelsouza.taskmanager.infrastructure.http.request;

import io.miguelsouza.taskmanager.application.input.UpdateTaskInput;
import io.miguelsouza.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskRequest(
        Optional<String> title,
        Optional<String> description,
        Optional<String> status
) {
    public UpdateTaskInput toInput() {
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));
    }
}

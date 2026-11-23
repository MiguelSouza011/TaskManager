package io.miguelsouza.taskmanager.infrastructure.repository;


import io.miguelsouza.taskmanager.domain.TaskRepository;
import io.miguelsouza.taskmanager.domain.TaskRepositoryTest;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest {
    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }
}

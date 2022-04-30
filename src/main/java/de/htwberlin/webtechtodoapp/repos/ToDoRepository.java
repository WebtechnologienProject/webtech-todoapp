package de.htwberlin.webtechtodoapp.repos;

import de.htwberlin.webtechtodoapp.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo, Long> {
}

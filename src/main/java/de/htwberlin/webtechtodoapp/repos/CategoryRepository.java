package de.htwberlin.webtechtodoapp.repos;

import de.htwberlin.webtechtodoapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

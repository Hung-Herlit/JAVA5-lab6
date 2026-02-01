package lab.lab6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab.lab6.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    
} 
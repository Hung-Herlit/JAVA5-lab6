package lab.lab6.repository;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lab.lab6.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    // @Query("SELECT c FROM Category c WHERE c.name = :name")
    // List<Category> findAllByName(@Param("name") String name);
    @Query("SELECT c FROM Category c WHERE c.name like ?1 ")
    List<Category> findAllByName(String name);
    
    @Query("SELECT c FROM Category c WHERE c.name like ?1 ORDER BY c.name DESC")
    List<Category> findAllByNameAndSort(String name);
    
    @Query("SELECT c FROM Category c WHERE c.name like ?1 ")
    List<Category> findAllByName(String name, Sort sort);

    List<Category> findByName(String name);
    
    List<Category> findByName(String name, Sort sort);
    
    List<Category> findByName(String name, Pageable pageable);
    
    List<Category> findByName(String name, Limit limit);

    List<Category> findByNameLike(String namePart);

    @Query(name = "Category.findAllCategiries")
    List<Category> getAllCategories();
} 
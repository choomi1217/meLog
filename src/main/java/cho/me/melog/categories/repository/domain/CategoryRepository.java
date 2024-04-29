package cho.me.melog.categories.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c where c.visible = true and c.deleted = false")
    List<Category> findExceptUnviable();

    @Query("select c from Category c where c.id = :id and c.visible = true and c.deleted = false")
    Category findByIdExceptUnviable(Long id);
}

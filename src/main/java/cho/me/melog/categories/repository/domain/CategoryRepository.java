package cho.me.melog.categories.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category c where c.visible = true and c.deleted = false")
    List<Category> findExceptInvisible();

    @Query("select c from Category c where c.id = :id and c.visible = true and c.deleted = false")
    Category findByIdExceptUnviable(Long id);

    @Query("select c from Category c where c.title = :title and c.visible = true and c.deleted = false")
    Optional<Category> findByTitle(String title);
}

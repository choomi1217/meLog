package cho.me.melog.article.repository.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a WHERE a.isDeleted = false and a.isPublished = true ORDER BY a.createdAt DESC")
    Page<Article> findAllArticlesByIsDeletedFalse(Pageable pageable);
}

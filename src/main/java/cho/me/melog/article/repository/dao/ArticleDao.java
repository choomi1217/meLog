package cho.me.melog.article.repository.dao;

import cho.me.melog.article.repository.domain.Article;
import cho.me.melog.article.repository.domain.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ArticleDao {
    private final ArticleRepository articleRepository;

    public ArticleDao(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Page<Article> findAllArticles(Pageable pageable) {
        return articleRepository.findAllArticlesByIsDeletedFalse(pageable);
    }

    public Article save(Article article) {
        return articleRepository.save(article);
    }

    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }
}

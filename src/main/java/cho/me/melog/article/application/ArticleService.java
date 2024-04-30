package cho.me.melog.article.application;

import cho.me.melog.article.dto.ArticleDto;
import cho.me.melog.article.dto.ArticleSaveForm;
import cho.me.melog.article.repository.dao.ArticleDao;
import cho.me.melog.article.repository.domain.Article;
import cho.me.melog.categories.repository.dao.CategoryDao;
import cho.me.melog.categories.repository.domain.Category;
import cho.me.melog.tag.repository.dao.TagDao;
import cho.me.melog.tag.repository.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleDao articleDao;
    private final CategoryDao categoryDao;
    private final TagDao tagDao;

    public ArticleService(ArticleDao articleDao, CategoryDao categoryDao, TagDao tagDao) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.tagDao = tagDao;
    }

    public Page<ArticleDto> findAllArticles(Pageable pageable) {
        return articleDao.findAllArticles(pageable).map(Article::toDto);
    }

    public ArticleDto saveArticle(ArticleSaveForm articleSaveForm) {
        String categoryName = articleSaveForm.getCategoryName();
        Category category = categoryDao.findByTitle(categoryName).orElseThrow(() -> new IllegalArgumentException("Category not found"));
        List<String> tagNames = articleSaveForm.getTagNames();
        List<Tag> tags = new ArrayList<>();
        for (String tagName : tagNames) {
            tags.add(tagDao.findTagByName(tagName).orElseThrow(() -> new IllegalArgumentException("Tag not found")));
        }
        Article article = articleSaveForm.toEntity(category, tags);
        return articleDao.save(article).toDto();
    }
}

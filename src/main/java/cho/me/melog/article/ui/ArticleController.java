package cho.me.melog.article.ui;

import cho.me.melog.article.application.ArticleService;
import cho.me.melog.article.dto.ArticleDto;
import cho.me.melog.article.dto.ArticleSaveForm;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/api/article")
    public ResponseEntity<List<ArticleDto>> getArticles(@PageableDefault(page = 1) Pageable pageable) {
        return ResponseEntity.ok(articleService.findAllArticles(pageable).getContent());
    }

    @PostMapping("/api/article")
    public ResponseEntity<ArticleDto> createArticle(ArticleSaveForm articleSaveForm) {
        return ResponseEntity.ok(articleService.saveArticle(articleSaveForm));
    }

}

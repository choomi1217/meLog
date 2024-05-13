package cho.me.melog.article.ui;

import cho.me.melog.article.application.ArticleService;
import cho.me.melog.article.dto.ArticleDto;
import cho.me.melog.article.dto.ArticleSaveForm;
import cho.me.melog.article.dto.PageDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 게시글 리스트 조회
     */
    @GetMapping("/api/article")
    public ResponseEntity<PageDto<ArticleDto>> getArticles(@PageableDefault(page = 1) Pageable pageable) {
        return ResponseEntity.ok(articleService.findAllArticles(pageable));
    }

    /**
     * 게시글 등록 화면
     */
    @GetMapping("/api/articleForm")
    public String articleForm() {
        return "/article/articleForm";
    }

    /**
     * 게시글 등록
     */
    @PostMapping("/api/article")
    public ResponseEntity<ArticleDto> createArticle(ArticleSaveForm articleSaveForm, HttpServletRequest request) {
        return ResponseEntity.ok(articleService.saveArticle(articleSaveForm, request));
    }

    /**
     * 게시글 상세 조회
     */
    @GetMapping("/api/article/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.findArticle(id));
    }

    /**
     * 게시글 수정 화면
     */
    @PutMapping("/api/article/{id}")
    public String articleEditForm(@PathVariable Long id) {
        return "/article/articleEditForm";
    }

    /**
     * 게시글 수정
     */
    @PostMapping("/api/article/{id}")
    public ResponseEntity<ArticleDto> updateArticle(@PathVariable Long id, ArticleSaveForm articleSaveForm) {
        return ResponseEntity.ok(articleService.updateArticle(id, articleSaveForm));
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/api/article/{id}")
    public ResponseEntity<Boolean> deleteArticle(@PathVariable Long id) {
        return ResponseEntity.ok(articleService.deleteArticle(id));
    }

}

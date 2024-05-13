package cho.me.melog.article.dto;

import cho.me.melog.article.repository.domain.Article;
import cho.me.melog.categories.repository.domain.Category;
import cho.me.melog.tag.repository.domain.Tag;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public record ArticleSaveForm(
        String title,
        String content,
        String thumbnail,
        String author,
        String categoryName,
        List<String> tagNames,
        Boolean isPublished,
        List<MultipartFile> files
) {
    public Article toEntity(Category category, List<Tag> tags) {
        return Article.builder()
                .title(title)
                .content(content)
                .thumbnail(thumbnail)
                .author(author)
                .category(category)
                .tags(tags)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .isDeleted(false)
                .isPublished(isPublished)
                .publishedAt(isPublished ? LocalDateTime.now() : null)
                .viewCount(0L)
                .likeCount(0L)
                .commentCount(0L)
                .build();
    }
}

package cho.me.melog.article.dto;

import cho.me.melog.article.repository.domain.Article;
import cho.me.melog.categories.repository.domain.Category;
import cho.me.melog.tag.repository.domain.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class ArticleSaveForm {
    private String title;
    private String content;
    private String thumbnail;
    private String author;
    private String categoryName;
    private List<String> tagNames;
    private Boolean isPublished;

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

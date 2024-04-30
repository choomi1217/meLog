package cho.me.melog.article.dto;

import cho.me.melog.categories.repository.domain.Category;
import cho.me.melog.tag.repository.domain.Tag;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class ArticleDto {

    private Long id;
    private String title;
    private String content;
    private String thumbnail;
    private String author;
    private Category category;
    private List<Tag> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDeleted;
    private Boolean isPublished;
    private LocalDateTime publishedAt;
    private Long viewCount;
    private Long likeCount;
    private Long commentCount;

    public ArticleDto(Long id, String title, String content, String thumbnail, String author, Category category, List<Tag> tags, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean isDeleted, Boolean isPublished, LocalDateTime publishedAt, Long viewCount, Long likeCount, Long commentCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.thumbnail = thumbnail;
        this.author = author;
        this.category = category;
        this.tags = tags;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isDeleted = isDeleted;
        this.isPublished = isPublished;
        this.publishedAt = publishedAt;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

}

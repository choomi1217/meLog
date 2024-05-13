package cho.me.melog.article.dto;

import cho.me.melog.article.repository.domain.Article;
import cho.me.melog.categories.repository.domain.Category;
import cho.me.melog.tag.repository.domain.Tag;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ArticleDto(
        Long id,
        String title,
        String content,
        String thumbnail,
        String author,
        Category category,
        List<Tag> tags,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Boolean isDeleted,
        Boolean isPublished,
        LocalDateTime publishedAt,
        Long viewCount,
        Long likeCount,
        Long commentCount) {

    public static ArticleDto of(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .thumbnail(article.getThumbnail())
                .author(article.getAuthor())
                .category(article.getCategory())
                .tags(article.getTags())
                .createdAt(article.getCreatedAt())
                .updatedAt(article.getUpdatedAt())
                .isDeleted(article.getIsDeleted())
                .isPublished(article.getIsPublished())
                .publishedAt(article.getPublishedAt())
                .viewCount(article.getViewCount())
                .likeCount(article.getLikeCount())
                .commentCount(article.getCommentCount())
                .build();
    }
}

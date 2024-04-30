package cho.me.melog.article.repository.domain;

import cho.me.melog.article.dto.ArticleDto;
import cho.me.melog.categories.repository.domain.Category;
import cho.me.melog.tag.repository.domain.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String thumbnail;
    private String author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDeleted;
    private Boolean isPublished;
    private LocalDateTime publishedAt;
    private Long viewCount;
    private Long likeCount;
    private Long commentCount;

    public ArticleDto toDto() {
        return ArticleDto.builder()
                .id(id)
                .title(title)
                .content(content)
                .thumbnail(thumbnail)
                .author(author)
                .category(category)
                .tags(tags)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .isDeleted(isDeleted)
                .isPublished(isPublished)
                .publishedAt(publishedAt)
                .viewCount(viewCount)
                .likeCount(likeCount)
                .commentCount(commentCount)
                .build();
    }
}

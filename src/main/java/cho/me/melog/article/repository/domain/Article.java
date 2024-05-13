package cho.me.melog.article.repository.domain;

import cho.me.melog.article.dto.ArticleDto;
import cho.me.melog.article.dto.ArticleSaveForm;
import cho.me.melog.categories.repository.domain.Category;
import cho.me.melog.tag.repository.domain.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<AttachedFile> attachedFiles = new ArrayList<>();

    public void update(ArticleSaveForm articleSaveForm) {
        this.title = articleSaveForm.title();
        this.content = articleSaveForm.content();
        this.thumbnail = articleSaveForm.thumbnail();
        this.author = articleSaveForm.author();
        this.updatedAt = LocalDateTime.now();
        this.isPublished = articleSaveForm.isPublished();
        this.publishedAt = articleSaveForm.isPublished() ? LocalDateTime.now() : null;
    }

    public boolean delete(boolean isDeleted) {
        this.isDeleted = isDeleted;
        return isDeleted;
    }
}

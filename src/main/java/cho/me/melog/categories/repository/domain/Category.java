package cho.me.melog.categories.repository.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

@Getter @Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String color;
    private String icon;
    private Long parentId;
    private Boolean visible;
    private Boolean deleted;
    private LocalDateTime createdAt;

    public Category(String title, String description, String color, String icon, Long parentId, Boolean visible, Boolean deleted, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.color = color;
        this.icon = icon;
        this.parentId = parentId;
        this.visible = visible;
        this.deleted = deleted;
        this.createdAt = createdAt;
    }

    public Category updateTitle(String title){
        this.title = title;
        return this;
    }

    public Category updateDescription(String description){
        this.description = description;
        return this;
    }

    public Category updateColor(String color){
        this.color = color;
        return this;
    }

    public Category updateIcon(String icon){
        this.icon = icon;
        return this;
    }

    public Category updateParentId(Long parentId){
        this.parentId = parentId;
        return this;
    }

    public Category updateVisible(Boolean visible){
        this.visible = visible;
        return this;
    }

    public Category updateDeleted(Boolean deleted){
        this.deleted = deleted;
        return this;
    }

    public void update(Category category) {
        this.title = category.title;
        this.description = category.description;
        this.color = category.color;
        this.icon = category.icon;
        this.parentId = category.parentId;
        this.visible = category.visible;
        this.deleted = category.deleted;
    }
}



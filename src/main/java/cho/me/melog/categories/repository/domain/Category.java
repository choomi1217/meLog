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
}



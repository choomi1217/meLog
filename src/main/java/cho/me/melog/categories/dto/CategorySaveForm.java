package cho.me.melog.categories.dto;

import cho.me.melog.categories.repository.domain.Category;
import jakarta.validation.constraints.NotNull;

import java.awt.*;
import java.time.LocalDateTime;

public class CategorySaveForm {

    @NotNull
    private final String title;
    @NotNull
    private final String description;
    @NotNull
    private final String color;
    @NotNull
    private final String icon;
    private final Long parentId;
    private final Boolean visible;

    public CategorySaveForm(String title, String description, String color, String icon, Long parentId, Boolean visible) {
        this.title = title;
        this.description = description;
        this.color = color;
        this.icon = icon;
        this.parentId = parentId;
        this.visible = visible;
    }

    public Category toDomain() {
        return Category.builder()
                .title(title)
                .description(description)
                .color(color.toString())
                .icon(icon)
                .parentId(parentId)
                .visible(visible)
                .deleted(false)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public String getIcon() {
        return icon;
    }

    public Long getParentId() {
        return parentId;
    }

    public Boolean getVisible() {
        return visible;
    }
}

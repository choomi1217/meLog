package cho.me.melog.categories.dto;

import cho.me.melog.categories.repository.domain.Category;

import java.awt.*;
import java.time.LocalDateTime;

public class CategorySaveForm {

    private final String title;
    private final String description;
    private final String color;
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
}

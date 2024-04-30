package cho.me.melog.categories.dto;

import cho.me.melog.annotation.ExcelColumn;
import cho.me.melog.categories.repository.domain.Category;

import java.time.LocalDateTime;

public class CategoryDto {
    private Long id;
    @ExcelColumn(headerName = "카테고리명")
    private String title;
    @ExcelColumn(headerName = "설명")
    private String description;
    @ExcelColumn(headerName = "색상")
    private String color;
    @ExcelColumn(headerName = "아이콘")
    private String icon;
    @ExcelColumn(headerName = "상위 카테고리 ID")
    private Long parentId;
    @ExcelColumn(headerName = "노출 여부")
    private Boolean visible;
    private Boolean deleted;
    private LocalDateTime createdAt;

    private CategoryDto(String title, String description, String color, String icon, Long parentId, Boolean visible, Boolean deleted, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.color = color;
        this.icon = icon;
        this.parentId = parentId;
        this.visible = visible;
        this.deleted = deleted;
        this.createdAt = createdAt;
    }

    public static CategoryDto of(String title, String description, String color, String icon, Boolean visible) {
        return new CategoryDto(title, description, color, icon, 0L, visible, false, LocalDateTime.now());
    }

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.description = category.getDescription();
        this.color = category.getColor();
        this.icon = category.getIcon();
        this.parentId = category.getParentId();
        this.visible = category.getVisible();
        this.deleted = category.getDeleted();
        this.createdAt = category.getCreatedAt();
    }

    public Category toDomain() {
        return Category.builder()
                .title(title)
                .description(description)
                .color(color)
                .icon(icon)
                .parentId(parentId)
                .visible(visible)
                .deleted(deleted)
                .createdAt(createdAt)
                .build();
    }
}

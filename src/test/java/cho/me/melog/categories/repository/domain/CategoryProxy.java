package cho.me.melog.categories.repository.domain;

import java.time.LocalDateTime;

public class CategoryProxy extends Category{

    private Long id;

    public CategoryProxy(Long id, String title, String description, String color, String icon, Long parentId, Boolean visible, Boolean deleted, LocalDateTime createdAt) {
        super(title, description, color, icon, parentId, visible, deleted, createdAt);
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

}
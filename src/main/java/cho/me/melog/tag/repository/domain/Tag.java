package cho.me.melog.tag.repository.domain;

import cho.me.melog.tag.dto.TagDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDateTime;

@Entity
public class Tag {

    @Id
    @Column(unique = true)
    private String name;
    private LocalDateTime createdAt;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }

    public TagDto toDto() {
        return new TagDto(name);
    }
}

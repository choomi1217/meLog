package cho.me.melog.tag.ui;

import cho.me.melog.tag.application.TagService;
import cho.me.melog.tag.dto.TagDto;
import cho.me.melog.tag.repository.domain.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/api/tag")
    public ResponseEntity<List<TagDto>> getTags() {
        return ResponseEntity.ok(tagService.findAllTags());
    }

    @GetMapping("/api/tag/{name}")
    public ResponseEntity<TagDto> getTag(@PathVariable String name) {
        return ResponseEntity.ok(tagService.findTagByName(name));
    }

    @PostMapping("/api/tag/{name}")
    public ResponseEntity<Tag> createTag(@PathVariable String name) {
        return ResponseEntity.ok(tagService.saveTag(name));
    }

    @DeleteMapping("/api/tag")
    public ResponseEntity<Boolean> deleteTag(@RequestParam String name) {
        return ResponseEntity.ok(tagService.deleteTag(name));
    }

}

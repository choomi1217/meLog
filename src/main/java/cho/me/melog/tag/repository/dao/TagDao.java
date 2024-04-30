package cho.me.melog.tag.repository.dao;

import cho.me.melog.tag.repository.domain.Tag;
import cho.me.melog.tag.repository.domain.TagRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TagDao {
    private final TagRepository tagRepository;

    public List<Tag> findAllTags() {
        return tagRepository.findAll();
    }

    public TagDao(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Optional<Tag> findTagByName(String name) {
        return tagRepository.findByName(name);
    }

    public Tag saveTag(String name) {
        return tagRepository.save(new Tag(name));
    }
}

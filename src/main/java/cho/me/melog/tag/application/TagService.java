package cho.me.melog.tag.application;

import cho.me.melog.tag.dto.TagDto;
import cho.me.melog.tag.repository.dao.TagDao;
import cho.me.melog.tag.repository.domain.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagDao tagDao;

    public TagService(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    public List<TagDto> findAllTags() {
        return tagDao.findAllTags().stream().map(Tag::toDto).toList();
    }

    public TagDto findTagByName(String name) {
        return tagDao.findTagByName(name).orElseGet(() -> saveTag(name)).toDto();
    }

    public Tag saveTag(String name) {
        if(null != findTagByName(name)) {
            throw new IllegalArgumentException("Tag already exists");
        }
        return tagDao.saveTag(name);
    }
}

package cho.me.melog.tag.repository.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("select t from Tag t where t.name = :name")
    Optional<Tag> findByName(String name);

    @Query("delete from Tag t where t.name = :name")
    int deleteByName(String name);
}

package cho.me.melog.categories.repository.dao;

import cho.me.melog.categories.repository.domain.Category;
import cho.me.melog.categories.repository.domain.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDao{
    private final CategoryRepository categoryRepository;

    public CategoryDao(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findExceptInvisible() {
        return categoryRepository.findExceptInvisible();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findByIdExceptUnviable(Long id) {
        return categoryRepository.findByIdExceptUnviable(id);
    }

    public void update(Category category) {
        Category entity = categoryRepository.findByIdExceptUnviable(category.getId());
        entity.update(category);
        categoryRepository.flush();
    }

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
}

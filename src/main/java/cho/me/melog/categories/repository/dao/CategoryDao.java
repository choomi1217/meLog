package cho.me.melog.categories.repository.dao;

import cho.me.melog.categories.repository.domain.Category;
import cho.me.melog.categories.repository.domain.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao{
    private final CategoryRepository categoryRepository;

    public CategoryDao(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findExceptUnviable() {
        return categoryRepository.findExceptUnviable();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findByIdExceptUnviable(Long id) {
        return categoryRepository.findByIdExceptUnviable(id);
    }
}

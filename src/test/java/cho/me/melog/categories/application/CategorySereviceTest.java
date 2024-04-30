package cho.me.melog.categories.application;

import cho.me.melog.categories.dto.CategoryDto;
import cho.me.melog.categories.dto.CategorySaveForm;
import cho.me.melog.categories.repository.dao.CategoryDao;
import cho.me.melog.categories.repository.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CategorySereviceTest {

    private CategoryDao categoryDao;

    @BeforeEach
    void setUp() {
        categoryDao = mock(CategoryDao.class);
    }

    @Test
    @DisplayName("카테고리 목록을 조회할 수 있어야 함")
    void categories() {
        List<Category> expectedCategories = Arrays.asList(new Category("title", "description", "color", "icon", 0L, true, false, LocalDateTime.now()));
        when(categoryDao.findExceptInvisible()).thenReturn(expectedCategories);

        CategorySerevice service = new CategorySerevice(categoryDao);
        List<Category> actualCategories = service.categories();

        assertEquals(expectedCategories, actualCategories);
        verify(categoryDao).findExceptInvisible();
    }

    @Test
    @DisplayName("카테고리를 저장할 수 있어야 함")
    void saveOneCategory() {
        CategorySaveForm saveForm = new CategorySaveForm("title", "description", "color", "icon", 1L, true);
        Category category = spy(Category.class);
        when(categoryDao.save(category)).thenReturn(saveForm.toDomain());

        CategorySerevice service = new CategorySerevice(categoryDao);
        Category saved = service.saveOneCategory(saveForm);

        assertEquals(saveForm.getTitle(), saved.getTitle());
        verify(categoryDao).save(category);
    }

    @Test
    @DisplayName("여러 카테고리를 저장할 수 있어야 함")
    void saveManyCategory() {
        /*MockMultipartFile multipartFile1 = new MockMultipartFile("file", "test.xlsx", "");

        when(categoryDao.save(any(Category.class)))
                .thenReturn(new Category("title", "description", "color", "icon", 0L, true, false, LocalDateTime.now()));

        CategorySerevice service = new CategorySerevice(categoryDao);
        List<Category> savedCategories = service.saveManyCategory(file);

        assertNotNull(savedCategories);
        assertEquals(2, savedCategories.size());
        verify(categoryDao, times(2)).save(any(Category.class));*/
    }

    @Test
    void findCategoryById() {
        when(categoryDao.findByIdExceptUnviable(1L))
                .thenReturn(new Category("title", "description", "color", "icon", 0L, true, false, LocalDateTime.now()));

        CategorySerevice service = new CategorySerevice(categoryDao);
        Category category = service.findCategoryById(1L);

        assertEquals("title", category.getTitle());
    }

    @Test
    void updateCategory() {
        CategorySaveForm saveForm = new CategorySaveForm("title", "description", "color", "icon", 1L, true);
        Category category = new Category("title", "description", "color", "icon", 0L, true, false, LocalDateTime.now());
        when(categoryDao.findByIdExceptUnviable(1L)).thenReturn(category);

        CategorySerevice service = new CategorySerevice(categoryDao);
        Category updated = service.updateCategory(1L, saveForm);

        assertEquals(saveForm.getTitle(), updated.getTitle());
        verify(categoryDao).findByIdExceptUnviable(1L);
    }
}
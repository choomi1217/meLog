package cho.me.melog.categories.application;

import cho.me.melog.categories.dto.CategoryDto;
import cho.me.melog.categories.dto.CategorySaveForm;
import cho.me.melog.categories.repository.dao.CategoryDao;
import cho.me.melog.categories.repository.domain.Category;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class CategorySerevice {

    private final CategoryDao categoryDao;

    public CategorySerevice(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> categories() {
        List<Category> categories = categoryDao.findExceptUnviable();
        return categories;
    }

    public Long saveOneCategory(CategorySaveForm request) {
        Category category = request.toDomain();
        Category save = categoryDao.save(category);
        return save.getId();
    }

    public List<Category> saveManyCategory(MultipartFile request) {
        List<Category> savedCategories;
        try (InputStream inputStream = request.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            savedCategories = new ArrayList<>();
            IntStream.range(1, sheet.getLastRowNum()).forEach(i -> {
                CategoryDto categoryDto = getCategoryDto(i, sheet);
                Category saved = categoryDao.save(categoryDto.toDomain());
                savedCategories.add(saved);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return savedCategories;
    }

    private static CategoryDto getCategoryDto(int i, Sheet sheet) {
        Row row = sheet.getRow(i);
        String title = row.getCell(0).getStringCellValue();
        String description = row.getCell(1).getStringCellValue();
        String color = row.getCell(2).getStringCellValue();
        String icon = row.getCell(3).getStringCellValue();
        Boolean visible = row.getCell(4).getBooleanCellValue();
        return CategoryDto.of(title, description, color, icon, visible);
    }

    public int getLastCellNum(Sheet sheet) {
        Row r = sheet.getRow(0);
        return r.getLastCellNum();
    }

    public CategoryDto findCategoryById(Long id) {
        Category category = categoryDao.findByIdExceptUnviable(id);
        return new CategoryDto(category);
    }

    public CategoryDto updateCategory(Long id, CategorySaveForm request) {
        return null;
    }
}

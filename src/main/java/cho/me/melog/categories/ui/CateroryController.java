package cho.me.melog.categories.ui;

import cho.me.melog.categories.application.CategorySerevice;
import cho.me.melog.categories.dto.CategoryDto;
import cho.me.melog.categories.repository.domain.Category;
import cho.me.melog.categories.dto.CategorySaveForm;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class CateroryController {

    private final CategorySerevice categoryService;

    public CateroryController(CategorySerevice categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/category")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categoryList = categoryService.categories();
        return ResponseEntity.ok(categoryList);
    }

    @GetMapping("/api/category/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {
        CategoryDto response = categoryService.findCategoryById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/category")
    public ResponseEntity<Long> saveOneCategory(CategorySaveForm request) {
        return ResponseEntity.ok(categoryService.saveOneCategory(request));
    }

    @PostMapping(value = "/api/categories", consumes = "multipart/form-data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> saveManyCategory(@RequestParam(value = "file")MultipartFile request) {
        return ResponseEntity.ok(categoryService.saveManyCategory(request));
    }

    @PutMapping("/api/category/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, CategorySaveForm request) {
        CategoryDto response = categoryService.updateCategory(id, request);
        return ResponseEntity.ok(response);
    }

}

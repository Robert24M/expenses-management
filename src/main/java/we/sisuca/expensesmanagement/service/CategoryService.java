package we.sisuca.expensesmanagement.service;

import org.springframework.stereotype.Service;
import we.sisuca.expensesmanagement.model.Category;
import we.sisuca.expensesmanagement.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void addNewCategory(Category category) {
        categoryRepository.save(category);
    }
}

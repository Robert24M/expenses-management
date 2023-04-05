package we.sisuca.expensesmanagement.service;

import org.springframework.stereotype.Service;
import we.sisuca.expensesmanagement.model.Category;
import we.sisuca.expensesmanagement.model.Expanse;
import we.sisuca.expensesmanagement.repository.CategoryRepository;
import we.sisuca.expensesmanagement.repository.ExpanseRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpanseService {

    private final ExpanseRepository expanseRepository;
    private final CategoryRepository categoryRepository;

    public ExpanseService(ExpanseRepository expanseRepository, CategoryRepository categoryRepository) {
        this.expanseRepository = expanseRepository;
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Expanse> getAllExpanses() {
        return expanseRepository.findAll();
    }

    public void addNewExpanse(Expanse expanse) {
        expanseRepository.save(expanse);
    }

    public Map<String, List<Expanse>> findAllExpanseByCategory() {

        Map<String, List<Expanse>> expansesByCategory = new HashMap<>();
        Iterable<Category> categories = categoryRepository.findAll();

        categories.forEach(category -> {
            expansesByCategory.put(category.getName(), expanseRepository.findByCategory(category.getId()));
        });

        return expansesByCategory;
    }
}

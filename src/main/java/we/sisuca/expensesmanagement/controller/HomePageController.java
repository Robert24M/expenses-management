package we.sisuca.expensesmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import we.sisuca.expensesmanagement.model.Category;
import we.sisuca.expensesmanagement.model.Expanse;
import we.sisuca.expensesmanagement.service.CategoryService;
import we.sisuca.expensesmanagement.service.ExpanseService;

import java.util.List;
import java.util.Map;

@RestController
public class HomePageController {

    private final CategoryService categoryService;
    private final ExpanseService expanseService;

    public HomePageController(CategoryService categoryService,
                              ExpanseService expanseService) {
        this.categoryService = categoryService;
        this.expanseService = expanseService;
    }

    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> getCategories() {
        return ResponseEntity.accepted()
                .body(categoryService.getAllCategories());
    }

    @GetMapping("/expanses")
    public ResponseEntity<Iterable<Expanse>> getAllExpanses() {
        return ResponseEntity.accepted()
                .body(expanseService.getAllExpanses());
    }

    @GetMapping("/expansesByCategory")
    public ResponseEntity<Map<String, List<Expanse>>> getAllExpansesByCategory() {
        return ResponseEntity.accepted()
                .body(expanseService.findAllExpanseByCategory());
    }
}

package we.sisuca.expensesmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import we.sisuca.expensesmanagement.model.Category;
import we.sisuca.expensesmanagement.model.Expense;
import we.sisuca.expensesmanagement.service.CategoryService;
import we.sisuca.expensesmanagement.service.ExpenseService;

import java.util.List;

@RestController
public class HomePageController {

    private final CategoryService categoryService;
    private final ExpenseService expenseService;

    public HomePageController(CategoryService categoryService,
                              ExpenseService expenseService) {
        this.categoryService = categoryService;
        this.expenseService = expenseService;
    }

    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> getCategories() {
        return ResponseEntity.accepted()
                .body(categoryService.getAllCategories());
    }

    @GetMapping("/expenses")
    public ResponseEntity<Iterable<Expense>> getAllExpanses() {
        return ResponseEntity.accepted()
                .body(expenseService.getAllExpenses());
    }

    @GetMapping("/expensesC")
    public ResponseEntity<List<Expense>> getAllByCategory(
            @RequestParam Long id
    ) {
        List<Expense> expenses = expenseService.getAllExpensesByCategory(id);

        return ResponseEntity.accepted()
                .body(expenses);
    }
}

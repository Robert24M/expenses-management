package we.sisuca.expensesmanagement.service;

import org.springframework.stereotype.Service;
import we.sisuca.expensesmanagement.model.Expense;
import we.sisuca.expensesmanagement.repository.CategoryRepository;
import we.sisuca.expensesmanagement.repository.ExpenseRepository;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    public ExpenseService(ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public void addNewExpanse(Expense expense) {
        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpensesByCategory(Long id) {
        return expenseRepository.findAllByCategoryId(id);
    }
}

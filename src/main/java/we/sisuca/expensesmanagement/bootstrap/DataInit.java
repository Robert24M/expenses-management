package we.sisuca.expensesmanagement.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import we.sisuca.expensesmanagement.model.Category;
import we.sisuca.expensesmanagement.model.Expense;
import we.sisuca.expensesmanagement.repository.CategoryRepository;
import we.sisuca.expensesmanagement.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataInit implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ExpenseRepository expenseRepository;

    public DataInit(CategoryRepository categoryRepository, ExpenseRepository expenseRepository) {
        this.categoryRepository = categoryRepository;
        this.expenseRepository = expenseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category homeBill = new Category();
        homeBill.setName("Home Bill");
        Category savedHomeBillCategory = categoryRepository.save(homeBill);

        Category food = new Category();
        food.setName("Food");
        Category savedFoodCategory = categoryRepository.save(food);

        Expense netflix = new Expense();
        netflix.setName("Netflix");
        netflix.setExpenseValue(new BigDecimal(60));
        netflix.setDescription("Netflix subscription");
        netflix.setTransactionDate(LocalDate.now());
        netflix.setCategory(savedHomeBillCategory);
        expenseRepository.save(netflix);

        Expense spotify = new Expense();
        spotify.setName("Spotify");
        spotify.setExpenseValue(new BigDecimal(35));
        spotify.setDescription("Spotify subscription");
        spotify.setTransactionDate(LocalDate.now());
        spotify.setCategory(savedHomeBillCategory);
        expenseRepository.save(spotify);

        Expense bread = new Expense();
        bread.setName("Bred");
        bread.setDescription("Just bread");
        bread.setExpenseValue(new BigDecimal(5));
        bread.setTransactionDate(LocalDate.now());
        bread.setCategory(savedFoodCategory);
        expenseRepository.save(bread);
    }
}

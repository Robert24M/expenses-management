package we.sisuca.expensesmanagement.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import we.sisuca.expensesmanagement.model.Category;
import we.sisuca.expensesmanagement.model.Expanse;
import we.sisuca.expensesmanagement.repository.CategoryRepository;
import we.sisuca.expensesmanagement.repository.ExpanseRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataInit implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ExpanseRepository expanseRepository;

    public DataInit(CategoryRepository categoryRepository, ExpanseRepository expanseRepository) {
        this.categoryRepository = categoryRepository;
        this.expanseRepository = expanseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category homeBill = new Category();
        homeBill.setName("Home Bill");
        Category savedHomeBillCategory = categoryRepository.save(homeBill);

        Category food = new Category();
        food.setName("Food");
        Category savedFoodCategory = categoryRepository.save(food);

        Expanse netflix = new Expanse();
        netflix.setName("Netflix");
        netflix.setExpanseValue(new BigDecimal(60));
        netflix.setDescription("Netflix subscription");
        netflix.setTransactionDate(LocalDate.now());
        netflix.setCategory(savedHomeBillCategory);
        expanseRepository.save(netflix);

        Expanse spotify = new Expanse();
        netflix.setName("Spotify");
        netflix.setExpanseValue(new BigDecimal(35));
        netflix.setDescription("Spotify subscription");
        netflix.setTransactionDate(LocalDate.now());
        netflix.setCategory(savedHomeBillCategory);
        expanseRepository.save(spotify);

        Expanse bread = new Expanse();
        bread.setName("Bred");
        bread.setDescription("Just bread");
        bread.setExpanseValue(new BigDecimal(5));
        bread.setTransactionDate(LocalDate.now());
        bread.setCategory(savedFoodCategory);
        expanseRepository.save(bread);
    }
}

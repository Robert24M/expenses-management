package we.sisuca.expensesmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import we.sisuca.expensesmanagement.model.Expense;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    List<Expense> findAllByCategoryId(Long category_id);
}

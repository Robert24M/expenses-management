package we.sisuca.expensesmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import we.sisuca.expensesmanagement.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

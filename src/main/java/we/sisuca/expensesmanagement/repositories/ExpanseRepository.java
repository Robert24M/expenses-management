package we.sisuca.expensesmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import we.sisuca.expensesmanagement.model.Expanse;

public interface ExpanseRepository extends CrudRepository<Expanse, Long> {
}

package we.sisuca.expensesmanagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import we.sisuca.expensesmanagement.model.Expanse;

import java.util.List;

public interface ExpanseRepository extends CrudRepository<Expanse, Long> {

    @Query("SELECT * FROM expanse where category_id = :categoryId")
    List<Expanse> findByCategory(@Param("categoryId")Long categoryId);
}

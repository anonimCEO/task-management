package md.usm.taskmanagement.repository;

import md.usm.taskmanagement.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

}

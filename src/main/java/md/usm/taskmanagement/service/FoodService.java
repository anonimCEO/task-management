package md.usm.taskmanagement.service;

import md.usm.taskmanagement.model.Beverage;
import md.usm.taskmanagement.model.Food;
import md.usm.taskmanagement.repository.BeverageRepository;
import md.usm.taskmanagement.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.xml.ws.ServiceMode;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getFood(){
        return foodRepository.findAll();
    }



    public void init() {
        foodRepository.saveAll(Arrays.asList(
                new Food("Salad","500", BigDecimal.valueOf(69)),
                new Food("Fish","400", BigDecimal.valueOf(79)),
                new Food("Soup","300", BigDecimal.valueOf(35)),
                new Food("Pizza","800", BigDecimal.valueOf(129))

                )
        );
    }

}

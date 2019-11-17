package md.usm.taskmanagement.controller;


import md.usm.taskmanagement.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class FoodController {

    private FoodService foodService;

    public FoodController(FoodService foodService){
        this.foodService = foodService;
        foodService.init();
    }

    @RequestMapping("/food")
    public String showAllFood(Model model){
           model.addAttribute("food", foodService.getFood());
            return "food";
    }

}

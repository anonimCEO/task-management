package md.usm.taskmanagement.controller;

import md.usm.taskmanagement.model.Beverage;
import md.usm.taskmanagement.service.BeverageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private BeverageService beverageService;

    public MainController(BeverageService beverageService) {
        this.beverageService = beverageService;
        beverageService.init();
    }

    @RequestMapping("/")
    public String homePage() {
        return "home.html";
    }

    @RequestMapping("/beverages")
    public String favoriteBeverages(Model model) {

        if (beverageService.isWorkingTime()) {
            model.addAttribute("drinks", beverageService.getAllowedDrinks());
        }
        else {
            model.addAttribute("drinks", beverageService.getDrinks());
        }

        return "beverages";

    }
    @RequestMapping("/showAllDrinks")
    public String showAllDrinks (Model model){
         model.addAttribute("allDrinks",beverageService.getDrinks());
        return "showAllDrinks";
    }

}

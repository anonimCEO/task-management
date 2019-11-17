package md.usm.taskmanagement.service;

import md.usm.taskmanagement.model.Beverage;
import md.usm.taskmanagement.repository.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BeverageService {
    @Autowired
    private BeverageRepository beverageRepository;

    public List<Beverage> getAllowedDrinks() {
        return beverageRepository.findAll()
                .stream()
                .filter(beverage -> !beverage.isAlcohol())
                .collect(Collectors.toList());

    }

    public List<Beverage> getDrinks() {
        return beverageRepository.findAll();
    }

    public boolean isWorkingTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        boolean isWorkingDay = !(localDateTime.getDayOfWeek() == DayOfWeek.SUNDAY || localDateTime.getDayOfWeek() == DayOfWeek.SATURDAY);

        return isWorkingDay && (localDateTime.getHour() < 18 && localDateTime.getHour() > 8);
    }

    public void init() {
        beverageRepository.saveAll(Arrays.asList(
                new Beverage("Water", BigDecimal.TEN, 0.00, "H2O"),
                new Beverage("Beer", BigDecimal.valueOf(12.00), 4.5, "Magical HOH"),
                new Beverage("Coffe", BigDecimal.valueOf(15.00), 0.00, "Magical HOH"),
                new Beverage("Sprite", BigDecimal.valueOf(16.00), 0.00, "Magical HOH"),
                new Beverage("Cola", BigDecimal.valueOf(15.00), 0.00, "Magical HOH"),
                new Beverage("Juice", BigDecimal.valueOf(19.00), 0.00, "Magical HOH"),
                new Beverage("Rum", BigDecimal.valueOf(23.00), 25.5, "Magical C2-H5-OH"),
                new Beverage("Baileys", BigDecimal.valueOf(65.00), 25.3, "Magical C2-H5-OH"),
                new Beverage("Vodka", BigDecimal.valueOf(55.00), 30.3, "Magical C2-H5-OH"),
                new Beverage("Whiskey", BigDecimal.valueOf(85.00), 45.0, "Magical C2-H5-OH")

                )
        );
    }


}

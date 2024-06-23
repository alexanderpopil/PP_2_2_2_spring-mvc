package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private static final List<Car> cars;

    static {
        cars = new ArrayList<>();

        cars.add(new Car("BMW X6", 2020, "Black"));
        cars.add(new Car("Audi A6", 2019, "White"));
        cars.add(new Car("Renault Logan", 2018, "Yellow"));
        cars.add(new Car("Lexus RX300", 2016, "Brown"));
        cars.add(new Car("BMW M8", 2017, "Blue"));
    }

    @GetMapping(value = "/cars")
    public String carsListPage(@RequestParam(value = "count", required = false) Integer count, Model model) {
        CarService carService = new CarServiceImpl();

        if (count == null) {
            model.addAttribute("cars", cars);
            return "cars";
        }

        model.addAttribute("cars", carService.getCars(cars, count));
        return "cars";
    }
}

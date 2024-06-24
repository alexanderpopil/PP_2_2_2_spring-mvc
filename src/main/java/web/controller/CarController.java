package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String carsListPage(@RequestParam(value = "count", required = false) Integer count, Model model) {

        if (count == null) {
            model.addAttribute("cars", carService.getCars(5));
            return "cars";
        }

        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}

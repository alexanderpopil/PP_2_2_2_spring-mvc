package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CarDaoImpl implements CarDao {

    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car("BMW X6", 2020, "Black"));
        cars.add(new Car("Audi A6", 2019, "White"));
        cars.add(new Car("Renault Logan", 2018, "Yellow"));
        cars.add(new Car("Lexus RX300", 2016, "Brown"));
        cars.add(new Car("BMW M8", 2017, "Blue"));
    }

    @Override
    public List<Car> getCars(int count) {
        int size = cars.size();
        if (count <= 0) {
            return Collections.emptyList();
        }

        if (count > size) {
            count = size;
        }
        return cars.subList(0, count);
    }
}

package web.service;

import web.model.Car;

import java.util.Collections;
import java.util.List;

public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCars(List<Car> cars, int count) {
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

package de.qaware.cockroach.demo.car;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class CarController {

    @Inject
    private CarRepository carRepository;

    @Inject
    private CarMapper carMapper;

    public List<CarDto> getCarsByDealer(UUID dealerId) {
        List<Car> cars = carRepository.getCarsByDealer(dealerId);
        return carMapper.toCarDtos(cars);
    }

    public CarDto storeCar(CarDto carDto) {
        Car car = carMapper.toCar(carDto);
        Car storedCar =  carRepository.save(car);
        return carMapper.toCarDto(storedCar);
    }
}

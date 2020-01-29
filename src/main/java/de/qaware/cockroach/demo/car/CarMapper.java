package de.qaware.cockroach.demo.car;

import de.qaware.cockroach.demo.dealer.DealerResolver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "cdi", uses = {DealerResolver.class})
public interface CarMapper {

    @Mapping(source = "dealer.id", target = "dealer")
    CarDto toCarDto(Car car);

    List<CarDto> toCarDtos(List<Car> cars);

    @Mapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, target = "id")
    Car toCar(CarDto carDto);

    List<Car> toCars(List<CarDto> carDtos);

}

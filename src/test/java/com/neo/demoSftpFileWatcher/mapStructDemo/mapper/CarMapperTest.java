package com.neo.demoSftpFileWatcher.mapStructDemo.mapper;

import com.neo.demoSftpFileWatcher.mapStructDemo.dto.CarDto;
import com.neo.demoSftpFileWatcher.mapStructDemo.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class CarMapperTest {

    CarMapper carMapper;

    @Before
    public void setup() {
        carMapper = Mappers.getMapper(CarMapper.class);
    }

    @Test
    public void testConvertCarToCarDto() {
        Car car = new Car("Toyota Camry", 5, "2017-04-01");
        CarDto carDto = carMapper.entityToDto(car);

        System.out.println("[testConvertCarToCarDto] car = " + car.toString());
        System.out.println("[testConvertCarToCarDto] carDto = " + carDto.toString());

        assertTrue(carDto.getMfgDateString().equals(car.getManufacturer()));
        assertTrue(carDto.getSeatCount() == car.getSeatCount());
    }

    @Test
    public void testConvertCarDtoToCar() {
        CarDto carDto = new CarDto("MINI Cooper S", 4, new Date());
        Car car = carMapper.dtoToEntity(carDto);

        System.out.println("[testConvertCarDtoToCar] carDto = " + carDto.toString());
        System.out.println("[testConvertCarDtoToCar] car = " + car.toString());

        assertTrue(car.getManufacturer().equals(carDto.getManufacturer()));
        assertTrue(car.getSeatCount() == carDto.getSeatCount());
    }

}
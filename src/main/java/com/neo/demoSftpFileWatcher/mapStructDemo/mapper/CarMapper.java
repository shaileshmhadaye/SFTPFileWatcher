package com.neo.demoSftpFileWatcher.mapStructDemo.mapper;

import com.neo.demoSftpFileWatcher.mapStructDemo.dto.CarDto;
import com.neo.demoSftpFileWatcher.mapStructDemo.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = MfgDateMapper.class)
public interface CarMapper {
    CarMapper CarMapper = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "mfgDateString", source = "mfgDateString")
    @Mapping(target = "manufacturer", source = "manufacturer")
    @Mapping(target = "seatCount", source = "seatCount")
    CarDto entityToDto(Car car);

    @Mapping(target = "mfgDateString", source = "mfgDateString")
    @Mapping(target = "manufacturer", source = "manufacturer")
    @Mapping(target = "seatCount", source = "seatCount")
    Car dtoToEntity(CarDto carDto);
}

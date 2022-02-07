package com.kyle1elyk.jpaexample.drops;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DropItemMapper {

    DropItemMapper INSTANCE = Mappers.getMapper(DropItemMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "count", target = "count")
    DropItemDTO toDTO(DropItem dropItem);
}

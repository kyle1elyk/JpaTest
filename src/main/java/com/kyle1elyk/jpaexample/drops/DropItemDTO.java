package com.kyle1elyk.jpaexample.drops;

import lombok.Value;

@Value
public class DropItemDTO {
    Integer id;
    String name;
    Integer count;
}

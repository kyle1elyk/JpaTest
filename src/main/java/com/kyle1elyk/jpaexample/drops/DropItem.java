package com.kyle1elyk.jpaexample.drops;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class DropItem {

    @Id @GeneratedValue
    Integer id;
    String name;
    Integer count;

}

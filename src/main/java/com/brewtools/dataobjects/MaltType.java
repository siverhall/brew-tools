package com.brewtools.dataobjects;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class MaltType {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double lovibond;
}

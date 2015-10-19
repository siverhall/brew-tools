package com.brewtools.dataobjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MaltType {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double lovibond;
}

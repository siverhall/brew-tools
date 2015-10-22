package com.brewtools.dataobjects;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String name;
    @Basic
    private Double batchSize;
    @Basic
    private Double preboilSize;
    @Basic
    private int boilTime;
    @Basic
    private String description;
    @Basic
    private Double efficiency;
}

package com.brewtools.dataobjects;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class MaltType {

    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String name;

    private Double lovibond;

    @Basic(optional = false)
    private int potential;
}

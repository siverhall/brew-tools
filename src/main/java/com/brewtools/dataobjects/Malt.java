package com.brewtools.dataobjects;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Malt {

    @Id
    @GeneratedValue
    private Long id;

    private Double amount;

    @ManyToOne(optional = false)
    private MaltType type;

    @ManyToOne(optional = false)
    private Recipe recipe;
}

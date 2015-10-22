package com.brewtools.dataobjects;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Hop {

    @Id
    @GeneratedValue
    private Long id;

    private Double alpha;

    private Double amount;

    private int boilTime;

    @ManyToOne(optional = false)
    private HopSpec hopSpec;

    @ManyToOne(optional = false)
    private Recipe recipe;

    @Enumerated(value = EnumType.STRING)
    private HopType hopType;

    @Enumerated(value = EnumType.STRING)
    private HopUsage hopUsage;

    public Hop() {
    }

    public enum HopType {
        PELLET, WHOLE_LEAF
    }

    public enum HopUsage {
        BOIL, DRY_HOP, MASH, FIRST_WORT
    }
}

package com.brewtools.services;

import com.brewtools.dataobjects.HopSpec;

import java.util.List;

public interface HopSpecService {
    void save(HopSpec hopSpec);

    List<HopSpec> getHopSpecs();
}

package com.brewtools.services;

import com.brewtools.dataobjects.HopSpec;
import com.brewtools.services.repos.HopSpecRepo;

import javax.inject.Inject;
import java.util.List;

public class HopSpecServiceImpl implements HopSpecService {

    @Inject
    private HopSpecRepo repo;

    @Override
    public void save(HopSpec hopSpec) {
        repo.save(hopSpec);
    }

    @Override
    public List<HopSpec> getHopSpecs() {
        return repo.findAll();
    }
}

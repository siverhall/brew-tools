package com.brewtools.services;

import com.brewtools.dataobjects.MaltType;
import com.brewtools.services.repos.MaltTypeRepo;

import javax.inject.Inject;
import java.util.List;

public class MaltTypeServiceImpl implements MaltTypeService {

    @Inject
    private MaltTypeRepo repo;

    @Override
    public List<MaltType> getTypes() {
        return repo.findAll();
    }
}

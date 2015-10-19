package com.brewtools.services;

import com.brewtools.services.repos.MaltTypeRepo;

import javax.inject.Inject;

public class MaltTypeServiceImpl implements MaltTypeService {

    @Inject
    private MaltTypeRepo repo;
}

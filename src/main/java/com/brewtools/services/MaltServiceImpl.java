package com.brewtools.services;

import com.brewtools.services.repos.MaltRepo;

import javax.inject.Inject;

public class MaltServiceImpl implements MaltService {

    @Inject
    private MaltRepo repo;
}

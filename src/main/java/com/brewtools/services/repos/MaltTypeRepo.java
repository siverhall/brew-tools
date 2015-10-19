package com.brewtools.services.repos;

import com.brewtools.dataobjects.MaltType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaltTypeRepo extends JpaRepository<MaltType, Long> {
}

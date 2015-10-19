package com.brewtools.services.repos;

import com.brewtools.dataobjects.Malt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaltRepo extends JpaRepository<Malt, Long> {
}

package com.wgAeroporto.model.dao;

import com.wgAeroporto.model.entity.VooEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VooRepository extends JpaRepository<VooEntity, Long> {

}

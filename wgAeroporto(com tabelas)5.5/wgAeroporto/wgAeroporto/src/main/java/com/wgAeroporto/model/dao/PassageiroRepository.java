package com.wgAeroporto.model.dao;

import com.wgAeroporto.model.entity.PassageiroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassageiroRepository extends JpaRepository<PassageiroEntity, Long> {
    // Já possui um método embutido no JpaRepository para buscar por ID
}

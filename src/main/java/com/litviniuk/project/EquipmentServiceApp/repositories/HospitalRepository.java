package com.litviniuk.project.EquipmentServiceApp.repositories;

import com.litviniuk.project.EquipmentServiceApp.models.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository <Hospital, Integer>{
    Optional<Hospital> findByHospitalName (String username);
}

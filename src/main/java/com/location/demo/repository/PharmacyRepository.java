package com.location.demo.repository;

import com.location.demo.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy,String>
{

}

package com.location.demo.repository;

import com.location.demo.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PharmacyRepository extends JpaRepository<Pharmacy,String>
{
    @Query("select b from Pharmacy b where  (?1 is null or b.address like %?1% or b.email like %?1% or b.name like %?1% or b.latitude like %?1% or b.longitude like %?1%)")
    List<Pharmacy> findAllPharmacy(String s);
}

package com.te.hds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.hds.entity.DeliveryPerson;

@Repository
public interface DeliveryGuyRepository extends JpaRepository<DeliveryPerson, Integer>{

}

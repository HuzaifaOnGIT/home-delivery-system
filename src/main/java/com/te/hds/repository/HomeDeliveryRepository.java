package com.te.hds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.hds.entity.User;
@Repository
public interface HomeDeliveryRepository extends JpaRepository<User, Integer >{

}

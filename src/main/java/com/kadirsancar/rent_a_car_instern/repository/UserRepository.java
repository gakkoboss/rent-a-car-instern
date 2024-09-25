package com.kadirsancar.rent_a_car_instern.repository;

import com.kadirsancar.rent_a_car_instern.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

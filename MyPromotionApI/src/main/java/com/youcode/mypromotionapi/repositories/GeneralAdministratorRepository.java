package com.youcode.mypromotionapi.repositories;

import com.youcode.mypromotionapi.entities.GeneralAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GeneralAdministratorRepository extends JpaRepository<GeneralAdministrator, UUID> {

}

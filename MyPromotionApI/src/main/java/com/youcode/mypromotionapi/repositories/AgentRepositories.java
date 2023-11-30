package com.youcode.mypromotionapi.repositories;

import com.youcode.mypromotionapi.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface AgentRepositories extends JpaRepository<Agent , UUID> {
}

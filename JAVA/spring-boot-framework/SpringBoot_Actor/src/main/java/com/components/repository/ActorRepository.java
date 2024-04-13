package com.components.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.components.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>
{

}

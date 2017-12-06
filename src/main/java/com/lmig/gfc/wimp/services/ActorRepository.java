package com.lmig.gfc.wimp.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmig.gfc.wimp.models.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {

}

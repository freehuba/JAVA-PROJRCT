package com.components.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.components.model.Actor;
import com.components.utility.ResponseStructure;

public interface ActorService 
{
	public ResponseEntity<ResponseStructure<Actor>> addActor(Actor actor);
	
	public ResponseEntity<ResponseStructure<Actor>> findByActorId(int actorId);
	
	public ResponseEntity<ResponseStructure<Actor>> updateActor(int actorId,Actor actor);
	
	public ResponseEntity<ResponseStructure<Actor>> deleteByActorId(int actorId);
	
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActors();
	
	public ResponseEntity<ResponseStructure<List<Actor>>> deleteAllActors();
}

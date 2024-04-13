package com.components.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.components.model.Actor;
import com.components.service.impl.ActorServiceImpl;
import com.components.utility.ResponseStructure;

@RestController
@RequestMapping("/actor")
public class ActorController {
	
	@Autowired
	private ActorServiceImpl actorServiceImpl;

	@PostMapping("/addActors")
	public ResponseEntity<ResponseStructure<Actor>> addActor(@RequestBody Actor actor) {
		return actorServiceImpl.addActor(actor);
	}
	
	@GetMapping("/findActorById/{actorId}")
	public ResponseEntity<ResponseStructure<Actor>> findActorById(@PathVariable("actorId") int actorId)
	{
		return actorServiceImpl.findByActorId(actorId);
	}
	
	@PutMapping("/updateActorById/{actorId}")
	public ResponseEntity<ResponseStructure<Actor>> updateActorById(@PathVariable("actorId") int actorId, @RequestBody Actor actor)
	{
		return actorServiceImpl.updateActor(actorId, actor);
	}
	
	@DeleteMapping("/deleteActorById/{actorId}")
	public ResponseEntity<ResponseStructure<Actor>> deleteActorById(@PathVariable("actorId") int actorId)
	{
		return actorServiceImpl.deleteByActorId(actorId);
	}
	
	@GetMapping("/findAllActor")
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActor()
	{
		return actorServiceImpl.findAllActors();
	}
	
	
	@DeleteMapping("/deleteAllActor")
	public ResponseEntity<ResponseStructure<List<Actor>>> deleteAllActor()
	{
		return actorServiceImpl.deleteAllActors();
	}
}

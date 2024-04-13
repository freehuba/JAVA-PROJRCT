package com.components.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.components.exception.ActorNotFoundByIdException;
import com.components.model.Actor;
import com.components.repository.ActorRepository;
import com.components.service.ActorService;
import com.components.utility.ResponseStructure;

@Service
public class ActorServiceImpl implements ActorService
{
	@Autowired
	private ActorRepository actorRepository;

	@Override
	public ResponseEntity<ResponseStructure<Actor>> addActor(Actor actor) 
	{
		Actor save = actorRepository.save(actor);
		System.out.println(save);
		ResponseStructure<Actor> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Actor data created successfullu..!");
		responseStructure.setData(save);
		return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Actor>> findByActorId(int actorId) {
		
		 Optional<Actor> optional = actorRepository.findById(actorId);
		 ResponseStructure<Actor> responseStructure = new ResponseStructure<>();
		 if(optional.isPresent())
		 {
			 Actor actor = optional.get();			
			 responseStructure.setStatusCode(HttpStatus.FOUND.value());
			 responseStructure.setMessage("Actor data found..!");
			 responseStructure.setData(actor);
			 return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.FOUND);
		 }
		 else 
		 {
			 //throw new ActorNotFoundByIdException("Actor not found");
			 return null;
		 }
	}

	@Override
	public ResponseEntity<ResponseStructure<Actor>> updateActor(int actorId, Actor updateActor) 
	{
		Optional<Actor> optional = actorRepository.findById(actorId);
		ResponseStructure<Actor> responseStructure = new ResponseStructure<>();
		if(optional.isPresent())
		{
			Actor existingActor = optional.get();
			updateActor.setActorId(existingActor.getActorId());
			Actor update = actorRepository.save(updateActor);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Actor Object is updated..!");
			responseStructure.setData(update);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.OK);
			
		}
		else
		{
			responseStructure.setStatusCode(HttpStatus.NOT_MODIFIED.value());
			responseStructure.setMessage("Actor Object not Modified..!");
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.NOT_MODIFIED);
		}
		
	}

	@Override
	public ResponseEntity<ResponseStructure<Actor>> deleteByActorId(int actorId) 
	{
		Optional<Actor> optional = actorRepository.findById(actorId);
		ResponseStructure<Actor> responseStructure = new ResponseStructure<>();
		if(optional.isPresent())
		{
			Actor existingActor = optional.get();
			actorRepository.deleteById(actorId);
			responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
			responseStructure.setMessage("Actor Object Deleted Successfully..!");
			responseStructure.setData(existingActor);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.NO_CONTENT);
			
		}
		else
		{
			responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
			responseStructure.setMessage("Actor Object Not Deleted Successufully..!");
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.NO_CONTENT);
		}
		
		
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActors() 
	{
		List<Actor> actors = actorRepository.findAll();
		ResponseStructure<List<Actor>> responseStructure = new ResponseStructure<>();
		
		if(actors.isEmpty())
		{
			 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			 responseStructure.setMessage("No Data Avilable...!");
			 responseStructure.setData(null);
			 return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.NOT_FOUND);
		}
		
		else 
		{
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("All Actor Objects Founded....!");
			responseStructure.setData(actors);
			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> deleteAllActors() 
	{
		List<Actor> actors = actorRepository.findAll();
		actorRepository.deleteAll();
		ResponseStructure<List<Actor>> responseStructure = new ResponseStructure<>();
		
		if(actors.isEmpty())
		{
			 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			 responseStructure.setMessage("No Data Avilable To Delete...!");
			 responseStructure.setData(null);
			 return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.NOT_FOUND);
		}
		
		else 
		{
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("All Actor Objects Deleted Successfully....!");
			responseStructure.setData(actors);
			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}
	}
	
	
}

package com.lmig.gfc.wimp.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.MovieRepository;

@RestController
@RequestMapping("/api/movies/{movieId}/performers")
public class PerformersApiController {
	private ActorRepository actorRepo;
	private MovieRepository movieRepo;

	public PerformersApiController(ActorRepository actorRepo, MovieRepository movieRepo) {
		this.actorRepo = actorRepo;
		this.movieRepo = movieRepo;
	}
	
	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Movie create(@PathVariable Long movieId, @RequestBody Long actorId) {
		Movie movie = movieRepo.findOne(movieId);
		Actor actor = actorRepo.findOne(actorId);
		
		//To stop individual form bing added as an owner more than once
		if(!movie.getActors().contains(actor)) {
			movie.getActors().add(actor);
			movieRepo.save(movie);
		}
		return movie;
	}

}

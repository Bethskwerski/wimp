package com.lmig.gfc.wimp.comfig;

import java.util.Date;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.MovieRepository;

@Configuration
public class SeedData {

	public SeedData(ActorRepository actorRepo, MovieRepository movieRepo) {
		actorRepo.save(new Actor("Mike", "Smith", (long) 2015, new Date(2000, 1, 12)));
		actorRepo.save(new Actor("Susan", "Hale", (long) 2015, new Date(2000, 1, 12)));
		actorRepo.save(new Actor("Tom", "Appleton", (long) 2015, new Date(2000, 1, 12)));
		actorRepo.save(new Actor("Lori", "Rider", (long) 2015, new Date(2000, 1, 12)));
		movieRepo.save(new Movie("A Method To Far", new Date(2015, 3, 6), (long) 1000000, "Java-R-Us"));
		movieRepo.save(new Movie("Game of Code", new Date(2000, 1, 6), (long) 5000000, "Just Coding"));
		movieRepo.save(new Movie("Wonder JPA", new Date(2017, 5, 9), (long) 10000000, "Over Done SuperHeros"));
		movieRepo.save(new Movie("Dr Postgres", new Date(2015, 3, 6), (long) 1000000, "Data is Cool"));
	}

}

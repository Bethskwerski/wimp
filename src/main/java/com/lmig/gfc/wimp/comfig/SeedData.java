package com.lmig.gfc.wimp.comfig;

import java.util.Date;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.AwardRepository;
import com.lmig.gfc.wimp.services.MovieRepository;

@Configuration
public class SeedData {

	public SeedData(ActorRepository actorRepo, MovieRepository movieRepo, AwardRepository awardRepo) {
		actorRepo.save(new Actor("Mike", "Smith", 2015L, new Date(2000, 1, 12)));
		actorRepo.save(new Actor("Susan", "Hale", 2015L, new Date(2000, 1, 12)));
		actorRepo.save(new Actor("Tom", "Appleton", 2015L, new Date(2000, 1, 12)));
		actorRepo.save(new Actor("Lori", "Rider", 2015L, new Date(2000, 1, 12)));
		movieRepo.save(new Movie("A Method To Far", new Date(2015, 3, 6), 1000000L, "Java-R-Us"));
		movieRepo.save(new Movie("Game of Code", new Date(2000, 1, 6), 5000000L, "Just Coding"));
		movieRepo.save(new Movie("Wonder JPA", new Date(2017, 5, 9), 10000000L, "Over Done SuperHeros"));
		movieRepo.save(new Movie("Dr Postgres", new Date(2015, 3, 6), 1000000L, "Data is Cool"));

	}

}

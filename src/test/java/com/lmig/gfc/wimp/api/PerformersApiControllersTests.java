package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.MovieRepository;


public class PerformersApiControllersTests {
	
	private PerformersApiController controller;
	@Mock
	private MovieRepository movieRepo;
	@Mock
	private ActorRepository actorRepo;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new PerformersApiController(actorRepo, movieRepo);
	}

	@Test
	public void create_when_actor_is_not_in_movie() {
		// Arrange
		Movie movie = new Movie();
		movie.setActors(new ArrayList<Actor>());
		Actor actor = new Actor();
		when(movieRepo.findOne(7L)).thenReturn(movie);
		when(actorRepo.findOne(3L)).thenReturn(actor);

		// act
		Movie actual = controller.create(7L, 3L);

		// Assert
		assertThat(actual).isSameAs(movie);
		verify(movieRepo).save(movie);
		assertThat(movie.getActors()).contains(actor);
		verify(movieRepo).findOne(7L);
		verify(actorRepo).findOne(3L);

	}

	@Test
	public void create_does_not_save_an_actor_if_the_actor_already_in_movie() {
		// Arrange
		Actor actor = new Actor();
		ArrayList<Actor> actors = new ArrayList<Actor>();
		actors.add(actor);
		Movie movie = new Movie();
		movie.setActors(actors);
		when(movieRepo.findOne(2L)).thenReturn(movie);
		when(actorRepo.findOne(3L)).thenReturn(actor);
		
		//act
		Movie actual = controller.create(2L, 3L);
		
		
		//Assert
		verify(actorRepo).findOne(3L);
		verify(movieRepo).findOne(2L);
		assertThat(actual).isSameAs(movie);
		verify(movieRepo, never()).save(movie);
		assertThat(movie.getActors()).hasSize(1);

	}


}

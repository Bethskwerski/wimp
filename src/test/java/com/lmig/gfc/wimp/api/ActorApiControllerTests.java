package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.services.ActorRepository;


public class ActorApiControllerTests {
	private ActorApiController controller;
	private ActorRepository repo;

	@Before
	public void setUp() {
		repo = mock(ActorRepository.class);
		controller = new ActorApiController(repo);
	}


	@Test
	public void Get_all_from_actor() {
		// Arrange
		ArrayList<Actor> actors = new ArrayList<Actor>();
		actors.add(new Actor("Mike", "Smith", 2015L, new Date(2000, 1, 12)));
		when(repo.findAll()).thenReturn(actors);
		

		// Act
		List<ActorView> actual = controller.getAll();

		// Assert
		assertThat(actual.size()).isSameAs(actors.size());
		assertThat(actual.get(0).getId()).isEqualTo(actors.get(0).getId());
		verify(repo).findAll();
	}

	

	@Test
	public void create_an_actor_and_saves_it() {
		// Arrange
		Actor actor = new Actor();
		when(repo.save(actor)).thenReturn(actor);

		// Act
		Actor actual = controller.create(actor);

		// Assert
		assertThat(actual).isSameAs(actor);
		verify(repo).save(actor);

	}

	@Test
	public void getOne_returns_the_actor() {
		// Arrange
		Actor actor = new Actor();
		when(repo.findOne(2L)).thenReturn(actor);

		// Act
		Actor actual = controller.getOne(2L);

		// Assert
		assertThat(actual).isSameAs(actor);
		verify(repo).findOne(2L);
		
	}

	@Test
	public void getOne_with_null() {
//		// Arrange
//		// not needed here since a mock object returns null
//		// for any method that returns a capital letter
//		// thing or you can be explicit with the next line
		when(repo.findOne(2L)).thenReturn(null);

		// Act
		Actor actual = controller.getOne(2L);

		// Assert
		assertThat(actual).isNull();
		verify(repo).findOne(2L);
		
	}

	@Test
	public void updates_sets_id_of_actors_and_calls_save_and_returns_actor() {
		// Arrange
		Actor actor = new Actor();
		when(repo.save(actor)).thenReturn(actor);

		// Act
		Actor actual = controller.update(actor, 3L);

		// Assert
		assertThat(actual).isSameAs(actor);
		verify(repo).save(actor);
		assertThat(actor.getId()).isEqualTo(3L);

	}

	@Test
	public void delete_removes_actor_at_id_and_returns_it() {
		// Arrange
		Actor actor = new Actor();
		when(repo.findOne(2L)).thenReturn(actor);

		// Act
		Actor actual = controller.delete(2L);

		// Assert
		assertThat(actual).isSameAs(actor);
		verify(repo).findOne(2L);
		verify(repo).delete(2L);

	}
	
}

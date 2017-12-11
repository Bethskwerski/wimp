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


import com.lmig.gfc.wimp.models.Movie;
import com.lmig.gfc.wimp.services.MovieRepository;

public class MovieApiControllerTests {
	private MovieApiController controller;
	private MovieRepository repo;

	@Before
	public void setUp() {
		repo = mock(MovieRepository.class);
		controller = new MovieApiController(repo);
	}


//	@Test
	public void Get_all_from_movie() {
		// Arrange
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("Game of Code", new Date(2000, 1, 6), 5000000L, "Just Coding"));
		when(repo.findAll()).thenReturn(movies);
		

		// Act
		List<Movie> actual = controller.getAll();

		// Assert
		assertThat(actual.size()).isSameAs(movies.size());
		assertThat(actual.get(0).getId()).isEqualTo(movies.get(0).getId());
		verify(repo).findAll();
	}
	
	
	@Test
	public void create_a_movie_and_saves_it() {
		// Arrange
		Movie movie = new Movie();
		when(repo.save(movie)).thenReturn(movie);

		// Act
		Movie actual = controller.create(movie);

		// Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).save(movie);

	}

	@Test
	public void get_one_returns_the_movie() {
		// Arrange
		Movie movie = new Movie();
		when(repo.findOne(2L)).thenReturn(movie);

		// Act
		Movie actual = controller.getOne(2L);

		// Assert
		assertThat(actual).isSameAs(movie);
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
		Movie actual = controller.getOne(2L);

		// Assert
		assertThat(actual).isNull();
		verify(repo).findOne(2L);
		
	}

	@Test
	public void updates_sets_id_of_movie_and_calls_save_and_returns_movie() {
		// Arrange
		Movie movie = new Movie();
		when(repo.save(movie)).thenReturn(movie);

		// Act
		Movie actual = controller.update(movie, 3L);

		// Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).save(movie);
		assertThat(movie.getId()).isEqualTo(3L);

	}

	@Test
	public void delete_removes_actor_at_id_and_returns_it() {
		// Arrange
		Movie movie = new Movie();
		when(repo.findOne(2L)).thenReturn(movie);

		// Act
		Movie actual = controller.delete(2L);

		// Assert
		assertThat(actual).isSameAs(movie);
		verify(repo).findOne(2L);
		verify(repo).delete(2L);

	}
	
}



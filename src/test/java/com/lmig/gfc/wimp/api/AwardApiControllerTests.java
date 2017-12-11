package com.lmig.gfc.wimp.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.AwardRepository;

public class AwardApiControllerTests {
	
	private AwardApiController controller;
	
	@Mock
	private ActorRepository actorRepo;
	@Mock
	private AwardRepository awardRepo;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new AwardApiController(awardRepo, actorRepo);
	}

	@Test
	public void create_an_award_for_actor() {
		// Arrange
		Actor actor = new Actor();
		Award award = new Award();
		when(actorRepo.findOne(3L)).thenReturn(actor);

		// act
		Actor actual = controller.create(3L, award);

		// Assert
		assertThat(actual).isSameAs(actor);
		verify(awardRepo).save(award);
		assertThat(award.getActor()).isSameAs(actor);
		verify(actorRepo).findOne(3L);

	}

}

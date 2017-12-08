package com.lmig.gfc.wimp.api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;
import com.lmig.gfc.wimp.services.ActorRepository;
import com.lmig.gfc.wimp.services.AwardRepository;

@RestController
@RequestMapping("/api/actors/{actorId}/awards")
public class AwardApiController {
	private AwardRepository awardRepo;
	private ActorRepository actorRepo;
	
	public AwardApiController(AwardRepository awardRepo, ActorRepository actorRepo) {
		this.awardRepo = awardRepo;
		this.actorRepo = actorRepo;
		
	}
	
	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Actor create(@PathVariable Long actorId, @RequestBody Award award) {
		Actor actor = actorRepo.findOne(actorId);
			award.setActor(actor);
			awardRepo.save(award);
		return actor;
	}

}

package springmvc_hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_hibernate.model.Player;
import springmvc_hibernate.repository.PlayerRepo;

@Service
public class PlayerService {
	@Autowired
	private PlayerRepo playerRepo;

	public void savePlayer(Player user) {

		playerRepo.save(user);
	}
	

}

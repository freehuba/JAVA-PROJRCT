package springmvc_hibernate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import springmvc_hibernate.model.Player;
import springmvc_hibernate.service.PlayerService;

@Controller
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	@PostMapping("/saveUser")
	public void save(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int playerId = Integer.parseInt(req.getParameter("playerId"));
		String playerName = req.getParameter("playerName");
		int playerAge = Integer.parseInt(req.getParameter("playerAge"));
		String playerCountry = req.getParameter("playerCountry");
		String iplTeam = req.getParameter("iplTeam");
		int iplSalary = Integer.parseInt(req.getParameter("iplSalary"));

		Player p = new Player();
		p.setPlayerId(playerId);
		p.setPlayerName(playerName);
		p.setPlayerAge(playerAge);
		p.setPlayerCountry(playerCountry);
		p.setPlayerTeam(playerCountry);
		p.setIplSalary(iplSalary);
		
		 ModelAndView mView = new ModelAndView();
		 mView.addObject("message", "Successufully Inserted..!");
		 mView.setViewName("success.jsp");

		playerService.savePlayer(p);

	}

}

package springmvc_hibernate.model;

import javax.persistence.Entity;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Player 
{
	@Id
	private int playerId;
	private String playerName;
	private int playerAge;
	private String playerCountry;
	private String playerTeam;
	private String iplTeam;
	private int iplSalary;
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerAge() {
		return playerAge;
	}
	public void setPlayerAge(int playerAge) {
		this.playerAge = playerAge;
	}
	public String getPlayerCountry() {
		return playerCountry;
	}
	public void setPlayerCountry(String playerCountry) {
		this.playerCountry = playerCountry;
	}
	public String getPlayerTeam() {
		return playerTeam;
	}
	public void setPlayerTeam(String playerTeam) {
		this.playerTeam = playerTeam;
	}
	public String getIplTeam() {
		return iplTeam;
	}
	public void setIplTeam(String iplTeam) {
		this.iplTeam = iplTeam;
	}
	public int getIplSalary() {
		return iplSalary;
	}
	public void setIplSalary(int iplSalary) {
		this.iplSalary = iplSalary;
	}
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", playerAge=" + playerAge
				+ ", playerCountry=" + playerCountry + ", playerTeam=" + playerTeam + ", iplTeam=" + iplTeam
				+ ", iplSalary=" + iplSalary + "]";
	}
	
	

}

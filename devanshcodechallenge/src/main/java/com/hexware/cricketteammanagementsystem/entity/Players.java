package com.hexware.cricketteammanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Players")
public class Players {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	@NotNull
	@Size(min=2,max=20,message=" player name must be within desired limits")
	private String playerName;
	@NotNull
	private int jerseyNumber;
	@NotNull
	@Size(min=2,max=20,message=" role must be within desired limits")
	private String role;
	@NotNull
	private int totalMatches;
	@NotNull
	@Size(min=2,max=20,message=" team name must be within desired limits")
	private String teamName;
	@NotNull
	@Size(min=2,max=20,message=" country name must be within desired limits")
	private String country;
	@NotNull
	@Size(min=2,max=20,message=" state name must be within desired limits")
	private String state;
	@NotNull
	@Size(min=2,max=20,message=" description must be within desired limits")
	private String description;
	
	public Players()
	{super();}

	public Players(int playerId,
			@NotNull @Size(min = 2, max = 20, message = " player name must be within desired limits") String playerName,
			@NotNull int jerseyNumber,
			@NotNull @Size(min = 2, max = 20, message = " role must be within desired limits") String role,
			@NotNull int totalMatches,
			@NotNull @Size(min = 2, max = 20, message = " team name must be within desired limits") String teamName,
			@NotNull @Size(min = 2, max = 20, message = " country name must be within desired limits") String country,
			@NotNull @Size(min = 2, max = 20, message = " state name must be within desired limits") String state,
			@NotNull @Size(min = 2, max = 20, message = " description must be within desired limits") String description) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.jerseyNumber = jerseyNumber;
		this.role = role;
		this.totalMatches = totalMatches;
		this.teamName = teamName;
		this.country = country;
		this.state = state;
		this.description = description;
	}

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

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Players [playerId=" + playerId + ", playerName=" + playerName + ", jerseyNumber=" + jerseyNumber
				+ ", role=" + role + ", totalMatches=" + totalMatches + ", teamName=" + teamName + ", country="
				+ country + ", state=" + state + ", description=" + description + "]";
	}
	

}

package com.hexware.cricketteammanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.hexware.cricketteammanagementsystem.dto.PlayerDTO;
import com.hexware.cricketteammanagementsystem.entity.Players;
import com.hexware.cricketteammanagementsystem.exception.DuplicateJerseyNumberException;
import com.hexware.cricketteammanagementsystem.exception.PlayerNotFoundException;

public interface IPlayerService {
	//Add player
	public Players addPlayer(Players player) throws DuplicateJerseyNumberException;
	
	//Update Player Details
	public Players updatePlayer(int pid,Players player) throws PlayerNotFoundException;
	
	
	//Get Player By ID
	public Players getPlayerById(int pid) throws PlayerNotFoundException;
	
	// Delete Player By ID
	public String deletePlayerById(int pid) throws PlayerNotFoundException;
	
	//View Player ID,Name,JerseyNumber,Role
	Optional<PlayerDTO> viewPlayerDetails(int playerId) throws PlayerNotFoundException;

}

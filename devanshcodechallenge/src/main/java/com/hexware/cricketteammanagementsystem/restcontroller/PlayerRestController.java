package com.hexware.cricketteammanagementsystem.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexware.cricketteammanagementsystem.dto.PlayerDTO;
import com.hexware.cricketteammanagementsystem.entity.Players;
import com.hexware.cricketteammanagementsystem.exception.DuplicateJerseyNumberException;
import com.hexware.cricketteammanagementsystem.exception.PlayerNotFoundException;
import com.hexware.cricketteammanagementsystem.service.IPlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {
	@Autowired
	IPlayerService service;
	
	//Adding Player
	@PostMapping(value="/addplayers",consumes = "application/json",produces = "application/json")
	public Players addPlayer(@Valid @RequestBody Players player) throws DuplicateJerseyNumberException {

		return service.addPlayer(player);

	}
	
	//Update Player Details
	@PutMapping("/updateplayers/{playerId}")
	public Players  updatePlayer(@PathVariable int playerId,@Valid @RequestBody Players player) throws PlayerNotFoundException {

		return service.updatePlayer(playerId, player);
		
	}
	
	
	//Get Player By ID
	@GetMapping("/getplayerbyid/{pid}") 
	public Players   getPlayerById(@PathVariable int pid) throws PlayerNotFoundException {
		
		return  service.getPlayerById(pid);
		
	}
	
	// View Player Details
	@GetMapping(value="/getallplayers/{playerId}",produces = "application/json")
	public Optional<PlayerDTO>  viewPlayerDetails(@PathVariable int playerId) throws PlayerNotFoundException{
		
		
		return service.viewPlayerDetails(playerId);
		
	}
	
	//Delete Player By ID
	@DeleteMapping("/deleteplayerbyid/{pid}") 
	public String  deleteDoctorById(@PathVariable int pid) throws PlayerNotFoundException {
		
		return  service.deletePlayerById(pid);
		
	}
	

}

package com.hexware.cricketteammanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexware.cricketteammanagementsystem.dto.PlayerDTO;
import com.hexware.cricketteammanagementsystem.entity.Players;
import com.hexware.cricketteammanagementsystem.exception.DuplicateJerseyNumberException;
import com.hexware.cricketteammanagementsystem.exception.PlayerNotFoundException;
import com.hexware.cricketteammanagementsystem.repository.PlayerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlayerServiceImpl implements IPlayerService{

	
	@Autowired
	PlayerRepository repo;
	
	
	
	@Override
	public Players addPlayer(Players player) throws DuplicateJerseyNumberException {
		
		
		try { //Check If jersey Number Already Exist.
		if(repo.existsByjerseyNumber(player.getJerseyNumber()))
		{ throw new DuplicateJerseyNumberException("Jersey Number Already Exist");}
	   return repo.save(player);}
		catch(DuplicateJerseyNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Players updatePlayer(int pid,Players player) throws PlayerNotFoundException {
		
		Players existing=repo.findById(pid).orElseThrow(()-> new PlayerNotFoundException("Player not found with ID:  "+pid));
		existing.setPlayerName(player.getPlayerName());
		existing.setJerseyNumber(player.getJerseyNumber());
		existing.setRole(player.getRole());
		existing.setTotalMatches(player.getTotalMatches());
		existing.setTeamName(player.getTeamName());
		existing.setCountry(player.getCountry());
		existing.setState(player.getState());
		existing.setDescription(player.getDescription());
		return repo.save(existing);
	}

	@Override
	public Players getPlayerById(int pid) throws PlayerNotFoundException{
		
				return repo.findById(pid).orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + pid));
			
	    }
	

	@Override
	public String deletePlayerById(int pid) throws PlayerNotFoundException{
		
		 try {
	            // Check If Player Exists
	            if (!repo.existsById(pid)) {
	                // If not, throw an exception with a  message
	                throw new PlayerNotFoundException("Player not found with id:  "+pid);
	            }
	            // If the player exists, delete the player
	            repo.deleteById(pid);
	            return "Player Record Deleted";
	        } catch (PlayerNotFoundException ex) {
	            // Log the exception message and rethrow the exception
	            System.err.println(ex.getMessage());
	            throw ex;
	        }
	}

	@Override
	 public Optional<PlayerDTO> viewPlayerDetails(int playerId)throws PlayerNotFoundException {
        Optional<Players> play = repo.findById(playerId);
        
        try{if (!play.isPresent()) {
        	throw new PlayerNotFoundException("Player not found with ID:    "+playerId);}
            Players player = play.get();
            PlayerDTO playerDTO = new PlayerDTO(
                player.getPlayerId(),
                player.getPlayerName(),
                player.getJerseyNumber(),
                player.getRole()
            );
            return Optional.of(playerDTO);
        }
        catch(PlayerNotFoundException ex) {
            // Log the exception message and rethrow the exception
            System.err.println(ex.getMessage());
            throw ex;
        } 
	
	}
}



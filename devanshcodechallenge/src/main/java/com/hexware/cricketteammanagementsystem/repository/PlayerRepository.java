package com.hexware.cricketteammanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexware.cricketteammanagementsystem.dto.PlayerDTO;
import com.hexware.cricketteammanagementsystem.entity.Players;

@Repository
public interface PlayerRepository extends JpaRepository<Players,Integer>{
	
	////View Player ID,Name,JerseyNumber,Role
	@Query("select p.playerId,p.playerName,p.jerseyNumber,p.role  from Players p where p.playerId=?1")
	List<PlayerDTO>  viewPlayerDetails(int playerId);

	
	//To check if JerseyNumber already Exist
	boolean existsByjerseyNumber(int jerseyNumber);
	
	

}

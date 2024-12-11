import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Player } from '../Model/Player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
   baseUrl:string="http://localhost:8081/api/players/";
  constructor(private http:HttpClient) { }

  addPlayer(player:Player):Observable<Player>
  { return this.http.post<Player>(this.baseUrl+"addplayers",player);}

  updatePlayer(player:Player):Observable<Player>
  {return this.http.put<Player>(this.baseUrl+`updateplayers/${player.playerId}`,player);}

  displayPlayerById(playerId:number):Observable<Player>
  { return this.http.get<Player>(this.baseUrl+`getplayer/${playerId}`);}


}

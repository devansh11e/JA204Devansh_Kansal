import { Component } from '@angular/core';
import { Player } from 'src/app/Model/Player';
import { PlayerService } from 'src/app/Service/player.service';

@Component({
  selector: 'app-display-player-by-id',
  templateUrl: './display-player-by-id.component.html',
  styleUrls: ['./display-player-by-id.component.css']
})
export class DisplayPlayerByIdComponent {
playList:Player[]=[];
constructor(private service:PlayerService){}

displayPlayerById(data:any)
{ const playerID=data.playerId;
  console.log(playerID);
  return this.service.displayPlayerById(playerID).subscribe(
    (response:Player)=>{ this.playList=[response]; console.log(this.playList);},
    (err)=>{ if (err.status === 404) {
      alert("Player not found");
    }console.log(err);}
  );
}
}

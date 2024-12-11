import { Component } from '@angular/core';
import { Player } from 'src/app/Model/Player';
import { PlayerService } from 'src/app/Service/player.service';

@Component({
  selector: 'app-update-player',
  templateUrl: './update-player.component.html',
  styleUrls: ['./update-player.component.css']
})
export class UpdatePlayerComponent {
 constructor(private service:PlayerService)
 { }

 updatePlayer(player:Player)
 { return this.service.updatePlayer(player).subscribe(
  (response)=>{console.log(response),alert(response.playerId+" player updated successfully");},
  (err)=>{console.log(err);}
 );}
}

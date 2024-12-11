import { Component } from '@angular/core';
import { Player } from 'src/app/Model/Player';
import { PlayerService } from 'src/app/Service/player.service';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent {
  constructor(private service:PlayerService)
  {}
  
  addPlayer(player:Player)
  {return this.service.addPlayer(player).subscribe(
    (response)=>{console.log(response),alert(response.playerId+" player added successfully");},
    (err)=>{console.log(err);
      if (err.status === 500) {
        alert("Jersey number already exists!");
    }
    }
  );}
}

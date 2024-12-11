import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AddPlayerComponent } from './Components/add-player/add-player.component';
import { UpdatePlayerComponent } from './Components/update-player/update-player.component';
import { DisplayPlayerByIdComponent } from './Components/display-player-by-id/display-player-by-id.component';

const routes: Routes = [
  {path:'home',component:AppComponent},
  {path:'add-player',component:AddPlayerComponent},
  {path:'update-player',component:UpdatePlayerComponent},
  {path:'display-player',component:DisplayPlayerByIdComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

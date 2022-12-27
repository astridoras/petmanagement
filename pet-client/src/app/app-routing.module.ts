import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {PetsListComponent} from "./components/pets-list/pets-list.component";
import {AddPetComponent} from "./components/add-pet/add-pet.component";

const routes: Routes = [
  { path: '', redirectTo: '/users/1/pets', pathMatch: 'full' },
  { path: 'users/:userId/pets', component: PetsListComponent },
  { path: 'users/:userId/pets/add', component: AddPetComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

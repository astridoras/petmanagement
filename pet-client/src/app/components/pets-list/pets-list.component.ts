import {Component, OnInit} from '@angular/core';
import {PetService} from "../../services/pet.service";
import {Pet} from "../../models/pet.model";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-pets-list',
  templateUrl: './pets-list.component.html',
  styleUrls: ['./pets-list.component.css']
})
export class PetsListComponent implements OnInit {
  pets: Pet[] = [];
  userId = this.route.snapshot.paramMap.get('userId');

  constructor(private service: PetService,
              private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.getPets();
  }

  getPets(): void {
    this.service.getAll(this.userId as string).subscribe(pets => this.pets = pets);
  }

}

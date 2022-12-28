import {Component, OnInit} from '@angular/core';
import {PetService} from "../../services/pet.service";
import {Country} from "../../models/country.model";
import {Color} from "../../models/color.model";
import {Type} from "../../models/type.model";
import {FormBuilder, Validators} from '@angular/forms';
import {PetJson} from "../../models/pet.json.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.css']
})
export class AddPetComponent implements OnInit {
  countries: Country[] = [];
  types: Type[] = [];
  colors: Color[] = [];
  submitted = false;
  userId = this.route.snapshot.paramMap.get('userId');


  petForm = this.formBuilder.group({
    petName: ['', Validators.required],
    petCode: ['', [Validators.required, Validators.minLength(5)]],
    type: ['', Validators.required],
    color: ['', Validators.required],
    country: ['',Validators.required],
  });

  constructor(private service: PetService,
              private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.service.getAllCountries().subscribe(countries => this.countries = countries);
    this.service.getAllTypes().subscribe(types => this.types = types);
    this.service.getAllColors().subscribe(colors => this.colors = colors);
  }

  get f() { return this.petForm.controls; }

  onSubmit(): void {
    this.submitted = true;
    if (this.petForm.invalid) {
      return;
    }
    this.service.create(this.userId as string, this.petForm.value as PetJson).subscribe();
    this.submitted = false;
    this.router.navigate([`/users/${this.userId}/pets`])
      .then(() => {
        window.location.reload();
      });
  }
}




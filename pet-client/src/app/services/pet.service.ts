import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Pet} from "../models/pet.model";
import {Country} from "../models/country.model";
import {Color} from "../models/color.model";
import {Type} from "../models/type.model";
import {PetJson} from "../models/pet.json.model";

@Injectable({
  providedIn: 'root'
})
export class PetService {
  baseUrl = 'http://localhost:8080';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private http: HttpClient) {
  }

  getAll(userId: string): Observable<Pet[]> {
    return this.http.get<Pet[]>(`${this.baseUrl}/users/${userId}/pets`);
  }

  create(userId: string, data: PetJson): Observable<PetJson> {
    return this.http.post<PetJson>(`${this.baseUrl}/users/${userId}/pets`, data,
      this.httpOptions);
  }

  getAllCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(`${this.baseUrl}/countries`);
  }

  getAllColors(): Observable<Color[]> {
    return this.http.get<Color[]>(`${this.baseUrl}/colors`);
  }

  getAllTypes(): Observable<Type[]> {
    return this.http.get<Type[]>(`${this.baseUrl}/types`);
  }

}

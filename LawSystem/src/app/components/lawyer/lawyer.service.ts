import { Injectable } from '@angular/core';
import { Lawyer } from './Lawyer';
// import { HttpClient } from 'selenium-webdriver/http';
import { HttpClient, HttpHeaders } from '@angular/common/http'

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    //'Authorization': 'Bearer '+ this.authService.getToken()
  })
};


@Injectable({
  providedIn: 'root'
})
export class LawyerService {

  private Url = 'http://Localhost:8080/api/Lawyer';
  constructor(private http: HttpClient) { }


  getList(): Observable<Lawyer[]> {
    console.log(this.Url + '/list');
    return this.http.get<Lawyer[]>(this.Url + '/list', httpOptions)
      .pipe(
        tap(items => this.log(`fetched List`)),
        catchError(this.handleError('getList', []))
      );
  }

  /** GET Lawyer by id. Will 404 if id not found */
  //  getDataByid(id: number): Observable<Lawyer> {
  //   const url = `${this.Url+'/find/'+id}`;
  //   return this.http.get<Lawyer>(url).pipe(
  //     tap(_ => this.log(`fetched Lawyer id=${id}`)),
  //     catchError(this.handleError<Lawyer>(`getLawyer id=${id}`))
  //   );
  // }


  addLawyer(Lawyer: Lawyer): Observable<Lawyer> {
    return this.http.post<Lawyer>(this.Url + '/save', Lawyer, httpOptions).pipe(
      tap((Lawyer: Lawyer) => this.log(`added Lawyer `)),
      catchError(this.handleError<Lawyer>('addLawyer'))
    );
  }

  updateLawyer(Lawyer: Lawyer): Observable<Lawyer> {
    //alert(JSON.stringify(Lawyer));
    //alert(this.Url+'/save');
    return this.http.put<Lawyer>(this.Url + '/update', Lawyer, httpOptions).pipe(
      tap((Lawyer: Lawyer) => this.log(`updated Lawyer `)),
      catchError(this.handleError<Lawyer>('addLawyer'))
    );
  }


  deleteLawyer(id: Number): Observable<any> {
    // const id1 = typeof Lawyer === 'number' ? Lawyer : Lawyer.Lawyerid;
    const url = `${this.Url + '/delete/' + id}`;
    return this.http.delete<any>(url, httpOptions).pipe(
      tap(_ => this.log(`deleted Lawyer id=${id}`)),
      catchError(this.handleError<any>('deleteLawyer'))
    );
  }


  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
  private log(message: string) {
    console.log(message);
  }
}

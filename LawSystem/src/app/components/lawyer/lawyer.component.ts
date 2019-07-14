import { Component, OnInit } from '@angular/core';
import { Lawyer } from './Lawyer';
import { LawyerService } from './lawyer.service';

@Component({
  selector: 'app-lawyer',
  templateUrl: './lawyer.component.html',
  styleUrls: ['./lawyer.component.css']
})
export class LawyerComponent implements OnInit {
  item: any;

  constructor(private service: LawyerService) { }

  ngOnInit() {
    this.newItem();
  }


  addLawyer() {
    this.service.addLawyer(this.item).subscribe(res => {
      alert(res);
    });
  }

  newItem() {
    this.item = new Lawyer(null, null, null, null, null, null);
  }
}

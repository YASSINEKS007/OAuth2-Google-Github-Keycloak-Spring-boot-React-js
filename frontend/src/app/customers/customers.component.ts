import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MatSort} from "@angular/material/sort";
import {MatPaginator} from "@angular/material/paginator";
import {CustomerService} from "../services/customer.service";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit {
  public customers: any;
  public dataSource: any;
  public displayedColumns = ['id', 'name', 'email'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;


  constructor(private http: HttpClient,
              private customerService: CustomerService) {
  }

  ngOnInit() {
    this.loadCustomers();
  }

  loadCustomers(): void {
    this.customerService.getAllCustomers().subscribe({
      next: (data: any) => {
        console.log('Data received: ', data);
        this.customers = data;
        this.dataSource = new MatTableDataSource(this.customers);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;

        if (this.customers.length === 0) {
          console.log("there is no data in database")
        }
      },
      error: (err) => {
        console.log(err);

      },
    });
  }

}

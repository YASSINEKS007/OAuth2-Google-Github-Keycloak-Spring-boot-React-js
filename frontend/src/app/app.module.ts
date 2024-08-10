import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';
import {ProductsComponent} from './products/products.component';
import {CustomersComponent} from './customers/customers.component';
import {TemplateComponent} from './template/template.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule, MatIconButton} from "@angular/material/button";
import {MatDrawerContainer} from "@angular/material/sidenav";
import {MatListItem, MatListModule} from "@angular/material/list";
import {provideHttpClient} from "@angular/common/http";
import {MatPaginatorModule} from "@angular/material/paginator";
import {
  MatCell,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow,
  MatRowDef,
  MatTableModule
} from "@angular/material/table";
import {MatSortModule} from "@angular/material/sort";

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    CustomersComponent,
    TemplateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatIconButton,
    MatDrawerContainer,
    MatListModule,
    MatListItem,
    MatButtonModule,
    MatPaginatorModule,
    MatHeaderRow,
    MatRow,
    MatCell,
    MatColumnDef,
    MatHeaderCell,
    MatHeaderRowDef,
    MatRowDef,
    MatTableModule,
    MatSortModule,

  ],
  providers: [
    provideAnimationsAsync(),
    provideHttpClient(),
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}

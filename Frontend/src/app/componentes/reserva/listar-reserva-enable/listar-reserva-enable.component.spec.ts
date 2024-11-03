import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarReservaEnableComponent } from './listar-reserva-enable.component';

describe('ListarReservaEnableComponent', () => {
  let component: ListarReservaEnableComponent;
  let fixture: ComponentFixture<ListarReservaEnableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarReservaEnableComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarReservaEnableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

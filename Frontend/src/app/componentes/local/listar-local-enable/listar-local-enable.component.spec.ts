import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarLocalEnableComponent } from './listar-local-enable.component';

describe('ListarLocalEnableComponent', () => {
  let component: ListarLocalEnableComponent;
  let fixture: ComponentFixture<ListarLocalEnableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarLocalEnableComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarLocalEnableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

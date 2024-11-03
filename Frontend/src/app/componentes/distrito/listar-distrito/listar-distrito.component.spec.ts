import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarDistritoComponent } from './listar-distrito.component';

describe('ListarDistritoComponent', () => {
  let component: ListarDistritoComponent;
  let fixture: ComponentFixture<ListarDistritoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarDistritoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarDistritoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

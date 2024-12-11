import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayPlayerByIdComponent } from './display-player-by-id.component';

describe('DisplayPlayerByIdComponent', () => {
  let component: DisplayPlayerByIdComponent;
  let fixture: ComponentFixture<DisplayPlayerByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayPlayerByIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayPlayerByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

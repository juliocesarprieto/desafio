import { TestBed, inject } from '@angular/core/testing';

import { LivrosServiceService } from './livros-service.service';

describe('LivrosServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LivrosServiceService]
    });
  });

  it('should be created', inject([LivrosServiceService], (service: LivrosServiceService) => {
    expect(service).toBeTruthy();
  }));
});

package com.coches.services.dtos;

import org.springframework.stereotype.Service;

@Service
public interface DtoFactory {
    DtoAssemblerCar getCars();
}
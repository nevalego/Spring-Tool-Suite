package com.coches.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.coches.entities.Car;
import com.coches.repositorios.RepositoryFactory;
import com.coches.services.CarsService;
import com.coches.services.dtos.CarDto;
import com.coches.services.dtos.DtoFactory;

@Service
public class CarsServiceImpl implements CarsService {

	private RepositoryFactory repositoryFactory;
	private DtoFactory dtoFactory;

	@Autowired
	public CarsServiceImpl(RepositoryFactory repositoryFactory, DtoFactory dtoFactory) {
		this.repositoryFactory = repositoryFactory;
		this.dtoFactory = dtoFactory;
	}

	@Override
	public List<CarDto> save(CarDto carDto) {

		List<Car> carsList = repositoryFactory.getCars().findByMatricula(carDto.matricula);

		if (carsList.isEmpty()) {
			
			List<CarDto> cars = new ArrayList<>();
			
			cars.add(dtoFactory.getCars().carToDto(repositoryFactory
	                .getCars().save(dtoFactory.getCars().dtoToCar(carDto))));
			
			return cars;
		} else
			throw new DataIntegrityViolationException("Ya existe un coche con esa matrícula");
	}

	@Override
	public List<CarDto> findById(Long cocheID) {
		Optional<Car> optional = repositoryFactory.getCars().findById(cocheID);

		if (optional.isPresent()) {
			Car car = optional.get();
			List<Car> carsList = new ArrayList<>();
			carsList.add(car);
			return dtoFactory.getCars().listToDto(carsList);
		} else {
			throw new IllegalArgumentException("No se encuentra ningún coche con ese ID");
		}
	}

	@Override
	public List<CarDto> delete(Long cocheID) {
		Optional<Car> optional = repositoryFactory.getCars().findById(cocheID);
		if (optional.isPresent()) {
			Car car = optional.get();
			repositoryFactory.getCars().delete(car);

			optional = repositoryFactory.getCars().findById(cocheID);
			if (optional.isPresent())
				throw new IllegalArgumentException("No se ha eliminado el coche con éxito");
			else {
				List<Car> carsList = new ArrayList<>();
				carsList.add(car);
				List<CarDto> carDtosList = dtoFactory.getCars().listToDto(carsList);
				return carDtosList;
			}
		} else {
			throw new IllegalArgumentException("El coche no existe y por tanto no se puede eliminar");
		}
	}

	@Override
	public List<CarDto> findAll() {
		List<Car> cars = new ArrayList<>();

		cars = repositoryFactory.getCars().findAll();

		if (cars == null)
			throw new IllegalArgumentException("Error al obtener el listado de los coches");
		else if (cars.isEmpty()) {
			throw new IllegalArgumentException("No hay ningún coche");
		} else {
			return dtoFactory.getCars().listToDto(cars);
		}

	}
}

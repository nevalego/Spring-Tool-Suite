package com.ejemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ejemplo.entidades.Coche;
import com.ejemplo.repositorios.CochesRepository;

@SpringBootApplication
public class EjemploSpringApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context= SpringApplication.run(EjemploSpringApplication.class, args);
		
		CochesRepository repository = context.getBean(CochesRepository.class);

        // Guardar un conjunto de coches
        repository.save(new Coche("Ford", "2216GMN", 100));
        repository.save(new Coche("Opel", "5154JTH", 110));
        repository.save(new Coche("Lamborgini", "2506EFN", 1500));
        repository.save(new Coche("Audi", "7355HSC", 200));

        // findAll 
        Iterable<Coche> todos = repository.findAll();
        System.out.println("Listar todos los Coches:");
        for (Coche c : todos) {
            System.out.println("\t" + c);
        }
        System.out.println();

        context.close();
	}
}


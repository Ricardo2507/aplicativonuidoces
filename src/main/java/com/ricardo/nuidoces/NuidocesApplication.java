package com.ricardo.nuidoces;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardo.nuidoces.domain.Categoria;
import com.ricardo.nuidoces.repositories.CategoriaRepository;

@SpringBootApplication
public class NuidocesApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(NuidocesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Doces Simples");
		Categoria cat2 = new Categoria(null, "Doces Goumert");
		Categoria cat3 = new Categoria(null, "Torta de morango");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		
	}

}

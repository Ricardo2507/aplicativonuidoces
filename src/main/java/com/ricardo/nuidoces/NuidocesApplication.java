package com.ricardo.nuidoces;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ricardo.nuidoces.domain.Categoria;
import com.ricardo.nuidoces.domain.Cidade;
import com.ricardo.nuidoces.domain.Estado;
import com.ricardo.nuidoces.domain.Produto;
import com.ricardo.nuidoces.repositories.CategoriaRepository;
import com.ricardo.nuidoces.repositories.CidadeRepository;
import com.ricardo.nuidoces.repositories.EstadoRepository;
import com.ricardo.nuidoces.repositories.ProdutoRepository;

@SpringBootApplication
public class NuidocesApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(NuidocesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Doces Simples");
		Categoria cat2 = new Categoria(null, "Doces Goumert");
		
		
		Produto p1 = new Produto(null, "Brigadeiro simples", 1.40);
		Produto p2 = new Produto(null, "Beijinho simples", 1.40);
		Produto p3 = new Produto(null, "Brigadeiro Gourmet", 1.70);
		Produto p4 = new Produto(null, "Torta de morango", 51.00);
				
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p4));
		cat2.getProdutos().addAll(Arrays.asList(p3));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		
			
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		
	}

}

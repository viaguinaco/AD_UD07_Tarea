package eus.birt.dam.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import eus.birt.dam.domain.Articulo;

public interface ArticuloRepository extends MongoRepository<Articulo, String>{
	List<Articulo> findByAutor(String name);
}

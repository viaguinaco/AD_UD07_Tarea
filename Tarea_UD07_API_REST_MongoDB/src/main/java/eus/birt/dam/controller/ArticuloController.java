package eus.birt.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Articulo;
import eus.birt.dam.repository.ArticuloRepository;


@RestController
@RequestMapping ("api/articulos")
public class ArticuloController {
	@Autowired
	ArticuloRepository articuloRepository;
		
	@GetMapping({"/",""})
	public List <Articulo> index() {
		return articuloRepository.findAll();
	}
	
	/*@GetMapping("/{id}")
	public Articulo showById(@PathVariable("id") String id) {
		return articuloRepository.findById(id).orElse(null);
	}*/
	
	//Otra opcion es usar el nombre como elemento de busqueda en el EndPoint
	//Se crea el metodo findByFirstName en ArticuloRepository (solamente cabecera es suficiente)
		
	@GetMapping("/{name}")
	public List <Articulo> showByName(@PathVariable("name") String name) {
		return articuloRepository.findByAutor(name);
	}
	
	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Articulo create(@RequestBody Articulo articulo) {
		return articuloRepository.save(articulo);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Articulo update(@RequestBody Articulo articulo, @PathVariable("id") String id) {
		Articulo tempArticulo = articuloRepository.findById(id).orElse(null);
		
		tempArticulo.setTitulo(articulo.getTitulo());
		tempArticulo.setAutor(articulo.getAutor());
		tempArticulo.setFecha(articulo.getFecha());
		tempArticulo.setContenido(articulo.getContenido());
		tempArticulo.setOpiniones(articulo.getOpiniones());
		
		return articuloRepository.save(tempArticulo);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		articuloRepository.deleteById(id);
	}
}

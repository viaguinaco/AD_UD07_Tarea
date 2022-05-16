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
		
		@GetMapping("/{id}")
		public Articulo show(@PathVariable("id") Long id) {
			return articuloRepository.findById(id).orElse(null);
		}
		
		@PostMapping("/")
		@ResponseStatus (HttpStatus.CREATED)
		public Articulo create(@RequestBody Articulo articulo) {
			return articuloRepository.save(articulo);
		}
		
		@PutMapping("/{id}")
		@ResponseStatus (HttpStatus.CREATED)
		public Articulo update(@RequestBody Articulo articulo, @PathVariable("id") Long id) {
			Articulo tempArticulo = articuloRepository.findById(id).orElse(null);
			
			tempArticulo.setTitulo(articulo.getTitulo());
			tempArticulo.setAutor(articulo.getAutor());
			tempArticulo.setCategoria(articulo.getCategoria());
			tempArticulo.setFecha(articulo.getFecha());
			tempArticulo.setTexto(articulo.getTexto());
			//Al ser un id diferente el metodo save hace en realidad un update
			return articuloRepository.save(tempArticulo);
		}
		
		@DeleteMapping("/{id}")
		@ResponseStatus (HttpStatus.NO_CONTENT)
		public void delete(@PathVariable("id") Long id) {
			articuloRepository.deleteById(id);
		}
		

}

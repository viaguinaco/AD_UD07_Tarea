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

import eus.birt.dam.domain.Opinion;
import eus.birt.dam.repository.OpinionRepository;
import eus.birt.dam.repository.ArticuloRepository;

@RestController
@RequestMapping ("api/opiniones")

public class OpinionController {

	@Autowired
	OpinionRepository opinionRepository;
	
	@Autowired
	ArticuloRepository articuloRepository;
		
	@GetMapping({"/",""})
	public List <Opinion> index() {
		return opinionRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Opinion show(@PathVariable("id") Long id) {
		return opinionRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/")
	@ResponseStatus (HttpStatus.CREATED)
	public Opinion create(@RequestBody Opinion opinion) {
		return opinionRepository.save(opinion);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Opinion update(@RequestBody Opinion opinion, @PathVariable("id") Long id) {
		Opinion tempOpinion = opinionRepository.findById(id).orElse(null);
		
		tempOpinion.setNombre(opinion.getNombre());
		tempOpinion.setEmail(opinion.getEmail());
		tempOpinion.setFecha(opinion.getFecha());
		tempOpinion.setContenido(opinion.getContenido());
		tempOpinion.setArticulo(opinion.getArticulo());
		
		return opinionRepository.save(tempOpinion);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		opinionRepository.deleteById(id);
	}
	
}

package eus.birt.dam.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document ("articulos")
public class Articulo {

	@Id
	private String id; //Puede ser tambien ObjectId o BigInt
	
	private String titulo;
	
	private String autor;
	
	private String categoria;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	private String contenido;
	
	private List <Opinion> opiniones = new ArrayList<>();
	
	public Articulo(String titulo, String autor, String categoria, LocalDate fecha, String contenido, List <Opinion> opiniones) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
		this.contenido = contenido;
		this.opiniones = opiniones;
	}
	
	@Override
	  public String toString() {
	    return String.format(
	        "Articulo[id=%s, titulo='%s', autor='%s', categoria='%s', fecha='%s', contenido='%s']",
	        id, titulo, autor, categoria, fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), contenido);
	  }
	
}

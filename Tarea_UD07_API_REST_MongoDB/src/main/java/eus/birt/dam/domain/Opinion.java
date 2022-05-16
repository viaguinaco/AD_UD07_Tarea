package eus.birt.dam.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Opinion {

	private String id;
	
	private String nombre;
	
	private String email;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	private String contenido;
	

	public Opinion(String nombre, String email, LocalDate fecha, String contenido) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.fecha = fecha;
		this.contenido = contenido;
	}
}

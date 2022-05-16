package eus.birt.dam.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="opinion")
public class Opinion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String email;
	
	@Column
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	@Column(length=8192)
	private String contenido;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn (name = "articulo_id")
	private Articulo articulo;

	public Opinion(String nombre, String email, LocalDate fecha, String contenido) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.fecha = fecha;
		this.contenido = contenido;
	}
}

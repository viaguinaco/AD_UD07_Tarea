package eus.birt.dam.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Articulo")
public class Articulo implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@Column
		private String titulo;
		
		@Column
		private String autor;
		
		@Column
		private String categoria;
		
		@Column
		private LocalDate fecha;
		
		@Column(length=8192)
		private String texto;
		
		@JsonManagedReference
		@OneToMany
		@JoinColumn (name = "articulo_id")
		List <Opinion> opiniones = new ArrayList<>();

		public Articulo(String titulo, String autor, String categoria, LocalDate fecha, String texto) {
			super();
			this.titulo = titulo;
			this.autor = autor;
			this.categoria = categoria;
			this.fecha = fecha;
			this.texto = texto;
		}
}

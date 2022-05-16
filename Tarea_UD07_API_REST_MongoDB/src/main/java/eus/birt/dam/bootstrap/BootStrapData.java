package eus.birt.dam.bootstrap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Articulo;
import eus.birt.dam.domain.Opinion;
import eus.birt.dam.repository.ArticuloRepository;


@Component
public class BootStrapData implements CommandLineRunner{

	@Autowired
	private ArticuloRepository articuloRepository;
	
	
	@Override
	public void run(String... args) throws Exception {

	  articuloRepository.deleteAll();
      
	  
	  List <Opinion> opiniones1 = new ArrayList<>();
	  Opinion opinion1 = new Opinion(new ObjectId().toString(),"Manu Rodriguez","rodriguez@gmail.com",LocalDate.parse("2022/05/11"),"Asi no hay forma de llegar a UEFA");
	  Opinion opinion2 = new Opinion(new ObjectId().toString(),"ZuriGorri","goraleones@athletic.eus",LocalDate.parse("2022/05/12"),"La culpa de todo es de Urrutia. Ya veras con las elecciones como espabilan algunos...");
	  opiniones1.add(opinion1);
	  opiniones1.add(opinion2);
	  
	  List <Opinion> opiniones2 = new ArrayList<>();
	  Opinion opinion3 = new Opinion(new ObjectId().toString(),"No te lo digo","nosvigilan@terra.es",LocalDate.parse("2022/05/16"),"Lo del Covid es una farsa, menuda conspiracion. Todo es una PLANDEMIA...");
	  opiniones2.add(opinion3);
	  
	  
	  articuloRepository.save(new Articulo("El Athletic se deprecia en Granada", "Pako Ruiz", "Athletic", LocalDate.parse("2022/05/10"), "Si quieres taza, toma taza y media. El Athletic se ha ridiculizado así mismo en Los Cármenes en un encuentro infame del colectivo de un Marcelino que tampoco ha estado al nivel que pedía el compromiso. El conjunto rojiblanco ha jugado a nada y ha depreciado su candidatura a atrapar una de las dos plazas europeas que restan por repartir después de sucumbir en un partido que ha proyectado incluso momentos de auténtica comedia, lo que acentúa más el monumental fiasco de un Athletic al que solo le queda rezar a la amatxu de Begoña para retornar a una competición continental. Si Villarreal y Real Sociedad lograran la victoria en los respectivos duelos que afrontan el jueves, ante el Rayo en Vallecas y el Cádiz en Anoeta, los leones se despedirían prácticamente de sus ya pocas opciones, una historia que se repite en los últimos tiempos y que deja en mal lugar a los futbolistas y al entrenador, conscientes de la pobrísima imagen que han ofrecido en una cita trascendental para sus intereses ante un Granada que se les ha comido en intensidad y deseo. El conjunto del exleón Aitor Karanka se ha valido de un regalo de Dani García y el episodio cómico ha sido aún mayor en el descuento, con el gol anulado al colombiano Luis Suárez con Unai Simón en pleno retorno de su subida al área nazarí, el remate posterior al palo de Raúl García y, para rizar el rizo, un posible penaltito sobre Zarraga no señalado. Ver para creer. Se mire como se mire, un fracaso.",opiniones2));
	  
	  articuloRepository.save(new Articulo("Euskadi registró 1.666 muertes por covid en 2021, frente a las 3.096 de 2020", "Pablo Viñas", "Salud", LocalDate.parse("2022/05/16"), "Euskadi registró 1.666 muertes debido al covid-19 en 2021, frente a las 3.096 de 2020. Las defunciones por coronavirus fueron 261 en el cuarto trimestre del pasado año, un 73% menos que en el mismo periodo de 2020, según datos elaborados por Eustat.",opiniones1));

	  
	  
	  System.out.println("Articulos found with findAll():");
	  System.out.println("-------------------------------");
	  for (Articulo articulo : articuloRepository.findAll()) {
      System.out.println(articulo);
	    }

	  }
	
}

package co.edu.unicauca.coordinacion.core.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class EstudianteEntity {
	private Integer id;
    private Integer codigo;
	private String nombre;	
	private String apellido;	
	private String email;	
	private String ciudad;		
	private String tituloUniv;	
	private String telefono;	
	private String genero;
	private Date createAt;

}

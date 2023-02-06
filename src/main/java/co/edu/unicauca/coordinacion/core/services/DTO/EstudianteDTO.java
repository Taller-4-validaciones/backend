package co.edu.unicauca.coordinacion.core.services.DTO;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class EstudianteDTO {
	private Integer id;
	@NotNull(message = "{student.code.empty}")
	@Max(2147483647)
    private Integer codigo;
	@NotNull(message = "{student.name.empty}")
	@Size(min = 5, max = 45, message = "{student.name.length}")
	private String nombre;
	@NotNull(message = "{student.lastname.empty}")
	@Size(min = 5, max = 45, message = "{student.lastname.length}")	
	private String apellido;	
	@NotNull(message = "{student.email.emply}")
	@Email(message = "{student.email.mask}")
	private String email;	
	@NotNull(message = "{student.city.empty}")
	@Size(min = 5, max = 45, message = "{student.city.length}")	
	private String ciudad;	
	@NotNull(message = "{student.degree.empty}")
	@Size(min = 5, max = 45, message = "{student.degree.length}")		
	private String tituloUniv;	
	@NotNull(message = "{student.phone.empty}")
	@Pattern(regexp = "[3][0-9]{9}",message = "{student.phone.number}")
	private String telefono;	
	@NotNull(message = "{student.gender.empty}")
	@Length(max = 15, message = "{student.gender.length}")	
	private String genero;
	@NotNull(message = "{student.date.empty}")
	@PastOrPresent(message = "{student.date.past}")	
	private Date createAt; 
}

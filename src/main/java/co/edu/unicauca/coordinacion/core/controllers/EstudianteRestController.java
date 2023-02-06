package co.edu.unicauca.coordinacion.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.coordinacion.core.services.DTO.EstudianteDTO;
import co.edu.unicauca.coordinacion.core.services.services.IEstudianteService;
import lombok.val;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
@RequestMapping("/api")
@Validated
public class EstudianteRestController {
    @Autowired
	private IEstudianteService EstudianteService;
	
	@GetMapping("/estudiantes")
	public List<EstudianteDTO> index() {
		return EstudianteService.findAll();
	}

	@GetMapping("/estudiantes/{code}")
	public EstudianteDTO show(@Min(1) @PathVariable Integer code) {
		EstudianteDTO objEstudiante = null;		
		objEstudiante = EstudianteService.findByCode(code);		
		return objEstudiante;
	}

	@PostMapping("/estudiantes")
	public EstudianteDTO create(@Valid @RequestBody EstudianteDTO estudiante) {
		EstudianteDTO objEstudiante = null;		
		objEstudiante = EstudianteService.save(estudiante);		
		return objEstudiante;
	}

	@PutMapping("/estudiantes/{id}")
	public EstudianteDTO update(@Valid @RequestBody EstudianteDTO estudiante,@Min(1) @PathVariable Integer id) {
		EstudianteDTO objEstudiante = null;
		EstudianteDTO estudianteActual = EstudianteService.findById(id);
		if(estudianteActual!=null)	
		{
			objEstudiante = EstudianteService.update(id,estudiante);
		}
		return objEstudiante;
	}

	@DeleteMapping("/estudiantes/{code}")
	public boolean delete(@Min(1) @PathVariable Integer code) {
		return EstudianteService.delete(code);
	}
}

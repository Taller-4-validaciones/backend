package co.edu.unicauca.coordinacion.core.services.services;

import java.util.List;

import co.edu.unicauca.coordinacion.core.services.DTO.EstudianteDTO;

public interface IEstudianteService {
    
    public List<EstudianteDTO> findAll();		
	public EstudianteDTO findByCode(Integer code);	
	public EstudianteDTO findById(Integer id);	
	public EstudianteDTO save(EstudianteDTO estudiante);	
	public EstudianteDTO update(Integer code, EstudianteDTO estudiante);	
	public boolean delete(Integer code);	
}

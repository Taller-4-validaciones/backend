package co.edu.unicauca.coordinacion.core.services.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import co.edu.unicauca.coordinacion.core.exceptionControllers.exceptions.EntidadNoExisteException;
import co.edu.unicauca.coordinacion.core.exceptionControllers.exceptions.EntidadYaExisteException;
import co.edu.unicauca.coordinacion.core.models.EstudianteEntity;
import co.edu.unicauca.coordinacion.core.repositories.EstudianteRepository;
import co.edu.unicauca.coordinacion.core.services.DTO.EstudianteDTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private EstudianteRepository servicioAccesoBd;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EstudianteDTO> findAll() {
        List<EstudianteEntity> estudiantesEntity = this.servicioAccesoBd.findAll();
        List<EstudianteDTO> estudiantesDTO = this.modelMapper.map(estudiantesEntity, new TypeToken<List<EstudianteDTO>>() {}.getType());
        return estudiantesDTO;
    }

    @Override
    public EstudianteDTO findByCode(Integer code) {
        EstudianteEntity estudianteEntity = this.servicioAccesoBd.findByCode(code);
        if (ObjectUtils.isEmpty(estudianteEntity)) {
            EntidadNoExisteException objException = new EntidadNoExisteException(
					"Estudiante con codigo " + code + " no existe en la BD");
			throw objException;
        }
        EstudianteDTO estudianteDTO = this.modelMapper.map(estudianteEntity, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    public EstudianteDTO findById(Integer id) {
        EstudianteEntity estudianteEntity = this.servicioAccesoBd.findById(id);
        if (ObjectUtils.isEmpty(estudianteEntity)) {
            EntidadNoExisteException objException = new EntidadNoExisteException(
					"Estudiante con id " + id + " no existe en la BD");
			throw objException;
        }
        EstudianteDTO estudianteDTO = this.modelMapper.map(estudianteEntity, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    public EstudianteDTO save(EstudianteDTO estudiante) {

        if (estudiante.getCodigo() != null) {
			if (this.servicioAccesoBd.findByCode(estudiante.getCodigo()) != null) {
				EntidadYaExisteException objException = new EntidadYaExisteException(
						"Estudiante con codigo " + estudiante.getCodigo() + " existe en la BD");
				throw objException;
			}
		}

        EstudianteEntity estudianteEntity = this.modelMapper.map(estudiante, EstudianteEntity.class);
        EstudianteEntity estudianteSaved = this.servicioAccesoBd.save(estudianteEntity);
        EstudianteDTO estudianteDTO = this.modelMapper.map(estudianteSaved, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    public EstudianteDTO update(Integer id, EstudianteDTO estudiante) {
        EstudianteEntity estudianteEntity = this.modelMapper.map(estudiante, EstudianteEntity.class);
        if (ObjectUtils.isEmpty(estudianteEntity)) {
            EntidadNoExisteException objException = new EntidadNoExisteException(
					"Estudiante con id " + id + " no existe en la BD");
			throw objException;
        }
        EstudianteEntity estudianteUpdated = this.servicioAccesoBd.update(id,estudianteEntity);
        EstudianteDTO estudianteDTO = this.modelMapper.map(estudianteUpdated, EstudianteDTO.class);
        return estudianteDTO;
    }

    @Override
    public boolean delete(Integer code) {
        boolean bandera = this.servicioAccesoBd.delete(code);
		if (!bandera) {
			EntidadNoExisteException objException = new EntidadNoExisteException(
					"Estudiante con codigo " + code + " no existe en la BD");
			throw objException;
		}
		return bandera;
    }   
}

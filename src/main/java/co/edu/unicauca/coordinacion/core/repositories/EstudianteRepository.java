package co.edu.unicauca.coordinacion.core.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.coordinacion.core.models.EstudianteEntity;

@Repository
public class EstudianteRepository {

	private ArrayList<EstudianteEntity> listaDeEstudiantes;

	public EstudianteRepository()
	{
		this.listaDeEstudiantes = new ArrayList<EstudianteEntity>();
		cargarEstudiantes();
	}
		
	public List<EstudianteEntity> findAll()
	{
		System.out.println("Invocando a listar estudiantes");
		return this.listaDeEstudiantes;
	}

	public EstudianteEntity findById(Integer id)
	{
		System.out.println("Invocando a listar estudiante por id");
		EstudianteEntity estudiante = null;
		for (EstudianteEntity estudianteEntity : listaDeEstudiantes) {
			System.out.println(estudianteEntity.getCodigo());
			if (estudianteEntity.getId().equals(id)) {
				estudiante = estudianteEntity;
				break;
			}
		}
		return estudiante;
	}

	public EstudianteEntity findByCode(Integer code)
	{
		System.out.println("Invocando a listar estudiante por codigo");
		EstudianteEntity estudiante = null;
		for (EstudianteEntity estudianteEntity : listaDeEstudiantes) {
			if (estudianteEntity.getCodigo().equals(code)) {
				estudiante = estudianteEntity;
				break;
			}
		}
		return estudiante;
	}

	public EstudianteEntity save(EstudianteEntity estudiante)
	{
		System.out.println("Invocando a guardar estudiante");
		EstudianteEntity estudianteEntity = null;
		estudiante.setId(this.listaDeEstudiantes.get(this.listaDeEstudiantes.size() - 1).getId() + 1);
		if(this.listaDeEstudiantes.add(estudiante)) {
			estudianteEntity = estudiante;
		}
		return estudianteEntity;
	}

	public EstudianteEntity update(Integer id, EstudianteEntity estudiante)
	{
		System.out.println("Invocando a actualizar estudiante");
		EstudianteEntity estudianteObj = null;
		for (int i = 0; i < this.listaDeEstudiantes.size(); i++) {
			if (this.listaDeEstudiantes.get(i).getId().equals(id)) {
				estudianteObj = estudiante;
				this.listaDeEstudiantes.set(i,estudiante);
				break;
			}
		}
		return estudianteObj;
	}

	public boolean delete(Integer code)
	{
		System.out.println("Invocando a borrar estudiante por código");
		for (EstudianteEntity estudianteEntity : listaDeEstudiantes) {
			if (estudianteEntity.getCodigo().equals(code)) {
				return this.listaDeEstudiantes.remove(estudianteEntity);
			}
		}
		return false;
	}

    private void cargarEstudiantes() {
        EstudianteEntity objCliente1 = new EstudianteEntity(1,12344, "Juan", "Perez", "juan@unicauca.edu.co","Popayán", "Ingeniero de sistemas","31252344","M",new Date());
		this.listaDeEstudiantes.add(objCliente1);
		EstudianteEntity objCliente2 = new EstudianteEntity(2,12355, "Catalina", "Lopez", "catalina@unicauca.edu.co","Popayán","Ingeniero electronico","313523445", "F", new Date());
		this.listaDeEstudiantes.add(objCliente2);
		EstudianteEntity objCliente3 = new EstudianteEntity(3, 12422,"Sandra", "Sanchez", "Sandra@unicauca.edu.co","Popayán","Ingeniero de sistemas", "315323552", "F", new Date());
		this.listaDeEstudiantes.add(objCliente3);
		EstudianteEntity objCliente4 = new EstudianteEntity(4, 124226,"Daniel", "Mora", "daniel@unicauca.edu.co","Popayán","Ingeniero de sistemas", "315323552", "M", new Date());
		this.listaDeEstudiantes.add(objCliente4);
		EstudianteEntity objCliente5 = new EstudianteEntity(5, 6124228,"Camilo", "Herrera", "camilo@unicauca.edu.co","Popayán","Ingeniero de sistemas", "3153235528", "M", new Date());
		this.listaDeEstudiantes.add(objCliente5);
		EstudianteEntity objCliente = new EstudianteEntity(6,34155 ,"Andres", "Perez", "andres@unicauca.edu.co", "Popayán","Ingeniero electronico","321442212", "M", new Date());
		this.listaDeEstudiantes.add(objCliente);
    }
}

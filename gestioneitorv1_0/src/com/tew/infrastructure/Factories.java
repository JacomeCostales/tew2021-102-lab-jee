package com.tew.infrastructure;

import impl.tew.business.SimpleServicesFactory;
import impl.tew.persistence.SimplePersistenceFactory;

import com.tew.persistence.PersistenceFactory;
import com.tew.business.AlumnosService;
import com.tew.business.ServicesFactory;
import com.tew.model.Alumno;

/**
 * Esta clase es la que realemente relaciona las interfaces de las capas 
 * con sus implementaciones finales. Si se deben hacer cambios de implementaci��n
 * en algunas de las capas habr��a que retocar esta clase.
 * 
 * En desarrollos mas sofisticados esto se especificar��n en ficheros de 
 * configuraci��n lo que permitiria al "assembler" y "deployer" ajustar los 
 * ensamblajes entre capas sin necesidad de recompilar.
 * 		Assembler: forma la aplicaci��n a base de componentes 
 * 			desarrollados externamente
 * 		Deployer: Adapta la aplicaci��n, o reconfigura la aplicaci��n en 
 * 			explotaci��n a las m��quinas/contenedores (tiers/layers)
 * 
 * Hay frameworks especializados en eso precisamente, por ejemplo Spring.
 * 
 * @author Enrique
 *
 */
public class Factories {

	public static ServicesFactory services = new SimpleServicesFactory();
	public static PersistenceFactory persistence = new SimplePersistenceFactory();

	private Alumno alumno = new Alumno();
	private Alumno[] alumnos = null;
	
	public Factories(Alumno a, Alumno [] als) {
		alumno = a;
		alumnos =als;
	}
	
	public String listado() {
		AlumnosService service;
		try {
			// Acceso a la implementacion de la capa de negocio
			// a trav�s de la factor�a
			service = Factories.services.createAlumnosService();
			// Asi le damos informaci�n a toArray para poder hacer el casting a Alumno[]
			alumnos = (Alumno [])service.getAlumnos().toArray(new Alumno[0]);
			return "exito";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String edit() {
		AlumnosService service;
		try {
			// Acceso a la implementacion de la capa de negocio
			// a trav�s de la factor�a
			service = Factories.services.createAlumnosService();
			//Recargamos el alumno en la tabla de la base de datos por si hubiera cambios.
			alumno = service.findById(alumno.getId());
			return "exito";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String salva() {
		AlumnosService service;
		try {
			// Acceso a la implementacion de la capa de negocio
			// a trav�s de la factor�a
			service = Factories.services.createAlumnosService();
			//Salvamos o actualizamos el alumno segun sea una operacion de alta o de edici�n
			if (alumno.getId() == null) {
			service.saveAlumno(alumno);
			}
			else {
			service.updateAlumno(alumno);
			}
			//Actualizamos el javabean de alumnos inyectado en la tabla
			alumnos = (Alumno [])service.getAlumnos().toArray(new Alumno[0]);
			return "exito";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String baja() {
		AlumnosService service;
		try {
			//fd
			service = Factories.services.createAlumnosService();
			//Eliminarlo de la lista 
			int i =0;
			for(Alumno a : alumnos) {
				if(a.getId()==alumno.getId()) {alumnos[i]=null;}
				i++;
			}
			//Elimniar alumno
			service.deleteAlumno(alumno.getId());
			return "exito";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	
}

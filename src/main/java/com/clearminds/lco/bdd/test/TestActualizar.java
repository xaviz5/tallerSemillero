package com.clearminds.lco.bdd.test;

import com.clearminds.lco.dtos.Estudiante;
import com.clearminds.lco.excepciones.BDDException;
import com.clearminds.lco.servicios.ServicioEstudiante;

public class TestActualizar {
	
	public static void main(String[] args) {
		ServicioEstudiante srvEstudiante = new ServicioEstudiante();
		try {
			srvEstudiante.actualizarEstudiante(new Estudiante(3,"Xavier","Ortiz"));
		} catch (BDDException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

}

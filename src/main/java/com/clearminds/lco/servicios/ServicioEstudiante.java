package com.clearminds.lco.servicios;

import java.sql.SQLException;
import java.sql.Statement;

import com.clearminds.lco.dtos.Estudiante;
import com.clearminds.lco.excepciones.BDDException;

public class ServicioEstudiante extends ServicioBase{

	public void insertarEstudiante(Estudiante estudiante) throws BDDException{
		abrirConexion();
		System.out.println("Insertando estudiante: "+estudiante);
		Statement stmt = null;
		try {
			stmt = getConexion().createStatement();
			String sql = "insert into estudiantes(nombre, apellido) values('"+
			estudiante.getNombre()+"','"+estudiante.getApellido()+"')";
			
			System.out.println("Script: "+sql);
			
			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al insertar estudiante");
		}
	}
	
}

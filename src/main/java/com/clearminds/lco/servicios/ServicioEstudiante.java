package com.clearminds.lco.servicios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.clearminds.lco.dtos.Estudiante;
import com.clearminds.lco.excepciones.BDDException;

public class ServicioEstudiante extends ServicioBase{

	public void insertarEstudiante(Estudiante estudiante) throws BDDException{
		abrirConexion();
		System.out.println("Insertando estudiante: "+estudiante);
		Statement stmt = null;
		try {
			stmt = getConexion().createStatement();
			String fecha = DateUtil.obtenerFecha(new Date());
			String sql = "insert into estudiantes(nombre, apellido, edad, fecha_modificacion) values('"+
			estudiante.getNombre()+"','"+estudiante.getApellido()+"',"+estudiante.getEdad()+",'"+fecha+"')";
			
			System.out.println("Script: "+sql);
			
			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al insertar estudiante");
		}
	}
	
	public void actualizarEstudiante(Estudiante estudiante) throws BDDException{
		abrirConexion();
		System.out.println("Actualizando estudiante con id: "+estudiante.getId());
		Statement stmt = null;
		try {
			stmt = getConexion().createStatement();
			String fecha = DateUtil.obtenerFecha(new Date());
			String sql = "update estudiantes set nombre='"+estudiante.getNombre()+"', apellido='"+
			estudiante.getApellido()+"', edad="+estudiante.getEdad()+", fecha_modificacion='"+fecha+"' where id="+estudiante.getId();
			
			System.out.println("Script: "+sql);
			
			stmt.executeUpdate(sql);
			cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("Error al actualizar estudiante");
		}
	}
	
}

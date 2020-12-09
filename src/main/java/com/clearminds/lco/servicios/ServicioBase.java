package com.clearminds.lco.servicios;

import java.sql.Connection;
import java.sql.SQLException;

import com.clearminds.lco.bdd.ConexionBDD;
import com.clearminds.lco.excepciones.BDDException;

public class ServicioBase {
	
	Connection conexion = null;
	
	public void abrirConexion() throws BDDException{
		conexion = ConexionBDD.obtenerConexion();
	}
	
	public void cerrarConexion(){
		try {
			if(conexion != null){
				conexion.close();
				System.out.println("Conexion cerrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error al cerrar la conexion");
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

}

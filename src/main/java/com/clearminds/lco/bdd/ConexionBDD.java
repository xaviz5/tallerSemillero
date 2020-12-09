package com.clearminds.lco.bdd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.clearminds.lco.excepciones.BDDException;

public class ConexionBDD {

	public static String leerPropiedad(String propiedad) {
		Properties p = new Properties();
		try {
			p.load(new FileReader("conexion.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return p.getProperty(propiedad);
	}
	
	public static Connection obtenerConexion() throws BDDException{
		
		Connection conn = null;
		
		String user = leerPropiedad("usuario");
		String pass = leerPropiedad("password");
		String url = leerPropiedad("urlConexion");
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BDDException("No se pudo conectar a la base de datos");
		}
		
		return conn;
	}
}

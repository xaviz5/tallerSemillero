package com.clearminds.lco.bdd.test;

import java.sql.Connection;

import com.clearminds.lco.bdd.ConexionBDD;

public class TestConexion {

	public static void main(String[] args) {

		try {
			Connection conexion = ConexionBDD.obtenerConexion();
			if(conexion != null){
				System.out.println("Conexion exitosa");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}

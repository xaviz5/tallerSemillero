package com.clearminds.lco.servicios;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static final String FORMATO_COMPLETO = "yyyy-MM-dd HH:mm:ss";

	public static String obtenerFecha(Date date){
		//El statico no pertenece al objeto si no a la clase
		SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_COMPLETO);
		String fecha = formateador.format(date);
		return fecha;
	}
}

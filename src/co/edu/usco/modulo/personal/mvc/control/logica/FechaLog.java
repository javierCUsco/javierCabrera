/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import javax.servlet.http.HttpServletRequest;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.FechaDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.UaaPersonal;
import co.edu.usco.modulo.personal.mvc.modelo.pensionado.Pensionado;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class FechaLog {

	/**
	 * @return
	 */
	public static Object getFechaServidor() {
		ConexionDB db = new FechaDB();
		return db.getObject(null);
	}

	/**
	 * @param fecha
	 * @return
	 */
	public static Object getFechaServidorLetras(String fecha) {
		int dia = Integer.parseInt(fecha.substring(8,10));
		int mes = Integer.parseInt(fecha.substring(5,7));
		int annio = Integer.parseInt(fecha.substring(0,4));

		StringBuffer letras = new StringBuffer();
		letras.append("a "+getDia(dia)+" ");
		letras.append("del "+getMes(mes)+" ");
		letras.append("del "+annio);
		letras.append("");
		letras.append("");
		letras.append("");
		return letras.toString();
	}

	protected static String getDia(int dia) {
		//String diaLetras = "";
		if (dia == 1) {
			return "un d�a";
		}
		if (dia == 2) {
			return "los dos ("+dia+") d�as";
		}
		if (dia == 3) {
			return "los tres ("+dia+") d�as";
		}
		if (dia == 4) {
			return "los cuarto ("+dia+") d�as";
		}
		if (dia == 5) {
			return "los cinco ("+dia+") d�as";
		}
		if (dia == 6) {
			return "los seis ("+dia+") d�as";
		}
		if (dia == 7) {
			return "los siete ("+dia+") d�as";
		}
		if (dia == 8) {
			return "los ocho ("+dia+") d�as";
		}
		if (dia == 9) {
			return "los nueve ("+dia+") d�as";
		}
		if (dia == 10) {
			return "los diez ("+dia+") d�as";
		}
		if (dia == 11) {
			return "los once ("+dia+") d�as";
		}
		if (dia == 12) {
			return "los doce ("+dia+") d�as";
		}
		if (dia == 13) {
			return "los trece ("+dia+") d�as";
		}
		if (dia == 14) {
			return "los catorce ("+dia+") d�as";
		}
		if (dia == 15) {
			return "los quince ("+dia+") d�as";
		}
		if (dia == 16) {
			return "los dieciseis ("+dia+") d�as";
		}
		if (dia == 17) {
			return "los diecisiete ("+dia+") d�as";
		}
		if (dia == 18) {
			return "los dieciocho ("+dia+") d�as";
		}
		if (dia == 19) {
			return "los diecinueve ("+dia+") d�as";
		}
		if (dia == 20) {
			return "los veinte ("+dia+") d�as";
		}
		if (dia == 21) {
			return "los veintiuno ("+dia+") d�as";
		}
		if (dia == 22) {
			return "los veintidos ("+dia+") d�as";
		}
		if (dia == 23) {
			return "los veintitres ("+dia+") d�as";
		}
		if (dia == 24) {
			return "los veinticuatro ("+dia+") d�as";
		}
		if (dia == 25) {
			return "los veinticinco ("+dia+") d�as";
		}
		if (dia == 26) {
			return "los veintiseis ("+dia+") d�as";
		}
		if (dia == 27) {
			return "los veintisiete ("+dia+") d�as";
		}
		if (dia == 28) {
			return "los veintiocho ("+dia+") d�as";
		}
		if (dia == 29) {
			return "los veintinueve ("+dia+") d�as";
		}
		if (dia == 30) {
			return "los treinta ("+dia+") d�as";
		}
		if (dia == 31) {
			return "los treinta y un ("+dia+") d�a";
		}
		return "";

	}
	protected static String getMes(int mes) {
		String diaLetras = "";
		if (mes == 1) {
			return "mes de Enero";
		}
		if (mes == 2) {
			return "mes de Febrero";
		}
		if (mes == 3) {
			return "mes de Marzo";
		}
		if (mes == 4) {
			return "mes de Abril";
		}
		if (mes == 5) {
			return "mes de Mayo";
		}
		if (mes == 6) {
			return "mes de Junio";
		}
		if (mes == 7) {
			return "mes de Julio";
		}
		if (mes == 8) {
			return "mes de Agosto";
		}
		if (mes == 9) {
			return "mes de Septiembre";
		}
		if (mes == 10) {
			return "mes de Octubre";
		}
		if (mes == 11) {
			return "mes de Nobiembre";
		}
		if (mes == 12) {
			return "mes de Diciembre";
		}
				return "";

	}

	/**
	 * @param request
	 * @return
	 */
	public static Object tiempoLaborado(HttpServletRequest request) {
		Pensionado pensionado = new Pensionado();
		pensionado.setPen_fecha(Fecha.getDate(String.valueOf(request.getParameter("pen_fecha"))));
		pensionado.getUaa_personal().setFechaInicio(Fecha.getDate(String.valueOf(request.getParameter("uap_fecha_inicio"))));
		String fecha_servidor=String.valueOf(FechaLog.getFechaServidor());
		Mensaje tem=Fecha.isValido( request.getParameter("uap_fecha_inicio"),fecha_servidor, "la fecha de pension \n");
		if(tem.isValido()){
			tem=Fecha.isValido( request.getParameter("uap_fecha_inicio"),fecha_servidor, "la fecha de pension \n");
			if(tem.isValido()){
				tem=Fecha.isValido( request.getParameter("uap_fecha_inicio"),request.getParameter("pen_fecha"), "la fecha de pension \n");
				if(tem.isValido()){
					tem.setMsm(String.valueOf(Fecha.restarFecha(pensionado.getUaa_personal().getFechaInicio(), pensionado.getPen_fecha())));
				}
			}
		}
		
		return tem;
	}
	
	
//	caa.setCaa_fecha_convocatoria(Fecha.getDate(String.valueOf(request.getParameter("caa_fecha_convocatoria"))));

}

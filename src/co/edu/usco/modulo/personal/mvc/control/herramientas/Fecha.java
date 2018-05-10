/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.herramientas;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.FechaDB;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.conexion;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Fecha {
	/**
	 * @param obj
	 * @return {@link Object}
	 */
	public static Object getFecha_servidor(Object obj) {
		conexion db = new FechaDB();
		return db.getObject(obj);
	}
/**
 * 
 * @param fecha
 * @return {@link Object}
 */
	public static Object getFecha_format(Date fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(fecha);
	}
	/**
	 * 
	 * @param fecha
	 * @return  {@link Date}
	 */
	public static Date getDate(String fecha) {
		String mes =String.valueOf(getMes(fecha));
		if(getMes(fecha)<10){
			mes ="0"+String.valueOf(getMes(fecha));
		}
		String dia =String.valueOf(getDia(fecha));
		if(getDia(fecha)<10){
			dia ="0"+String.valueOf(getDia(fecha));
		}
		String annio =String.valueOf(getAnnio(fecha));
		fecha=dia+"/"+mes+"/"+annio;
		System.out.println(fecha);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		 Date date= null;
		 try {

	            date = formato.parse(fecha);

	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		
		return date;
	}
	
	
	/**
	 * @param fecha
	 * @return {@link Date}
	 */
	public static Date getFecha_date(String fecha){
		Date fechaDate=null;
		if(fecha != null && fecha.length()>0 && !fecha.equals("")){
			try{
			fechaDate =  new Date(Long.parseLong(fecha));
			}catch (Exception e) {
				fechaDate =  new Date(fecha);
			}
		}
		return fechaDate;
		}

	/**
	 * @param fecha
	 * @return {@link String}
	 */
	public static String getFecha_formatString(String fecha) {
		
		String mes =String.valueOf(getMes(fecha));
		String dia =String.valueOf(getDia(fecha));
		String annio =String.valueOf(getAnnio(fecha));
		return dia+"/"+mes+"/"+annio;
	}
	
	
	/**
	 * @param fecha1
	 * @param fecha2
	 * @param mensaje
	 * @return {@link Mensaje}
	 */
	public static Mensaje isValido(String fecha1, String fecha2,  String mensaje) {
		Mensaje msm= new Mensaje(true,"",null);
		
		/** Obtenemos las fechas enviadas en el formato a comparar */
		final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 

		
		Calendar calendarfchini = new GregorianCalendar( getAnnio(fecha1), getMes(fecha1),getDia(fecha1));
		Calendar calendarfchfin = new GregorianCalendar( getAnnio(fecha2), getMes(fecha2),getDia(fecha2));
//		JOptionPane.showMessageDialog(null, getAnnio(fecha1)+" "+ getMes(fecha1)+" "+getDia(fecha1)+ "   ----> "+  getAnnio(fecha2)+" "+  getMes(fecha2)+" "+ getDia(fecha2));
		java.sql.Date fechaIni = new java.sql.Date(calendarfchini.getTimeInMillis());
		java.sql.Date fechaFin= new java.sql.Date(calendarfchfin.getTimeInMillis());

		long diferencia = ( fechaFin.getTime() - fechaIni.getTime() )/MILLSECS_PER_DAY; 
		
			if ((diferencia< 0)) {
				
				msm.setMsm(mensaje);
				msm.setValido(false);
			}
			
			return msm;
	}
	
	private  static int getDia(String fecha){
		int dia=Integer.parseInt(fecha.substring(8, 10));
		return dia;
	}
	private  static int getMes(String fecha){
		int mes = Integer.parseInt(fecha.substring(5, 7));
		return mes;
	}
	private  static int getAnnio(String fecha){
		int annio=Integer.parseInt(fecha.substring(0, 4));
		return annio;
		
	}
	


	    /**
	     * @param fch1
	     * @param fch2
	     * @return {@link Object}
	     */
	    public static Object  restarFecha(Date fch1, Date fch2) {

	        String fechaInicio = "";
	        String fechaActual = "";
//	        Date date = new Date();
	        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	        fechaActual = df.format(fch2);
	        fechaInicio=df.format(fch1);
	        String[] aFechaIng = fechaInicio.split("/");
	        Integer diaInicio = Integer.parseInt(aFechaIng[0]);
	        Integer mesInicio = Integer.parseInt(aFechaIng[1]);
	        Integer anioInicio = Integer.parseInt(aFechaIng[2]);

	        String[] aFecha = fechaActual.split("/");
	        Integer diaActual = Integer.parseInt(aFecha[0]);
	        Integer mesActual = Integer.parseInt(aFecha[1]);
	        Integer anioActual = Integer.parseInt(aFecha[2]);
	        int b = 0;
	        int dias = 0;
	        int mes = 0;
	        int anios = 0;
	        int meses = 0;
	        mes = mesInicio - 1;
	        if (mes == 2) {
	            if ((anioActual % 4 == 0) && ((anioActual % 100 != 0) || (anioActual % 400 == 0))) {
	                b = 29;
	            } else {
	                b = 28;
	            }
	        } else if (mes <= 7) {
	            if (mes == 0) {
	                b = 31;
	            } else if (mes % 2 == 0) {
	                b = 30;
	            } else {
	                b = 31;
	            }
	        } else if (mes > 7) {
	            if (mes % 2 == 0) {
	                b = 31;
	            } else {
	                b = 30;
	            }
	        }
	        if ((anioInicio > anioActual) || (anioInicio == anioActual && mesInicio > mesActual)
	                || (anioInicio == anioActual && mesInicio == mesActual && diaInicio > diaActual)) {
	            System.out.println("La fecha de inicio debe ser anterior a la fecha Actual");
	        } else {
	            if (mesInicio <= mesActual) {
	                anios = anioActual - anioInicio;
	                if (diaInicio <= diaActual) {
	                    meses = mesActual - mesInicio;
	                    dias = b - (diaInicio - diaActual);
	                } else {
	                    if (mesActual == mesInicio) {
	                        anios = anios - 1;
	                    }
	                    meses = (mesActual - mesInicio - 1 + 12) % 12;
	                    dias = b - (diaInicio - diaActual);
	                }
	            } else {
	                anios = anioActual - anioInicio - 1;
	                System.out.println(anios);
	                if (diaInicio > diaActual) {
	                    meses = mesActual - mesInicio - 1 + 12;
	                    dias = b - (diaInicio - diaActual);
	                } else {
	                    meses = mesActual - mesInicio + 12;
	                    dias = diaActual - diaInicio;
	                }
	            }
	        }
	        String tiempo="";
	        if(anios==1){
	        	tiempo=anios+" año, ";
	        }else{
	        	tiempo=anios+" años, ";
	        }
	        if(meses>0){
	        	if(meses==1){
	        		tiempo=tiempo+meses+" mes, ";
	        	}else{
	        		tiempo=tiempo+meses+" meses, ";
	        	}
	        }
	        if(dias>0){
	        	if(dias==1){
	        		tiempo=tiempo+dias+" dia, ";
	        	}else{
	        		tiempo=tiempo+dias+" dias, ";
	        	}
	        }

	        return tiempo;
	    }

	 
	

	
	
}

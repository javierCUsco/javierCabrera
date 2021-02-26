/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.logica;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Occurs;

import co.edu.usco.modulo.personal.mvc.control.accesoDB.PersonaDB;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.UaaPersonalDB;
import co.edu.usco.modulo.personal.mvc.control.accesoDB.UaaPersonalReporteDB;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionUscoDB;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.UaaPersonal;
import co.edu.usco.modulo.personal.mvc.modelo.Vinculacion;
import co.edu.usco.seguridad.seguridad;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class UaaPersonalLog {
	static ConexionUscoDB db=null;
	public static Object getLista(Object object) {
		 db= new UaaPersonalDB();
		 List<UaaPersonal> lista=(List<UaaPersonal>) db.getAll(object);
		 if(lista==null || lista.size()==0){
			 UaaPersonal uaaPersonal= new UaaPersonal();
			 lista = new LinkedList<UaaPersonal>();
			 uaaPersonal.getPersona().setNombre("No se encontro vinculacion por favor comicarse con talento humano");
			 lista.add(uaaPersonal);
		 }
		 return lista; 	
	}
	
	public static Object getObject(Object object) {
		db= new UaaPersonalDB();
		Mensaje mensaje= new Mensaje();
		mensaje.setResultado(db.getObject(object));
		return mensaje;
		
	}

	/**
	 * @param param
	 * @return
	 */
	public static Object getDocentes(Object param) {
		 //db= new UaaPersonalReporteDB();
		 UaaPersonalReporteDB db=new UaaPersonalReporteDB();
		 List<UaaPersonal> lista=(List<UaaPersonal>) db.getAllSnies(param);
		 if(lista==null || lista.size()==0){
			 UaaPersonal uaaPersonal= new UaaPersonal();
			 uaaPersonal.getPersona().setNombre("No se encontro vinculacion por favor comicarse con talento humano");
			 lista = new LinkedList<UaaPersonal>();
			 lista.add(uaaPersonal);
		 }
		Mensaje mensaje= new Mensaje();
		mensaje.setResultado(lista);
		 return mensaje; 	
	}

	public static Object getVinculaciones(Object[] param) {
		 db= new UaaPersonalDB();
		 List<UaaPersonal> lista=(List<UaaPersonal>) db.getVinculacion(param);
		 if(lista==null || lista.size()==0){
			 UaaPersonal uaaPersonal= new UaaPersonal();
			 uaaPersonal.getPersona().setNombre("No se encontro vinculacion por favor comicarse con talento humano");
			 lista = new LinkedList<UaaPersonal>();
			 lista.add(uaaPersonal);
		 }
		 return lista; 	
	}

	/**
	 * @param obj
	 * @return
	 */
	public static Object newObject(Object obj) {
		Mensaje mensaje = (Mensaje) getvalidaDatos( obj);
		Object param[] = (Object[]) obj;
	if (mensaje.isValido()) {
		if (param[2].toString().equals("1")) {

			db = new UaaPersonalDB();
		
			UaaPersonal uaaPersonal = (UaaPersonal) mensaje.getResultado();
//			UaaPersonal uaaPersonal2 = new UaaPersonal();
//			uaaPersonal2.setCodigo(uaaPersonal.getCodigo());
			param[0] = uaaPersonal;
			mensaje.setValido(db.esObject(obj));
			if (mensaje.isValido()) {
				param[0] = uaaPersonal;
				param[2] = 1;
				int resultado = (int) db.setObject(param);
				if (resultado == 1) {
					mensaje.setValido(true);
					mensaje.setMsm("se ha guardado el registro..");
				} else {
					mensaje.setValido(false);
					mensaje.setMsm("Error no se ha guardado el registro..");
				}
			} else {

			}
		}
		if (param[2].toString().equals("2")) {

			db = new UaaPersonalDB();

			UaaPersonal uaaPersonal = (UaaPersonal) mensaje.getResultado();
//			UaaPersonal uaaPersonal2 = new UaaPersonal();
//			uaaPersonal2.setCodigo(uaaPersonal.getCodigo());
			param[0] = uaaPersonal;

			//mensaje.setValido(db.esObject(obj));
			//if (!mensaje.isValido()) {
				param[0] = uaaPersonal;
				param[2] = 2;
				int resultado = (int) db.setObject(param);
				if (resultado == 1) {
					mensaje.setValido(true);
					mensaje.setMsm("se ha actualizado el registro..");
				} else {
					mensaje.setValido(false);
					mensaje.setMsm("Error no se ha guardado el registro..");
				}
//			} else {
//
//			}
		}
	}

	return mensaje;

}
/**
* 
* @param request
* @param obj
* @return
*/
private static Object getvalidaDatos(Object obj) {

	Mensaje mensaje = new Mensaje();
	mensaje.setValido(true);
	Mensaje mensaje2 = null;
	Object param[] = (Object[]) obj;
	UaaPersonal uaaPersonal = (UaaPersonal) param[0];
	String fechaServidor = String.valueOf(FechaLog.getFechaServidor());
	if (uaaPersonal.getPersona() == null) {
		mensaje.setMsm(", Debe seleccionar El doccente");
		mensaje.setValido(false);
	}
	if (uaaPersonal.getVinculacion() == null) {
		mensaje.setMsm(", Debe seleccionar vinculación");
		mensaje.setValido(false);
	}
	if (uaaPersonal.getSede() == null) {
		mensaje.setMsm(", Debe seleccionar la sede");
		mensaje.setValido(false);
	}
	if (uaaPersonal.getResolucion() == null || uaaPersonal.getResolucion().equals(" ")) {
		mensaje.setMsm(", debe seleccionar la resolucion");
		mensaje.setValido(false);
	}
	
	
	if (uaaPersonal.getFechaInicio() != null) {
		mensaje2 = Fecha.getValidaFechas(Fecha.sumarDias(Fecha.getDate(fechaServidor),30), uaaPersonal.getFechaInicio(),
				"fecha de inicio");
		if (!mensaje2.isValido()) {
			mensaje.setMsm(", error en la fecha de inicio");
			mensaje.setValido(false);
		}
	} else {
		mensaje.setMsm(", Debe digitar la fecha de inicio");
		mensaje.setValido(false);
	}

	if (uaaPersonal.getCargo() == null) {
		mensaje.setMsm(", Debe seleccionar el cargo");
		mensaje.setValido(false);
	}
	if (uaaPersonal.getDedicacion() == null) {
		mensaje.setMsm(", Debe seleccionar la dedicación");
		mensaje.setValido(false);
	}
	if (uaaPersonal.getEscalafon() == null) {
		mensaje.setMsm(", Debe seleccionar el escalafon con el que el docente inicia");
		mensaje.setValido(false);
	}
	if (uaaPersonal.getFechaFin() != null) {

//		mensaje2 = Fecha.getValidaFechas(Fecha.getDate(fechaServidor), uaaPersonal.getFechaFin(),
//				"error en la fecha fin");
//		if (!mensaje2.isValido()) {
//			mensaje.setMsm(", error en la Fecha fin de ");
//			mensaje.setValido(false);
//		}
	} 
//	else {
//		mensaje.setMsm(", Debe digitar la fecha de nacimiento");
//		mensaje.setValido(false);
//	}
	// if(persona.getLugarResidencia()==null ) {
	// mensaje.setMsm(", Debe seleccionar el Lugar de expedicion del documento de
	// identificacion");
	// mensaje.setValido(false);
	// }
	
	

	mensaje.setResultado(uaaPersonal);
	System.out.println(mensaje);
	return mensaje;

}

public static Object getPersonas(Object param) {
	 db= new UaaPersonalDB();
	 List<UaaPersonal> lista=(List<UaaPersonal>) db.getDocentes(param);
	 if(lista==null || lista.size()==0){
		 UaaPersonal uaaPersonal= new UaaPersonal();
		 uaaPersonal.getPersona().setNombre("No se encontro vinculacion por favor comicarse con talento humano");
		 lista = new LinkedList<UaaPersonal>();
		 lista.add(uaaPersonal);
	 }
	 return lista; 
}

public static Object getPersonasVinculadas(Object param) {
	 db= new UaaPersonalDB();
	 Mensaje mensaje= new Mensaje();
	 mensaje.setValido(true);
	 List<UaaPersonal> lista=(List<UaaPersonal>) db.getReporte(param);
	 if(lista==null || lista.size()==0){
		 mensaje.setValido(false);
		 mensaje.setMsm("No se encontro vinculacion por favor comicarse con talento humano");
	 }
	 mensaje.setResultado(lista);
	 return mensaje; 
}

public static Object newObjectAdministrativo(Object obj) {
	Mensaje mensaje = (Mensaje) getvalidaDatosAdminstrativos( obj);
	Object param[] = (Object[]) obj;
	System.out.println("es valido "+mensaje.isValido());
if (mensaje.isValido()) {
	System.out.println(">>>>   "+param[2].toString());
	if (param[2].toString().equals("3")) {
		db = new UaaPersonalDB();
		UaaPersonal uaaPersonal = (UaaPersonal) mensaje.getResultado();
//		personatem.setIdentificacion(persona.getIdentificacion());
		param[0] = uaaPersonal;
		UaaPersonalDB dbt=new UaaPersonalDB();
		mensaje.setValido((boolean) dbt.ocupaCargoAdmin(param));
		//System.out.println(">>>>   "+mensaje.isValido());
		if (!mensaje.isValido()) {
			param[0] = uaaPersonal;
			int resultado = (int) db.setObject(obj);
			if (resultado == 1) {
				mensaje.setValido(true);
				mensaje.setMsm("se ha guardado el registro..");
			} else {
				mensaje.setValido(false);
				mensaje.setMsm("Error no se ha guardado el registro..");
			}
		} else {
			mensaje.setValido(false);
			mensaje.setMsm("Error. Tiene vinculaciones de encargo sin cerrar la vinculación");
		}
	}
	if (param[2].toString().equals("4")) {
		db = new UaaPersonalDB();
		UaaPersonal uaaPersonal = (UaaPersonal) mensaje.getResultado();
		//UaaPersonal uaaPersonal2 = new UaaPersonal();
//		uaaPersonal2.setCodigo(uaaPersonal.getCodigo());
		param[0] = uaaPersonal;
		System.out.println("en el >>>>   "+param[2].toString());
//		mensaje.setValido(db.esObject(obj));
//		if (mensaje.isValido()) {
			
			int resultado = (int) db.setObject(obj);
			if (resultado == 1) {
				mensaje.setValido(true);
				mensaje.setMsm("se ha guardado el registro..");
			} else {
				mensaje.setValido(false);
				mensaje.setMsm("Error no se ha guardado el registro..");
			}
//		} else {
//
//		}
	}
}

return mensaje;
}

private static Mensaje getvalidaDatosAdminstrativos(Object obj) {
	Mensaje mensaje = new Mensaje();
	mensaje.setValido(true);
	Mensaje mensaje2 = null;
	Object param[] = (Object[]) obj;
	UaaPersonal uaaPersonal = (UaaPersonal) param[0];
	String fechaServidor = String.valueOf(FechaLog.getFechaServidor());
	if (uaaPersonal.getPersona() == null) {
		mensaje.setMsm(", Debe seleccionar El Usuario");
		mensaje.setValido(false);
	}
	
	if (uaaPersonal.getSede() == null) {
		mensaje.setMsm(", Debe seleccionar la sede");
		mensaje.setValido(false);
	}
	if (uaaPersonal.getResolucion() == null || uaaPersonal.getResolucion().equals(" ")) {
		mensaje.setMsm(", debe seleccionar la resolucion");
		mensaje.setValido(false);
	}
	
	
	if (uaaPersonal.getFechaInicio() != null) {
		mensaje2 = Fecha.getValidaFechas(Fecha.getDate(fechaServidor), uaaPersonal.getFechaInicio(),
				"fecha de inicio");
		if (!mensaje2.isValido()) {
			mensaje.setMsm(", error en la fecha de inicio");
			mensaje.setValido(false);
		}
	} else {
		mensaje.setMsm(", Debe digitar la fecha de inicio");
		mensaje.setValido(false);
	}

	if (uaaPersonal.getUaaCargo() == null) {
		mensaje.setMsm(", debe seleccionar la el cargo ");
		mensaje.setValido(false);
	}

	
	if (uaaPersonal.getFechaFin() != null) {

//		mensaje2 = Fecha.getValidaFechas(Fecha.getDate(fechaServidor), uaaPersonal.getFechaFin(),
//				"error en la fecha fin");
//		if (!mensaje2.isValido()) {
//			mensaje.setMsm(", error en la Fecha fin de ");
//			mensaje.setValido(false);
//		}
	} 
//	else {
//		mensaje.setMsm(", Debe digitar la fecha de nacimiento");
//		mensaje.setValido(false);
//	}
	// if(persona.getLugarResidencia()==null ) {
	// mensaje.setMsm(", Debe seleccionar el Lugar de expedicion del documento de
	// identificacion");
	// mensaje.setValido(false);
	// }
	
	

	mensaje.setResultado(uaaPersonal);
	System.out.println(mensaje);
	return mensaje;
}

public static Object reporteDocente(Object[] param) {
	UaaPersonalDB  esnies=new UaaPersonalDB();
	return esnies.getAllSnies(param);
}

public static Object getAgenda(Object[] param) {
	// TODO Auto-generated method stub
	return null;
}

}

package co.edu.usco.modulo.personal.mvc.modelo.pensionado;

import java.io.Serializable;
import java.util.Date;

import co.edu.usco.modulo.personal.mvc.modelo.UaaPersonal;

public class Pensionado implements Serializable {
	private int pen_codigo;//int] IDENTITY(1,1) NOT NULL,
	private UaaPersonal uaa_personal= new UaaPersonal();//int] NOT NULL,
	private Date pen_fecha;//date] NOT NULL,
	private String pen_tiempo_trabajo;//int] NOT NULL,
	private String pen_resolucion;//nvarchar](20) NOT NULL,
	private String pen_observacion;//nvarchar](max) NOT NULL
	private TipoPension tipoPension= new TipoPension();
	
	
	
	
	
	/**
	 * 
	 */
	public Pensionado() {
	}





	/**
	 * @param persona
	 * @param uaa_personal
	 * @param pen_fecha
	 * @param pen_tiempo_trabajo
	 * @param pen_resolucion
	 * @param pen_observacion
	 * @param tipoPension
	 */
	public Pensionado( UaaPersonal uaa_personal, Date pen_fecha, String pen_tiempo_trabajo,
			String pen_resolucion, String pen_observacion, TipoPension tipoPension) {
		this.uaa_personal = uaa_personal;
		this.pen_fecha = pen_fecha;
		this.pen_tiempo_trabajo = pen_tiempo_trabajo;
		this.pen_resolucion = pen_resolucion;
		this.pen_observacion = pen_observacion;
		this.tipoPension = tipoPension;
	}





	/**
	 * @param pen_codigo
	 * @param persona
	 * @param uaa_personal
	 * @param pen_fecha
	 * @param pen_tiempo_trabajo
	 * @param pen_resolucion
	 * @param pen_observacion
	 * @param tipoPension
	 */
	public Pensionado(int pen_codigo, UaaPersonal uaa_personal, Date pen_fecha, String pen_tiempo_trabajo,
			String pen_resolucion, String pen_observacion, TipoPension tipoPension) {
		this.pen_codigo = pen_codigo;
		this.uaa_personal = uaa_personal;
		this.pen_fecha = pen_fecha;
		this.pen_tiempo_trabajo = pen_tiempo_trabajo;
		this.pen_resolucion = pen_resolucion;
		this.pen_observacion = pen_observacion;
		this.tipoPension = tipoPension;
	}





	/**
	 * @return the pen_codigo
	 */
	public int getPen_codigo() {
		return pen_codigo;
	}





	/**
	 * @param pen_codigo the pen_codigo to set
	 */
	public void setPen_codigo(int pen_codigo) {
		this.pen_codigo = pen_codigo;
	}




	/**
	 * @return the uaa_personal
	 */
	public UaaPersonal getUaa_personal() {
		return uaa_personal;
	}





	/**
	 * @param uaa_personal the uaa_personal to set
	 */
	public void setUaa_personal(UaaPersonal uaa_personal) {
		this.uaa_personal = uaa_personal;
	}





	/**
	 * @return the pen_fecha
	 */
	public Date getPen_fecha() {
		return pen_fecha;
	}





	/**
	 * @param pen_fecha the pen_fecha to set
	 */
	public void setPen_fecha(Date pen_fecha) {
		this.pen_fecha = pen_fecha;
	}





	/**
	 * @return the pen_tiempo_trabajo
	 */
	public String getPen_tiempo_trabajo() {
		return pen_tiempo_trabajo;
	}





	/**
	 * @param pen_tiempo_trabajo the pen_tiempo_trabajo to set
	 */
	public void setPen_tiempo_trabajo(String pen_tiempo_trabajo) {
		this.pen_tiempo_trabajo = pen_tiempo_trabajo;
	}





	/**
	 * @return the pen_resolucion
	 */
	public String getPen_resolucion() {
		return pen_resolucion;
	}





	/**
	 * @param pen_resolucion the pen_resolucion to set
	 */
	public void setPen_resolucion(String pen_resolucion) {
		this.pen_resolucion = pen_resolucion;
	}





	/**
	 * @return the pen_observacion
	 */
	public String getPen_observacion() {
		return pen_observacion;
	}





	/**
	 * @param pen_observacion the pen_observacion to set
	 */
	public void setPen_observacion(String pen_observacion) {
		this.pen_observacion = pen_observacion;
	}





	/**
	 * @return the tipoPension
	 */
	public TipoPension getTipoPension() {
		return tipoPension;
	}





	/**
	 * @param tipoPension the tipoPension to set
	 */
	public void setTipoPension(TipoPension tipoPension) {
		this.tipoPension = tipoPension;
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pensionado [pen_codigo=" + pen_codigo + ", uaa_personal=" + uaa_personal
				+ ", pen_fecha=" + pen_fecha + ", pen_tiempo_trabajo=" + pen_tiempo_trabajo + ", pen_resolucion="
				+ pen_resolucion + ", pen_observacion=" + pen_observacion + ", tipoPension=" + tipoPension + "]";
	}
	
	
	
}

/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;


/**
 * clase calendarioOb objeto de tipo calendatio
 * @author ING_JAVIER
 * @version 10/06/2014 1
 */
public class Calendario {

	
	private int codigo;// int;// IDENTITY(1,1) NOT NULL
	private Periodo periodo= new Periodo();
	private String nombre;// varchar;//(30) NULL,
	private String fecha;// datetime;// NULL,
	private String documento;// varchar;//(10) NULL,
	
	
	
	/**
	 * 
	 */
	public Calendario() {
	}
	/**
	 * @param codigo
	 * @param periodo
	 * @param nombre
	 * @param fecha
	 * @param documento
	 */
	public Calendario(int codigo, Periodo periodo, String nombre, String fecha, String documento) {
		this.codigo = codigo;
		this.periodo = periodo;
		this.nombre = nombre;
		this.fecha = fecha;
		this.documento = documento;
	}
	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the periodo
	 */
	public Periodo getPeriodo() {
		return periodo;
	}
	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}
	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Calendario [codigo=" + codigo + ", periodo=" + periodo + ", nombre=" + nombre + ", fecha=" + fecha
				+ ", documento=" + documento + "]";
	}
	
	
	
}

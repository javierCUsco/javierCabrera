/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ING_JAVIER
 *
 */
@SuppressWarnings("serial")
public class Periodo implements Serializable{
	private int codigo;//] [int] IDENTITY(1,1) NOT NULL,
	private int  pet_codigo;//] [int] NULL,
	private String nombre;//] [varchar](50) NULL,
	private int anno;//] [int] NULL,
	private int periodo;//] [tinyint] NULL,
	private Date fechaInicio;//] [datetime] NULL,
	private Date fechaFin;//] [datetime] NULL,
	
	
	public Periodo(){
		
	}
	
	
	
	/**
	 * @param codigo
	 */
	public Periodo(int codigo) {
		this.codigo = codigo;
	}



	/**
	 * @param anno
	 * @param periodo
	 */
	public Periodo(int anno,int periodo){
		this.anno=anno;
		this.periodo=periodo;
	}

	
	/**
	 * @param per_codigo
	 * @param pet_codigo
	 * @param per_nombre
	 * @param per_anno
	 * @param per_periodo
	 * @param per_fecha_inicio
	 * @param per_fecha_fin
	 */
	public Periodo(int per_codigo,int  pet_codigo,String per_nombre,int per_anno,int per_periodo,Date per_fecha_inicio,Date per_fecha_fin){
		this.codigo=per_codigo;
		
		this.pet_codigo=pet_codigo;
		this.nombre=per_nombre;
		this.anno=per_anno;
		this.periodo=per_periodo;
		this.fechaInicio=per_fecha_inicio;
		this.fechaFin= per_fecha_fin;
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
	 * @return the pet_codigo
	 */
	public int getPet_codigo() {
		return pet_codigo;
	}


	/**
	 * @param pet_codigo the pet_codigo to set
	 */
	public void setPet_codigo(int pet_codigo) {
		this.pet_codigo = pet_codigo;
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
	 * @return the anno
	 */
	public int getAnno() {
		return anno;
	}


	/**
	 * @param anno the anno to set
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}


	/**
	 * @return the periodo
	 */
	public int getPeriodo() {
		return periodo;
	}


	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}


	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}


	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}


	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Periodo [codigo=" + codigo + ", pet_codigo=" + pet_codigo + ", nombre=" + nombre + ", anno=" + anno
				+ ", periodo=" + periodo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	
	
	
}

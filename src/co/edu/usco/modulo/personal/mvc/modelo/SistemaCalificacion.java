/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;



/**
 * @author Ingeniero Javier cabrera
 *
 */
public class SistemaCalificacion {
	private int codigo;//int] IDENTITY(1,1) NOT NULL,
	private Sistema sistema= new Sistema();
	private int puntaje;//varchar](5) NULL,
	private String observacion;//varchar](max) NULL,
	private String fecha;//date] NULL,
	private Usuario usuario;
	private String estado;//varchar](1) NULL,
	
	
	
	/**
	 * 
	 */
	public SistemaCalificacion() {
	}
	/**
	 * @param codigo
	 * @param sistema
	 * @param puntaje
	 * @param observacion
	 * @param fecha
	 * @param usuario
	 * @param estado
	 */
	public SistemaCalificacion(int codigo, Sistema sistema, int puntaje, String observacion, String fecha,
			Usuario usuario, String estado) {
		this.codigo = codigo;
		this.sistema = sistema;
		this.puntaje = puntaje;
		this.observacion = observacion;
		this.fecha = fecha;
		this.usuario = usuario;
		this.estado = estado;
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
	 * @return the sistema
	 */
	public Sistema getSistema() {
		return sistema;
	}
	/**
	 * @param sistema the sistema to set
	 */
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	/**
	 * @return the puntaje
	 */
	public int getPuntaje() {
		return puntaje;
	}
	/**
	 * @param puntaje the puntaje to set
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SistemaCalificacion [codigo=" + codigo + ", sistema=" + sistema + ", puntaje=" + puntaje
				+ ", observacion=" + observacion + ", fecha=" + fecha + ", usuario=" + usuario + ", estado=" + estado
				+ "]";
	}
	
	
	
	
	

}

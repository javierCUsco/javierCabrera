/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author Maritza
 *
 */
public class Mensaje {

	private boolean valido;
	private String msm="";
	private Object resultado;
	
	
	
	/**
	 * 
	 */
	public Mensaje() {
	}
	/**
	 * @param valido
	 * @param msm
	 * @param resultado
	 * @param usuario
	 */
	public Mensaje(boolean valido, String msm, Object resultado, Object usuario) {
		this.valido = valido;
		this.msm = msm;
		this.resultado = resultado;
//		this.usuario = (Usuario) usuario;
	}
	/**
	 * @return the valido
	 */
	public boolean isValido() {
		return valido;
	}
	/**
	 * @param valido the valido to set
	 */
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	/**
	 * @return the msm
	 */
	public String getMsm() {
		return msm;
	}
	/**
	 * @param msm the msm to set
	 */
	public void setMsm(String msm) {
		this.msm = msm;
	}
	/**
	 * @return the resultado
	 */
	public Object getResultado() {
		return resultado;
	}
	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}
	/**
	 * @return the usuario
	 */
//	public Usuario getUsuario() {
//		return usuario;
//	}
	/**
	 * @param usuario the usuario to set
	 */
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mensaje [valido=" + valido + ", msm=" + msm + ", resultado=" + resultado + ", usuario=" +1 + "]";
	}
	
	
	
}

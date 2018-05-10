/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author Maritza
 *
 */
public class Mensaje implements Serializable {

	private boolean valido;
	private String msm;
	private Object resultado;
	
	
	
	
	public Mensaje(boolean valido, String msm, Object resultado) {
		this.valido = valido;
		this.msm = msm;
		this.resultado = resultado;
	}
	public Mensaje() {
		// TODO Auto-generated constructor stub
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mensaje [valido=" + valido + ", msm=" + msm + ", resultado=" + resultado + "]";
	}

	
}

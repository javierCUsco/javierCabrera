/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo.pensionado;

import java.io.Serializable;

/**
 * @author ING. JAVIER CABRERA LASSO
 *
 */
public class TipoPension implements Serializable {
	
	private int tip_pen_codigo;//int] IDENTITY(1,1) NOT NULL,
	private String tip_pen_nombre;//nvarchar](100) NOT NULL
	
	/**
	 * 
	 */
	public TipoPension() {
	}
	/**
	 * @param tip_pen_codigo
	 * @param tip_pen_nombre
	 */
	public TipoPension(int tip_pen_codigo, String tip_pen_nombre) {
		this.tip_pen_codigo = tip_pen_codigo;
		this.tip_pen_nombre = tip_pen_nombre;
	}
	/**
	 * @return the tip_pen_codigo
	 */
	public int getTip_pen_codigo() {
		return tip_pen_codigo;
	}
	/**
	 * @param tip_pen_codigo the tip_pen_codigo to set
	 */
	public void setTip_pen_codigo(int tip_pen_codigo) {
		this.tip_pen_codigo = tip_pen_codigo;
	}
	/**
	 * @return the tip_pen_nombre
	 */
	public String getTip_pen_nombre() {
		return tip_pen_nombre;
	}
	/**
	 * @param tip_pen_nombre the tip_pen_nombre to set
	 */
	public void setTip_pen_nombre(String tip_pen_nombre) {
		this.tip_pen_nombre = tip_pen_nombre;
	}
	

	
}

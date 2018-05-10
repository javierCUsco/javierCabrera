/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author Maritza
 *
 */
public class nivel_academicoOb implements Serializable {

	private int nia_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String nia_nombre;//varchar](50) NULL,
	private int nia_orden;//tinyint] NULL,
	private int for_codigo;//tinyint] NULL,
	private String snies_codigo;//char](2) NULL,
	private int sippa_nia_codigo;//int] NULL,
	private int sippa_nivcodigo;//char](3) NULL,
	
//	private nia_codigo;//int] 
//	private nia_nombre;//varchar](50) NULL,
//	private nia_orden;//tinyint] NULL,
//	private for_codigo;//tinyint] NULL,
//	private snies_codigo;//char](2) NULL,
//	private sippa_nia_codigo;//int] NULL,
//	private sippa_nivcodigo;//char](3) NULL,
	private int nia_codigo_mp_hecaa;//int] NULL,
	private int nia_codigo_ned_hecaa;//int] NULL,
	private int nia_codigo_ne_hecaa;//int] NULL,
	private int nat_codigo;//int] NULL,
	private int nia_cap_puntos;//int] NULL,
	private int nia_cap_puntos_adicionales;//int] NULL,
	private int nia_cap_maximo;//int] NULL,
	private int nia_cap_puntos_xano;//int] NULL,
	private int nia_cap_descripcion;//int] NULL,
	private String nia_estado;//varchar](1) NOT NULL,
	
	
	
	
	/**
	 * @return the nia_codigo
	 */
	public int getNia_codigo() {
		return nia_codigo;
	}
	/**
	 * @param nia_codigo the nia_codigo to set
	 */
	public void setNia_codigo(int nia_codigo) {
		this.nia_codigo = nia_codigo;
	}
	/**
	 * @return the nia_nombre
	 */
	public String getNia_nombre() {
		return nia_nombre;
	}
	/**
	 * @param nia_nombre the nia_nombre to set
	 */
	public void setNia_nombre(String nia_nombre) {
		this.nia_nombre = nia_nombre;
	}
	/**
	 * @return the nia_orden
	 */
	public int getNia_orden() {
		return nia_orden;
	}
	/**
	 * @param nia_orden the nia_orden to set
	 */
	public void setNia_orden(int nia_orden) {
		this.nia_orden = nia_orden;
	}
	/**
	 * @return the for_codigo
	 */
	public int getFor_codigo() {
		return for_codigo;
	}
	/**
	 * @param for_codigo the for_codigo to set
	 */
	public void setFor_codigo(int for_codigo) {
		this.for_codigo = for_codigo;
	}
	/**
	 * @return the snies_codigo
	 */
	public String getSnies_codigo() {
		return snies_codigo;
	}
	/**
	 * @param snies_codigo the snies_codigo to set
	 */
	public void setSnies_codigo(String snies_codigo) {
		this.snies_codigo = snies_codigo;
	}
	/**
	 * @return the sippa_nia_codigo
	 */
	public int getSippa_nia_codigo() {
		return sippa_nia_codigo;
	}
	/**
	 * @param sippa_nia_codigo the sippa_nia_codigo to set
	 */
	public void setSippa_nia_codigo(int sippa_nia_codigo) {
		this.sippa_nia_codigo = sippa_nia_codigo;
	}
	/**
	 * @return the sippa_nivcodigo
	 */
	public int getSippa_nivcodigo() {
		return sippa_nivcodigo;
	}
	/**
	 * @param sippa_nivcodigo the sippa_nivcodigo to set
	 */
	public void setSippa_nivcodigo(int sippa_nivcodigo) {
		this.sippa_nivcodigo = sippa_nivcodigo;
	}
	/**
	 * @return the nia_codigo_mp_hecaa
	 */
	public int getNia_codigo_mp_hecaa() {
		return nia_codigo_mp_hecaa;
	}
	/**
	 * @param nia_codigo_mp_hecaa the nia_codigo_mp_hecaa to set
	 */
	public void setNia_codigo_mp_hecaa(int nia_codigo_mp_hecaa) {
		this.nia_codigo_mp_hecaa = nia_codigo_mp_hecaa;
	}
	/**
	 * @return the nia_codigo_ned_hecaa
	 */
	public int getNia_codigo_ned_hecaa() {
		return nia_codigo_ned_hecaa;
	}
	/**
	 * @param nia_codigo_ned_hecaa the nia_codigo_ned_hecaa to set
	 */
	public void setNia_codigo_ned_hecaa(int nia_codigo_ned_hecaa) {
		this.nia_codigo_ned_hecaa = nia_codigo_ned_hecaa;
	}
	/**
	 * @return the nia_codigo_ne_hecaa
	 */
	public int getNia_codigo_ne_hecaa() {
		return nia_codigo_ne_hecaa;
	}
	/**
	 * @param nia_codigo_ne_hecaa the nia_codigo_ne_hecaa to set
	 */
	public void setNia_codigo_ne_hecaa(int nia_codigo_ne_hecaa) {
		this.nia_codigo_ne_hecaa = nia_codigo_ne_hecaa;
	}
	/**
	 * @return the nat_codigo
	 */
	public int getNat_codigo() {
		return nat_codigo;
	}
	/**
	 * @param nat_codigo the nat_codigo to set
	 */
	public void setNat_codigo(int nat_codigo) {
		this.nat_codigo = nat_codigo;
	}
	/**
	 * @return the nia_cap_puntos
	 */
	public int getNia_cap_puntos() {
		return nia_cap_puntos;
	}
	/**
	 * @param nia_cap_puntos the nia_cap_puntos to set
	 */
	public void setNia_cap_puntos(int nia_cap_puntos) {
		this.nia_cap_puntos = nia_cap_puntos;
	}
	/**
	 * @return the nia_cap_puntos_adicionales
	 */
	public int getNia_cap_puntos_adicionales() {
		return nia_cap_puntos_adicionales;
	}
	/**
	 * @param nia_cap_puntos_adicionales the nia_cap_puntos_adicionales to set
	 */
	public void setNia_cap_puntos_adicionales(int nia_cap_puntos_adicionales) {
		this.nia_cap_puntos_adicionales = nia_cap_puntos_adicionales;
	}
	/**
	 * @return the nia_cap_maximo
	 */
	public int getNia_cap_maximo() {
		return nia_cap_maximo;
	}
	/**
	 * @param nia_cap_maximo the nia_cap_maximo to set
	 */
	public void setNia_cap_maximo(int nia_cap_maximo) {
		this.nia_cap_maximo = nia_cap_maximo;
	}
	/**
	 * @return the nia_cap_puntos_xano
	 */
	public int getNia_cap_puntos_xano() {
		return nia_cap_puntos_xano;
	}
	/**
	 * @param nia_cap_puntos_xano the nia_cap_puntos_xano to set
	 */
	public void setNia_cap_puntos_xano(int nia_cap_puntos_xano) {
		this.nia_cap_puntos_xano = nia_cap_puntos_xano;
	}
	/**
	 * @return the nia_cap_descripcion
	 */
	public int getNia_cap_descripcion() {
		return nia_cap_descripcion;
	}
	/**
	 * @param nia_cap_descripcion the nia_cap_descripcion to set
	 */
	public void setNia_cap_descripcion(int nia_cap_descripcion) {
		this.nia_cap_descripcion = nia_cap_descripcion;
	}
	/**
	 * @return the nia_estado
	 */
	public String getNia_estado() {
		return nia_estado;
	}
	/**
	 * @param nia_estado the nia_estado to set
	 */
	public void setNia_estado(String nia_estado) {
		this.nia_estado = nia_estado;
	}

	
	
	
}

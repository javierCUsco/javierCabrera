/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class Institucion_educativaOb implements Serializable {
	private int ine_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	//private int iet_codigo;//int] NOT NULL,
	private institucion_educativa_tipoOb tipo_institucion= new institucion_educativa_tipoOb();
	private String ine_nombre;//varchar](150) NOT NULL,
//	private mun_codigo;//int] NULL,
	private MunicipioOb municipio= new MunicipioOb();
	private PaisOb pais = new PaisOb();
//	private jor_codigo;//int] NULL,
	private JornadaOb jornada= new JornadaOb();
	private String ine_nivel;//varchar](50) NULL,
	private int inc_codigo;//int] NULL,
	private String sippa_inscodigo;//char](5) NULL,
	private String ine_fecha1;//datetime] NULL,
	private String ine_fecha2;//datetime] NULL,
	private String ine_codigo_hecaa;//varchar](30) NULL,
	/**
	 * @return the ine_codigo
	 */
	public int getIne_codigo() {
		return ine_codigo;
	}
	/**
	 * @param ine_codigo the ine_codigo to set
	 */
	public void setIne_codigo(int ine_codigo) {
		this.ine_codigo = ine_codigo;
	}
	/**
	 * @return the ine_nombre
	 */
	public String getIne_nombre() {
		return ine_nombre;
	}
	/**
	 * @param ine_nombre the ine_nombre to set
	 */
	public void setIne_nombre(String ine_nombre) {
		this.ine_nombre = ine_nombre;
	}
	/**
	 * @return the municipio
	 */
	public MunicipioOb getMunicipio() {
		return municipio;
	}
	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(MunicipioOb municipio) {
		this.municipio = municipio;
	}
	/**
	 * @return the ine_nivel
	 */
	public String getIne_nivel() {
		return ine_nivel;
	}
	/**
	 * @param ine_nivel the ine_nivel to set
	 */
	public void setIne_nivel(String ine_nivel) {
		this.ine_nivel = ine_nivel;
	}
	
	/**
	 * @return the inc_codigo
	 */
	public int getInc_codigo() {
		return inc_codigo;
	}
	/**
	 * @param inc_codigo the inc_codigo to set
	 */
	public void setInc_codigo(int inc_codigo) {
		this.inc_codigo = inc_codigo;
	}
	/**
	 * @return the sippa_inscodigo
	 */
	public String getSippa_inscodigo() {
		return sippa_inscodigo;
	}
	/**
	 * @param sippa_inscodigo the sippa_inscodigo to set
	 */
	public void setSippa_inscodigo(String sippa_inscodigo) {
		this.sippa_inscodigo = sippa_inscodigo;
	}
	/**
	 * @return the ine_fecha1
	 */
	public String getIne_fecha1() {
		return ine_fecha1;
	}
	/**
	 * @param ine_fecha1 the ine_fecha1 to set
	 */
	public void setIne_fecha1(String ine_fecha1) {
		this.ine_fecha1 = ine_fecha1;
	}
	/**
	 * @return the ine_fecha2
	 */
	public String getIne_fecha2() {
		return ine_fecha2;
	}
	/**
	 * @param ine_fecha2 the ine_fecha2 to set
	 */
	public void setIne_fecha2(String ine_fecha2) {
		this.ine_fecha2 = ine_fecha2;
	}
	/**
	 * @return the ine_codigo_hecaa
	 */
	public String getIne_codigo_hecaa() {
		return ine_codigo_hecaa;
	}
	/**
	 * @param ine_codigo_hecaa the ine_codigo_hecaa to set
	 */
	public void setIne_codigo_hecaa(String ine_codigo_hecaa) {
		this.ine_codigo_hecaa = ine_codigo_hecaa;
	}
	/**
	 * @return the tipo_institucion
	 */
	public institucion_educativa_tipoOb getTipo_institucion() {
		return tipo_institucion;
	}
	/**
	 * @param tipo_institucion the tipo_institucion to set
	 */
	public void setTipo_institucion(institucion_educativa_tipoOb tipo_institucion) {
		this.tipo_institucion = tipo_institucion;
	}
	/**
	 * @return the pais
	 */
	public PaisOb getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(PaisOb pais) {
		this.pais = pais;
	}
	/**
	 * @return the jornada
	 */
	public JornadaOb getJornada() {
		return jornada;
	}
	/**
	 * @param jornada the jornada to set
	 */
	public void setJornada(JornadaOb jornada) {
		this.jornada = jornada;
	}
	
	
	
}

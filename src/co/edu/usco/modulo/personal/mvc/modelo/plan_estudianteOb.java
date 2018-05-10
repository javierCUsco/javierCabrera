/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author Ing. Javier Cabrera
 *
 */
@SuppressWarnings("serial")
public class plan_estudianteOb implements Serializable {
	private int ple_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String est_codigo;//char](11) NULL,
	private int pla_codigo;//int] NULL,
	private int ple_estado;//bit] NULL,
	private int res_codigo;//int] NULL,
	private String ple_observacion;//varchar](200) NULL,
	private String sippa_placodigo;//char](7) NULL,
	private String sippa_procodigo;//char](4) NULL,
	private int paa_plan_academico;
	public int getPle_codigo() {
		return ple_codigo;
	}
	public void setPle_codigo(int ple_codigo) {
		this.ple_codigo = ple_codigo;
	}
	public String getEst_codigo() {
		return est_codigo;
	}
	public void setEst_codigo(String est_codigo) {
		this.est_codigo = est_codigo;
	}
	public int getPla_codigo() {
		return pla_codigo;
	}
	public void setPla_codigo(int pla_codigo) {
		this.pla_codigo = pla_codigo;
	}
	public int getPle_estado() {
		return ple_estado;
	}
	public void setPle_estado(int ple_estado) {
		this.ple_estado = ple_estado;
	}
	public int getRes_codigo() {
		return res_codigo;
	}
	public void setRes_codigo(int res_codigo) {
		this.res_codigo = res_codigo;
	}
	public String getPle_observacion() {
		return ple_observacion;
	}
	public void setPle_observacion(String ple_observacion) {
		this.ple_observacion = ple_observacion;
	}
	public String getSippa_placodigo() {
		return sippa_placodigo;
	}
	public void setSippa_placodigo(String sippa_placodigo) {
		this.sippa_placodigo = sippa_placodigo;
	}
	public String getSippa_procodigo() {
		return sippa_procodigo;
	}
	public void setSippa_procodigo(String sippa_procodigo) {
		this.sippa_procodigo = sippa_procodigo;
	}
	/**
	 * @return the paa_plan_academico
	 */
	public int getPaa_plan_academico() {
		return paa_plan_academico;
	}
	/**
	 * @param paa_plan_academico the paa_plan_academico to set
	 */
	public void setPaa_plan_academico(int paa_plan_academico) {
		this.paa_plan_academico = paa_plan_academico;
	}
	
	
}

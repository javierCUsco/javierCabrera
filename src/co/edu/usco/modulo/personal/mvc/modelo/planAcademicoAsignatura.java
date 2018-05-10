/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;

/**
 * @author ING_JAVIER
 *
 */
@SuppressWarnings("serial")
public class planAcademicoAsignatura implements Serializable{

	private int paa_codigo;//;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private int pla_codigo;//int] NOT NULL,
	private int asi_codigo;//int] NOT NULL,
	private String paa_area;//char](10) NULL,
	private String paa_subarea;//char](10) NULL,
	private int paa_semestre;//int] NULL,
	private int paa_credito;//int] NOT NULL,
	private int paa_intensidad;//int] NULL,
	private int pet_codigo;//int] NULL,
	private int nuc_codigo;//int] NULL,
	private int com_codigo;//int] NULL,
	private String paa_estado;//char](10) NULL,
	private float paa_nota_minima;//float] NOT NULL,
	private int paa_chequeo_requisito;//tinyint] NULL,
	private int paa_plan_academico;//tinyint] NULL,
	private String paa_obligatoria;//char](1) NULL,
	private String paa_programable;//char](1) NULL,
	private int paa_semanaxsemestre;//int] NULL,
	private int paa_h_trabajo_ind_sem;//int] NULL,
	private int paa_prerrequisito_creditos;//int] NULL,
	private String sippa_plancodigo;//char](7) NULL,
	private String sippa_asicodigo;//char](8) NULL,
	private String sippa_progcodigo;//char](4) NULL,
	private int paa_creditos_requisito;//int] NULL,
	/**
	 * 
	 */
	public planAcademicoAsignatura() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the paa_codigo
	 */
	public int getPaa_codigo() {
		return paa_codigo;
	}
	/**
	 * @param paa_codigo the paa_codigo to set
	 */
	public void setPaa_codigo(int paa_codigo) {
		this.paa_codigo = paa_codigo;
	}
	/**
	 * @return the pla_codigo
	 */
	public int getPla_codigo() {
		return pla_codigo;
	}
	/**
	 * @param pla_codigo the pla_codigo to set
	 */
	public void setPla_codigo(int pla_codigo) {
		this.pla_codigo = pla_codigo;
	}
	/**
	 * @return the asi_codigo
	 */
	public int getAsi_codigo() {
		return asi_codigo;
	}
	/**
	 * @param asi_codigo the asi_codigo to set
	 */
	public void setAsi_codigo(int asi_codigo) {
		this.asi_codigo = asi_codigo;
	}
	/**
	 * @return the paa_area
	 */
	public String getPaa_area() {
		return paa_area;
	}
	/**
	 * @param paa_area the paa_area to set
	 */
	public void setPaa_area(String paa_area) {
		this.paa_area = paa_area;
	}
	/**
	 * @return the paa_subarea
	 */
	public String getPaa_subarea() {
		return paa_subarea;
	}
	/**
	 * @param paa_subarea the paa_subarea to set
	 */
	public void setPaa_subarea(String paa_subarea) {
		this.paa_subarea = paa_subarea;
	}
	/**
	 * @return the paa_semestre
	 */
	public int getPaa_semestre() {
		return paa_semestre;
	}
	/**
	 * @param paa_semestre the paa_semestre to set
	 */
	public void setPaa_semestre(int paa_semestre) {
		this.paa_semestre = paa_semestre;
	}
	/**
	 * @return the paa_credito
	 */
	public int getPaa_credito() {
		return paa_credito;
	}
	/**
	 * @param paa_credito the paa_credito to set
	 */
	public void setPaa_credito(int paa_credito) {
		this.paa_credito = paa_credito;
	}
	/**
	 * @return the paa_intensidad
	 */
	public int getPaa_intensidad() {
		return paa_intensidad;
	}
	/**
	 * @param paa_intensidad the paa_intensidad to set
	 */
	public void setPaa_intensidad(int paa_intensidad) {
		this.paa_intensidad = paa_intensidad;
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
	 * @return the nuc_codigo
	 */
	public int getNuc_codigo() {
		return nuc_codigo;
	}
	/**
	 * @param nuc_codigo the nuc_codigo to set
	 */
	public void setNuc_codigo(int nuc_codigo) {
		this.nuc_codigo = nuc_codigo;
	}
	/**
	 * @return the com_codigo
	 */
	public int getCom_codigo() {
		return com_codigo;
	}
	/**
	 * @param com_codigo the com_codigo to set
	 */
	public void setCom_codigo(int com_codigo) {
		this.com_codigo = com_codigo;
	}
	/**
	 * @return the paa_estado
	 */
	public String getPaa_estado() {
		return paa_estado;
	}
	/**
	 * @param paa_estado the paa_estado to set
	 */
	public void setPaa_estado(String paa_estado) {
		this.paa_estado = paa_estado;
	}
	/**
	 * @return the paa_nota_minima
	 */
	public float getPaa_nota_minima() {
		return paa_nota_minima;
	}
	/**
	 * @param paa_nota_minima the paa_nota_minima to set
	 */
	public void setPaa_nota_minima(float paa_nota_minima) {
		this.paa_nota_minima = paa_nota_minima;
	}
	/**
	 * @return the paa_chequeo_requisito
	 */
	public int getPaa_chequeo_requisito() {
		return paa_chequeo_requisito;
	}
	/**
	 * @param paa_chequeo_requisito the paa_chequeo_requisito to set
	 */
	public void setPaa_chequeo_requisito(int paa_chequeo_requisito) {
		this.paa_chequeo_requisito = paa_chequeo_requisito;
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
	/**
	 * @return the paa_obligatoria
	 */
	public String getPaa_obligatoria() {
		return paa_obligatoria;
	}
	/**
	 * @param paa_obligatoria the paa_obligatoria to set
	 */
	public void setPaa_obligatoria(String paa_obligatoria) {
		this.paa_obligatoria = paa_obligatoria;
	}
	/**
	 * @return the paa_programable
	 */
	public String getPaa_programable() {
		return paa_programable;
	}
	/**
	 * @param paa_programable the paa_programable to set
	 */
	public void setPaa_programable(String paa_programable) {
		this.paa_programable = paa_programable;
	}
	/**
	 * @return the paa_semanaxsemestre
	 */
	public int getPaa_semanaxsemestre() {
		return paa_semanaxsemestre;
	}
	/**
	 * @param paa_semanaxsemestre the paa_semanaxsemestre to set
	 */
	public void setPaa_semanaxsemestre(int paa_semanaxsemestre) {
		this.paa_semanaxsemestre = paa_semanaxsemestre;
	}
	/**
	 * @return the paa_h_trabajo_ind_sem
	 */
	public int getPaa_h_trabajo_ind_sem() {
		return paa_h_trabajo_ind_sem;
	}
	/**
	 * @param paa_h_trabajo_ind_sem the paa_h_trabajo_ind_sem to set
	 */
	public void setPaa_h_trabajo_ind_sem(int paa_h_trabajo_ind_sem) {
		this.paa_h_trabajo_ind_sem = paa_h_trabajo_ind_sem;
	}
	/**
	 * @return the paa_prerrequisito_creditos
	 */
	public int getPaa_prerrequisito_creditos() {
		return paa_prerrequisito_creditos;
	}
	/**
	 * @param paa_prerrequisito_creditos the paa_prerrequisito_creditos to set
	 */
	public void setPaa_prerrequisito_creditos(int paa_prerrequisito_creditos) {
		this.paa_prerrequisito_creditos = paa_prerrequisito_creditos;
	}
	/**
	 * @return the sippa_plancodigo
	 */
	public String getSippa_plancodigo() {
		return sippa_plancodigo;
	}
	/**
	 * @param sippa_plancodigo the sippa_plancodigo to set
	 */
	public void setSippa_plancodigo(String sippa_plancodigo) {
		this.sippa_plancodigo = sippa_plancodigo;
	}
	/**
	 * @return the sippa_asicodigo
	 */
	public String getSippa_asicodigo() {
		return sippa_asicodigo;
	}
	/**
	 * @param sippa_asicodigo the sippa_asicodigo to set
	 */
	public void setSippa_asicodigo(String sippa_asicodigo) {
		this.sippa_asicodigo = sippa_asicodigo;
	}
	/**
	 * @return the sippa_progcodigo
	 */
	public String getSippa_progcodigo() {
		return sippa_progcodigo;
	}
	/**
	 * @param sippa_progcodigo the sippa_progcodigo to set
	 */
	public void setSippa_progcodigo(String sippa_progcodigo) {
		this.sippa_progcodigo = sippa_progcodigo;
	}
	/**
	 * @return the paa_creditos_requisito
	 */
	public int getPaa_creditos_requisito() {
		return paa_creditos_requisito;
	}
	/**
	 * @param paa_creditos_requisito the paa_creditos_requisito to set
	 */
	public void setPaa_creditos_requisito(int paa_creditos_requisito) {
		this.paa_creditos_requisito = paa_creditos_requisito;
	}
	
	
	
}

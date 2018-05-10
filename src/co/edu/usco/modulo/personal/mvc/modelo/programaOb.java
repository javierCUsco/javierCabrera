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
public class programaOb implements Serializable{

	private int pro_codigo;//int] IDENTITY(1,1) NOT NULL,
//	private  pro_programa;//char](4) NULL,
//	private  sed_codigo;//int] NULL,
	private int uaa_codigo;//int] NOT NULL,
//	private  nia_codigo;//int] NULL,
	private  String pro_registro_icfes;//varchar](50) NULL,
	private  String pro_registro_snies;//varchar](50) NULL,
	private  int jor_codigo;//int] NULL,
//	private  res_codigo;//int] NULL,
	private  String pro_titulo_otorgado;//varchar](100) NULL,
//	private  pro_fecha_creacion;//datetime] NULL,
//	private  mod_codigo;//tinyint] NULL,
//	private  con_codigo;//int] NULL,
	private  String pro_horario;//varchar](100) NULL,
	private  String pro_estado;//char](1) NULL,
//	private  pro_propio;//char](1) NULL,
	private  int uaa_programa_gen;//int] NULL,
//	private  par_codigo;//int] NULL,
//	private  nbc_codigo;//int] NULL,
	private  String pro_calendario;//char](1) NULL,
//	private  sippa_pro_codigo;//char](4) NULL,
	private ModalidadOb modalidad=new ModalidadOb(); 
	private JornadaOb jornada= new JornadaOb();
	private nivel_academicoOb nivel = new nivel_academicoOb();
	public nivel_academicoOb getNivel() {
		return nivel;
	}

	public void setNivel(nivel_academicoOb nivel) {
		this.nivel = nivel;
	}

	/**
	 * 
	 */
	public programaOb() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the pro_codigo
	 */
	public int getPro_codigo() {
		return pro_codigo;
	}

	/**
	 * @param pro_codigo the pro_codigo to set
	 */
	public void setPro_codigo(int pro_codigo) {
		this.pro_codigo = pro_codigo;
	}

	/**
	 * @return the uaa_codigo
	 */
	public int getUaa_codigo() {
		return uaa_codigo;
	}

	/**
	 * @param uaa_codigo the uaa_codigo to set
	 */
	public void setUaa_codigo(int uaa_codigo) {
		this.uaa_codigo = uaa_codigo;
	}

	/**
	 * @return the pro_registro_icfes
	 */
	public String getPro_registro_icfes() {
		return pro_registro_icfes;
	}

	/**
	 * @param pro_registro_icfes the pro_registro_icfes to set
	 */
	public void setPro_registro_icfes(String pro_registro_icfes) {
		this.pro_registro_icfes = pro_registro_icfes;
	}

	/**
	 * @return the pro_registro_snies
	 */
	public String getPro_registro_snies() {
		return pro_registro_snies;
	}

	/**
	 * @param pro_registro_snies the pro_registro_snies to set
	 */
	public void setPro_registro_snies(String pro_registro_snies) {
		this.pro_registro_snies = pro_registro_snies;
	}

	/**
	 * @return the jor_codigo
	 */
	public int getJor_codigo() {
		return jor_codigo;
	}

	/**
	 * @param jor_codigo the jor_codigo to set
	 */
	public void setJor_codigo(int jor_codigo) {
		this.jor_codigo = jor_codigo;
	}

	/**
	 * @return the pro_titulo_otorgado
	 */
	public String getPro_titulo_otorgado() {
		return pro_titulo_otorgado;
	}

	/**
	 * @param pro_titulo_otorgado the pro_titulo_otorgado to set
	 */
	public void setPro_titulo_otorgado(String pro_titulo_otorgado) {
		this.pro_titulo_otorgado = pro_titulo_otorgado;
	}

	/**
	 * @return the pro_horario
	 */
	public String getPro_horario() {
		return pro_horario;
	}

	/**
	 * @param pro_horario the pro_horario to set
	 */
	public void setPro_horario(String pro_horario) {
		this.pro_horario = pro_horario;
	}

	/**
	 * @return the pro_estado
	 */
	public String getPro_estado() {
		return pro_estado;
	}

	/**
	 * @param pro_estado the pro_estado to set
	 */
	public void setPro_estado(String pro_estado) {
		this.pro_estado = pro_estado;
	}

	/**
	 * @return the uaa_programa_gen
	 */
	public int getUaa_programa_gen() {
		return uaa_programa_gen;
	}

	/**
	 * @param uaa_programa_gen the uaa_programa_gen to set
	 */
	public void setUaa_programa_gen(int uaa_programa_gen) {
		this.uaa_programa_gen = uaa_programa_gen;
	}

	/**
	 * @return the pro_calendario
	 */
	public String getPro_calendario() {
		return pro_calendario;
	}

	/**
	 * @param pro_calendario the pro_calendario to set
	 */
	public void setPro_calendario(String pro_calendario) {
		this.pro_calendario = pro_calendario;
	}

	/**
	 * @return the modalidad
	 */
	public ModalidadOb getModalidad() {
		return modalidad;
	}

	/**
	 * @param modalidad the modalidad to set
	 */
	public void setModalidad(ModalidadOb modalidad) {
		this.modalidad = modalidad;
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

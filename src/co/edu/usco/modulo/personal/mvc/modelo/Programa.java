/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author ING_JAVIER
 *
 */
public class Programa {

	private int pro_codigo;//int] IDENTITY(1,1) NOT NULL,
//	private  pro_programa;//char](4) NULL,
	private  Sede sede= new Sede();//int] NULL,
	private int uaa_codigo;//int] NOT NULL,

	private NivelAcademico nivelAcademico= new NivelAcademico();
	private  String registroIcfes;//varchar](50) NULL,
	private  String registroSnies;//varchar](50) NULL,
	private  int jor_codigo;//int] NULL,
	private Jornada jornada= new Jornada();
//	private  res_codigo;//int] NULL,
	private  String tituloOtorgado;//varchar](100) NULL,
//	private  pro_fecha_creacion;//datetime] NULL,
//	private  mod_codigo;//tinyint] NULL,
//	private  con_codigo;//int] NULL,
	private  String horario;//varchar](100) NULL,
	private  String estado;//char](1) NULL,
//	private  pro_propio;//char](1) NULL,
	private  int uaa_programa_gen;//int] NULL,
//	private  par_codigo;//int] NULL,
//	private  nbc_codigo;//int] NULL,
	private  String calendario;//char](1) NULL,
//	private  sippa_pro_codigo;//char](4) NULL,
	private Modalidad modalidad=new Modalidad();
	
	
	/**
 * 
 */
public Programa() {
}
	/**
 * @param pro_codigo
 * @param sede
 * @param uaa_codigo
 * @param nivelAcademico
 * @param registroIcfes
 * @param registroSnies
 * @param jor_codigo
 * @param jornada
 * @param tituloOtorgado
 * @param horario
 * @param estado
 * @param uaa_programa_gen
 * @param calendario
 * @param modalidad
 */
public Programa(int pro_codigo, Sede sede, int uaa_codigo, NivelAcademico nivelAcademico, String registroIcfes,
		String registroSnies, int jor_codigo, Jornada jornada, String tituloOtorgado, String horario, String estado,
		int uaa_programa_gen, String calendario, Modalidad modalidad) {
	this.pro_codigo = pro_codigo;
	this.sede = sede;
	this.uaa_codigo = uaa_codigo;
	this.nivelAcademico = nivelAcademico;
	this.registroIcfes = registroIcfes;
	this.registroSnies = registroSnies;
	this.jor_codigo = jor_codigo;
	this.jornada = jornada;
	this.tituloOtorgado = tituloOtorgado;
	this.horario = horario;
	this.estado = estado;
	this.uaa_programa_gen = uaa_programa_gen;
	this.calendario = calendario;
	this.modalidad = modalidad;
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
	 * @return the sede
	 */
	public Sede getSede() {
		return sede;
	}
	/**
	 * @param sede the sede to set
	 */
	public void setSede(Sede sede) {
		this.sede = sede;
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
	 * @return the nivelAcademico
	 */
	public NivelAcademico getNivelAcademico() {
		return nivelAcademico;
	}
	/**
	 * @param nivelAcademico the nivelAcademico to set
	 */
	public void setNivelAcademico(NivelAcademico nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}
	/**
	 * @return the registroIcfes
	 */
	public String getRegistroIcfes() {
		return registroIcfes;
	}
	/**
	 * @param registroIcfes the registroIcfes to set
	 */
	public void setRegistroIcfes(String registroIcfes) {
		this.registroIcfes = registroIcfes;
	}
	/**
	 * @return the registroSnies
	 */
	public String getRegistroSnies() {
		return registroSnies;
	}
	/**
	 * @param registroSnies the registroSnies to set
	 */
	public void setRegistroSnies(String registroSnies) {
		this.registroSnies = registroSnies;
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
	 * @return the jornada
	 */
	public Jornada getJornada() {
		return jornada;
	}
	/**
	 * @param jornada the jornada to set
	 */
	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}
	/**
	 * @return the tituloOtorgado
	 */
	public String getTituloOtorgado() {
		return tituloOtorgado;
	}
	/**
	 * @param tituloOtorgado the tituloOtorgado to set
	 */
	public void setTituloOtorgado(String tituloOtorgado) {
		this.tituloOtorgado = tituloOtorgado;
	}
	/**
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}
	/**
	 * @param horario the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
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
	 * @return the calendario
	 */
	public String getCalendario() {
		return calendario;
	}
	/**
	 * @param calendario the calendario to set
	 */
	public void setCalendario(String calendario) {
		this.calendario = calendario;
	}
	/**
	 * @return the modalidad
	 */
	public Modalidad getModalidad() {
		return modalidad;
	}
	/**
	 * @param modalidad the modalidad to set
	 */
	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Programa [pro_codigo=" + pro_codigo + ", sede=" + sede + ", uaa_codigo=" + uaa_codigo
				+ ", nivelAcademico=" + nivelAcademico + ", registroIcfes=" + registroIcfes + ", registroSnies="
				+ registroSnies + ", jor_codigo=" + jor_codigo + ", jornada=" + jornada + ", tituloOtorgado="
				+ tituloOtorgado + ", horario=" + horario + ", estado=" + estado + ", uaa_programa_gen="
				+ uaa_programa_gen + ", calendario=" + calendario + ", modalidad=" + modalidad + "]";
	} 
	

	

}

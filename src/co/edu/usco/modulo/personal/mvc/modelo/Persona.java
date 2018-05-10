/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ING_JAVIER
 * 
 */

@SuppressWarnings("serial")
public class Persona implements Serializable {
//	private int usu_id;
//	private int per_codigo; // int] IDENTITY(1,1) NOT NULL,
//	private String per_identificacion; // varchar](15) NULL,
//	private String tii_codigo; // int] NOT NULL,
//	private String mun_nombre;//
//	private String per_apellido; // varchar](40) NULL,
//	private String per_nombre; // varchar](40) NULL,
//	private String programa;

	/**
	 * @return the historia_academica
	 */
	public List<PersonaHistoriaAcademica> getHistoria_academica() {
		return historia_academica;
	}
	/**
	 * @param historia_academica the historia_academica to set
	 */
	public void setHistoria_academica(List<PersonaHistoriaAcademica> historia_academica) {
		this.historia_academica = historia_academica;
	}
	/**
	 * @return the historia_laboral
	 */
	public List<PersonaHistoriaLaboral> getHistoria_laboral() {
		return historia_laboral;
	}
	/**
	 * @param historia_laboral the historia_laboral to set
	 */
	public void setHistoria_laboral(List<PersonaHistoriaLaboral> historia_laboral) {
		this.historia_laboral = historia_laboral;
	}
	private int per_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String per_identificacion;//varchar](15) NOT NULL,
//	private int tii_codigo;//int] NOT NULL,
	private Tipo_idOb tii_codigo= new Tipo_idOb();
	private String per_libreta_militar;//varchar](15) NULL,
	private String per_apellido;//varchar](40) NULL,
	private String per_nombre;//varchar](40) NULL,
//	private String per_genero;//char](1) NULL,
	private GeneroOb genero= new GeneroOb();
//	private int per_lugar_expedicion;//int] NULL,
	private MunicipioOb per_lugar_expedicion= new MunicipioOb();
	private Date per_fecha_expedicion;//datetime] NULL,
	private Date per_fecha_nacimiento;//datetime] NULL,
	private String per_direccion_residencia;//varchar](255) NULL,
	private String per_telefono_movil;//varchar](50) NULL,
	private String per_telefono_fijo;//varchar](30) NULL,
//	private String per_estado_civil;//char](1) NULL,
	private Estado_civilOb estado_civil= new Estado_civilOb();
//	private int per_lugar_nacimiento;//int] NULL,
	private MunicipioOb per_lugar_nacimiento= new MunicipioOb();
//	private int per_lugar_residencia;//int] NULL,
	private MunicipioOb per_lugar_residencia= new MunicipioOb();
	private int per_departamento_residencia;//int] NULL,
	private int per_pais_residencia;//int] NULL,
	private String per_barrio;//varchar](50) NULL,
//	private int per_estrato;//tinyint] NULL,
	private EstratoOb estrato= new EstratoOb();
//	private int eps_codigo;//int] NULL,
	private Eps eps= new Eps();
	private int eta_codigo;//int] NULL,
	private String per_numero_afiliacion_eps;//varchar](20) NULL,
	private String per_ips_sisben;//varchar](200) NULL,
	private String per_id_cotizante;//varchar](15) NULL,
	private String per_beneficiario_ley1081;//char](1) NULL,
	private String per_familiar_direccion;//varchar](255) NULL,
	private String per_familiar_nombre;//varchar](60) NULL,
	private String per_familiar_telefono;//varchar](30) NULL,
//	private int per_familiar_lugar_residencia;//int] NULL,
	private MunicipioOb familiar_lugar_residencia= new MunicipioOb();
	private String per_email;//varchar](100) NULL,
	private String per_email_interno;//varchar](100) NULL,
	private int enviar_correo;//tinyint] NULL,
	private String per_pagina_personal;//varchar](100) NULL,
//	private int grs_codigo;//int] NULL,
	private Grupo_sangineoOb grs= new Grupo_sangineoOb();
	private int per_estado;//tinyint] NULL,
//	private int nat_codigo;//int] NULL,
	private LNX_naturalezaOb naturaleza= new LNX_naturalezaOb();
//	private int reg_codigo;//int] NULL,
	private LNX_regimenOb regimen= new LNX_regimenOb();
	private String per_razon_social;//varchar](200) NULL,
	private String per_identificacion_dup;//varchar](15) NULL,
	private String per_cedula;//varchar](15) NULL,
	private String per_tarjeta;//varchar](15) NULL,
	private String per_codigo_postal;//varchar](10) NULL,
	private String per_pasaporte;//varchar](10) NULL,
	private String per_huella;//varbinary](3000) NULL,
	private String per_fecha_registro;//datetime] NULL,
	private int per_codigo_pais_hecaa;//int] NULL,
	private String per_fecha_actualizacion;//datetime] NULL,
	private Archivo archivo= new Archivo();
	
	
	private List<PersonaHistoriaAcademica> historia_academica;
	private List<PersonaHistoriaLaboral> historia_laboral;
	
	
	
	/**
	 * @param historia_academica
	 * @param historia_laboral
	 */
	public Persona() {
		this.historia_academica =new  LinkedList<PersonaHistoriaAcademica>();
		this.historia_laboral =new LinkedList<PersonaHistoriaLaboral>();
	}
	/**
	 * @return the per_codigo
	 */
	public int getPer_codigo() {
		return per_codigo;
	}
	/**
	 * @param per_codigo the per_codigo to set
	 */
	public void setPer_codigo(int per_codigo) {
		this.per_codigo = per_codigo;
	}
	/**
	 * @return the per_identificacion
	 */
	public String getPer_identificacion() {
		return per_identificacion;
	}
	/**
	 * @param per_identificacion the per_identificacion to set
	 */
	public void setPer_identificacion(String per_identificacion) {
		this.per_identificacion = per_identificacion;
	}
	/**
	 * @return the tii_codigo
	 */
	public Tipo_idOb getTii_codigo() {
		return tii_codigo;
	}
	/**
	 * @param tii_codigo the tii_codigo to set
	 */
	public void setTii_codigo(Tipo_idOb tii_codigo) {
		this.tii_codigo = tii_codigo;
	}
	/**
	 * @return the per_libreta_militar
	 */
	public String getPer_libreta_militar() {
		return per_libreta_militar;
	}
	/**
	 * @param per_libreta_militar the per_libreta_militar to set
	 */
	public void setPer_libreta_militar(String per_libreta_militar) {
		this.per_libreta_militar = per_libreta_militar;
	}
	/**
	 * @return the per_apellido
	 */
	public String getPer_apellido() {
		return per_apellido;
	}
	/**
	 * @param per_apellido the per_apellido to set
	 */
	public void setPer_apellido(String per_apellido) {
		this.per_apellido = per_apellido;
	}
	/**
	 * @return the per_nombre
	 */
	public String getPer_nombre() {
		return per_nombre;
	}
	/**
	 * @param per_nombre the per_nombre to set
	 */
	public void setPer_nombre(String per_nombre) {
		this.per_nombre = per_nombre;
	}
	/**
	 * @return the genero
	 */
	public GeneroOb getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(GeneroOb genero) {
		this.genero = genero;
	}
	/**
	 * @return the per_lugar_expedicion
	 */
	public MunicipioOb getPer_lugar_expedicion() {
		return per_lugar_expedicion;
	}
	/**
	 * @param per_lugar_expedicion the per_lugar_expedicion to set
	 */
	public void setPer_lugar_expedicion(MunicipioOb per_lugar_expedicion) {
		this.per_lugar_expedicion = per_lugar_expedicion;
	}
	/**
	 * @return the per_fecha_expedicion
	 */
	public Date getPer_fecha_expedicion() {
		return per_fecha_expedicion;
	}
	/**
	 * @param per_fecha_expedicion the per_fecha_expedicion to set
	 */
	public void setPer_fecha_expedicion(Date per_fecha_expedicion) {
		if(per_fecha_expedicion!=null){
			this.per_fecha_expedicion = per_fecha_expedicion;
		}
	}
	/**
	 * @return the per_fecha_nacimiento
	 */
	public Date getPer_fecha_nacimiento() {
		return per_fecha_nacimiento;
	}
	/**
	 * @param per_fecha_nacimiento the per_fecha_nacimiento to set
	 */
	public void setPer_fecha_nacimiento(Date per_fecha_nacimiento) {
		if(per_fecha_nacimiento!=null){
			this.per_fecha_nacimiento = per_fecha_nacimiento;
		}
	}
	/**
	 * @return the per_direccion_residencia
	 */
	public String getPer_direccion_residencia() {
		return per_direccion_residencia;
	}
	/**
	 * @param per_direccion_residencia the per_direccion_residencia to set
	 */
	public void setPer_direccion_residencia(String per_direccion_residencia) {
		this.per_direccion_residencia = per_direccion_residencia;
	}
	/**
	 * @return the per_telefono_movil
	 */
	public String getPer_telefono_movil() {
		return per_telefono_movil;
	}
	/**
	 * @param per_telefono_movil the per_telefono_movil to set
	 */
	public void setPer_telefono_movil(String per_telefono_movil) {
		this.per_telefono_movil = per_telefono_movil;
	}
	/**
	 * @return the per_telefono_fijo
	 */
	public String getPer_telefono_fijo() {
		return per_telefono_fijo;
	}
	/**
	 * @param per_telefono_fijo the per_telefono_fijo to set
	 */
	public void setPer_telefono_fijo(String per_telefono_fijo) {
		this.per_telefono_fijo = per_telefono_fijo;
	}
	/**
	 * @return the estado_civil
	 */
	public Estado_civilOb getEstado_civil() {
		return estado_civil;
	}
	/**
	 * @param estado_civil the estado_civil to set
	 */
	public void setEstado_civil(Estado_civilOb estado_civil) {
		this.estado_civil = estado_civil;
	}
	/**
	 * @return the per_lugar_nacimiento
	 */
	public MunicipioOb getPer_lugar_nacimiento() {
		return per_lugar_nacimiento;
	}
	/**
	 * @param per_lugar_nacimiento the per_lugar_nacimiento to set
	 */
	public void setPer_lugar_nacimiento(MunicipioOb per_lugar_nacimiento) {
		this.per_lugar_nacimiento = per_lugar_nacimiento;
	}
	/**
	 * @return the per_lugar_residencia
	 */
	public MunicipioOb getPer_lugar_residencia() {
		return per_lugar_residencia;
	}
	/**
	 * @param per_lugar_residencia the per_lugar_residencia to set
	 */
	public void setPer_lugar_residencia(MunicipioOb per_lugar_residencia) {
		this.per_lugar_residencia = per_lugar_residencia;
	}
	/**
	 * @return the per_departamento_residencia
	 */
	public int getPer_departamento_residencia() {
		return per_departamento_residencia;
	}
	/**
	 * @param per_departamento_residencia the per_departamento_residencia to set
	 */
	public void setPer_departamento_residencia(int per_departamento_residencia) {
		this.per_departamento_residencia = per_departamento_residencia;
	}
	/**
	 * @return the per_pais_residencia
	 */
	public int getPer_pais_residencia() {
		return per_pais_residencia;
	}
	/**
	 * @param per_pais_residencia the per_pais_residencia to set
	 */
	public void setPer_pais_residencia(int per_pais_residencia) {
		this.per_pais_residencia = per_pais_residencia;
	}
	/**
	 * @return the per_barrio
	 */
	public String getPer_barrio() {
		return per_barrio;
	}
	/**
	 * @param per_barrio the per_barrio to set
	 */
	public void setPer_barrio(String per_barrio) {
		this.per_barrio = per_barrio;
	}
	/**
	 * @return the estrato
	 */
	public EstratoOb getEstrato() {
		return estrato;
	}
	/**
	 * @param estrato the estrato to set
	 */
	public void setEstrato(EstratoOb estrato) {
		this.estrato = estrato;
	}
	/**
	 * @return the eps
	 */
	public Eps getEps() {
		return eps;
	}
	/**
	 * @param eps the eps to set
	 */
	public void setEps(Eps eps) {
		this.eps = eps;
	}
	/**
	 * @return the eta_codigo
	 */
	public int getEta_codigo() {
		return eta_codigo;
	}
	/**
	 * @param eta_codigo the eta_codigo to set
	 */
	public void setEta_codigo(int eta_codigo) {
		this.eta_codigo = eta_codigo;
	}
	/**
	 * @return the per_numero_afiliacion_eps
	 */
	public String getPer_numero_afiliacion_eps() {
		return per_numero_afiliacion_eps;
	}
	/**
	 * @param per_numero_afiliacion_eps the per_numero_afiliacion_eps to set
	 */
	public void setPer_numero_afiliacion_eps(String per_numero_afiliacion_eps) {
		this.per_numero_afiliacion_eps = per_numero_afiliacion_eps;
	}
	/**
	 * @return the per_ips_sisben
	 */
	public String getPer_ips_sisben() {
		return per_ips_sisben;
	}
	/**
	 * @param per_ips_sisben the per_ips_sisben to set
	 */
	public void setPer_ips_sisben(String per_ips_sisben) {
		this.per_ips_sisben = per_ips_sisben;
	}
	/**
	 * @return the per_id_cotizante
	 */
	public String getPer_id_cotizante() {
		return per_id_cotizante;
	}
	/**
	 * @param per_id_cotizante the per_id_cotizante to set
	 */
	public void setPer_id_cotizante(String per_id_cotizante) {
		this.per_id_cotizante = per_id_cotizante;
	}
	/**
	 * @return the per_beneficiario_ley1081
	 */
	public String getPer_beneficiario_ley1081() {
		return per_beneficiario_ley1081;
	}
	/**
	 * @param per_beneficiario_ley1081 the per_beneficiario_ley1081 to set
	 */
	public void setPer_beneficiario_ley1081(String per_beneficiario_ley1081) {
		this.per_beneficiario_ley1081 = per_beneficiario_ley1081;
	}
	/**
	 * @return the per_familiar_direccion
	 */
	public String getPer_familiar_direccion() {
		return per_familiar_direccion;
	}
	/**
	 * @param per_familiar_direccion the per_familiar_direccion to set
	 */
	public void setPer_familiar_direccion(String per_familiar_direccion) {
		this.per_familiar_direccion = per_familiar_direccion;
	}
	/**
	 * @return the per_familiar_nombre
	 */
	public String getPer_familiar_nombre() {
		return per_familiar_nombre;
	}
	/**
	 * @param per_familiar_nombre the per_familiar_nombre to set
	 */
	public void setPer_familiar_nombre(String per_familiar_nombre) {
		this.per_familiar_nombre = per_familiar_nombre;
	}
	/**
	 * @return the per_familiar_telefono
	 */
	public String getPer_familiar_telefono() {
		return per_familiar_telefono;
	}
	/**
	 * @param per_familiar_telefono the per_familiar_telefono to set
	 */
	public void setPer_familiar_telefono(String per_familiar_telefono) {
		this.per_familiar_telefono = per_familiar_telefono;
	}
	
	/**
	 * @return the familiar_lugar_residencia
	 */
	public MunicipioOb getFamiliar_lugar_residencia() {
		return familiar_lugar_residencia;
	}
	/**
	 * @param familiar_lugar_residencia the familiar_lugar_residencia to set
	 */
	public void setFamiliar_lugar_residencia(MunicipioOb familiar_lugar_residencia) {
		this.familiar_lugar_residencia = familiar_lugar_residencia;
	}
	/**
	 * @return the per_email
	 */
	public String getPer_email() {
		return per_email;
	}
	/**
	 * @param per_email the per_email to set
	 */
	public void setPer_email(String per_email) {
		this.per_email = per_email;
	}
	/**
	 * @return the per_email_interno
	 */
	public String getPer_email_interno() {
		return per_email_interno;
	}
	/**
	 * @param per_email_interno the per_email_interno to set
	 */
	public void setPer_email_interno(String per_email_interno) {
		this.per_email_interno = per_email_interno;
	}
	/**
	 * @return the enviar_correo
	 */
	public int getEnviar_correo() {
		return enviar_correo;
	}
	/**
	 * @param enviar_correo the enviar_correo to set
	 */
	public void setEnviar_correo(int enviar_correo) {
		this.enviar_correo = enviar_correo;
	}
	/**
	 * @return the per_pagina_personal
	 */
	public String getPer_pagina_personal() {
		return per_pagina_personal;
	}
	/**
	 * @param per_pagina_personal the per_pagina_personal to set
	 */
	public void setPer_pagina_personal(String per_pagina_personal) {
		this.per_pagina_personal = per_pagina_personal;
	}
	/**
	 * @return the grs
	 */
	public Grupo_sangineoOb getGrs() {
		return grs;
	}
	/**
	 * @param grs the grs to set
	 */
	public void setGrs(Grupo_sangineoOb grs) {
		this.grs = grs;
	}
	/**
	 * @return the per_estado
	 */
	public int getPer_estado() {
		return per_estado;
	}
	/**
	 * @param per_estado the per_estado to set
	 */
	public void setPer_estado(int per_estado) {
		this.per_estado = per_estado;
	}
	/**
	 * @return the naturaleza
	 */
	public LNX_naturalezaOb getNaturaleza() {
		return naturaleza;
	}
	/**
	 * @param naturaleza the naturaleza to set
	 */
	public void setNaturaleza(LNX_naturalezaOb naturaleza) {
		this.naturaleza = naturaleza;
	}
	/**
	 * @return the regimen
	 */
	public LNX_regimenOb getRegimen() {
		return regimen;
	}
	/**
	 * @param regimen the regimen to set
	 */
	public void setRegimen(LNX_regimenOb regimen) {
		this.regimen = regimen;
	}
	/**
	 * @return the per_razon_social
	 */
	public String getPer_razon_social() {
		return per_razon_social;
	}
	/**
	 * @param per_razon_social the per_razon_social to set
	 */
	public void setPer_razon_social(String per_razon_social) {
		this.per_razon_social = per_razon_social;
	}
	/**
	 * @return the per_identificacion_dup
	 */
	public String getPer_identificacion_dup() {
		return per_identificacion_dup;
	}
	/**
	 * @param per_identificacion_dup the per_identificacion_dup to set
	 */
	public void setPer_identificacion_dup(String per_identificacion_dup) {
		this.per_identificacion_dup = per_identificacion_dup;
	}
	/**
	 * @return the per_cedula
	 */
	public String getPer_cedula() {
		return per_cedula;
	}
	/**
	 * @param per_cedula the per_cedula to set
	 */
	public void setPer_cedula(String per_cedula) {
		this.per_cedula = per_cedula;
	}
	/**
	 * @return the per_tarjeta
	 */
	public String getPer_tarjeta() {
		return per_tarjeta;
	}
	/**
	 * @param per_tarjeta the per_tarjeta to set
	 */
	public void setPer_tarjeta(String per_tarjeta) {
		this.per_tarjeta = per_tarjeta;
	}
	/**
	 * @return the per_codigo_postal
	 */
	public String getPer_codigo_postal() {
		return per_codigo_postal;
	}
	/**
	 * @param per_codigo_postal the per_codigo_postal to set
	 */
	public void setPer_codigo_postal(String per_codigo_postal) {
		this.per_codigo_postal = per_codigo_postal;
	}
	/**
	 * @return the per_pasaporte
	 */
	public String getPer_pasaporte() {
		return per_pasaporte;
	}
	/**
	 * @param per_pasaporte the per_pasaporte to set
	 */
	public void setPer_pasaporte(String per_pasaporte) {
		this.per_pasaporte = per_pasaporte;
	}
	/**
	 * @return the per_huella
	 */
	public String getPer_huella() {
		return per_huella;
	}
	/**
	 * @param per_huella the per_huella to set
	 */
	public void setPer_huella(String per_huella) {
		this.per_huella = per_huella;
	}
	/**
	 * @return the per_fecha_registro
	 */
	public String getPer_fecha_registro() {
		return per_fecha_registro;
	}
	/**
	 * @param per_fecha_registro the per_fecha_registro to set
	 */
	public void setPer_fecha_registro(String per_fecha_registro) {
		this.per_fecha_registro = per_fecha_registro;
	}
	/**
	 * @return the per_codigo_pais_hecaa
	 */
	public int getPer_codigo_pais_hecaa() {
		return per_codigo_pais_hecaa;
	}
	/**
	 * @param per_codigo_pais_hecaa the per_codigo_pais_hecaa to set
	 */
	public void setPer_codigo_pais_hecaa(int per_codigo_pais_hecaa) {
		this.per_codigo_pais_hecaa = per_codigo_pais_hecaa;
	}
	/**
	 * @return the per_fecha_actualizacion
	 */
	public String getPer_fecha_actualizacion() {
		return per_fecha_actualizacion;
	}
	/**
	 * @param per_fecha_actualizacion the per_fecha_actualizacion to set
	 */
	public void setPer_fecha_actualizacion(String per_fecha_actualizacion) {
		this.per_fecha_actualizacion = per_fecha_actualizacion;
	}
	/**
	 * @return the archivo
	 */
	public Archivo getArchivo() {
		return archivo;
	}
	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [per_codigo=" + per_codigo + ", per_identificacion=" + per_identificacion + ", tii_codigo="
				+ tii_codigo + ", per_libreta_militar=" + per_libreta_militar + ", per_apellido=" + per_apellido
				+ ", per_nombre=" + per_nombre + ", genero=" + genero + ", per_lugar_expedicion=" + per_lugar_expedicion
				+ ", per_fecha_expedicion=" + per_fecha_expedicion + ", per_fecha_nacimiento=" + per_fecha_nacimiento
				+ ", per_direccion_residencia=" + per_direccion_residencia + ", per_telefono_movil="
				+ per_telefono_movil + ", per_telefono_fijo=" + per_telefono_fijo + ", estado_civil=" + estado_civil
				+ ", per_lugar_nacimiento=" + per_lugar_nacimiento + ", per_lugar_residencia=" + per_lugar_residencia
				+ ", per_departamento_residencia=" + per_departamento_residencia + ", per_pais_residencia="
				+ per_pais_residencia + ", per_barrio=" + per_barrio + ", estrato=" + estrato + ", eps=" + eps
				+ ", eta_codigo=" + eta_codigo + ", per_numero_afiliacion_eps=" + per_numero_afiliacion_eps
				+ ", per_ips_sisben=" + per_ips_sisben + ", per_id_cotizante=" + per_id_cotizante
				+ ", per_beneficiario_ley1081=" + per_beneficiario_ley1081 + ", per_familiar_direccion="
				+ per_familiar_direccion + ", per_familiar_nombre=" + per_familiar_nombre + ", per_familiar_telefono="
				+ per_familiar_telefono + ", familiar_lugar_residencia=" + familiar_lugar_residencia + ", per_email="
				+ per_email + ", per_email_interno=" + per_email_interno + ", enviar_correo=" + enviar_correo
				+ ", per_pagina_personal=" + per_pagina_personal + ", grs=" + grs + ", per_estado=" + per_estado
				+ ", naturaleza=" + naturaleza + ", regimen=" + regimen + ", per_razon_social=" + per_razon_social
				+ ", per_identificacion_dup=" + per_identificacion_dup + ", per_cedula=" + per_cedula + ", per_tarjeta="
				+ per_tarjeta + ", per_codigo_postal=" + per_codigo_postal + ", per_pasaporte=" + per_pasaporte
				+ ", per_huella=" + per_huella + ", per_fecha_registro=" + per_fecha_registro
				+ ", per_codigo_pais_hecaa=" + per_codigo_pais_hecaa + ", per_fecha_actualizacion="
				+ per_fecha_actualizacion + ", archivo=" + archivo + ", historia_academica=" + historia_academica
				+ ", historia_laboral=" + historia_laboral + "]";
	}
	
	
	
	
	
	

}

/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class UaaPersonal implements Serializable {
	/**
	 * @return the uap_codigo
	 */
	public int getUap_codigo() {
		return uap_codigo;
	}
	/**
	 * @param uap_codigo the uap_codigo to set
	 */
	public void setUap_codigo(int uap_codigo) {
		this.uap_codigo = uap_codigo;
	}
	/**
	 * @return the uaa
	 */
	public Uaa getUaa() {
		return uaa;
	}
	/**
	 * @param uaa the uaa to set
	 */
	public void setUaa(Uaa uaa) {
		this.uaa = uaa;
	}
	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}
	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	/**
	 * @return the uap_fecha_inicio
	 */
	public Date getUap_fecha_inicio() {
		return uap_fecha_inicio;
	}
	/**
	 * @param uap_fecha_inicio the uap_fecha_inicio to set
	 */
	public void setUap_fecha_inicio(Date uap_fecha_inicio) {
		if(uap_fecha_inicio!=null){
			this.uap_fecha_inicio = uap_fecha_inicio;
		}
	}
	/**
	 * @return the uap_fecha_fin
	 */
	public Date getUap_fecha_fin() {
		return uap_fecha_fin;
	}
	/**
	 * @param uap_fecha_fin the uap_fecha_fin to set
	 */
	public void setUap_fecha_fin(Date uap_fecha_fin) {
		if(uap_fecha_fin!=null){
			this.uap_fecha_fin = uap_fecha_fin;
		}
	}
	/**
	 * @return the cargo
	 */
	public Cargo getCargo() {
		return cargo;
	}
	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	/**
	 * @return the vinculacio
	 */
	public Vinculacion getVinculacio() {
		return vinculacio;
	}
	/**
	 * @param vinculacio the vinculacio to set
	 */
	public void setVinculacio(Vinculacion vinculacio) {
		this.vinculacio = vinculacio;
	}
	/**
	 * @return the dedicacion
	 */
	public Dedicacion getDedicacion() {
		return dedicacion;
	}
	/**
	 * @param dedicacion the dedicacion to set
	 */
	public void setDedicacion(Dedicacion dedicacion) {
		this.dedicacion = dedicacion;
	}
	/**
	 * @return the uap_resolucion
	 */
	public String getUap_resolucion() {
		return uap_resolucion;
	}
	/**
	 * @param uap_resolucion the uap_resolucion to set
	 */
	public void setUap_resolucion(String uap_resolucion) {
		this.uap_resolucion = uap_resolucion;
	}
	/**
	 * @return the uap_estado
	 */
	public int getUap_estado() {
		return uap_estado;
	}
	/**
	 * @param uap_estado the uap_estado to set
	 */
	public void setUap_estado(int uap_estado) {
		this.uap_estado = uap_estado;
	}
	/**
	 * @return the esv_codigo
	 */
	public int getEsv_codigo() {
		return esv_codigo;
	}
	/**
	 * @param esv_codigo the esv_codigo to set
	 */
	public void setEsv_codigo(int esv_codigo) {
		this.esv_codigo = esv_codigo;
	}
	/**
	 * @return the esc_valor
	 */
	public double getEsc_valor() {
		return esc_valor;
	}
	/**
	 * @param esc_valor the esc_valor to set
	 */
	public void setEsc_valor(double esc_valor) {
		this.esc_valor = esc_valor;
	}
	/**
	 * @return the sippa_puntos
	 */
	public String getSippa_puntos() {
		return sippa_puntos;
	}
	/**
	 * @param sippa_puntos the sippa_puntos to set
	 */
	public void setSippa_puntos(String sippa_puntos) {
		this.sippa_puntos = sippa_puntos;
	}
	/**
	 * @return the sippa_doccedula
	 */
	public String getSippa_doccedula() {
		return sippa_doccedula;
	}
	/**
	 * @param sippa_doccedula the sippa_doccedula to set
	 */
	public void setSippa_doccedula(String sippa_doccedula) {
		this.sippa_doccedula = sippa_doccedula;
	}
	/**
	 * @return the sippa_vincodigo
	 */
	public String getSippa_vincodigo() {
		return sippa_vincodigo;
	}
	/**
	 * @param sippa_vincodigo the sippa_vincodigo to set
	 */
	public void setSippa_vincodigo(String sippa_vincodigo) {
		this.sippa_vincodigo = sippa_vincodigo;
	}
	/**
	 * @return the sippa_calcodigo
	 */
	public String getSippa_calcodigo() {
		return sippa_calcodigo;
	}
	/**
	 * @param sippa_calcodigo the sippa_calcodigo to set
	 */
	public void setSippa_calcodigo(String sippa_calcodigo) {
		this.sippa_calcodigo = sippa_calcodigo;
	}
	/**
	 * @return the sippa_dedcodigo
	 */
	public String getSippa_dedcodigo() {
		return sippa_dedcodigo;
	}
	/**
	 * @param sippa_dedcodigo the sippa_dedcodigo to set
	 */
	public void setSippa_dedcodigo(String sippa_dedcodigo) {
		this.sippa_dedcodigo = sippa_dedcodigo;
	}
	/**
	 * @return the uap_codigo_anterior
	 */
	public int getUap_codigo_anterior() {
		return uap_codigo_anterior;
	}
	/**
	 * @param uap_codigo_anterior the uap_codigo_anterior to set
	 */
	public void setUap_codigo_anterior(int uap_codigo_anterior) {
		this.uap_codigo_anterior = uap_codigo_anterior;
	}
	/**
	 * @return the uac_codigo
	 */
	public UaaCargo getUac_codigo() {
		return uaaCargo;
	}
	/**
	 * @param uac_codigo the uac_codigo to set
	 */
	public void setUac_codigo(UaaCargo uac_codigo) {
		this.uaaCargo = uac_codigo;
	}
	/**
	 * @return the uap_plantaencargo
	 */
	public String getUap_plantaencargo() {
		return uap_plantaencargo;
	}
	/**
	 * @param uap_plantaencargo the uap_plantaencargo to set
	 */
	public void setUap_plantaencargo(String uap_plantaencargo) {
		this.uap_plantaencargo = uap_plantaencargo;
	}
	/**
	 * @return the uap_uacocupado
	 */
	public int getUap_uacocupado() {
		return uap_uacocupado;
	}
	/**
	 * @param uap_uacocupado the uap_uacocupado to set
	 */
	public void setUap_uacocupado(int uap_uacocupado) {
		this.uap_uacocupado = uap_uacocupado;
	}
	/**
	 * @return the uap_dependencia_ejerce
	 */
	public int getUap_dependencia_ejerce() {
		return uap_dependencia_ejerce;
	}
	/**
	 * @param uap_dependencia_ejerce the uap_dependencia_ejerce to set
	 */
	public void setUap_dependencia_ejerce(int uap_dependencia_ejerce) {
		this.uap_dependencia_ejerce = uap_dependencia_ejerce;
	}
	/**
	 * @return the codRegistro
	 */
	public int getCodRegistro() {
		return codRegistro;
	}
	/**
	 * @param codRegistro the codRegistro to set
	 */
	public void setCodRegistro(int codRegistro) {
		this.codRegistro = codRegistro;
	}
	/**
	 * @return the uap_id_carnet
	 */
	public String getUap_id_carnet() {
		return uap_id_carnet;
	}
	/**
	 * @param uap_id_carnet the uap_id_carnet to set
	 */
	public void setUap_id_carnet(String uap_id_carnet) {
		this.uap_id_carnet = uap_id_carnet;
	}
	/**
	 * @return the sede
	 */
	public sedeOb getSede() {
		return sede;
	}
	/**
	 * @param sede the sede to set
	 */
	public void setSede(sedeOb sede) {
		this.sede = sede;
	}
	/**
	 * @return the uap_observacion
	 */
	public String getUap_observacion() {
		return uap_observacion;
	}
	/**
	 * @param uap_observacion the uap_observacion to set
	 */
	public void setUap_observacion(String uap_observacion) {
		this.uap_observacion = uap_observacion;
	}
	
	
	
	private int uap_codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private Uaa uaa= new Uaa();//int] NOT NULL,
	private Persona persona= new Persona();//int] NOT NULL,
	private Date uap_fecha_inicio;//datetime] NOT NULL,
	private Date uap_fecha_fin;//datetime] NULL,
	private Cargo cargo= new Cargo();//int] NULL,
	private Vinculacion vinculacio= new Vinculacion();//int] NOT NULL,
	private Dedicacion dedicacion= new Dedicacion();//int] NULL,
	private String uap_resolucion;//varchar](100) NULL,
	private int uap_estado;//smallint] NULL,
	private int esv_codigo;//int] NULL,
	private double esc_valor;//money] NULL,
	private String sippa_puntos;//varchar](500) NULL,
	private String sippa_doccedula;//char](11) NULL,
	private String sippa_vincodigo;//char](3) NULL,
	private String sippa_calcodigo;//char](6) NULL,
	private String sippa_dedcodigo;//char](1) NULL,
	private int uap_codigo_anterior;//int] NULL,
	private UaaCargo uaaCargo= new UaaCargo();//int] NULL,
	private String uap_plantaencargo;//char](1) NULL,
	private int uap_uacocupado;//int] NULL,
	private int uap_dependencia_ejerce;//int] NULL,
	private int codRegistro;//bigint] NULL,
	private String uap_id_carnet;//varchar](45) NULL,
	private sedeOb sede= new sedeOb();//int] NULL,
	private String uap_observacion;//nvarchar](max) NULL,
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UaaPersonal [uap_codigo=" + uap_codigo + ", uaa=" + uaa + ", persona=" + persona + ", uap_fecha_inicio="
				+ uap_fecha_inicio + ", uap_fecha_fin=" + uap_fecha_fin + ", cargo=" + cargo + ", vinculacio="
				+ vinculacio + ", dedicacion=" + dedicacion + ", uap_resolucion=" + uap_resolucion + ", uap_estado="
				+ uap_estado + ", esv_codigo=" + esv_codigo + ", esc_valor=" + esc_valor + ", sippa_puntos="
				+ sippa_puntos + ", sippa_doccedula=" + sippa_doccedula + ", sippa_vincodigo=" + sippa_vincodigo
				+ ", sippa_calcodigo=" + sippa_calcodigo + ", sippa_dedcodigo=" + sippa_dedcodigo
				+ ", uap_codigo_anterior=" + uap_codigo_anterior + ", uac_codigo=" + uaaCargo + ", uap_plantaencargo="
				+ uap_plantaencargo + ", uap_uacocupado=" + uap_uacocupado + ", uap_dependencia_ejerce="
				+ uap_dependencia_ejerce + ", codRegistro=" + codRegistro + ", uap_id_carnet=" + uap_id_carnet
				+ ", sede=" + sede + ", uap_observacion=" + uap_observacion + "]";
	}
	/**
	 * @param uap_codigo
	 * @param uaa
	 * @param persona
	 * @param uap_fecha_inicio
	 * @param uap_fecha_fin
	 * @param cargo
	 * @param vinculacio
	 * @param dedicacion
	 * @param uap_resolucion
	 * @param uap_estado
	 * @param esv_codigo
	 * @param esc_valor
	 * @param sippa_puntos
	 * @param sippa_doccedula
	 * @param sippa_vincodigo
	 * @param sippa_calcodigo
	 * @param sippa_dedcodigo
	 * @param uap_codigo_anterior
	 * @param uac_codigo
	 * @param uap_plantaencargo
	 * @param uap_uacocupado
	 * @param uap_dependencia_ejerce
	 * @param codRegistro
	 * @param uap_id_carnet
	 * @param sede
	 * @param uap_observacion
	 */
	public UaaPersonal(int uap_codigo, Uaa uaa, Persona persona, Date uap_fecha_inicio, Date uap_fecha_fin,
			Cargo cargo, Vinculacion vinculacio, Dedicacion dedicacion, String uap_resolucion, int uap_estado,
			int esv_codigo, double esc_valor, String sippa_puntos, String sippa_doccedula, String sippa_vincodigo,
			String sippa_calcodigo, String sippa_dedcodigo, int uap_codigo_anterior, UaaCargo uac_codigo,
			String uap_plantaencargo, int uap_uacocupado, int uap_dependencia_ejerce, int codRegistro,
			String uap_id_carnet, sedeOb sede, String uap_observacion) {
		this.uap_codigo = uap_codigo;
		this.uaa = uaa;
		this.persona = persona;
		this.uap_fecha_inicio = uap_fecha_inicio;
		this.uap_fecha_fin = uap_fecha_fin;
		this.cargo = cargo;
		this.vinculacio = vinculacio;
		this.dedicacion = dedicacion;
		this.uap_resolucion = uap_resolucion;
		this.uap_estado = uap_estado;
		this.esv_codigo = esv_codigo;
		this.esc_valor = esc_valor;
		this.sippa_puntos = sippa_puntos;
		this.sippa_doccedula = sippa_doccedula;
		this.sippa_vincodigo = sippa_vincodigo;
		this.sippa_calcodigo = sippa_calcodigo;
		this.sippa_dedcodigo = sippa_dedcodigo;
		this.uap_codigo_anterior = uap_codigo_anterior;
		this.uaaCargo = uac_codigo;
		this.uap_plantaencargo = uap_plantaencargo;
		this.uap_uacocupado = uap_uacocupado;
		this.uap_dependencia_ejerce = uap_dependencia_ejerce;
		this.codRegistro = codRegistro;
		this.uap_id_carnet = uap_id_carnet;
		this.sede = sede;
		this.uap_observacion = uap_observacion;
	}
	/**
	 * 
	 */
	public UaaPersonal() {
	}
	
	
	
}

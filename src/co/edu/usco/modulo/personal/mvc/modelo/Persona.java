/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ING_JAVIER
 * 
 */

public class Persona {


	private int codigo;//int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	private String identificacion;//varchar](15) NOT NULL,
	private TipoId tipoId= new TipoId();
	private String libretaMilitar;//varchar](15) NULL,
	private String apellido;//varchar](40) NULL,
	private String nombre;//varchar](40) NULL,
	private String apellido2;//varchar](40) NULL,
	private String nombre2;//varchar](40) NULL,
	private Genero genero= new Genero();
	private Municipio lugarExpedicion= new Municipio();
	private Date fechaExpedicion;//datetime] NULL,
	private Date fechaNacimiento;//datetime] NULL,
	private String direccionResidencia;//varchar](255) NULL,
	private String telefonoMovil;//varchar](50) NULL,
	private String telefonoFijo;//varchar](30) NULL,
	private EstadoCivil estadoCivil= new EstadoCivil();
	private Municipio lugarNacimiento= new Municipio();
	private Municipio lugarResidencia= new Municipio();
//	private int departamentoResidencia;//int] NULL,
//	private int paisResidencia;//int] NULL,
	private String barrio;//varchar](50) NULL,
	private Estrato estrato= new Estrato();
	private Eps eps= new Eps();
	private int etaCodigo;//int] NULL,
	private String numeroAfiliacionEps;//varchar](20) NULL,
	private String ipsSisben;//varchar](200) NULL,
	private String idCotizante;//varchar](15) NULL,
	private String beneficiarioLey1081;//char](1) NULL,
	private String familiarDireccion;//varchar](255) NULL,
	private String familiarNombre;//varchar](60) NULL,
	private String familiarTelefono;//varchar](30) NULL,
	private Municipio familiarLugarResidencia= new Municipio();
	private String email;//varchar](100) NULL,
	private String emailInterno;//varchar](100) NULL,
	private int enviarCorreo;//tinyint] NULL,
	private String paginaPersonal;//varchar](100) NULL,
	private GrupoSanguineo grupoSanguineo= new GrupoSanguineo();
	private boolean estado;//tinyint] NULL,
//	private LNXNaturaleza naturaleza= new LNXNaturaleza();
//	private LNX_regimenOb regimen= new LNX_regimenOb();
	private String razonSocial;//varchar](200) NULL,
	private String identificacionDup;//varchar](15) NULL,
	private String cedula;//varchar](15) NULL,
	private String tarjeta;//varchar](15) NULL,
	private String codigoPostal;//varchar](10) NULL,
	private String pasaporte;//varchar](10) NULL,
	private String huella;//varbinary](3000) NULL,
	private String fechaRegistro;//datetime] NULL,
	private int codigoPaisHecaa;//int] NULL,
	private String fechaActualizacion;//datetime] NULL,
//	private Archivo archivo= new Archivo();
	private DocentePuntos docentePuntos= new DocentePuntos();
	
	private Usco usco;
	private PersonaHistoriaAcademica historiaAcademica;
	private PersonaHistoriaLaboral historiaLaboral;
	
	
	
	
	/**
	 * @param codigo
	 */
	public Persona(int codigo) {
		this.codigo = codigo;
	}

	


	/**
	 * @param codigo
	 * @param archivo
	 */
//	public Persona(int codigo, Archivo archivo) {
//		this.codigo = codigo;
//		this.archivo = archivo;
//	}




	/**
	 * @param historia_academica
	 * @param historia_laboral
	 */
	public Persona() {
		this.historiaAcademica =new  PersonaHistoriaAcademica();
		this.historiaLaboral =new PersonaHistoriaLaboral();
	}



	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}



	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}



	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}



	/**
	 * @return the tii
	 */
	public TipoId getTipoId() {
		return tipoId;
	}



	/**
	 * @param tii the tii to set
	 */
	public void setTipoId(TipoId tii) {
		this.tipoId = tii;
	}



	/**
	 * @return the libretaMilitar
	 */
	public String getLibretaMilitar() {
		return libretaMilitar;
	}



	/**
	 * @param libretaMilitar the libretaMilitar to set
	 */
	public void setLibretaMilitar(String libretaMilitar) {
		this.libretaMilitar = libretaMilitar;
	}



	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}



	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}



	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}



	/**
	 * @param apellido2 
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}



	/**
	 * @return the nombre2
	 */
	public String getNombre2() {
		return nombre2;
	}



	/**
	 * @param nombre2 the nombre2 to set
	 */
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}



	/**
	 * @return the genero
	 */
	public Genero getGenero() {
		return genero;
	}



	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}



	/**
	 * @return the lugarExpedicion
	 */
	public Municipio getLugarExpedicion() {
		return lugarExpedicion;
	}



	/**
	 * @param lugarExpedicion the lugarExpedicion to set
	 */
	public void setLugarExpedicion(Municipio lugarExpedicion) {
		this.lugarExpedicion = lugarExpedicion;
	}



	/**
	 * @return the fechaExpedicion
	 */
	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}



	/**
	 * @param fechaExpedicion the fechaExpedicion to set
	 */
	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}



	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}



	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	/**
	 * @return the direccionResidencia
	 */
	public String getDireccionResidencia() {
		return direccionResidencia;
	}



	/**
	 * @param direccionResidencia the direccionResidencia to set
	 */
	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}



	/**
	 * @return the telefonoMovil
	 */
	public String getTelefonoMovil() {
		return telefonoMovil;
	}



	/**
	 * @param telefonoMovil the telefonoMovil to set
	 */
	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}



	/**
	 * @return the telefonoFijo
	 */
	public String getTelefonoFijo() {
		return telefonoFijo;
	}



	/**
	 * @param telefonoFijo the telefonoFijo to set
	 */
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}



	/**
	 * @return the estadoCivil
	 */
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}



	/**
	 * @param estadoCivil the estadoCivil to set
	 */
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}



	/**
	 * @return the lugarNacimiento
	 */
	public Municipio getLugarNacimiento() {
		return lugarNacimiento;
	}



	/**
	 * @param lugarNacimiento the lugarNacimiento to set
	 */
	public void setLugarNacimiento(Municipio lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}



	/**
	 * @return the lugarResidencia
	 */
	public Municipio getLugarResidencia() {
		return lugarResidencia;
	}



	/**
	 * @param lugarResidencia the lugarResidencia to set
	 */
	public void setLugarResidencia(Municipio lugarResidencia) {
		this.lugarResidencia = lugarResidencia;
	}



	/**
	 * @return the departamentoResidencia
	 */
//	public int getDepartamentoResidencia() {
//		return departamentoResidencia;
//	}



	/**
	 * @param departamentoResidencia the departamentoResidencia to set
	 */
//	public void setDepartamentoResidencia(int departamentoResidencia) {
//		this.departamentoResidencia = departamentoResidencia;
//	}



	/**
	 * @return the paisResidencia
	 */
//	public int getPaisResidencia() {
//		return paisResidencia;
//	}



	/**
	 * @param paisResidencia the paisResidencia to set
	 */
//	public void setPaisResidencia(int paisResidencia) {
//		this.paisResidencia = paisResidencia;
//	}



	/**
	 * @return the barrio
	 */
	public String getBarrio() {
		return barrio;
	}



	/**
	 * @param barrio the barrio to set
	 */
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}



	/**
	 * @return the estrato
	 */
	public Estrato getEstrato() {
		return estrato;
	}



	/**
	 * @param estrato the estrato to set
	 */
	public void setEstrato(Estrato estrato) {
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
	 * @return the etaCodigo
	 */
	public int getEtaCodigo() {
		return etaCodigo;
	}



	/**
	 * @param etaCodigo the etaCodigo to set
	 */
	public void setEtaCodigo(int etaCodigo) {
		this.etaCodigo = etaCodigo;
	}



	/**
	 * @return the numeroAfiliacionEps
	 */
	public String getNumeroAfiliacionEps() {
		return numeroAfiliacionEps;
	}



	/**
	 * @param numeroAfiliacionEps the numeroAfiliacionEps to set
	 */
	public void setNumeroAfiliacionEps(String numeroAfiliacionEps) {
		this.numeroAfiliacionEps = numeroAfiliacionEps;
	}



	/**
	 * @return the ipsSisben
	 */
	public String getIpsSisben() {
		return ipsSisben;
	}



	/**
	 * @param ipsSisben the ipsSisben to set
	 */
	public void setIpsSisben(String ipsSisben) {
		this.ipsSisben = ipsSisben;
	}



	/**
	 * @return the idCotizante
	 */
	public String getIdCotizante() {
		return idCotizante;
	}



	/**
	 * @param idCotizante the idCotizante to set
	 */
	public void setIdCotizante(String idCotizante) {
		this.idCotizante = idCotizante;
	}



	/**
	 * @return the beneficiarioLey1081
	 */
	public String getBeneficiarioLey1081() {
		return beneficiarioLey1081;
	}



	/**
	 * @param beneficiarioLey1081 the beneficiarioLey1081 to set
	 */
	public void setBeneficiarioLey1081(String beneficiarioLey1081) {
		this.beneficiarioLey1081 = beneficiarioLey1081;
	}



	/**
	 * @return the familiarDireccion
	 */
	public String getFamiliarDireccion() {
		return familiarDireccion;
	}



	/**
	 * @param familiarDireccion the familiarDireccion to set
	 */
	public void setFamiliarDireccion(String familiarDireccion) {
		this.familiarDireccion = familiarDireccion;
	}



	/**
	 * @return the familiarNombre
	 */
	public String getFamiliarNombre() {
		return familiarNombre;
	}



	/**
	 * @param familiarNombre the familiarNombre to set
	 */
	public void setFamiliarNombre(String familiarNombre) {
		this.familiarNombre = familiarNombre;
	}



	/**
	 * @return the familiarTelefono
	 */
	public String getFamiliarTelefono() {
		return familiarTelefono;
	}



	/**
	 * @param familiarTelefono the familiarTelefono to set
	 */
	public void setFamiliarTelefono(String familiarTelefono) {
		this.familiarTelefono = familiarTelefono;
	}



	/**
	 * @return the familiarLugarResidencia
	 */
	public Municipio getFamiliarLugarResidencia() {
		return familiarLugarResidencia;
	}



	/**
	 * @param familiarLugarResidencia the familiarLugarResidencia to set
	 */
	public void setFamiliarLugarResidencia(Municipio familiarLugarResidencia) {
		this.familiarLugarResidencia = familiarLugarResidencia;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the emailInterno
	 */
	public String getEmailInterno() {
		return emailInterno;
	}



	/**
	 * @param emailInterno the emailInterno to set
	 */
	public void setEmailInterno(String emailInterno) {
		this.emailInterno = emailInterno;
	}



	/**
	 * @return the enviarCorreo
	 */
	public int getEnviarCorreo() {
		return enviarCorreo;
	}



	/**
	 * @param enviarCorreo the enviarCorreo to set
	 */
	public void setEnviarCorreo(int enviarCorreo) {
		this.enviarCorreo = enviarCorreo;
	}



	/**
	 * @return the paginaPersonal
	 */
	public String getPaginaPersonal() {
		return paginaPersonal;
	}



	/**
	 * @param paginaPersonal the paginaPersonal to set
	 */
	public void setPaginaPersonal(String paginaPersonal) {
		this.paginaPersonal = paginaPersonal;
	}



	/**
	 * @return the grs
	 */
	public GrupoSanguineo getGrupoSanguineo() {
		return grupoSanguineo;
	}



	/**
	 * @param grs the grs to set
	 */
	public void setGrupoSanguineo(GrupoSanguineo grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}



	/**
	 * @return the estado
	 */
	public boolean getEstado() {
		return estado;
	}



	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}



	/**
	 * @return the naturaleza
	 */
//	public LNXNaturaleza getNaturaleza() {
//		return naturaleza;
//	}



	/**
	 * @param naturaleza the naturaleza to set
	 */
	public void setNaturaleza(LNXNaturaleza naturaleza) {
//		this.naturaleza = naturaleza;
	}



	/**
	 * @return the regimen
	 */
//	public LNX_regimenOb getRegimen() {
//		return regimen;
//	}



	/**
	 * @param regimen the regimen to set
	 */
//	public void setRegimen(LNX_regimenOb regimen) {
//		this.regimen = regimen;
//	}



	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}



	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}



	/**
	 * @return the identificacionDup
	 */
	public String getIdentificacionDup() {
		return identificacionDup;
	}



	/**
	 * @param identificacionDup the identificacionDup to set
	 */
	public void setIdentificacionDup(String identificacionDup) {
		this.identificacionDup = identificacionDup;
	}



	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}



	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	/**
	 * @return the tarjeta
	 */
	public String getTarjeta() {
		return tarjeta;
	}



	/**
	 * @param tarjeta the tarjeta to set
	 */
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}



	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}



	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}



	/**
	 * @return the pasaporte
	 */
	public String getPasaporte() {
		return pasaporte;
	}



	/**
	 * @param pasaporte the pasaporte to set
	 */
	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}



	/**
	 * @return the huella
	 */
	public String getHuella() {
		return huella;
	}



	/**
	 * @param huella the huella to set
	 */
	public void setHuella(String huella) {
		this.huella = huella;
	}



	/**
	 * @return the fechaRegistro
	 */
	public String getFechaRegistro() {
		return fechaRegistro;
	}



	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



	/**
	 * @return the codigoPaisHecaa
	 */
	public int getCodigoPaisHecaa() {
		return codigoPaisHecaa;
	}



	/**
	 * @param codigoPaisHecaa the codigoPaisHecaa to set
	 */
	public void setCodigoPaisHecaa(int codigoPaisHecaa) {
		this.codigoPaisHecaa = codigoPaisHecaa;
	}



	/**
	 * @return the fechaActualizacion
	 */
	public String getFechaActualizacion() {
		return fechaActualizacion;
	}



	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(String fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}



	/**
	 * @return the archivo
	 */
//	public Archivo getArchivo() {
//		return archivo;
//	}



	/**
	 * @param archivo the archivo to set
	 */
//	public void setArchivo(Archivo archivo) {
//		this.archivo = archivo;
//	}



	/**
	 * @return the historiaAcademica
	 */
	public PersonaHistoriaAcademica getHistoriaAcademica() {
		return historiaAcademica;
	}



	/**
	 * @param historiaAcademica the historiaAcademica to set
	 */
	public void setHistoriaAcademica(PersonaHistoriaAcademica historiaAcademica) {
		this.historiaAcademica = historiaAcademica;
	}



	/**
	 * @return the historiaLaboral
	 */
	public PersonaHistoriaLaboral getHistoriaLaboral() {
		return historiaLaboral;
	}



	/**
	 * @param historiaLaboral the historiaLaboral to set
	 */
	public void setHistoriaLaboral(PersonaHistoriaLaboral historiaLaboral) {
		this.historiaLaboral = historiaLaboral;
	}






	/**
	 * @return the usco
	 */
	public Usco getUsco() {
		return usco;
	}




	/**
	 * @param usco the usco to set
	 */
	public void setUsco(Usco usco) {
		this.usco = usco;
	}




	/**
	 * @return the docentePuntos
	 */
	public DocentePuntos getDocentePuntos() {
		return docentePuntos;
	}




	/**
	 * @param docentePuntos the docentePuntos to set
	 */
	public void setDocentePuntos(DocentePuntos docentePuntos) {
		this.docentePuntos = docentePuntos;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", identificacion=" + identificacion + ", tipoId=" + tipoId
				+ ", libretaMilitar=" + libretaMilitar + ", apellido=" + apellido + ", nombre=" + nombre
				+ ", apellido2=" + apellido2 + ", nombre2=" + nombre2 + ", genero=" + genero + ", lugarExpedicion="
				+ lugarExpedicion + ", fechaExpedicion=" + fechaExpedicion + ", fechaNacimiento=" + fechaNacimiento
				+ ", direccionResidencia=" + direccionResidencia + ", telefonoMovil=" + telefonoMovil
				+ ", telefonoFijo=" + telefonoFijo + ", estadoCivil=" + estadoCivil + ", lugarNacimiento="
				+ lugarNacimiento + ", lugarResidencia=" + lugarResidencia + ", barrio=" + barrio + ", estrato="
				+ estrato + ", eps=" + eps + ", etaCodigo=" + etaCodigo + ", numeroAfiliacionEps=" + numeroAfiliacionEps
				+ ", ipsSisben=" + ipsSisben + ", idCotizante=" + idCotizante + ", beneficiarioLey1081="
				+ beneficiarioLey1081 + ", familiarDireccion=" + familiarDireccion + ", familiarNombre="
				+ familiarNombre + ", familiarTelefono=" + familiarTelefono + ", familiarLugarResidencia="
				+ familiarLugarResidencia + ", email=" + email + ", emailInterno=" + emailInterno + ", enviarCorreo="
				+ enviarCorreo + ", paginaPersonal=" + paginaPersonal + ", grupoSanguineo=" + grupoSanguineo
				+ ", estado=" + estado + ", razonSocial=" + razonSocial + ", identificacionDup=" + identificacionDup
				+ ", cedula=" + cedula + ", tarjeta=" + tarjeta + ", codigoPostal=" + codigoPostal + ", pasaporte="
				+ pasaporte + ", huella=" + huella + ", fechaRegistro=" + fechaRegistro + ", codigoPaisHecaa="
				+ codigoPaisHecaa + ", fechaActualizacion=" + fechaActualizacion + ", docentePuntos=" + docentePuntos
				+ ", usco=" + usco + ", historiaAcademica=" + historiaAcademica + ", historiaLaboral=" + historiaLaboral
				+ "]";
	}

	
}

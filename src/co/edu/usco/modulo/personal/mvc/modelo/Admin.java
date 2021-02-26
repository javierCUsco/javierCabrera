/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;



/**
 * @author ING_JAVIER
 *
 */
public class Admin {

	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	private String clave2; 
	private int usuarioAdmin;
	private int usuariosys;
	private int isChange;
	private boolean estado;
	private int uid;
	private String us;
	private String clavereal;
	private String sys;
	private String ip;
	private int modulo;
	private Uaa uaa= new Uaa();
	private Url url=new Url();
	private Grupo grupo= new Grupo(); 
	private String metodo;
	
	
	/**
	 * 
	 */
	public Admin() {
	}

	/**
	 * @return the clave2
	 */
	public String getClave2() {
		return clave2;
	}
	/**
	 * @param clave2 the clave2 to set
	 */
	public void setClave2(String clave2) {
		this.clave2 = clave2;
	}
	/**
	 * @return the usuarioAdmin
	 */
	public int getUsuarioAdmin() {
		return usuarioAdmin;
	}
	/**
	 * @param usuarioAdmin the usuarioAdmin to set
	 */
	public void setUsuarioAdmin(int usuarioAdmin) {
		this.usuarioAdmin = usuarioAdmin;
	}
	/**
	 * @return the usuariosys
	 */
	public int getUsuariosys() {
		return usuariosys;
	}
	/**
	 * @param usuariosys the usuariosys to set
	 */
	public void setUsuariosys(int usuariosys) {
		this.usuariosys = usuariosys;
	}
	/**
	 * @return the isChange
	 */
	public int getIsChange() {
		return isChange;
	}
	/**
	 * @param isChange the isChange to set
	 */
	public void setIsChange(int isChange) {
		this.isChange = isChange;
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
	 * @return the clavereal
	 */
	public String getClavereal() {
		return clavereal;
	}
	/**
	 * @param clavereal the clavereal to set
	 */
	public void setClavereal(String clavereal) {
		this.clavereal = clavereal;
	}
	/**
	 * @return the sys
	 */
	public String getSys() {
		return sys;
	}
	/**
	 * @param sys the sys to set
	 */
	public void setSys(String sys) {
		this.sys = sys;
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
	 * @return the url
	 */
	public Url getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(Url url) {
		this.url = url;
	}
	/**
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}
	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the us
	 */
	public String getUs() {
		return us;
	}

	/**
	 * @param us the us to set
	 */
	public void setUs(String us) {
		this.us = us;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the modulo
	 */
	public int getModulo() {
		return modulo;
	}

	/**
	 * @param modulo the modulo to set
	 */
	public void setModulo(int modulo) {
		this.modulo = modulo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Admin [clave2=" + clave2 + ", usuarioAdmin=" + usuarioAdmin + ", usuariosys=" + usuariosys
				+ ", isChange=" + isChange + ", estado=" + estado + ", uid=" + uid + ", us=" + us
				+ ", clavereal=" + clavereal + ", sys=" + sys + ", ip=" + ip
				+ ", modulo=" + modulo + ", uaa=" + uaa + ", url=" + url + ", grupo=" + grupo + "]";
	}

	/**
	 * @return the metodo
	 */
	public String getMetodo() {
		return metodo;
	}

	/**
	 * @param metodo the metodo to set
	 */
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	
	
	
}

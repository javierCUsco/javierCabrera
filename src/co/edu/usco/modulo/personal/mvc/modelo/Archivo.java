/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.modelo;


/**
 * @author Maritza
 *
 */
public class Archivo {

	private String repositorio="";
	private String archivo="";//varchar](255) NULL,
	private String archivoMd5="";//varchar](255) NULL,
	private String contentType="";//varchar](255) NULL,
	private boolean cambio=false;
	
	
	
	/**
	 * 
	 */
	public Archivo() {
	}
	/**
	 * @param repositorio
	 * @param archivo
	 * @param archivoMd5
	 * @param contentType
	 * @param cambio
	 */
	public Archivo(String repositorio, String archivo, String archivoMd5, String contentType, boolean cambio) {
		this.repositorio = repositorio;
		this.archivo = archivo;
		this.archivoMd5 = archivoMd5;
		this.contentType = contentType;
		this.cambio = cambio;
	}
	/**
	 * @return the repositorio
	 */
	public String getRepositorio() {
		return repositorio;
	}
	/**
	 * @param repositorio the repositorio to set
	 */
	public void setRepositorio(String repositorio) {
		this.repositorio = repositorio;
	}
	/**
	 * @return the archivo
	 */
	public String getArchivo() {
		return archivo;
	}
	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	/**
	 * @return the archivoMd5
	 */
	public String getArchivoMd5() {
		return archivoMd5;
	}
	/**
	 * @param archivoMd5 the archivoMd5 to set
	 */
	public void setArchivoMd5(String archivoMd5) {
		this.archivoMd5 = archivoMd5;
	}
	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}
	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	/**
	 * @return the cambio
	 */
	public boolean isCambio() {
		return cambio;
	}
	/**
	 * @param cambio the cambio to set
	 */
	public void setCambio(boolean cambio) {
		this.cambio = cambio;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Archivo [repositorio=" + repositorio + ", archivo=" + archivo + ", archivoMd5=" + archivoMd5
				+ ", contentType=" + contentType + ", cambio=" + cambio + "]";
	}
	
	
	
	
	
}

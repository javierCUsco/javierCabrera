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
public class periodoOb implements Serializable{
	private int per_codigo;//] [int] IDENTITY(1,1) NOT NULL,
	private int per_codigoiter;//] [int] IDENTITY(1,1) NOT NULL,
	private int  pet_codigo;//] [int] NULL,
	private String per_nombre;//] [varchar](50) NULL,
	private String periodos_insc;
	private String periodosNo_insc;
	private int per_anno;//] [int] NULL,
	private int per_annointer;//] [int] NULL,
	private int per_periodo;//] [tinyint] NULL,
	private int per_periodo1;//] [tinyint] NULL,
	private String per_fecha_inicio;//] [datetime] NULL,
	private String per_fecha_fin;//] [datetime] NULL,
	
	
	public periodoOb(){
		
	}
	
	
	public periodoOb(int per_anno,int per_periodo){
		this.per_anno=per_anno;
		this.per_periodo=per_periodo;
	}

	
	public periodoOb(int per_codigo,int  pet_codigo,String per_nombre,int per_anno,int per_periodo,String per_fecha_inicio,String per_fecha_fin){
		this.per_codigo=per_codigo;
		this.per_codigoiter =per_codigo;
		this.pet_codigo=pet_codigo;
		this.per_nombre=per_nombre;
		this.per_anno=per_anno;
		this.per_periodo=per_periodo;
		this.per_fecha_inicio=per_fecha_inicio;
		this.per_fecha_fin= per_fecha_fin;
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
	 * @return the per_codigoiter
	 */
	public int getPer_codigoiter() {
		return per_codigoiter;
	}



	/**
	 * @param per_codigoiter the per_codigoiter to set
	 */
	public void setPer_codigoiter(int per_codigoiter) {
		this.per_codigoiter = per_codigoiter;
	}



	/**
	 * @return the per_anno
	 */
	public int getPer_anno() {
		return per_anno;
	}



	/**
	 * @param per_anno the per_anno to set
	 */
	public void setPer_anno(int per_anno) {
		this.per_anno = per_anno;
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
	 * @return the per_periodo
	 */
	public int getPer_periodo() {
		return per_periodo;
	}
	/**
	 * @param per_periodo the per_periodo to set
	 */
	public void setPer_periodo(int per_periodo) {
		this.per_periodo = per_periodo;
	}
	/**
	 * @return the per_fecha_inicio
	 */
	public String getPer_fecha_inicio() {
		return per_fecha_inicio;
	}
	/**
	 * @param per_fecha_inicio the per_fecha_inicio to set
	 */
	public void setPer_fecha_inicio(String per_fecha_inicio) {
		this.per_fecha_inicio = per_fecha_inicio;
	}
	/**
	 * @return the per_fecha_fin
	 */
	public String getPer_fecha_fin() {
		return per_fecha_fin;
	}
	/**
	 * @param per_fecha_fin the per_fecha_fin to set
	 */
	public void setPer_fecha_fin(String per_fecha_fin) {
		this.per_fecha_fin = per_fecha_fin;
	}



	/**
	 * @return the periodos_insc
	 */
	public String getPeriodos_insc() {
		return periodos_insc;
	}



	/**
	 * @param periodos_insc the periodos_insc to set
	 */
	public void setPeriodos_insc(String periodos_insc) {
		this.periodos_insc = periodos_insc;
	}



	/**
	 * @return the periodosNo_insc
	 */
	public String getPeriodosNo_insc() {
		return periodosNo_insc;
	}



	/**
	 * @param periodosNo_insc the periodosNo_insc to set
	 */
	public void setPeriodosNo_insc(String periodosNo_insc) {
		this.periodosNo_insc = periodosNo_insc;
	}



	/**
	 * @return the per_periodo1
	 */
	public int getPer_periodo1() {
		return per_periodo1;
	}



	/**
	 * @param per_periodo1 the per_periodo1 to set
	 */
	public void setPer_periodo1(int per_periodo1) {
		this.per_periodo1 = per_periodo1;
	}



	/**
	 * @return the per_annointer
	 */
	public int getPer_annointer() {
		return per_annointer;
	}



	/**
	 * @param per_annointer the per_annointer to set
	 */
	public void setPer_annointer(int per_annointer) {
		this.per_annointer = per_annointer;
	}
	
	
	
}

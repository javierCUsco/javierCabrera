/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.interfaceDB;

/**
 * @author ING_JAVIER Universidad surcolombiana
 * la interface conexion se implementara en todas las clases que se utilicen para la persistencia. Se agregaron los metodos 
 * mas comunes, los que generalmente se pueden utilizar en toda las clases. 
 * 
 *
 */
public interface ConexionDB {

	/**
	 * El metodo getAll se utiliza para realizar una consulta general de la una tabla 
	 * @return retorna una lista con todo el contenido de la tabla, recibe como parametro un objeto de tipo Object
	 * @param obj  
	 */
	public Object getAll(Object obj);
	
	/**
	 * El metodo getObject que se utiliza para realizar una consulta especifica de una tabla o tablas realcionadas. 
	 * @return retorna un objeto de tipo Object el cual contiene el resultado de una consulta especifica,
	 * @param obj recibe como parametro un objeto de tipo Object el cual contiene los datos para realizar la consulta.  
	 */
	public Object getObject(Object obj);
	
	/**
	 * El metodo insertObject es utilizado para insertar un registro a una tabla especifica, aunque esta implemetado en todas las clase
	 * en las que se hacen persistencia no entodos se utiliza ya que en este aplicativo solo se almacena en una tabla 
	 * @return retorna un objeto de tipo Object el cual contiene el resultado de la insertción.
	 * @param obj recibe como parametro un objeto de tipo Object  
	 */
	public Object setObject(Object obj);
	
	/**
	 * El metodo esObject es utilizado para hacer una consulta de un registro a una tabla especifica, aunque esta implemetado en todas las clase
	 * en las que se hacen persistencia no se utiliza en todas. 
	 * @return retorna un objeto de tipo boolean el cual indicara si el registro que se busca existe o no.
	 * @param obj recibe como parametro un objeto de tipo Object el cual contiene la información para realizar las consulta. 
	 */
	
	public boolean esObject(Object obj);
}

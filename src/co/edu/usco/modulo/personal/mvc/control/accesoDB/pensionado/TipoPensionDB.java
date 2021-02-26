/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.accesoDB.pensionado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.controlDB.Conexion;
import co.edu.usco.modulo.personal.mvc.control.interfaceDB.ConexionDB;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.pensionado.TipoPension;

/**
 * @author ING. JAVIER CABRERA LASSO
 *
 */
public class TipoPensionDB implements ConexionDB {
	Logger imp = Logger.getLogger(getClass().getName());

	/**
	 * 
	 */
	public static String  campos="tp.tip_pen_codigo, tp.tip_pen_nombre";
	public Object getAll(Object obj) {
		Connection conn = null;
		Statement sentencia=null;
		ResultSet resul=null;
		imp =Logger.getLogger(getClass().getName());
		 LinkedList<TipoPension> lista = new LinkedList<TipoPension>();
			Conexion consegura = new Conexion();
			StringBuffer sql = new StringBuffer();
			 try {
				 Usuario admin= (Usuario) obj;
			sql.append("select "+campos+" ");
			sql.append(" from tipo_pension tp  with(nolock) ");
			sql.append("");
			sql.append("");

			imp.info("consulta  1 " + sql.toString());
			conn = consegura.getconn_admin(admin);
			sentencia = conn.createStatement();
			resul = sentencia.executeQuery(sql.toString());
			while (resul.next()) {
				lista.add(new TipoPension(resul.getInt(1), resul.getString(2)));
			}
			resul.close();
			sentencia.close();

		} catch (SQLException e) {
			imp.error("error  en la conexion " + e + " " + sql.toString());
			consegura.cerrarconn(conn, resul, sentencia);
		}
		return lista;
	}

	@Override
	public Object getObject(Object obj) {
		return null;
	}

	@Override
	public Object setObject(Object obj) {
		return null;
	}

	@Override
	public boolean esObject(Object obj) {
		return false;
	}
}

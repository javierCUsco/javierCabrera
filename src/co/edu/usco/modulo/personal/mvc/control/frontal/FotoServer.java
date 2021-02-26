package co.edu.usco.modulo.personal.mvc.control.frontal;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import co.edu.usco.modulo.personal.mvc.control.herramientas.Session;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;

/**
 * Servlet implementation class FotoServer
 */
public class FotoServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//if (Session.esSession(request)) {
			Persona persona = null;
			if (request.getParameter("codigo") != null) {
				persona = new Persona();
				persona.setCodigo(Integer.parseInt(request.getParameter("codigo")));
			}

			if (persona == null) {
				response.sendError(401);
			} else {
				response.setContentType("image/png;image/jpg");
				try {
					CloseableHttpClient httpclient = HttpClients.createDefault();
					HttpGet get = new HttpGet(
							"https://gaitana.usco.edu.co/porteria_movil/Show?image=" + persona.getCodigo());
					get.setHeader("Authorization", "Basic MktqaDlDNGNzbV4/a1ZaQlM0JVM6SEh3UkZjNXU2Q21TMHdtP0c2Qns=");

					CloseableHttpResponse respo = httpclient.execute(get);
					try {
						HttpEntity entity = respo.getEntity();
						BufferedImage bi = ImageIO.read(entity.getContent());
						OutputStream out = response.getOutputStream();
						ImageIO.write(bi, "png", out);
						out.close();
						EntityUtils.consume(entity);
					} finally {
						respo.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
//		} else {
//			response.sendError(401);
//		}

	}
}

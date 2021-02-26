package co.edu.usco.modulo.personal.mvc.control.herramientas;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import co.edu.usco.modulo.personal.mvc.control.logica.WebParametroLog;
import co.edu.usco.modulo.personal.mvc.modelo.Mensaje;
import co.edu.usco.modulo.personal.mvc.modelo.Persona;
import co.edu.usco.modulo.personal.mvc.modelo.WebParametro;
import co.edu.usco.seguridad.Archivos;
import co.edu.usco.seguridad.Path;
import co.edu.usco.seguridad.seguridad;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
@WebServlet(value = "/multipartest", name = "multipartest") 
/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 50, // 50 MB
		maxRequestSize = 1024 * 1024 * 100)
//@WebServlet(name = "loadFile", urlPatterns = { "/upload" })
// @MultipartConfig
/**
 * Servlet implementation class loadFile
 */
public class LoadFile extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	private static Logger LOGGER = null;
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//
//		PrintWriter out = response.getWriter();
//		ObjectMapper objectMapper = new ObjectMapper();
//		response.setContentType("application/json");
//		String json ="";
//		if (Session.esSession(request)) {
//			json= objectMapper.writeValueAsString(processRequest( request));
//		}else{
//			Mensaje mensaje=new Mensaje(false, "se cerro la session debe loguearse", null,null);
//			json= objectMapper.writeValueAsString(mensaje);
//		}
//		out.print(json);
//
//	}
//	
//	// private Logger imp ;
//	/**
//	 * @param request
//	 * @return
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public Object processRequest(HttpServletRequest request) throws ServletException, IOException {
//		// response.setContentType("text/html;charset=UTF-8");
//		// Create path components to save the file
//		Persona persona= new Persona();
//		LOGGER = Logger.getLogger(getClass().getName());
//		// BaseDato basedato = new BaseDato();
//		LOGGER.info("1 en load filePart inicio ");
//		// final String path1 =
//		// basedato.getParametros("ADMIN","UPLOAD_DIRECTORY")
//		
//		Mensaje mensaje=new Mensaje();
//		mensaje=(Mensaje) setFile(request, persona);
//		return mensaje;
//	}
//
//	/***
//	 * metodo que verifica si ya hay un adjunto
//	 * 
//	 * @param request
//	 * @return
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public static boolean gethayadjunto(HttpServletRequest request)
//			throws ServletException, IOException {
//		boolean hay = false;
//		if (request.getContentType() != null && request.getContentType().contains("multipart/form-data")) {
//			for (Part part : request.getParts()) {
//				String dispositionHeader = part.getHeader("content-disposition");
//				if (dispositionHeader != null) {
//					Pattern fileNamePattern = Pattern.compile(".*filename=.*\"(.+)\".*",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
//					Matcher m = fileNamePattern.matcher(dispositionHeader);
////					System.out.println(" 5 "+m);
//					if (m.matches()) {
//						hay=true;
//					}
//					
//				}
//			}
//		}
//		return hay;
//	}
//
//	private static String getFileName1(final Part part) {
//		final String partHeader = part.getHeader("content-disposition");
//		
//		for (String content : part.getHeader("content-disposition").split(";")) {
//			if (content.trim().startsWith("filename")) {
//				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
//			}
//		}
//		return null;
//	}
//
//	public Object setFile(HttpServletRequest request, Persona persona) throws IOException, ServletException {
//		String fileName = null;
//		Mensaje mensaje =new Mensaje(); 
//		OutputStream out = null;
//		InputStream filecontent = null;
//		Part filePart = null;
////		System.out.println(" 1 ");
//		if (request.getContentType() != null && request.getContentType().contains("multipart/form-data")) {
////			System.out.println(" 2 ");
//			for (Part part : request.getParts()) {
////				System.out.print(" 3 ");
//				String dispositionHeader = part.getHeader("content-disposition");
////				System.out.println(" 4 "+dispositionHeader);
//				if (dispositionHeader != null) {
//					
//					Pattern fileNamePattern = Pattern.compile(".*filename=.*\"(.+)\".*",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
//					Matcher m = fileNamePattern.matcher(dispositionHeader);
////					System.out.println(" 5 "+m);
//					if (m.matches()) {
//						
//						fileName = m.group(1);
//						persona.getArchivo().setArchivo(fileName);
//						filePart = request.getPart(TipoContenido.string(fileName));
////						System.out.println(" 6 "+persona.getArchivo().getArchivo());
//					}
//					WebParametro webParametro= new WebParametro("UPLOAD_DIRECTORY");
//					webParametro = (WebParametro) WebParametroLog.getObject(webParametro);
//					persona.getArchivo().setRepositorio(webParametro.getValor());
//					persona.getArchivo().setContentType(part.getContentType());
////					System.out.println(" 7 ");
//					String nombre = persona.getArchivo().getArchivo().substring(0,persona.getArchivo().getArchivo().lastIndexOf("."));
//					
//					mensaje = (Mensaje) seguridad.getNombreArchivo(nombre, "Nombre del archivo");
////					System.out.println(" 8 ");
//					if (mensaje.isValido()) {
////						persona.getArchivo().setArchivo(nombre);
////						System.out.println(" 8.1 >> "+persona.getArchivo().getArchivo());
//						mensaje = (Mensaje) Archivos.archivoValido(persona);
////						System.out.println(" 8.2 >> "+String.valueOf(datos[1]));
////						System.out.println(" 9 ");
//						if (mensaje.isValido()) {
//							persona.getArchivo().setArchivo(persona.getArchivo().getArchivo().replaceAll("\\\\|/|\\||:|\\?|\\*|\"|<|>|\\p{Cntrl}", "_"));
//							String extension = persona.getArchivo().getArchivo().substring(persona.getArchivo().getArchivo().lastIndexOf("."));
////							System.out.println(" 10 "+extension);
//							try {
//								persona.getArchivo().setArchivoMd5(Base.MD5(persona.getArchivo().getArchivo() + Fecha.getFecha_servidor(null)));
//								persona.getArchivo().setArchivoMd5(persona.getArchivo().getArchivoMd5().toUpperCase());
//								out = new FileOutputStream(new File(Path.getDirectorio(persona, File.separator)+ File.separator + persona.getArchivo().getArchivoMd5()));
//								 filecontent = part.getInputStream();
//								 int read = 0;
//								 final byte[] bytes = new byte[1024];
//								 while ((read = filecontent.read(bytes)) != -1) {
//									 out.write(bytes, 0, read);
//								 }
//								 
//								 if (out != null) {
//										out.close();
//									}
//									 if (filecontent != null) {
//									 filecontent.close();
//									 }
//							}catch (FileNotFoundException fne) {
//								// TODO: handle exception
//								
//							} catch (NoSuchAlgorithmException e) {
//								LOGGER.info("Error al almacenar el archivo " + e.getMessage());
//								// e.printStackTrace();
//							} finally {
//								if (out != null) {
//									out.close();
//								}
//								 if (filecontent != null) {
//								 filecontent.close();
//								 }
//							}
//						}
//							
//
//					}
//				} else {
//					mensaje.setValido(false);	
//					mensaje.setMsm("");	
//				}
//
//			}
//
//		}else{
//			
//		}
////		System.out.print(" sale  "+persona.getArchivo().getArchivo());
//		mensaje.setResultado(persona);
//		LOGGER.info("sale  " + persona.getArchivo().getArchivo());
//		return mensaje;
//	}
}

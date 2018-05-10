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
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import co.edu.usco.modulo.personal.mvc.control.logica.Wep_parametroLog;
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

//@WebServlet(value = "/multipartest", name = "multipartest") 
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 50, // 50 MB
		maxRequestSize = 1024 * 1024 * 100)
@WebServlet(name = "loadFile", urlPatterns = { "/upload" })
// @MultipartConfig
/**
 * Servlet implementation class loadFile
 */
public class LoadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = null;

	// private Logger imp ;
	public Object processRequest(HttpServletRequest request, Persona persona) throws ServletException, IOException {
		// response.setContentType("text/html;charset=UTF-8");
		// Create path components to save the file
		LOGGER = Logger.getLogger(getClass().getName());
		// BaseDato basedato = new BaseDato();
		LOGGER.info("1 en load filePart inicio ");
		// final String path1 =
		// basedato.getParametros("ADMIN","UPLOAD_DIRECTORY")
		Object datos[] = { false, "error en al cargar el archivo. " };
Mensaje mensaje=new Mensaje();
		if (1 == 1) {
			mensaje=(Mensaje) setFile(request, persona);
//			LOGGER.info("1 en load filePart inicio " + (PersonaOb)mensaje.getResultado().getClass()Persona.getper_codigo());

			// final Part filePart = request.getPart(tipoContenido.string(dir));

			// final String fileName = getName(request,persona);
			// final Part filePart =
			// request.getPart(tipoContenido.string(fileName));
			// LOGGER.info("1 en load filePart "+fileName);
			//// persona.getArchivo(). setUrl_repositorio( path1);
			// Web_parametroOb paramtro=(Web_parametroOb)
			// Wep_parametroLog.getObject(null);
			// persona.getArchivo().setPh_archivo( paramtro.getWep_valor());
			// LOGGER.info("2 el nombre con la extencion fileName
			// "+fileName.toString());
			// OutputStream out = null;
			// InputStream filecontent = null;
			//// final PrintWriter writer = response.getWriter();
			// String tipo_contenido = filePart.getContentType();
			// LOGGER.info("3 el nombre con la extencion tipo_contenido
			// "+tipo_contenido);
			// persona.getArchivo().setPh_content_type(tipo_contenido);
			// LOGGER.info("4 el nombre con la extencion
			// "+persona.getArchivo().getPh_archivo());
			// String
			// nombre=persona.getArchivo().getPh_archivo().substring(0,persona.getArchivo().getPh_archivo().lastIndexOf("."));
			// LOGGER.info("5 el nombre "+nombre);
			//
			//
			// datos=(Object[]) seguridad.nombreArchivo(nombre, "Nombre del
			// archivo");
			//
			// try {
			//
			// if((boolean)datos[0]){
			// datos= (Object[]) Archivos.archivoValido(persona);
			// LOGGER.info("6 dato"+datos[0]);
			// if((boolean)datos[0]){
			// long tamanio = filePart.getSize();
			// LOGGER.info("7 dato"+datos[0]);
			// if((tamanio/1024)>4000){
			// LOGGER.info(" 8 el tamanio excede el tamaño "+(tamanio/1024));
			// persona.getArchivo().setPh_archivo("");
			// persona.getArchivo().setPh_archivo_md5("");
			// LOGGER.error( " 9 Problemas durante la carga del archivo. error
			// en el tamaño del archivo");
			// datos[0]=false;
			// datos[1]="tamaño del archivo invalido "+tamanio+"k no puede ser
			// superiora a 4000k";
			// }else{
			// LOGGER.info("10 dato"+datos[0]);
			// persona.getArchivo().setPh_archivo(persona.getArchivo().getPh_archivo().replaceAll("\\\\|/|\\||:|\\?|\\*|\"|<|>|\\p{Cntrl}","_"));
			// LOGGER.info("11 dato"+datos[0]);
			// String extension =
			// persona.getArchivo().getPh_archivo().substring(persona.getArchivo().getPh_archivo().lastIndexOf("."));
			// LOGGER.info("12 dato"+datos[0]);
			// persona.getArchivo().setPh_archivo_md5(
			// Base.MD5(persona.getArchivo().getPh_archivo()+Fecha.getFecha_servidor(null)));
			// LOGGER.info("13 dato"+datos[0]);
			// persona.getArchivo().setPh_archivo_md5(persona.getArchivo().getPh_archivo_md5().toUpperCase());
			//
			// LOGGER.info("el tamanio "+(tamanio/1024));
			//
			// out = new FileOutputStream(new
			// File(Path.getDirectorio(persona,File.separator) + File.separator+
			// persona.getArchivo().getPh_archivo_md5()));
			// LOGGER.info("14 dato"+datos[0]);
			// filecontent = filePart.getInputStream();
			// LOGGER.info("15 dato"+datos[0]);
			// int read = 0;
			// final byte[] bytes = new byte[1024];
			// LOGGER.info("16 dato"+datos[0]);
			// while ((read = filecontent.read(bytes)) != -1) {
			// LOGGER.info("17 dato"+datos[0]);
			// out.write(bytes, 0, read);
			// }
			// LOGGER.info("18 dato"+datos[0]);
			// LOGGER.info( "File{0}being uploaded to {1}");
			//
			// }
			// }else{
			// persona.getArchivo().setPh_archivo("");
			// persona.getArchivo().setPh_archivo_md5("");
			// LOGGER.error( "Problemas durante la carga del archivo. Error
			// nombre de archivo: tipoArchivo.archivoValido(persona)
			// {0}"+datos[0]+" "+datos[1]);
			// datos[0]=false;
			// datos[1]="Formato no valido, Recuerde que los formatos validos
			// son PDF o JPG. Intente de nuevo";
			// }
			// }else{
			// persona.getArchivo().setPh_archivo("");
			// persona.getArchivo().setPh_archivo_md5("");
			// LOGGER.error( "Problemas durante la carga del archivo. Error de
			// extencion: {0}"+datos[0]+" "+datos[1]);
			// datos[0]=false;
			// }
			// } catch (FileNotFoundException fne) {
			// datos[0]=false;
			// datos[1]="Error al cargar el archivo verifique el nombre y la
			// extencion";
			// LOGGER.error( "Problems during file upload. Error: {0}
			// "+fne.getMessage());
			// if (out != null) {
			// out.close();
			// }
			// if (filecontent != null) {
			// filecontent.close();
			// }
			// } catch (NoSuchAlgorithmException e) {
			// // TODO Auto-generated catch block
			// LOGGER.error( "Problems during file upload. Error: {0}
			// "+e.getMessage());
			// datos[0]=false;
			// datos[1]="Error al cargar el archivo verifique el nombre y la
			// extencion";
			// e.printStackTrace();
			// if (out != null) {
			// out.close();
			// }
			// if (filecontent != null) {
			// filecontent.close();
			// }
			// }
			// finally {
			// if (out != null) {
			// out.close();
			// }
			// if (filecontent != null) {
			// filecontent.close();
			// }
			//
			// }
		} else {
			datos[0] = false;
			datos[1] = "Error no adjunto el archivo...";
		}

//		Object[] resultado = { datos[0], datos[1], persona };
		return mensaje;
	}

	/***
	 * metodo que verifica si ya hay un adjunto
	 * 
	 * @param request
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public static boolean gethayadjunto(HttpServletRequest request)
			throws ServletException, IOException {
		boolean hay = false;
		if (request.getContentType() != null && request.getContentType().contains("multipart/form-data")) {
			for (Part part : request.getParts()) {
				String dispositionHeader = part.getHeader("content-disposition");
				if (dispositionHeader != null) {
					Pattern fileNamePattern = Pattern.compile(".*filename=.*\"(.+)\".*",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
					Matcher m = fileNamePattern.matcher(dispositionHeader);
//					System.out.println(" 5 "+m);
					if (m.matches()) {
						hay=true;
					}
					
				}
			}
		}
		return hay;
	}

	private static String getFileName1(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	public Object setFile(HttpServletRequest request, Persona persona) throws IOException, ServletException {
		String fileName = null;
		Object datos[] = { false, "error en al cargar el archivo. " };
		Mensaje mensaje =new Mensaje(); 
		OutputStream out = null;
		InputStream filecontent = null;
		Part filePart = null;
//		System.out.println(" 1 ");
		if (request.getContentType() != null && request.getContentType().contains("multipart/form-data")) {
//			System.out.println(" 2 ");
			for (Part part : request.getParts()) {
//				System.out.print(" 3 ");
				String dispositionHeader = part.getHeader("content-disposition");
//				System.out.println(" 4 "+dispositionHeader);
				if (dispositionHeader != null) {
					
					Pattern fileNamePattern = Pattern.compile(".*filename=.*\"(.+)\".*",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
					Matcher m = fileNamePattern.matcher(dispositionHeader);
//					System.out.println(" 5 "+m);
					if (m.matches()) {
						
						fileName = m.group(1);
						persona.getArchivo().setPh_archivo(fileName);
						filePart = request.getPart(TipoContenido.string(fileName));
//						System.out.println(" 6 "+persona.getArchivo().getPh_archivo());
					}
					WebParametro paramtro = (WebParametro) Wep_parametroLog.getObject(null);
					persona.getArchivo().setUrl_repositorio(paramtro.getWep_valor());
					persona.getArchivo().setPh_content_type(part.getContentType());
//					System.out.println(" 7 ");
					String nombre = persona.getArchivo().getPh_archivo().substring(0,persona.getArchivo().getPh_archivo().lastIndexOf("."));
					
					datos = (Object[]) seguridad.nombreArchivo(nombre, "Nombre del archivo");
//					System.out.println(" 8 ");
					if ((boolean) datos[0]) {
//						persona.getArchivo().setPh_archivo(nombre);
//						System.out.println(" 8.1 >> "+persona.getArchivo().getPh_archivo());
						datos = (Object[]) Archivos.archivoValido(persona);
//						System.out.println(" 8.2 >> "+String.valueOf(datos[1]));
//						System.out.println(" 9 ");
						if ((boolean) datos[0]) {
							persona.getArchivo().setPh_archivo(persona.getArchivo().getPh_archivo().replaceAll("\\\\|/|\\||:|\\?|\\*|\"|<|>|\\p{Cntrl}", "_"));
							String extension = persona.getArchivo().getPh_archivo().substring(persona.getArchivo().getPh_archivo().lastIndexOf("."));
//							System.out.println(" 10 "+extension);
							try {
								persona.getArchivo().setPh_archivo_md5(Base.MD5(persona.getArchivo().getPh_archivo() + Fecha.getFecha_servidor(null)));
								persona.getArchivo().setPh_archivo_md5(persona.getArchivo().getPh_archivo_md5().toUpperCase());
								out = new FileOutputStream(new File(Path.getDirectorio(persona, File.separator)+ File.separator + persona.getArchivo().getPh_archivo_md5()));
								 filecontent = part.getInputStream();
								 int read = 0;
								 final byte[] bytes = new byte[1024];
								 while ((read = filecontent.read(bytes)) != -1) {
									 out.write(bytes, 0, read);
								 }
								 
								 if (out != null) {
										out.close();
									}
									 if (filecontent != null) {
									 filecontent.close();
									 }
							}catch (FileNotFoundException fne) {
								// TODO: handle exception
								
							} catch (NoSuchAlgorithmException e) {
								LOGGER.info("Error al almacenar el archivo " + e.getMessage());
								// e.printStackTrace();
							} finally {
								if (out != null) {
									out.close();
								}
								 if (filecontent != null) {
								 filecontent.close();
								 }
							}
						}else{
							mensaje.setValido((boolean) (datos[0]));	
							mensaje.setMsm(String.valueOf(datos[1]));	
						}
							

					}else{
						mensaje.setValido((boolean) (datos[0]));	
						mensaje.setMsm(String.valueOf(datos[1]));	
					}

				} else {
					mensaje.setValido((boolean) (datos[0]));	
					mensaje.setMsm(String.valueOf(datos[1]));	
				}

			}

		}else{
			
		}
//		System.out.print(" sale  "+persona.getArchivo().getPh_archivo());
		mensaje.setResultado(persona);
		LOGGER.info("sale  " + persona.getArchivo().getPh_archivo());
		return mensaje;
	}
}

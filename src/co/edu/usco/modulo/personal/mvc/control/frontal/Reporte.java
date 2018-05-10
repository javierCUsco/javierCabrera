package co.edu.usco.modulo.personal.mvc.control.frontal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.usco.modulo.personal.mvc.control.herramientas.CabeceraReporte;
import co.edu.usco.modulo.personal.mvc.control.herramientas.CeldaPdf;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.logica.FechaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.Wep_parametroLog;
import co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa.CarreraAdministrativaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.carreraAdministrativa.CarreraAdministrativaAtualizacionLog;
import co.edu.usco.modulo.personal.mvc.modelo.WebParametro;
import co.edu.usco.modulo.personal.mvc.modelo.Usuario;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativa;
import co.edu.usco.modulo.personal.mvc.modelo.carreraAdministrativa.CarreraAdministrativaActualizacion;

/**
 * Servlet implementation class Reporte
 */
@WebServlet("/Reporte")
public class Reporte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Logger imp =Logger.getLogger(getClass().getName());
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename="+"CarreraAdministrativa"+"");
		ByteArrayOutputStream baos = null;
//		Document document = new Document(PageSize.LETTER,36,36,100,70);
		Document document = new Document(PageSize.LEGAL.rotate(),  85, 65,36, 36);	
		baos = new ByteArrayOutputStream();
		 imp.info(" inicia" );
		Usuario usuadmin = (Usuario) request.getSession().getAttribute("usuario");
		 CarreraAdministrativa carrera_administrativa = new CarreraAdministrativa();
		
		if (request.getParameter("per_codigo") != null) {
			carrera_administrativa.getPersona().setPer_codigo(Integer.parseInt(request.getParameter("per_codigo")));
		}
		Object param[] = { carrera_administrativa, usuadmin };
		carrera_administrativa= (CarreraAdministrativa) CarreraAdministrativaLog.getObject(param);
		String fecha=String.valueOf(FechaLog.getFechaServidor());
		WebParametro parametro = new WebParametro("CARRERA_ADMINISTRATIVA_NOMBRE_JEFE");
		parametro= (WebParametro) Wep_parametroLog.getObject(parametro);
		try {
			PdfWriter writer = PdfWriter.getInstance(document, baos);
			CabeceraReporte cabeceraReporte= new CabeceraReporte();
			cabeceraReporte.setEncabezado(getServletContext().getRealPath("assets/img/usco.png"));
			cabeceraReporte.setFecha(fecha);
			cabeceraReporte.setFondo(getServletContext().getRealPath("assets/img/usco1.png"));
			cabeceraReporte.setPie(getServletContext().getRealPath("assets/img/direccion.jpg"));
			cabeceraReporte.setUsuario(usuadmin.getPersona().getPer_nombre()+" "+usuadmin.getPersona().getPer_apellido());
			cabeceraReporte.setPosX(PageSize.LEGAL.getHeight() );
			cabeceraReporte.setPosY(PageSize.LEGAL.getWidth());
			 imp.info(" crea la cabecera" );
			writer.setPageEvent(cabeceraReporte);
			document.open();
			 imp.info(" abre el documento" );
			Paragraph parrafo = new Paragraph(  "LA SUSCRITA COORDINADORA DE LA COMISION UNIVERSITARIA DE CARRERA ESPECIAL ADMINISTRATIVA DE LA UNIVERSIDAD SURCOLOMBIANA \n",FontFactory.getFont("TIMES_ROMAN", 13, Font.BOLD,BaseColor.BLACK));
			parrafo.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(parrafo);
			CarreraAdministrativaActualizacion carrera_administrativa_actualizacion= new CarreraAdministrativaActualizacion();
			carrera_administrativa_actualizacion.setCaa(carrera_administrativa);
			param[0] =carrera_administrativa_actualizacion;
			LinkedList<CarreraAdministrativaActualizacion> lista=(LinkedList<CarreraAdministrativaActualizacion>) CarreraAdministrativaAtualizacionLog.getLista(param);
			parrafo = new Paragraph("certifica".toUpperCase(),FontFactory.getFont("arial", 12, Font.BOLD,BaseColor.BLACK));
			
			parrafo.setAlignment(Paragraph.ALIGN_CENTER);
			parrafo.setSpacingAfter(15);
			parrafo.setSpacingBefore(15);
			document.add(parrafo);
			StringBuffer text=new StringBuffer();
			text.append("Que el(la) empleado(a) publico(a) "+carrera_administrativa.getPersona().getPer_nombre() +""+carrera_administrativa.getPersona().getPer_apellido()+" Identificado(a) con cedula de ciudadania N."+carrera_administrativa.getPersona().getPer_identificacion()+", expedido en "+carrera_administrativa.getPersona().getPer_lugar_expedicion().getMun_nombre() +" ( "+carrera_administrativa.getPersona().getPer_lugar_expedicion().getDepartamento().getDep_nombre() +" ) ");
			text.append("se encuentra inscrito(a) en el Registro de Carrera Especial Administrativo, desde "+carrera_administrativa.getCaa_fecha_acta_posesion()+", en el cargo que acontinuacion se menciona:"+"");
			parrafo = new Paragraph(text.toString(),FontFactory.getFont("arial", 10, Font.NORMAL,BaseColor.BLACK));
			parrafo.setAlignment(Element.ALIGN_LEFT);
			parrafo.setSpacingAfter(15);
			parrafo.setSpacingBefore(15);
			document.add(parrafo);
			String titulos[]={"Cargo","Código","Grado", "Unidad A A. del cargo","Acto administrativo","No. acto", "Fecha Acto","Observaciones"};
			PdfPTable table=null;
 			table=new PdfPTable(titulos.length);
 			table.setWidthPercentage(280 / 2.51f);
			float[] medidaCeldas = { 2.50F,2.50f,2.50f, 3.80f,2.0f, 3.50f, 2.0f, 3.50f};
			table.setWidths(medidaCeldas);
 			 
 			for(int i=0;i<titulos.length; i++){
 				table.addCell( CeldaPdf.getCelda(titulos[i], "arial", 10, 3.f, 1, 1, 0, 0, 0, 0, 1));
 			}
 			 
 			table.addCell(CeldaPdf.getCelda(carrera_administrativa.getUaa_cargo().getCargo().getCar_nombre(), "arial", 7, 0f, 2, 1, 1,0f,0,0));
 			table.addCell(CeldaPdf.getCelda(String.valueOf(carrera_administrativa.getUaa_cargo().getUac_codigoplanta()), "arial",  7, 0f, 2, 1, 1,0f,0,0));
 			table.addCell(CeldaPdf.getCelda(String.valueOf(carrera_administrativa.getUaa_cargo().getUac_grado()), "arial", 7, 0f, 2, 1, 1,0f,0,0));
 			table.addCell(CeldaPdf.getCelda(carrera_administrativa.getUaa_cargo().getUaa().getUaa_nombre(), "arial", 7, 0f, 2, 1, 1,0f,0,0));
 			table.addCell(CeldaPdf.getCelda(carrera_administrativa.getCaa_acto_adtivo(), "arial", 7, 0f, 2, 1, 1,0f,0,0));
// 			table.addCell(CeldaPdf.getCelda(carrera_administrativa.getCaa_fecha_resolucion_elegibles(), "arial", 7, 0f, 2, 1, 1,0f,0,0));
// 			table.addCell(CeldaPdf.getCelda(carrera_administrativa.getCaa_fecha_acto_adtivo(), "arial", 7, 0f, 2, 1, 1,0f,0,0));
 			table.addCell(CeldaPdf.getCelda(carrera_administrativa.getCaa_observacion(), "arial", 7, 0, 1, 1, 0, 0, 0, 0));
 			document.add(table);
 			
 			
 			text=new StringBuffer();
 			text.append("Con actualización en el registro desde "+carrera_administrativa.getCaa_fecha_acta_posesion()+", en el cargo que acontinuacion se relaciona: ");
 			parrafo = new Paragraph(text.toString(),FontFactory.getFont("arial", 10, Font.NORMAL,BaseColor.BLACK));
			parrafo.setAlignment(Element.ALIGN_LEFT);
			parrafo.setSpacingAfter(15);
			parrafo.setSpacingBefore(15);
			document.add(parrafo);
 			
			table=new PdfPTable(titulos.length);
			table.setWidthPercentage(280 / 2.51f);
			float[] medidaCeldas1 = { 2.50F,2.50f,2.50f, 3.80f,2.0f, 3.50f, 2.0f, 3.50f};
			table.setWidths(medidaCeldas1);
 			 
 			for(int i=0;i<titulos.length; i++){
 				table.addCell(CeldaPdf.getCelda(titulos[i], "arial", 10, 0, 1, 1, 0, 0, 0, 0));
 			}
 			for(int i=0;i<lista.size(); i++){
 				table.addCell(CeldaPdf.getCelda(lista.get(i).getUaa_cargo().getCargo().getCar_nombre(), "arial", 7, 0, 1, 1, 0, 0, 0, 0));
 				table.addCell(CeldaPdf.getCelda(lista.get(i).getUaa_cargo().getUac_codigoplanta(), "arial", 7, 0, 1, 1, 0, 0, 0, 0));
 				table.addCell(CeldaPdf.getCelda(String.valueOf(lista.get(i).getUaa_cargo().getUac_grado()), "arial", 7, 0, 1, 1, 0, 0, 0, 0));
 				table.addCell(CeldaPdf.getCelda(lista.get(i).getUaa_cargo().getUaa().getUaa_nombre(), "arial", 7, 0, 1, 1, 0, 0, 0, 0));
 				table.addCell(CeldaPdf.getCelda(lista.get(i).getCaaa_acto_administrativo(), "arial", 7, 0, 1, 1, 0, 0, 0, 0));
 				table.addCell(CeldaPdf.getCelda(String.valueOf(lista.get(i).getCaaa_codigo()), "arial", 7, 0, 1, 1, 0, 0, 0, 0));
// 				table.addCell(CeldaPdf.getCelda(lista.get(i).getCaaa_fecha_acto_administrativo(), "arial", 7, 0, 1, 1, 0, 0, 0, 0));
 				table.addCell(CeldaPdf.getCelda(lista.get(i).getCaaa_observacion(), "arial", 7, 0, 1, 1, 0, 0, 0, 0));
 			}
 			document.add(table);
 			text=new StringBuffer();
 			text.append("La presente certificacion se espide a solicitud el interesado(a) "+FechaLog.getFechaServidorLetras(fecha)+" ");
 			text.append("La ultima anotacion que se certifica, corresponde a la información mas reciente reportada a esta Comisión. ");
 			text.append("La información consignada puede se objeto de verificación. ");
 			text.append("\n\n ");
 			text.append("Cordialmente ");
 			text.append("\n\n\n ");
 			text.append(""+parametro.getWep_valor()+"\n ");
 			text.append("Coordinadora\n ");
 			text.append("Comisión Universitaria de Carrera Administrativa");
 			parrafo = new Paragraph(text.toString(),FontFactory.getFont("arial", 10, Font.NORMAL,BaseColor.BLACK));
			parrafo.setAlignment(Element.ALIGN_LEFT);
			parrafo.setSpacingAfter(15);
			parrafo.setSpacingBefore(15);
			document.add(parrafo);
			 document.close();
			 imp.info(" cierra el documento" );
	            // setting some response headers
	            response.setHeader("Expires", "0");
	            response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
	            response.setHeader("Pragma", "public");
	            // setting the content type
	            response.setContentType("application/pdf");
	            // the contentlength
	            response.setContentLength(baos.size());
	            // write ByteArrayOutputStream to the ServletOutputStream
	            OutputStream os = response.getOutputStream();
	            baos.writeTo(os);
	            os.flush();
	            os.close(); 
	            imp.info(" termina" );

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			 imp.error(" inicia"+ e.getStackTrace()+" "+e.fillInStackTrace()+""+e.getLocalizedMessage());
			e.printStackTrace();
		}
		
	}
}

package co.edu.usco.modulo.personal.mvc.control.frontal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.usco.modulo.personal.mvc.control.herramientas.CabeceraReporte;
import co.edu.usco.modulo.personal.mvc.control.herramientas.CeldaPdf;
import co.edu.usco.modulo.personal.mvc.control.herramientas.Fecha;
import co.edu.usco.modulo.personal.mvc.control.logica.FechaLog;
import co.edu.usco.modulo.personal.mvc.control.logica.WebParametroLog;
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
		if(request.getParameter("param")!=null) {
			response.setContentType("application/json");
			}else {
				response.setContentType("text/html");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("param")!=null) {
			response.setContentType("application/json");
			}else {
				response.setContentType("text/html");
			}
		processRequest(request, response);
	}

	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Logger imp =Logger.getLogger(getClass().getName());
		
		if(request.getParameter("per_codigo")!=null) {
			response.setContentType("application/pdf");
			}else {
				response.setContentType("text/html");
			}
		response.addHeader("Content-Disposition", "attachment; filename="+"CarreraAdministrativa"+".pdf");
		ByteArrayOutputStream baos = null;
//		Document document = new Document(PageSize.LETTER,36,36,100,70);
		Document document = new Document(PageSize.LETTER.rotate(),  35, 35,90, 30);	
		baos = new ByteArrayOutputStream();
		 imp.info(" inicia" );
		Usuario usuadmin = (Usuario) request.getSession().getAttribute("usuario");
		 CarreraAdministrativa carrera_administrativa = new CarreraAdministrativa();
		
		if (request.getParameter("per_codigo") != null) {
			carrera_administrativa.getPersona().setCodigo(Integer.parseInt(request.getParameter("per_codigo")));
		}
		Object param[] = { carrera_administrativa, usuadmin };
		carrera_administrativa= (CarreraAdministrativa) CarreraAdministrativaLog.getObject(param);
		String fecha=String.valueOf(FechaLog.getFechaServidor());
		WebParametro parametro = new WebParametro("CARRERA_ADMINISTRATIVA_NOMBRE_JEFE");
		parametro= (WebParametro) WebParametroLog.getObject(parametro);
		try {
			PdfWriter writer = PdfWriter.getInstance(document, baos);
			CabeceraReporte cabeceraReporte= new CabeceraReporte();
			cabeceraReporte.setEncabezado(getServletContext().getRealPath("assets/img/usco.png"));
			cabeceraReporte.setFecha(fecha);
			cabeceraReporte.setCodigo(getCodigo(carrera_administrativa.getCodigo(),carrera_administrativa.getFechaActoAdtivo()));
			cabeceraReporte.setFondo(getServletContext().getRealPath("assets/img/usco1.png"));
			cabeceraReporte.setPie(getServletContext().getRealPath("assets/img/direccion.jpg"));
//			cabeceraReporte.setPie2(getServletContext().getRealPath("assets/img/pie.jpg"));
			String nombre=usuadmin.getPersona().getNombre().substring(0,1).toUpperCase().concat(usuadmin.getPersona().getNombre().substring(1, usuadmin.getPersona().getNombre().length()).toLowerCase())+" "+usuadmin.getPersona().getApellido().substring(0,1).toUpperCase().concat(usuadmin.getPersona().getApellido().substring(1, usuadmin.getPersona().getApellido().length()).toLowerCase());
			cabeceraReporte.setUsuario(nombre);
			cabeceraReporte.setPosX(PageSize.LETTER.getHeight() );
			cabeceraReporte.setPosY(PageSize.LETTER.getWidth());
			BaseFont bf = BaseFont.createFont(getServletContext().getRealPath("assets/fonts/PALSCRI.ttf"), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	        Font font = new Font(bf, 12,2) {
			};
	        cabeceraReporte.setFont(font);
			 imp.info(" crea la cabecera" );
			writer.setPageEvent(cabeceraReporte);
			document.open();
			 imp.info(" abre el documento" );
			Paragraph parrafo = new Paragraph("\n\nEL(LA) SUSCRITO(A) SECRETARIO(A) TÉCNICO(A) DE LA COMISIÓN UNIVERSITARIA DE CARRERA ADMINISTRATIVA ESPECIAL \n",FontFactory.getFont("arial", 11, Font.BOLD,BaseColor.BLACK));
//			Paragraph parrafo = new Paragraph(  "LA SUSCRITA COORDINADORA DE LA COMISION UNIVERSITARIA DE CARRERA ESPECIAL ADMINISTRATIVA DE LA UNIVERSIDAD SURCOLOMBIANA \n",FontFactory.getFont("TIMES_ROMAN", 13, Font.BOLD,BaseColor.BLACK));
			parrafo.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(parrafo);
			CarreraAdministrativaActualizacion carrera_administrativa_actualizacion= new CarreraAdministrativaActualizacion();
			carrera_administrativa_actualizacion.setCaa(carrera_administrativa);
			param[0] =carrera_administrativa_actualizacion;
			LinkedList<CarreraAdministrativaActualizacion> lista=(LinkedList<CarreraAdministrativaActualizacion>) CarreraAdministrativaAtualizacionLog.getLista(param);
			parrafo = new Paragraph("certifica".toUpperCase(),FontFactory.getFont("arial", 11, Font.BOLD,BaseColor.BLACK));
			
			parrafo.setAlignment(Paragraph.ALIGN_CENTER);
			parrafo.setSpacingAfter(15);
			parrafo.setSpacingBefore(15);
			document.add(parrafo);
			StringBuffer text=new StringBuffer();
//			text.append("Que el(la) empleado(a) publico(a) "+carrera_administrativa.getPersona().getNombre() +" "+carrera_administrativa.getPersona().getApellido()+" Identificado(a) con cedula de ciudadanía No."+carrera_administrativa.getPersona().getPer_identificacion()+", expedido en "+carrera_administrativa.getPersona().getPer_lugar_expedicion().getMun_nombre() +" ( "+carrera_administrativa.getPersona().getPer_lugar_expedicion().getDepartamento().getDep_nombre() +" ) ");
			text.append("Que el(la) empleado(a) público(a) "+carrera_administrativa.getPersona().getNombre() +" "+carrera_administrativa.getPersona().getApellido()+" Identificado(a) con cedula de ciudadanía No."+carrera_administrativa.getPersona().getIdentificacion()+", ");
//			text.append("se encuentra inscrito(a) en el Registro Público de Carrera Administrativa Especial, desde "+FechaLog.getFechaServidorLetras(carrera_administrativa.getCaa_fecha_acta_posesion().toString())+", en el cargo que a continuación se menciona:"+"");
			text.append("se encuentra inscrito(a) en el Registro Público de Carrera Administrativa Especial,  en el cargo que a continuación se menciona:"+"");
			parrafo = new Paragraph(text.toString(),FontFactory.getFont("arial", 10, Font.NORMAL,BaseColor.BLACK));
			parrafo.setAlignment(Element.ALIGN_LEFT);
			parrafo.setSpacingAfter(15);
			parrafo.setSpacingBefore(15);
			document.add(parrafo);
			String titulos[]={"Cargo","Código","Grado", "Unidad A A. del cargo","Acto Administrativo","No. Acto", "Fecha Acto"};
			PdfPTable table=null;
 			table=new PdfPTable(titulos.length);
 			table.setWidthPercentage(250 / 2.51f);
			float[] medidaCeldas = {  5.50f,1.20F, 1.0f, 7.50f, 3.0f, 1.30f, 1.50f};
			table.setWidths(medidaCeldas);
 			 
 			for(int i=0;i<titulos.length; i++){
 				table.addCell( CeldaPdf.getCelda(titulos[i], "arial", 8, 3.f, 1, 1, 0, 0, 0, 0, 1));
 			}
 			 
 			table.addCell(CeldaPdf.getCelda(carrera_administrativa.getUaaCargo().getCargo().getNombre(), "arial", 7, 0f, 0, 3, 0,0f,0,0));
 			table.addCell(CeldaPdf.getCelda(String.valueOf(carrera_administrativa.getUaaCargo().getCargo().getId()), "arial",  7, 0f, 0, 1, 0,0f,0,0));
 			table.addCell(CeldaPdf.getCelda(String.valueOf(carrera_administrativa.getUaaCargo().getGrado()), "arial", 7, 0f, 0, 1, 0,0f,0,0));
 			table.addCell(CeldaPdf.getCelda(carrera_administrativa.getUaaCargo().getUaa().getNombre(), "arial", 7, 1.5f, 0, 3, 0,0f,0,0));
 			table.addCell(CeldaPdf.getCelda(carrera_administrativa.getActoAdtivo(), "arial", 7, 0f, 0, 3, 0,0f,0,0));
 			table.addCell(CeldaPdf.getCelda(String.valueOf(carrera_administrativa.getCodigo()), "arial", 7, 0f, 0, 1, 0,0f,0,0));
 			table.addCell(CeldaPdf.getCelda(String.valueOf(carrera_administrativa.getFechaActoAdtivo()), "arial", 7, 0f, 0, 1, 0,0f,0,0));
// 			table.addCell(CeldaPdf.getCelda(carrera_administrativa.getCaa_observacion(), "arial", 8, 0, 0, 1, 1, 0, 0, 0));
 			document.add(table);
 			
 			if(lista!=null && lista.size()>0){
 			
	 			text=new StringBuffer();
//	 			text.append("Con actualización en el registro desde "+FechaLog.getFechaServidorLetras(lista.get(0).getCaaa_fecha_acto_administrativo().toString())+", en el cargo que a continuación se relaciona: ");
	 			text.append("Con actualización en el registro en el cargo que a continuación se relaciona: ");
	 			parrafo = new Paragraph(text.toString(),FontFactory.getFont("arial", 9, Font.NORMAL,BaseColor.BLACK));
				parrafo.setAlignment(Element.ALIGN_LEFT);
				parrafo.setSpacingAfter(15);
				parrafo.setSpacingBefore(15);
				document.add(parrafo);
	 			
				table=new PdfPTable(titulos.length);
				table.setWidthPercentage(250 / 2.51f);
				float[] medidaCeldas1 = {  5.50f,1.20F, 1.0f, 7.50f, 3.0f, 1.30f, 1.50f};
				table.setWidths(medidaCeldas1);
	 			 
	 			for(int i=0;i<titulos.length; i++){
	 				table.addCell( CeldaPdf.getCelda(titulos[i], "arial", 8, 3.f, 1, 1, 0, 0, 0, 0, 1));
	 			}
	 			for(int i=0;i<lista.size(); i++){
	 				table.addCell(CeldaPdf.getCelda(lista.get(i).getUaaCargo().getCargo().getNombre(), "arial",  7, 0f, 0, 3, 0,0f,0,0));
	 				table.addCell(CeldaPdf.getCelda(lista.get(i).getUaaCargo().getCodigoPlanta(), "arial",  7, 0f, 0, 1, 0,0f,0,0));
	 				table.addCell(CeldaPdf.getCelda(String.valueOf(lista.get(i).getUaaCargo().getGrado()), "arial",  7, 0f, 0, 1, 0,0f,0,0));
	 				table.addCell(CeldaPdf.getCelda(lista.get(i).getUaaCargo().getUaa().getNombre(), "arial",  7, 0f, 0, 3, 0,0f,0,0));
	 				table.addCell(CeldaPdf.getCelda(lista.get(i).getActoAdministrativo(),"arial",  7, 0f, 0, 3, 0,0f,0,0));
	 				table.addCell(CeldaPdf.getCelda(String.valueOf(lista.get(i).getCodigo()), "arial",  7, 0f, 0, 1, 0,0f,0,0));
	 				table.addCell(CeldaPdf.getCelda(String.valueOf(lista.get(i).getFechaActoAdministrativo()), "arial",  7, 0f, 0, 1, 0,0f,0,0));
	// 				table.addCell(CeldaPdf.getCelda(lista.get(i).getCaaa_observacion(), "arial",  9, 0f, 0, 1, 1,0f,0,0));
	 			}
	 			document.add(table);
 			}
 			text=new StringBuffer();
 			text.append("La presente certificación se expide a solicitud del interesado(a) "+FechaLog.getFechaServidorLetras(fecha)+". ");
 			text.append("La ultima anotación que se certifica, corresponde a la información más reciente reportada a esta Comisión. ");
 			text.append("La información consignada puede ser objetó de verificación. ");
 			text.append("\n\n ");
 			text.append("Cordialmente, ");
 			text.append("\n\n\n ");
 			text.append(""+parametro.getValor()+"\n ");
 			text.append("Secretario(a) Técnico(a)\n ");
 			text.append("Comisión Universitaria de Carrera Administrativa Especial");
 			parrafo = new Paragraph(text.toString(),FontFactory.getFont("arial", 9, Font.NORMAL,BaseColor.BLACK));
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

	private String getCodigo(int codigo, Date date) {
		String valor =String.valueOf(codigo);
		String fecha=(String) Fecha.getFecha_format(date);
		fecha=fecha.replaceAll("/", "");
		fecha=(fecha+valor);
		return fecha;
	}
	
	
	
	
}

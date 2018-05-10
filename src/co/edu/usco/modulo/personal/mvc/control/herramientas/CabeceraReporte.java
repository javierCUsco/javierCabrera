/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.herramientas;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class CabeceraReporte extends PdfPageEventHelper{

	private String encabezado;
	private String fondo;
	private float posX;
	private float posY;
	private String pie;
	PdfTemplate total;
	private String usuario;
	private String fecha;
	
	/**
     * Crea el objecto PdfTemplate el cual contiene el numero total de
     * paginas en el documento
     */
    public void onOpenDocument(PdfWriter writer, Document document) {
    	
        total = writer.getDirectContent().createTemplate(30, 16);
       
    }
	
    /**
     * Esta es el metodo a llamar cuando ocurra el evento <b>onEndPage</b>, es en este evento
     * donde crearemos el encabeazado y el pie de la pagina ademas agregamos la imagen fondo de agua a la pagiba con los elementos indicados e.
     */
    public void onEndPage(PdfWriter writer, Document document) {
        PdfPTable table = new PdfPTable(1);
        try {
            table.setTotalWidth(527);
            table.getDefaultCell().setBorder(0);
            Image img1;
           	img1 = Image.getInstance(this.encabezado);
           	//aca
           	img1.setAbsolutePosition((this.posX- img1.getScaledWidth()) / 2,(this.posY- (img1.getScaledHeight())) / 2);
			table.addCell(img1);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
           // tabletemp.addCell(String.format("Pagina %01d de ", writer.getPageNumber())+Image.getInstance(total));
         
            PdfPTable tabletemp = new PdfPTable(3);
            tabletemp.setWidths(new int[]{24, 24, 2});
            tabletemp.setTotalWidth(527);
            tabletemp.addCell(CeldaPdf.getCelda("", "HELVETICA", 8,1.0f, 0,0,0,0f,0,0));
           
            tabletemp.addCell(CeldaPdf.getCelda(String.format("Pagina %01d de ", writer.getPageNumber()), "HELVETICA", 8,1.0f, 0,2,0,0f,0,0));
//            System.out.println("total    pagina     "+String.format(" "+writer.getPageSize()));
            Image imgtotal=Image.getInstance(total) ;
            imgtotal.scaleAbsoluteHeight(10f);
            PdfPCell cell = new PdfPCell(imgtotal);
            cell.setBorder(0);
            tabletemp.addCell(cell);
           
     
            //tabletemp.addCell(celdaPdf.getCelda(this.certificado, "HELVETICA", 8,1.0f, 0,0,0,0f));
            // Esta linea escribe la tabla como encabezado
            table.addCell(tabletemp);
            table.writeSelectedRows(0, -1, 50, 760, writer.getDirectContent());
            
            Image imgfondo = Image.getInstance(this.fondo);
			imgfondo.setAbsolutePosition((this.posX- imgfondo.getScaledWidth()) / 2,(this.posY- (imgfondo.getScaledHeight() + 10)) / 2);

			document.add(imgfondo);
			
			  PdfPTable pie = new PdfPTable(1);
			  pie.setTotalWidth(this.posX);
			  pie.getDefaultCell().setBorder(0);
	          Image imgpie;
	          imgpie = Image.getInstance(this.pie);
	          pie.addCell(imgpie);
	          pie.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	          pie.writeSelectedRows(0, -1, 50, 70, writer.getDirectContent());
	          
	          PdfPTable pie3 = new PdfPTable(1);
			  pie3.setTotalWidth(60);
			  
//			  pie3.getDefaultCell().setBorder(0);
//	          imgpie =Image.getInstance(this.getFirma().getImgfirma());
//	          imgpie.setRotationDegrees(45);
//	          imgpie.scaleToFit(100, 72);
//	          pie3.addCell(imgpie);
//	          pie3.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
////	          pie3.writeSelectedRows(0, -1, 300, 35, writer.getDirectContent());
//	          pie3.writeSelectedRows(0, -1, 540, 75, writer.getDirectContent());
	         
	          PdfPTable pie2 = new PdfPTable(3);
			  pie2.setTotalWidth(540);
			  pie2.getDefaultCell().setBorder(0);
			  pie2.setWidths(new int[]{50, 90, 5});

	          pie2.addCell(CeldaPdf.getCelda("Imprime "+this.usuario, "HELVETICA", 6, 0, 0, 0, 0, 0,0,0));
	          imgtotal.scaleAbsoluteHeight(8f);
			  PdfPCell cell1 = new PdfPCell(imgtotal);
			  cell1.setBorder(0);
			  cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			  
	          pie2.addCell(CeldaPdf.getCelda(String.format("Pagina %01d de ", writer.getPageNumber()), "HELVETICA", 6,1.0f, 0,2,0,0f,0,0));
	          pie2.addCell(cell1);
			
	          pie2.addCell(CeldaPdf.getCelda(""+this.fecha, "HELVETICA", 6, 1, 0, 0, 0, 0,0,0));
	          //pie2.addCell(celdaPdf.getCelda("     ", "HELVETICA", 6, 01, 0, 0, 0, 0,0,0));
	          pie2.addCell(CeldaPdf.getCelda("", "HELVETICA", 6, 1.0f, 0, 2, 0, 0f,2,0));
	          pie2.writeSelectedRows(0, -1, 36, 45, writer.getDirectContent());
			
        } catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    
    /**
     * Realiza el conteo de paginas al momento de cerrar el documento
     */
    public void onCloseDocument(PdfWriter writer, Document document) {
    	int tam=writer.getPageNumber();
    	tam= tam-1;
        ColumnText.showTextAligned(total, Element.ALIGN_LEFT, new Phrase(String.valueOf(tam)), 2, 2, 0);
    }    
    
    
	/**
	 * @return the encabezado
	 */
	public String getEncabezado() {
		return encabezado;
	}
	/**
	 * @param encabezado the encabezado to set
	 */
	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}
	/**
	 * @return the fondo
	 */
	public String getFondo() {
		return fondo;
	}
	/**
	 * @param fondo the fondo to set
	 */
	public void setFondo(String fondo) {
		this.fondo = fondo;
	}
	/**
	 * @return the posX
	 */
	public float getPosX() {
		return posX;
	}
	/**
	 * @param posX the posX to set
	 */
	public void setPosX(float posX) {
		this.posX = posX;
	}
	/**
	 * @return the posY
	 */
	public float getPosY() {
		return posY;
	}
	/**
	 * @param posY the posY to set
	 */
	public void setPosY(float posY) {
		this.posY = posY;
	}
	/**
	 * @return the pie
	 */
	public String getPie() {
		return pie;
	}
	/**
	 * @param pie the pie to set
	 */
	public void setPie(String pie) {
		this.pie = pie;
	}
	/**
	 * @return the total
	 */
	public PdfTemplate getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(PdfTemplate total) {
		this.total = total;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}

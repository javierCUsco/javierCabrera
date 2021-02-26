/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.herramientas;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
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
	private String pie2;
	PdfTemplate total;
	private String usuario;
	private String fecha;
	private Font font;
	private String codigo;
	
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
            table.setTotalWidth(this.posX-50);
            table.getDefaultCell().setBorder(0);
            Image encabezado;
           	encabezado = Image.getInstance(this.encabezado);
           	encabezado.scaleToFit(10, 10);
           	encabezado.setAbsolutePosition(((this.posX- encabezado.getScaledWidth()) / 2)-10,(this.posY- (encabezado.getScaledHeight())) / 2);
			table.addCell(encabezado);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
           // tabletemp.addCell(String.format("Pagina %01d de ", writer.getPageNumber())+Image.getInstance(total));
         
            PdfPTable tabletemp = new PdfPTable(3);
            tabletemp.setWidths(new int[]{80, 160, 24});
            tabletemp.setTotalWidth(900);
            tabletemp.addCell(CeldaPdf.getCelda(this.getCodigo()+"", "HELVETICA", 8,5.0f, 0,0,0,0f,0,0));
           
            tabletemp.addCell(CeldaPdf.getCelda(String.format("Pagina %01d de ", writer.getPageNumber()), "HELVETICA", 8,3.0f, 0,2,0,0f,0,0));
//            System.out.println("total    pagina     "+String.format(" "+writer.getPageSize()));
            Image imgtotal=Image.getInstance(total) ;
            imgtotal.scaleAbsoluteHeight(10f);
            PdfPCell cell = new PdfPCell(imgtotal);
            cell.setBorder(0);
            tabletemp.addCell(cell);
            tabletemp.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
     
            //tabletemp.addCell(celdaPdf.getCelda(this.certificado, "HELVETICA", 8,1.0f, 0,0,0,0f));
            // Esta linea escribe la tabla como encabezado
            table.addCell(tabletemp);
            table.writeSelectedRows(0, -1, 30, 600, writer.getDirectContent());
            Image imgfondo = Image.getInstance(this.fondo);
			imgfondo.setAbsolutePosition((this.posX- imgfondo.getScaledWidth()) / 2,(this.posY- (imgfondo.getScaledHeight() + 10)) / 2);
			document.add(imgfondo);
        
	          
			
			PdfPTable pie2 = new PdfPTable(2);
			  pie2.setTotalWidth(this.posX);
			  pie2.getDefaultCell().setBorder(0);
			  pie2.setWidths(new int[]{30, 50});
			 
	          pie2.addCell(CeldaPdf.getCeldaFuente("Imprime : "+this.usuario+"\n"+"Fecha impresión : "+this.fecha, this.font,  0, 0, 0, 0, 0,0,0, 0));
	          pie2.addCell(CeldaPdf.getCelda("", "HELVETICA", 6, 0, 0, 0, 0, 0,0,0));
	          
	          
	          Image imgpie;
	          imgpie = Image.getInstance(this.pie);
	          imgpie.scaleToFit(190f, 190f);
	          imgpie.setAbsolutePosition((this.posX-218),20);
	          imgpie.setBorderWidth(10);
	          imgpie.setBorderColor(BaseColor.WHITE);
	          document.add(imgpie);
	          
	          
//	          Image imgpie2;
//	          imgpie2 = Image.getInstance(this.pie2);
//	          imgpie2.scaleToFit(200f, 200f);
//	          imgpie2.setAbsolutePosition(20,25);
//	          imgpie2.setBorderWidth(10);
//	          imgpie2.setBorderColor(BaseColor.WHITE);
//	          document.add(imgpie2);
	          pie2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	          pie2.writeSelectedRows(0, 1, 50, 80, writer.getDirectContent());
			
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
	 * @param pie the pie to set
	 */
	public void setPie2(String pie2) {
		this.pie2 = pie2;
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

	/**
	 * @return the font
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * @param font the font to set
	 */
	public void setFont(Font font) {
		
		this.font = font;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}

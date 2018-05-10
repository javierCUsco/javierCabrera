/**
 * 
 */
package co.edu.usco.modulo.personal.mvc.control.herramientas;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;

/**
 * @author INGENIERO JAVIER CABRERA
 *
 */
public class CeldaPdf {

	/**
	 * metodo para crear celda de tabla para pdf
	 * @param info informcion que se quiere publicar, String 
	 * @param tipoLetra el tipo de letra que se desea utilizar
	 * @param tamanoLetra tamaño de letra que se va a po
	 * @param paddin
	 * @param border se utiliza para se se quiere o no poner el borde
	 * @param alineacion posision en que quedara la iformacion
	 * @param estilo 
	 * @param altura de la celda
	 * @return
	 */
	public static PdfPCell getCelda(String info,String tipoLetra, int tamanoLetra,  float paddin,int border,int alineacion, int estilo,float altura, int colspan, int rowspan){

		PdfPCell celda = new PdfPCell(new Paragraph(info, FontFactory.getFont(tipoLetra,tamanoLetra, estilo, BaseColor.BLACK))); // color
		
		celda.setHorizontalAlignment(alineacion);
		// añadimos un espaciado
		celda.setPadding(paddin);
		// colocamos un color de fondo
		if(border==0){
//			System.out.println("Rectangle.NO_BORDER "+Rectangle.NO_BORDER);
			celda.setBorder(Rectangle.NO_BORDER);
		}
		if(border==2){
			celda.setBorderWidthTop(0.5f);
			
		}
		if (altura!=0){
			celda.setFixedHeight(altura);
		}
		if(colspan>0){
			celda.setColspan(colspan);
		}
		if(rowspan>0){
			celda.setRowspan(rowspan);
		}
		return celda;
	}
	
	
	
	/**
	 * 
	 * metodo para crear celda de tabla para pdf
	 * @param 1-info informcion que se quiere publicar, String 
	 * @param 2-tipoLetra el tipo de letra que se desea utilizar String 
	 * @param 3-tamanoLetra tamaño de la letra que se va a utilizar int
	 * @param 4-paddin float
	 * @param 5-border se utiliza para se se quiere o no poner el borde int
	 * @param 6-alineacion posision en que quedara la informacion int centro 1,justificado 3,izquierda 0,derecha 2
	 * @param 7-estilo float
	 * @param 8-altura de la celda int
	 * @param 9-colspan int 
	 * @param 10-rowspan int
	 * @param 11-color 
	 * @return
	 */
	public static PdfPCell getCelda(String info,String tipoLetra, int tamanoLetra,  float paddin,int border,int alineacion, int estilo,float altura,  int colspan, int rowspan, int color){

		PdfPCell celda = new PdfPCell(new Paragraph(info, FontFactory.getFont(tipoLetra,tamanoLetra, estilo, BaseColor.BLACK))); // color

		celda.setHorizontalAlignment(alineacion);
		// añadimos un espaciado
		celda.setPadding(paddin);
		// colocamos un color de fondo
		
		if(color ==-1){
			celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
		}else{
			if(color%2==0){
				celda.setBackgroundColor(BaseColor.WHITE);
			}else{
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
			}
		}
		
		

		if(border>0){
//			System.out.println("Rectangle.NO_BORDER "+Rectangle.NO_BORDER);
			
			if(border==1){
				celda.setBorder(Rectangle.BOTTOM);
			}
			if(border==2){
				celda.setBorderWidthTop(0.5f);
				
			}
			if(border==3){
				celda.setBorder(Rectangle.BOTTOM);
				
			}
		}else{
			celda.setBorder(Rectangle.NO_BORDER);
		}
		
		
		
		
		if (altura!=0){
			celda.setFixedHeight(altura);
		}
		
		
		if(colspan>0){
			celda.setColspan(colspan);
		}
		if(rowspan>0){
			celda.setRowspan(rowspan);
		}
		
		return celda;
	}
	
	
	
	
}

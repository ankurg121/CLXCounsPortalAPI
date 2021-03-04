package com.jilit.clxacademics.business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jilit.clxacademics.config.CounsellingInstituteProfile;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

public class HeaderPDFCell {

	//@Autowired
	//private CounsellingInstituteProfile ims;

    public HeaderPDFCell() {

    }
   

    public PdfPTable getHeader(String applicantsname,String fathername,String rank,String category,String status,String counsellingdate,CounsellingInstituteProfile ims) {
        PdfPTable masterTable = new PdfPTable(50);
        PdfPTable table11 = new PdfPTable(2);
		PdfPTable table12 = new PdfPTable(14);
        PdfPCell cell;
        Image img2 = null;
       // CounsellingInstituteProfile ims=new CounsellingInstituteProfile();
        try {

		    String dateStr = new Date().toString();
			DateFormat originalFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
			DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = originalFormat.parse(dateStr);
			String todatdate = targetFormat.format(date);

            BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.EMBEDDED);
            Font font1 = new Font(bf, 8, Font.BOLD);
            Font font2 = new Font(bf, 10, Font.BOLD);
            Font font3 = new Font(bf, 10, Font.UNDERLINE);
            Font font4 = new Font(bf, 6, Font.NORMAL);
            Font font5 = new Font(bf, 6, Font.ITALIC);
            
            img2 = Image.getInstance(getClass().getClassLoader().getResource(ims.getLogourl()));
			img2.scaleAbsoluteHeight(80);
			img2.scaleAbsoluteWidth(80);

			cell = new PdfPCell(img2);
			cell.setBorder(0);
			cell.setColspan(2);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setVerticalAlignment(Element.ALIGN_LEFT);
			table11.addCell(cell);
		

		// -------------Institute Name--------------

		cell = new PdfPCell(new Phrase(ims.getName(), font2));
		cell.setBorder(0);
		cell.setColspan(14);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table12.addCell(cell);

		// -------------Decleration--------------

				cell = new PdfPCell(new Phrase("("+ims.getDecleration()+")", font5));
				cell.setBorder(0);
				cell.setColspan(14);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				table12.addCell(cell);

				
		// -------------Institute Address--------------

		cell = new PdfPCell(new Phrase(ims.getAddress1() + " ," + ims.getAddress2() + ", " + ims.getCity()+"("+ims.getState()+")", font4));
		cell.setBorder(0);
		cell.setColspan(14);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table12.addCell(cell);

		// -------------Institute City And State--------------

		cell = new PdfPCell(new Phrase("Tel.:" +ims.getTelephone()+","+"Fax:"+ims.getFax()+","+ims.getWebsite(), font4));
		cell.setBorder(0);
		cell.setColspan(14);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		table12.addCell(cell);

		cell = new PdfPCell(table11);
		cell.setColspan(2);
		cell.setRowspan(1);
		cell.setVerticalAlignment(Element.ALIGN_LEFT);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(0);
		masterTable.addCell(cell);

		cell = new PdfPCell(table12);
		cell.setColspan(54);
		cell.setRowspan(1);
		cell.setVerticalAlignment(Element.ALIGN_LEFT);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(0);
		masterTable.addCell(cell);

            cell = new PdfPCell(new Phrase("CHOICE PROFORMA",font2));
            cell.setBorder(0);
            cell.setColspan(50);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            masterTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(" "));
            cell.setBorder(0);
            cell.setColspan(50);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            masterTable.addCell(cell);
            
            
            // -------------Applicants Name--------------

            cell = new PdfPCell(new Phrase("NAME OF CANDIDATE",font1));
            cell.setBorder(0);
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_LEFT);
            masterTable.addCell(cell);

            cell = new PdfPCell(new Phrase(applicantsname.toUpperCase(),font1));
            cell.setBorder(0);
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_LEFT);
            masterTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Date : "+counsellingdate,font1));
            cell.setBorder(0);
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_LEFT);
            masterTable.addCell(cell);

           
            // -------------father Name--------------

            cell = new PdfPCell(new Phrase("NAME OF FATHER/GUARDIAN",font1));
            cell.setBorder(0);
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_LEFT);
            masterTable.addCell(cell);

            cell = new PdfPCell(new Phrase(fathername.toUpperCase(), font1));
            cell.setBorder(0);
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_LEFT);
            masterTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(status,font1));
            cell.setBorder(0);
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_LEFT);
            masterTable.addCell(cell);

            // -------------Rank--------------

            cell = new PdfPCell(new Phrase("OVERALL JEE RANK",font1));
            cell.setBorder(0);
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_LEFT);
            masterTable.addCell(cell);

            cell = new PdfPCell(new Phrase(rank, font1));
            cell.setBorder(0);
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_LEFT);
            masterTable.addCell(cell);
            
            cell = new PdfPCell(new Phrase(""));
            cell.setBorder(0);
            cell.setColspan(10);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            masterTable.addCell(cell);

            // -------------Category--------------

            cell = new PdfPCell(new Phrase("CATEGORY",font1));
            cell.setBorder(0);
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_LEFT);
            masterTable.addCell(cell);

            cell = new PdfPCell(new Phrase(category, font1));
            cell.setBorder(0);
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_LEFT);
            masterTable.addCell(cell);

            cell = new PdfPCell(new Phrase(""));
            cell.setBorder(0);
            cell.setColspan(10);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_RIGHT);
            masterTable.addCell(cell);
            
      
            
            cell = new PdfPCell(new Phrase(""));
            cell.setBorder(0);
            cell.setColspan(50);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_RIGHT);
            masterTable.addCell(cell);
            
            // -------------choices--------------

            cell = new PdfPCell(new Phrase("Choices..........>",font1));
            cell.setBorder(0);
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_LEFT);
            masterTable.addCell(cell);

            cell = new PdfPCell(new Phrase(""));
            cell.setBorder(0);
            cell.setColspan(10);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            masterTable.addCell(cell);

            cell = new PdfPCell(new Phrase("Generated On Date :"+todatdate,font1));
            cell.setBorder(0);
            cell.setColspan(20);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setVerticalAlignment(Element.ALIGN_RIGHT);
            masterTable.addCell(cell);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return masterTable;
    }
}


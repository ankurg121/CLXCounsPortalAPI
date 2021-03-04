package com.jilit.clxacademics.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.repository.CInstituteMasterRepository;
import com.jilit.clxacademics.repository.CStudentMasterRepository;
import com.jilit.clxacademics.service.CounsellingAllocationReceiptReportService;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class CounsellingAllocationReceiptReportServiceImpl implements CounsellingAllocationReceiptReportService {

	@Autowired
	private CStudentMasterRepository cstudentmasterrepository;

	@Autowired
	private CInstituteMasterRepository cinstitutemasterrepository;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getStudentAllottedInstitute(Map jsonMap) throws CLXException {
		List<Map> studentlist = null;
		List<Map> hostellist = null;
		Map returnmap = new HashMap();
		String counsellingid = jsonMap.get("counsellingid").toString();
		String rank = jsonMap.get("rank").toString();
		String applicationid = jsonMap.get("applicationid").toString();
		studentlist = cstudentmasterrepository.getStudentAllotedData(counsellingid, rank, applicationid);
		if (studentlist != null && !studentlist.isEmpty()) {
			String studentid = studentlist.get(0).get("studentid").toString();
			String institutecode = studentlist.get(0).get("allotedinstitute").toString();
			hostellist = cstudentmasterrepository.getHostelConfirmation(studentid, institutecode);
			returnmap.put("studentlist", studentlist);
			returnmap.put("hostellist", hostellist);
		} else {
			hostellist = new ArrayList();
			returnmap.put("studentlist", studentlist);
			returnmap.put("hostellist", hostellist);
		}
		return returnmap;
	}

	@SuppressWarnings("rawtypes")
	public byte[] getCounsellingReceiptReport(Map jsonMap, HttpServletRequest request, HttpServletResponse response) {
		ByteArrayOutputStream bstream = new ByteArrayOutputStream();
		try {

			getReport(bstream, jsonMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bstream.toByteArray();
	}

	@SuppressWarnings("rawtypes")
	public void getReport(ByteArrayOutputStream bstream, Map datamap) {
		try {

			Document document = new Document(PageSize.A4, 0, 0, 30, 30);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, bstream);
			document.setMargins(0, 0, 30, 30);
			document.open();
			document.addCreationDate();

			BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.EMBEDDED);
			Font font1 = new Font(bf, 8, Font.BOLD);
			Font font = new Font(bf, 8, Font.NORMAL);

			PdfPTable masterTable = new PdfPTable(50);

			PdfPTable table11 = new PdfPTable(2);
			PdfPTable table12 = new PdfPTable(14);
			PdfPCell cell;

			Image img2 = null;

			String counsellingid = datamap.get("counsellingid").toString();
			String rank = datamap.get("rank").toString();
			String applicationid = datamap.get("applicationid").toString();
			String institutecode = "JIIT";//
			// datamap.get("institutecode").toString();
			// short counsellingno = 1;//
			// datamap.get("counsellingno").toString();

			String institutename = "";
			String address1 = "";
			String address2 = "";
			String city = "";
			String state = "";
			String faxno = "";
			String stdcode = "";
			String phone = "";
			String website = "";
			String logoname = "";
			String watermarkname = "";

			List<Map> institutelist = cinstitutemasterrepository.getInstituteData(institutecode);
			if (institutelist != null && !institutelist.isEmpty()) {
				Map data = institutelist.get(0);
				institutename = data.get("institutename").toString();
				address1 = data.get("address1") == null ? "" : data.get("address1").toString();
				address2 = data.get("address2") == null ? "" : data.get("address2").toString();
				city = data.get("city") == null ? "" : data.get("city").toString();
				state = data.get("state") == null ? "" : data.get("state").toString();
				faxno = data.get("faxnos") == null ? "" : data.get("faxnos").toString();
				stdcode = data.get("stdcode") == null ? "" : data.get("stdcode").toString();
				phone = data.get("phoneno") == null ? "" : data.get("phoneno").toString();
				website = data.get("website") == null ? "" : data.get("website").toString();
				logoname = data.get("logofilename") == null ? "" : data.get("logofilename").toString();
				watermarkname = data.get("watermarkfilename") == null ? "" : data.get("watermarkfilename").toString();
			}

			List<Map> studentList = cstudentmasterrepository.getStudentDetail(counsellingid, rank, applicationid);
			String allocationdate = "";
			if (studentList != null && !studentList.isEmpty()) {
				if (studentList.get(0) != null) {
					allocationdate = studentList.get(0).get("allocationdate").toString();
				}
			}

			List<Map> hostelconfirmation = null;
			List<Map> choiceslist = null;

			// -------------Report Name--------------

			// cell = new PdfPCell(new Phrase(reportname, font1));
			// cell.setBorder(0);
			// cell.setColspan(14);
			// cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell.setVerticalAlignment(Element.ALIGN_CENTER);
			// table12.addCell(cell);
			//
			// cell = new PdfPCell(table11);
			// cell.setColspan(2);
			// cell.setRowspan(1);
			// cell.setVerticalAlignment(Element.ALIGN_LEFT);
			// cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBorder(0);
			// masterTable.addCell(cell);
			//
			// cell = new PdfPCell(table12);
			// cell.setColspan(48);
			// cell.setRowspan(1);
			// cell.setVerticalAlignment(Element.ALIGN_LEFT);
			// cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBorder(0);
			// masterTable.addCell(cell);
			//
			// cell = new PdfPCell(new Phrase(""));
			// cell.setColspan(50);
			// cell.setRowspan(1);
			// cell.setVerticalAlignment(Element.ALIGN_LEFT);
			// cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			// cell.setBorder(0);
			// masterTable.addCell(cell);

			cell = new PdfPCell(new Phrase(" " + institutename, font1));
			cell.setBorder(0);
			cell.setColspan(50);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			masterTable.addCell(cell);

			cell = new PdfPCell(
					new Phrase("(Declared Deemed to be University under Section 3 of the UGC Act, 1956)", font));
			cell.setBorder(0);
			cell.setColspan(50);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			masterTable.addCell(cell);

			cell = new PdfPCell(new Phrase(" " + address1 + " " + city + "(" + state + ")", font));
			cell.setBorder(0);
			cell.setColspan(50);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			masterTable.addCell(cell);

			cell = new PdfPCell(
					new Phrase("Tel.:" + stdcode + "-" + phone + ", Fax: " + faxno + ", website: " + website, font));
			cell.setBorder(0);
			cell.setColspan(50);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			masterTable.addCell(cell);

			cell = new PdfPCell(new Phrase(" BRANCH ALLOCATION ", font1));
			cell.setBorder(0);
			cell.setColspan(50);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			masterTable.addCell(cell);

			cell = new PdfPCell(new Phrase(" Allocation Date: " + allocationdate + "", font1));
			cell.setBorder(0);
			cell.setColspan(50);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			masterTable.addCell(cell);

			cell = new PdfPCell(new Phrase("Run Date- :  " + new Date(), font1));
			cell.setBorder(0);
			cell.setColspan(50);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setVerticalAlignment(Element.ALIGN_RIGHT);
			masterTable.addCell(cell);

			if (studentList != null && !studentList.isEmpty()) {
				if (studentList.get(0) != null) {
					String studentid = studentList.get(0).get("studentid").toString();
					String name = studentList.get(0).get("name").toString();
					String allottedinstitute = studentList.get(0).get("allotedinstitute").toString();
					String programcode = studentList.get(0).get("programcode").toString();
					String branchdesc = studentList.get(0).get("branchdesc").toString();
					String category = studentList.get(0).get("fromcategory").toString();
					String rollno = studentList.get(0).get("rollno").toString();
					Short counsellingno = Short.valueOf(studentList.get(0).get("counsellingno").toString());

					hostelconfirmation = cstudentmasterrepository.getHostelConfirmation(studentid, allottedinstitute);
					String hostel = "NO";
					if (hostelconfirmation != null && !hostelconfirmation.isEmpty()) {
						if (hostelconfirmation.get(0) != null) {
							hostel = hostelconfirmation.get(0).get("").toString();
						}
					}

					cell = new PdfPCell(new Phrase("", font));
					cell.setBorder(0);
					cell.setColspan(50);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Rank : " + rank, font));
					cell.setBorder(1);
					cell.setColspan(30);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					cell.setBorderWidthLeft((float) 1);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Category :  " + category, font));
					cell.setBorder(1);
					cell.setColspan(20);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					cell.setBorderWidthRight((float) 1);
					cell.setBorderWidthLeft((float) 1);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Name : " + name, font));
					cell.setBorder(0);
					cell.setColspan(30);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					cell.setBorderWidthLeft((float) 1);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Roll No. :  " + rollno, font));
					cell.setBorder(0);
					cell.setColspan(20);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					cell.setBorderWidthRight((float) 1);
					cell.setBorderWidthLeft((float) 1);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(1);
					cell.setColspan(50);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Preferance Of Choices................. ", font1));
					cell.setBorder(0);
					cell.setColspan(50);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Choice No.", font));
					cell.setColspan(5);
					cell.setRowspan(1);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBorder(Element.RECTANGLE);
					cell.setBorderWidthTop((float) .1);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Institute", font));
					cell.setColspan(10);
					cell.setRowspan(1);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorder(Element.RECTANGLE);
					cell.setBorderWidthTop((float) .1);
					cell.setBorderWidthLeft((float) 0);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Code", font));
					cell.setColspan(10);
					cell.setRowspan(1);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorder(Element.RECTANGLE);
					cell.setBorderWidthTop((float) .1);
					cell.setBorderWidthLeft((float) 0);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Branch Name", font));
					cell.setColspan(25);
					cell.setRowspan(1);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBorder(Element.RECTANGLE);
					cell.setBorderWidthTop((float) .1);
					cell.setBorderWidthLeft((float) 0);
					masterTable.addCell(cell);

					choiceslist = cstudentmasterrepository.getCousellingChoiceList(counsellingid, counsellingno, rank);

					if (choiceslist != null && !choiceslist.isEmpty()) {
						for (int i = 0; i < choiceslist.size(); i++) {

							Map m = choiceslist.get(i);

							cell = new PdfPCell(new Phrase(i + 1 + ".", font));
							cell.setColspan(5);
							cell.setRowspan(1);
							cell.setVerticalAlignment(Element.ALIGN_CENTER);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							cell.setBorder(Element.RECTANGLE);
							cell.setBorderWidthTop((float) .1);
							masterTable.addCell(cell);

							cell = new PdfPCell(new Phrase(m.get("institutecode").toString(), font));
							cell.setColspan(10);
							cell.setRowspan(1);
							cell.setVerticalAlignment(Element.ALIGN_CENTER);
							cell.setBorder(Element.RECTANGLE);
							cell.setBorderWidthTop((float) .1);
							cell.setBorderWidthLeft((float) 0);
							masterTable.addCell(cell);

							cell = new PdfPCell(new Phrase(m.get("alpha").toString(), font));
							cell.setColspan(10);
							cell.setRowspan(1);
							cell.setVerticalAlignment(Element.ALIGN_CENTER);
							cell.setBorder(Element.RECTANGLE);
							cell.setBorderWidthTop((float) .1);
							cell.setBorderWidthLeft((float) 0);
							masterTable.addCell(cell);

							cell = new PdfPCell(new Phrase(m.get("branchdesc").toString(), font));
							cell.setColspan(25);
							cell.setRowspan(1);
							cell.setVerticalAlignment(Element.ALIGN_CENTER);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							cell.setBorder(Element.RECTANGLE);
							cell.setBorderWidthTop((float) .1);
							cell.setBorderWidthLeft((float) 0);
							masterTable.addCell(cell);

						}
					} else {
						cell = new PdfPCell(new Phrase("No data found", font));
						cell.setColspan(25);
						cell.setRowspan(1);
						cell.setVerticalAlignment(Element.ALIGN_CENTER);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBorder(0);
						cell.setBorderWidthTop((float) 0);
						cell.setBorderWidthLeft((float) 0);
						masterTable.addCell(cell);
					}

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(1);
					cell.setColspan(50);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Branch Allotted................... ", font1));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Institute ", font));
					cell.setBorder(0);
					cell.setColspan(5);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("" + allottedinstitute, font));
					cell.setBorder(0);
					cell.setColspan(10);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(0);
					cell.setColspan(10);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" Branch Accepted ", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Program ", font));
					cell.setBorder(0);
					cell.setColspan(5);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("" + programcode, font));
					cell.setBorder(0);
					cell.setColspan(10);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(0);
					cell.setColspan(10);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Branch ", font));
					cell.setBorder(0);
					cell.setColspan(5);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("" + branchdesc, font));
					cell.setBorder(0);
					cell.setColspan(20);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Signature of the candidate ", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("Hostel ", font));
					cell.setBorder(0);
					cell.setColspan(5);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("" + hostel, font));
					cell.setBorder(0);
					cell.setColspan(20);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell.setVerticalAlignment(Element.ALIGN_LEFT);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("(" + name + ")", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("A/c may accept dues ", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" Signature of the Admission Committee", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(" ", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase("", font));
					cell.setBorder(0);
					cell.setColspan(25);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					masterTable.addCell(cell);

					// if (list != null) {
					// String collection = "--";
					// String refund = "--";
					// String transferIn = "--";
					// String transferOut = "--";
					// int totalAmmount = 0;
					// String currencyCode = "";
					//
					// cell = new PdfPCell(new Phrase(" ", font));
					// cell.setBorder(0);
					// cell.setColspan(50);
					// cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					// cell.setVerticalAlignment(Element.ALIGN_LEFT);
					// masterTable.addCell(cell);
					//
					// cell = new PdfPCell(new Phrase("Total " + currencyCode +
					// " "
					// +
					// totalAmmount, font));
					// cell.setBorder(0);
					// cell.setColspan(50);
					// cell.setHorizontalAlignment(Element.ALIGN_LEFT);
					// cell.setVerticalAlignment(Element.ALIGN_LEFT);
					// masterTable.addCell(cell);
					// } else {
					// cell = new PdfPCell(new Phrase("No data found", font));
					// cell.setColspan(50);
					// cell.setRowspan(1);
					// cell.setVerticalAlignment(Element.ALIGN_CENTER);
					// cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					// cell.setBorder(0);
					// cell.setBorderWidthTop((float) 0);
					// cell.setBorderWidthLeft((float) 0);
					// masterTable.addCell(cell);
					// }
				} else {
					cell = new PdfPCell(new Phrase("No data found", font));
					cell.setColspan(50);
					cell.setRowspan(1);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBorder(0);
					cell.setBorderWidthTop((float) 0);
					cell.setBorderWidthLeft((float) 0);
					masterTable.addCell(cell);
				}
			} else {
				cell = new PdfPCell(new Phrase("No data found", font));
				cell.setColspan(50);
				cell.setRowspan(1);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setBorder(0);
				cell.setBorderWidthTop((float) 0);
				cell.setBorderWidthLeft((float) 0);
				masterTable.addCell(cell);
			}
			// }
			// PdfWriter.getInstance(document, bstream);
			document.open();
			// document.add(table12);
			// document.add(table);
			document.add(masterTable);
			document.close();
			pdfWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.jilit.clxacademics.service.impl;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jilit.clxacademics.business.HeaderPDFCell;
import com.jilit.clxacademics.config.CounsellingInstituteProfile;
import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.model.CDraftChoiceMaster;
import com.jilit.clxacademics.model.CDraftChoiceMasterPK;
import com.jilit.clxacademics.repository.CDraftChoiceMasterRepository;
import com.jilit.clxacademics.repository.C_CurrentRepository;
import com.jilit.clxacademics.service.MyBranchPreferenceService;
import com.jilit.clxacademics.util.ErrorBank;
import com.jilit.clxacademics.util.Identifier;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class MyBranchPreferenceServiceImpl implements MyBranchPreferenceService {

	@Autowired
	private CDraftChoiceMasterRepository cdraftchoicemasterrepository;

	@Autowired
	private C_CurrentRepository c_currentrepository;
	
	@Autowired
	public CounsellingInstituteProfile ims;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getBranchPreerenceList(Map jsonMap) throws CLXException {
		Map branchchoiceMap = new HashMap<>();
		List<Map> branchpreferencelist = new ArrayList();
		//List<Map> isfreezedlist = new ArrayList();
		Map isfreezedlist = new HashMap();
		String counsellingid = jsonMap.get("counsellingid").toString();
		String rank = jsonMap.get("rank").toString();
		String categorycode = jsonMap.get("categorycode").toString();
		
		List list=c_currentrepository.getCurrentCounsellingNo(counsellingid);
		short counsellingno = new Short(list.get(0).toString());
		
		isfreezedlist = cdraftchoicemasterrepository.isBranchFreezed(counsellingid,rank,counsellingno);
		
		Date freezedate=null;
		Date entrydate=null;
		if(isfreezedlist.containsKey("freezedate"))
			freezedate=(Date) isfreezedlist.get("freezedate");
		if (isfreezedlist.containsKey("entrydate"))
			entrydate=(Date) isfreezedlist.get("entrydate");
		
		if(freezedate==null)
			branchpreferencelist = cdraftchoicemasterrepository.getbranchpreferencelist(counsellingid, rank, categorycode);
		else {
			throw new CLXException(ErrorBank.BRANCHES_FREEZED, Identifier.MYBRANCHPREFRENCESERVICEIMPL);
		}
		branchchoiceMap.put("branchpreferencelist", branchpreferencelist);
		branchchoiceMap.put("counsellingno", counsellingno);
		branchchoiceMap.put("entrydate", entrydate);
		
		return branchchoiceMap;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	@Transactional
	public String saveDraftChoice(Map jsonMap) throws CLXException {
		String status = "";
		List<CDraftChoiceMaster> draftchoicemasterlist = new ArrayList();

		try {
			DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date entrydate= targetFormat.parse( targetFormat.format(new Date()));
			
			String counsellingid = jsonMap.get("counsellingid").toString();
			short counsellingno = new Short(jsonMap.get("counsellingno").toString());
			String rank = jsonMap.get("rank").toString();
			String entryby = jsonMap.get("memberid").toString();
			
			// cdraftchoicemasterrepository.isuserValid(counsellingid,applicantid);
			cdraftchoicemasterrepository.deleteMyBranchChoice(counsellingid,rank,counsellingno);
			
			List<Map> choicelist = (List) jsonMap.get("choicelist");
			for (int i = 0; i < choicelist.size(); i++) {

				Map choicemap = (Map) choicelist.get(i);
				if(choicemap.get("choiceno") != null)
				{
				String institutecode = choicemap.get("institutecode").toString();
				String programtype = choicemap.get("programtype").toString();
				String programcode = choicemap.get("programcode").toString();
				String branchcode = choicemap.get("branchcode").toString();
				String choiceno = choicemap.get("choiceno").toString();
				String alpha = choicemap.get("alpha").toString();
				CDraftChoiceMaster cdraftchoicemaster = new CDraftChoiceMaster();
				CDraftChoiceMasterPK cdraftchoicemasterpk = new CDraftChoiceMasterPK();
				cdraftchoicemasterpk.setAlpha(alpha);
				cdraftchoicemasterpk.setBranchcode(branchcode);
				cdraftchoicemasterpk.setChoiceno(new Short(choiceno));
				cdraftchoicemasterpk.setCounsellingid(counsellingid);
				cdraftchoicemasterpk.setCounsellingno(counsellingno);
				cdraftchoicemasterpk.setProgramcode(programcode);
				cdraftchoicemasterpk.setProgramtype(programtype);
				cdraftchoicemasterpk.setRank(rank);
				cdraftchoicemaster.setCDraftChoiceMasterPK(cdraftchoicemasterpk);
				cdraftchoicemaster.setDeactive("N");
				cdraftchoicemaster.setEntryby(entryby);
				cdraftchoicemaster.setEntrydate(entrydate);
				cdraftchoicemaster.setInstitutecode(institutecode);
				cdraftchoicemaster.setFreeze("N");
				draftchoicemasterlist.add(cdraftchoicemaster);
				}
			}
			cdraftchoicemasterrepository.saveAll(draftchoicemasterlist);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CLXException(ErrorBank.ERROR_WHILE_SAVING, Identifier.MYBRANCHPREFRENCESERVICEIMPL);
		}
		return status;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public byte[] getReport(HttpServletResponse response1, Map bodyMap) throws CLXException {
		String reporttype="";
		List list=new ArrayList();
		//Map branchchoiceMap = new HashMap<>();
		String applicantsname = bodyMap.get("applicantsname").toString();
		String fathername = bodyMap.get("fathername").toString();
		String rank = bodyMap.get("rank").toString();
		String category = bodyMap.get("categorycode").toString();
		String counsellingid = bodyMap.get("counsellingid").toString();
		
		List<Map> branchpreferencereportlist = new ArrayList();
		//List<Map> isfreezedlist = new ArrayList();
		Map isfreezedlist = new HashMap();
		
		List counsnolist=c_currentrepository.getCurrentCounsellingNo(counsellingid);
		short counsellingno = new Short(counsnolist.get(0).toString());
		
		isfreezedlist = cdraftchoicemasterrepository.isBranchFreezed(counsellingid,rank,counsellingno);
 		Date freezedate=null;
 		Date entrydate=null;
 		String counsellingdate="";
		if(isfreezedlist.containsKey("freezedate"))
			{
				freezedate=(Date) isfreezedlist.get("freezedate");
				if(freezedate!=null)
					counsellingdate=isfreezedlist.get("freezedate").toString();
			}
		if (isfreezedlist.containsKey("entrydate"))
			{
				entrydate=(Date) isfreezedlist.get("entrydate");
				
				if(counsellingdate.equals(""))
					counsellingdate=isfreezedlist.get("entrydate").toString();
			}
		
		if(freezedate==null)
		{
			reporttype="DRAFT";
			list = cdraftchoicemasterrepository.getBranchPreferenceDraftReportlist(counsellingid,rank,counsellingno);
		}
		else {
			reporttype="FREEZED";
			list = cdraftchoicemasterrepository.getBranchPreferenceFreezedReportlist(counsellingid,rank,counsellingno);
		}
		
		 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ByteArrayOutputStream bstream = new ByteArrayOutputStream();

		try {
			
			String dateStr = counsellingdate;
			DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = originalFormat.parse(dateStr);
			String counsellingdate1 = targetFormat.format(date);
			
			//String counsellingdate1=sdf.format(counsellingdate);

			//InstituteMaster ims = instituteMasterRepository.findByInstituteid(instituteID);
			Document document = new Document(PageSize.A4, 0, 0, 30, 30);
			document.setMargins(0, 0, 30, 30);
			document.open();
			//document.addCreationDate();

			BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.EMBEDDED);
			Font font1 = new Font(bf, 8, Font.BOLD);
			Font font = new Font(bf, 8, Font.NORMAL);

			// This class is used for header part..
			HeaderPDFCell hpdf = new HeaderPDFCell();

			PdfPTable masterTable = hpdf.getHeader(applicantsname,fathername,rank,category,reporttype,counsellingdate1,ims);
			PdfPCell cell;

//			cell = new PdfPCell(new Phrase(" "));
//			cell.setColspan(50);
//			cell.setRowspan(1);
//			cell.setVerticalAlignment(Element.ALIGN_LEFT);
//			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			cell.setBorder(0);
//			masterTable.addCell(cell);


			cell = new PdfPCell(new Phrase("Institute", font1));
			cell.setColspan(10);
			cell.setRowspan(1);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(Element.RECTANGLE);
			cell.setBorderWidthTop((float) .1);
			masterTable.addCell(cell);

			cell = new PdfPCell(new Phrase("Branch Code", font1));
			cell.setColspan(10);
			cell.setRowspan(1);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(Element.RECTANGLE);
			cell.setBorderWidthTop((float) .1);
			cell.setBorderWidthLeft((float) 0);
			masterTable.addCell(cell);

			cell = new PdfPCell(new Phrase("Branch Description", font1));
			cell.setColspan(20);
			cell.setRowspan(1);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(Element.RECTANGLE);
			cell.setBorderWidthTop((float) .1);
			cell.setBorderWidthLeft((float) 0);
			masterTable.addCell(cell);
			
			cell = new PdfPCell(new Phrase("Alpha", font1));
			cell.setColspan(5);
			cell.setRowspan(1);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(Element.RECTANGLE);
			cell.setBorderWidthTop((float) .1);
			cell.setBorderWidthLeft((float) 0);
			masterTable.addCell(cell);
			
			cell = new PdfPCell(new Phrase("Priority", font1));
			cell.setColspan(5);
			cell.setRowspan(1);
			cell.setVerticalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(Element.RECTANGLE);
			cell.setBorderWidthTop((float) .1);
			cell.setBorderWidthLeft((float) 0);
			masterTable.addCell(cell);


			if (!list.isEmpty() && list != null) {
				for (int i = 0; i < list.size(); i++) {
					Map m = (Map) list.get(i);

					if(m.get("choiceno") != null)
					{
					cell = new PdfPCell(new Phrase(m.get("institutecode").toString(), font));
					cell.setColspan(10);
					cell.setRowspan(1);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorder(Element.RECTANGLE);
					cell.setBorderWidthTop((float) 0);
					cell.setBorderWidthLeft((float) 0);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(m.get("programcode").toString()+"-"+m.get("branchcode").toString(), font));
					cell.setColspan(10);
					cell.setRowspan(1);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorder(Element.RECTANGLE);
					cell.setBorderWidthTop((float) 0);
					cell.setBorderWidthLeft((float) 0);
					masterTable.addCell(cell);

					cell = new PdfPCell(new Phrase(m.get("branchdesc").toString(), font));
					cell.setColspan(20);
					cell.setRowspan(1);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorder(Element.RECTANGLE);
					cell.setBorderWidthTop((float) 0);
					cell.setBorderWidthLeft((float) 0);
					masterTable.addCell(cell);
					
					cell = new PdfPCell(new Phrase(m.get("alpha").toString(), font));
					cell.setColspan(5);
					cell.setRowspan(1);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorder(Element.RECTANGLE);
					cell.setBorderWidthTop((float) 0);
					cell.setBorderWidthLeft((float) 0);
					masterTable.addCell(cell);
					
					cell = new PdfPCell(new Phrase(m.get("choiceno").toString(), font));
					cell.setColspan(10);
					cell.setRowspan(1);
					cell.setVerticalAlignment(Element.ALIGN_CENTER);
					cell.setBorder(Element.RECTANGLE);
					cell.setBorderWidthTop((float) 0);
					cell.setBorderWidthLeft((float) 0);
					masterTable.addCell(cell);
					}
				}
			} else {

				cell = new PdfPCell(new Phrase("No data found", font1));
				cell.setColspan(50);
				cell.setRowspan(1);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setBorder(0);
				cell.setBorderWidthTop((float) 0);
				cell.setBorderWidthLeft((float) 0);
				masterTable.addCell(cell);
			}

			PdfWriter.getInstance(document, bstream);
			document.open();
			// document.add(table12);
			// document.add(table);
			document.add(masterTable);
			document.close();
			
            PdfReader reader = new PdfReader(bstream.toByteArray());
            bstream = new ByteArrayOutputStream();
            PdfStamper stamp = new PdfStamper(reader, bstream);
            PdfContentByte under;
            
			Image img = Image.getInstance(getClass().getClassLoader().getResource(ims.getWatermarkurl()));
            img.setAbsolutePosition(200,450);
            img.scalePercent(72f / 250 * 100f);
            img.scaleAbsolute(200,200);
            under = stamp.getUnderContent(1);
            under.addImage(img);
            stamp.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bstream.toByteArray();
	}

	private ArrayList Map(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map getDraftReportGridChoice(Map jsonMap) throws CLXException {
		Map branchchoiceMap = new HashMap<>();
		List<Map> branchpreferencereportlist = new ArrayList();
		Map isfreezedlist = new HashMap();
		String counsellingid = jsonMap.get("counsellingid").toString();
		String rank = jsonMap.get("rank").toString();
		
		List list=c_currentrepository.getCurrentCounsellingNo(counsellingid);
		short counsellingno = new Short(list.get(0).toString());
		
		isfreezedlist = cdraftchoicemasterrepository.isBranchFreezed(counsellingid,rank,counsellingno);
		
		Date freezedate=null;
		Date entrydate=null;
		if(isfreezedlist.containsKey("freezedate"))
			freezedate=(Date) isfreezedlist.get("freezedate");
		if (isfreezedlist.containsKey("entrydate"))
			entrydate=(Date) isfreezedlist.get("entrydate");
		
		if(freezedate==null)
		{
			branchchoiceMap.put("reporttype", "D");
			branchchoiceMap.put("statusdate", entrydate);
			branchpreferencereportlist = cdraftchoicemasterrepository.getBranchPreferenceDraftReportlist(counsellingid,rank,counsellingno);
			branchchoiceMap.put("branchpreferencereportlist", branchpreferencereportlist);
		}
		else {
			//Date freezedate=(Date) isfreezedlist.get("freezedate");
			branchchoiceMap.put("reporttype", "F");
			branchchoiceMap.put("statusdate", freezedate);
			branchpreferencereportlist = cdraftchoicemasterrepository.getBranchPreferenceFreezedReportlist(counsellingid,rank,counsellingno);
			branchchoiceMap.put("branchpreferencereportlist", branchpreferencereportlist);
		}
		return branchchoiceMap;
	}

}

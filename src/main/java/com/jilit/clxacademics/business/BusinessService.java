package com.jilit.clxacademics.business;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.jilit.clxacademics.exceptions.EntityNotFoundException;
import com.jilit.clxacademics.model.IdGenerationControl;
import com.jilit.clxacademics.model.IdGenerationControlPK;
import com.jilit.clxacademics.model.IdGenerationSetup;
import com.jilit.clxacademics.model.NumberingControlOthers;
import com.jilit.clxacademics.model.NumberingControlOthersPK;
import com.jilit.clxacademics.repository.IdGenerationControlRepository;
import com.jilit.clxacademics.repository.IdGenerationSetupRepository;
//import com.jilit.clxacademics.repository.InstituteMasterRepository;
import com.jilit.clxacademics.repository.NumberingControlOthersRepository;
import com.jilit.clxacademics.repository.NumberingSetupOthersRepository;
import com.jilit.clxacademics.util.ErrorBank;
import com.jilit.clxacademics.util.Identifier;
import com.jilit.clxacademics.util.JISDateUtil;

/**
 * 
 * @author ashutosh1.kumar
 *
 */
@Component
public class BusinessService {

	public BusinessService() {
	}

	@Autowired
	private IdGenerationSetupRepository idGenerationSetupRepository;

	@Autowired
	private NumberingSetupOthersRepository numberingSetupOthersRepository;

	@Autowired
	private NumberingControlOthersRepository numberingControlOthersRepository;

//	@Autowired
//	@Qualifier("instituteMasterRepository")
//	private InstituteMasterRepository instituteMasterRepository;

	@Autowired
	private IdGenerationControlRepository idGenerationControlRepository;

	@SuppressWarnings("rawtypes")
	private List<HashMap> idGenDataList = null;

	@SuppressWarnings("rawtypes")
	private List<HashMap> NumberDataGenDataList = null;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String generateNumber(String companyinstid, String pPrefix, String companyinstitute, Date pTransDate) {
		String mVchNo = "";
		String totalwidth = "";
		String mYMD = "";
		long mLastRunningNo;
		String mGroupID = "";
		Date mLastVoucherDate = new Date();
		String returnValue = "";
		boolean insert = false;
		List<Object[]> numberingGroupList = null;
		try {
			numberingGroupList = numberingSetupOthersRepository.getNumberingSetupGroupID(companyinstid, pPrefix, companyinstitute);
			if (numberingGroupList != null && numberingGroupList.size() > 0) {
				mGroupID = numberingGroupList.get(0)[0].toString();
				mYMD = numberingGroupList.get(0)[1].toString();
				totalwidth = numberingGroupList.get(0)[2].toString();
			} else {
				throw new EntityNotFoundException(Identifier.REQUEST_FOR_DATA, ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
			}
			String mdd = JISDateUtil.convertDateFormat(pTransDate, "dd");
			String myy = JISDateUtil.convertDateFormat(pTransDate, "yy");
			String myyyy = JISDateUtil.convertDateFormat(pTransDate, "yyyy");
			String mYYYYMM = JISDateUtil.convertDateFormat(pTransDate, "yyyyMM");
			String mMMDD = JISDateUtil.convertDateFormat(pTransDate, "MMdd");
			String mYYYYMMDD = JISDateUtil.convertDateFormat(pTransDate, "yyyyMMdd");

			mVchNo = pPrefix;
			if (mYMD.equals("YYMM")) {
				mVchNo = mVchNo + myy + mdd;
			} else if (mYMD.equals("YY")) {
				mVchNo = mVchNo + myy;
			} else if (mYMD.equals("YYYY")) {
				mVchNo = mVchNo + myyyy;
			} else if (mYMD.equals("YYYYMM")) {
				mVchNo = mVchNo + mYYYYMM;
			} else if (mYMD.equals("MMDD")) {
				mVchNo = mVchNo + mMMDD;
			} else if (mYMD.equals("YYYYMMDD")) {
				mVchNo = mVchNo + mYYYYMMDD;
			}
			NumberingControlOthersPK ncpk = new NumberingControlOthersPK();
			NumberingControlOthers nc = new NumberingControlOthers();
			ncpk.setGroupid(mGroupID);
			ncpk.setYmd(mYMD);
			Optional<NumberingControlOthers> existingslno = numberingControlOthersRepository.findById(ncpk);

			if (!existingslno.isPresent() || existingslno == null) {
				mLastRunningNo = 1;
			} else {
				nc = (NumberingControlOthers) existingslno.get();
				mLastRunningNo = Integer.parseInt(nc.getLastrunningno() == null ? "0" : nc.getLastrunningno().toString()) + 1;
				try {
					mLastVoucherDate = JISDateUtil.convertToDateFormat(JISDateUtil.convertDateFormat(pTransDate, "DD-MM-YYYY"), "DD-MM-YYYY");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			int vcn = Integer.parseInt(totalwidth) - (mVchNo.trim().length());
			if (vcn > 0) {
				String s = String.valueOf(mLastRunningNo);
				if (s.length() > vcn) {
					return returnValue = "*";
				}
				String lpadString = String.format("%" + vcn + "s", mLastRunningNo).replace(' ', '0');
				mVchNo = mVchNo + "~N~";
				mVchNo = mVchNo.replace("~N~", lpadString);
			} else {
				return returnValue = "$";
			}

			if (existingslno == null || !existingslno.isPresent()) {
				insert = true;
				nc = new NumberingControlOthers();
				NumberingControlOthersPK id = new NumberingControlOthersPK();
				id.setGroupid(mGroupID);
				id.setYmd(mYMD);
				nc.setNumberingcontrolothersPK(id);
				nc.setLastno(mVchNo);
				nc.setLastrunningno(new BigDecimal(mLastRunningNo));
				nc.setLastnumberdate(JISDateUtil.convertToDateFormat(JISDateUtil.convertDateFormat(pTransDate, "DD-MM-YYYY"), "DD-MM-YYYY"));
			} else {
				insert = false;
				nc = (NumberingControlOthers) existingslno.get();
				nc.setLastno(mVchNo);
				nc.setLastrunningno(new BigDecimal(mLastRunningNo));
				nc.setLastnumberdate(mLastVoucherDate);
			}
			if (NumberDataGenDataList == null) {
				NumberDataGenDataList = new ArrayList();
			}
			if (returnValue.length() == 1) {
				mVchNo = returnValue;
			} else {
				HashMap map = new HashMap();
				map.put("insert", insert);
				map.put("dto", nc);
				NumberDataGenDataList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (mVchNo);
	}

	/**
	 * @description This method is used for generate ID using company ID and
	 *              companyUnique ID.
	 * @param compunqid
	 * @param companyid
	 * @param idcode
	 * @return
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String generateId(String instituteunqid, String instituteid, String idcode) {
		if (!validateCompanyOrInstId(instituteunqid, instituteid)) {
			return "*";
		}
		String month = (new SimpleDateFormat("MM")).format(System.currentTimeMillis());
		String year = (new SimpleDateFormat("yy")).format(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder(16);
		String generatedNumber = "0000001" + "";

		Optional<IdGenerationSetup> prefix = idGenerationSetupRepository.findById(idcode);
		String tablePrefix = prefix.get().getPrefix();
		char alpha = 'A';
		List<Object[]> maxAlphaList = null;
		maxAlphaList = idGenerationControlRepository.getAlpha(instituteunqid, idcode, year, month);
		IdGenerationControlPK idgcpk = null;
		IdGenerationControl idgc = null;
		if (maxAlphaList != null && !maxAlphaList.isEmpty()) {
			alpha = maxAlphaList.get(0)[0].toString().charAt(0);
			try {
				idgc = new IdGenerationControl();
				idgcpk = new IdGenerationControlPK();
				idgcpk.setAlpha(alpha);
				idgcpk.setIcid(instituteunqid);
				idgcpk.setIdcode(idcode);
				idgcpk.setMonth(month);
				idgcpk.setYear(year);
				Optional<IdGenerationControl> exitingid = idGenerationControlRepository.findById(idgcpk);
				if (exitingid != null || exitingid.isPresent())
					idgc = (IdGenerationControl) exitingid.get();

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (String.valueOf(idgc.getLastrunningno()).equals("9999999")) {
				alpha++;
			} else {
				generatedNumber = leftPad(String.valueOf(idgc.getLastrunningno().intValue() + 1), 7, '0');
			}
		} else {
			idgc = new IdGenerationControl();
			idgc.setIdGenerationControlPK(new IdGenerationControlPK(instituteunqid, idcode, year, month, alpha));
		}
		if (idGenDataList == null) {
			idGenDataList = new ArrayList();
		}
		sb.append(instituteunqid + tablePrefix + year + month + alpha + generatedNumber);
		HashMap map = new HashMap();
		map.put("model", idgc);
		map.put("generatedid", sb.toString());
		idGenDataList.add(map);
		return sb.toString();
	}

	/**
	 * @description This method is used for validate company Id exist or not.
	 * @param companyid
	 * @return
	 */
	public boolean validateCompanyOrInstId(String instituteunqid, String instituteid) {
		//InstituteMaster cm = (InstituteMaster) instituteMasterRepository.findByInstituteid(instituteid);
		//TO BE CHANGED BY ASHOK
//		if ((cm) != null) {
//			return true;
//		}

		return true;//false;
	}

	public static String leftPad(String originalString, int length, char padCharacter) {
		StringBuilder sb = new StringBuilder();
		while (sb.length() + originalString.length() < length) {
			sb.append(padCharacter);
		}
		sb.append(originalString);
		return sb.toString();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void insertOrUpdateInIdGen() {
		IdGenerationControl idGenerationControl = null;
		IdGenerationControlPK id = null;
		if (idGenDataList != null) {
			idGenerationControl = new IdGenerationControl();
			id = new IdGenerationControlPK();
			for (int i = 0; i < idGenDataList.size(); i++) {
				HashMap hashMap = idGenDataList.get(i);
				/* BigInteger(hashMap.get("generatedid").toString().substring(13, 20)); */
				BigInteger lastrunningno = new BigInteger(hashMap.get("generatedid").toString().substring(11));
				idGenerationControl = (IdGenerationControl) hashMap.get("model");
				id.setAlpha(idGenerationControl.getId().getAlpha());
				id.setIcid(idGenerationControl.getId().getIcid());
				id.setIdcode(idGenerationControl.getId().getIdcode());
				id.setMonth(idGenerationControl.getId().getMonth());
				id.setYear(idGenerationControl.getId().getYear());
				idGenerationControl.setId(id);
				idGenerationControl.setLastid(hashMap.get("generatedid").toString());
				idGenerationControl.setLastrunningno(lastrunningno);
				try {
					idGenerationControlRepository.save(idGenerationControl);
					idGenDataList = new ArrayList();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void insertOrUpdateInOtherNumber() {
		if (NumberDataGenDataList != null) {
			for (int i = 0; i < NumberDataGenDataList.size(); i++) {
				HashMap hashMap = NumberDataGenDataList.get(i);
				NumberingControlOthers nc1 = (NumberingControlOthers) hashMap.get("dto");
				numberingControlOthersRepository.save(nc1);
				NumberDataGenDataList = new ArrayList();
			}
		}
	}
	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public String generateNumber(String companyinstid, String pPrefix, String companyinstitute, Date pTransDate, String instituteUnqCode) {
//		String mVchNo = "";
//		String totalwidth = "";
//		String mYMD = "";
//		long mLastRunningNo;
//		String mGroupID = "";
//		Date mLastVoucherDate = new Date();
//		String returnValue = "";
//		boolean insert = false;
//		List<Object[]> numberingGroupList = null;
//		try {
//			numberingGroupList = numberingSetupOthersRepository.getNumberingSetupGroupID(companyinstid, pPrefix, companyinstitute);
//			if (numberingGroupList != null && numberingGroupList.size() > 0) {
//				mGroupID = numberingGroupList.get(0)[0].toString();
//				mYMD = numberingGroupList.get(0)[1].toString();
//				totalwidth = numberingGroupList.get(0)[2].toString();
//				totalwidth=totalwidth ;
//			} else {
//				throw new EntityNotFoundException(Identifier.REQUEST_FOR_DATA, ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
//			}
//			String mdd = JISDateUtil.convertDateFormat(pTransDate, "dd");
//			String myy = JISDateUtil.convertDateFormat(pTransDate, "yy");
//			String myyyy = JISDateUtil.convertDateFormat(pTransDate, "yyyy");
//			String mYYYYMM = JISDateUtil.convertDateFormat(pTransDate, "yyyyMM");
//			String mMMDD = JISDateUtil.convertDateFormat(pTransDate, "MMdd");
//			String mYYYYMMDD = JISDateUtil.convertDateFormat(pTransDate, "yyyyMMdd");
//
//			mVchNo = pPrefix;
//			if (mYMD.equals("YYMM")) {
//				mVchNo = mVchNo + myy + mdd;
//			} else if (mYMD.equals("YY")) {
//				mVchNo = mVchNo + myy;
//			} else if (mYMD.equals("YYYY")) {
//				mVchNo = mVchNo + myyyy;
//			} else if (mYMD.equals("YYYYMM")) {
//				mVchNo = mVchNo + mYYYYMM;
//			} else if (mYMD.equals("MMDD")) {
//				mVchNo = mVchNo + mMMDD;
//			} else if (mYMD.equals("YYYYMMDD")) {
//				mVchNo = mVchNo + mYYYYMMDD;
//			}
//			NumberingControlOthersPK ncpk = new NumberingControlOthersPK();
//			NumberingControlOthers nc = new NumberingControlOthers();
//			ncpk.setGroupid(mGroupID);
//			ncpk.setYmd(mYMD);
//			Optional<NumberingControlOthers> existingslno = numberingControlOthersRepository.findById(ncpk);
//
//			if (!existingslno.isPresent() || existingslno == null) {
//				mLastRunningNo = 1;
//			} else {
//				nc = (NumberingControlOthers) existingslno.get();
//				mLastRunningNo = Integer.parseInt(nc.getLastrunningno() == null ? "0" : nc.getLastrunningno().toString()) + 1;
//				try {
//					mLastVoucherDate = JISDateUtil.convertToDateFormat(JISDateUtil.convertDateFormat(pTransDate, "DD-MM-YYYY"), "DD-MM-YYYY");
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//
//			int vcn = Integer.parseInt(totalwidth) - ((mVchNo.trim().length())+2); // 2 for Institute Unique ID
//			if (vcn > 0) {
//				String s = String.valueOf(mLastRunningNo);
//				if (s.length() > vcn) {
//					return returnValue = "*";
//				}
//				String lpadString = String.format("%" + vcn + "s", mLastRunningNo).replace(' ', '0');
//				mVchNo = mVchNo + "~N~";
//				mVchNo = mVchNo.replace("~N~", lpadString);
//			} else {
//				return returnValue = "$";
//			}
//
//			if (existingslno == null ) {
//				insert = true;
//				nc = new NumberingControlOthers();
//				NumberingControlOthersPK id = new NumberingControlOthersPK();
//				id.setGroupid(mGroupID);
//				id.setYmd(mYMD);
//				nc.setNumberingcontrolothersPK(id);
//				nc.setLastno(mVchNo);
//				nc.setLastrunningno(new BigDecimal(mLastRunningNo));
//				nc.setLastnumberdate(JISDateUtil.convertToDateFormat(JISDateUtil.convertDateFormat(pTransDate, "DD-MM-YYYY"), "DD-MM-YYYY"));
//			} else {
//				insert = false;
//				nc = (NumberingControlOthers) existingslno.get();
//				nc.setLastno(mVchNo);
//				nc.setLastrunningno(new BigDecimal(mLastRunningNo));
//				nc.setLastnumberdate(mLastVoucherDate);
//			}
//			if (NumberDataGenDataList == null) {
//				NumberDataGenDataList = new ArrayList();
//			}
//			if (returnValue.length() == 1) {
//				mVchNo = returnValue;
//			} else {
//				HashMap map = new HashMap();
//				map.put("insert", insert);
//				map.put("dto", nc);
//				NumberDataGenDataList.add(map);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		mVchNo= instituteUnqCode+mVchNo;
//		return (mVchNo);
//	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String generateNumber(String companyinstid, String pPrefix, String companyinstitute, Date pTransDate, String instituteUnqCode) {
		String mVchNo = "";
		String totalwidth = "";
		String mYMD = "";
		long mLastRunningNo;
		String mGroupID = "";
		Date mLastVoucherDate = new Date();
		String returnValue = "";
		boolean insert = false;
		List<Object[]> numberingGroupList = null;
		try {
			numberingGroupList = numberingSetupOthersRepository.getNumberingSetupGroupID(companyinstid, pPrefix, companyinstitute);
			if (numberingGroupList != null && numberingGroupList.size() > 0) {
				mGroupID = numberingGroupList.get(0)[0].toString();
				mYMD = numberingGroupList.get(0)[1].toString();
				totalwidth = numberingGroupList.get(0)[2].toString();
				totalwidth=totalwidth ;
			} else {
				throw new EntityNotFoundException(Identifier.REQUEST_FOR_DATA, ErrorBank.ERROR_INVALID_JSON_BODYDATA_SUPPLIED);
			}
			String mdd = JISDateUtil.convertDateFormat(pTransDate, "dd");
			String myy = JISDateUtil.convertDateFormat(pTransDate, "yy");
			String myyyy = JISDateUtil.convertDateFormat(pTransDate, "yyyy");
			String mYYYYMM = JISDateUtil.convertDateFormat(pTransDate, "yyyyMM");
			String mMMDD = JISDateUtil.convertDateFormat(pTransDate, "MMdd");
			String mYYYYMMDD = JISDateUtil.convertDateFormat(pTransDate, "yyyyMMdd");

			mVchNo = pPrefix;
			if (mYMD.equals("YYMM")) {
				mVchNo = mVchNo + myy + mdd;
			} else if (mYMD.equals("YY")) {
				mVchNo = mVchNo + myy;
			} else if (mYMD.equals("YYYY")) {
				mVchNo = mVchNo + myyyy;
			} else if (mYMD.equals("YYYYMM")) {
				mVchNo = mVchNo + mYYYYMM;
			} else if (mYMD.equals("MMDD")) {
				mVchNo = mVchNo + mMMDD;
			} else if (mYMD.equals("YYYYMMDD")) {
				mVchNo = mVchNo + mYYYYMMDD;
			}
			NumberingControlOthersPK ncpk = new NumberingControlOthersPK();
			NumberingControlOthers nc = new NumberingControlOthers();
			ncpk.setGroupid(mGroupID);
			ncpk.setYmd(mYMD);
			Optional<NumberingControlOthers> existingslno = numberingControlOthersRepository.findById(ncpk);

			if (!existingslno.isPresent() || existingslno == null) {
				mLastRunningNo = 1;
			} else {
				nc = (NumberingControlOthers) existingslno.get();
				mLastRunningNo = Integer.parseInt(nc.getLastrunningno() == null ? "0" : nc.getLastrunningno().toString()) + 1;
				try {
					mLastVoucherDate = JISDateUtil.convertToDateFormat(JISDateUtil.convertDateFormat(pTransDate, "DD-MM-YYYY"), "DD-MM-YYYY");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			int vcn = Integer.parseInt(totalwidth) - ((mVchNo.trim().length())+2); // 2 for Institute Unique ID
			if (vcn > 0) {
				String s = String.valueOf(mLastRunningNo);
				if (s.length() > vcn) {
					return returnValue = "*";
				}
				String lpadString = String.format("%" + vcn + "s", mLastRunningNo).replace(' ', '0');
				mVchNo = mVchNo + "~N~";
				mVchNo = mVchNo.replace("~N~", lpadString);
			} else {
				return returnValue = "$";
			}

			if (existingslno == null || !existingslno.isPresent()) {
				insert = true;
				nc = new NumberingControlOthers();
				NumberingControlOthersPK id = new NumberingControlOthersPK();
				id.setGroupid(mGroupID);
				id.setYmd(mYMD);
				nc.setNumberingcontrolothersPK(id);
				nc.setLastno(mVchNo);
				nc.setLastrunningno(new BigDecimal(mLastRunningNo));
				nc.setLastnumberdate(JISDateUtil.convertToDateFormat(JISDateUtil.convertDateFormat(pTransDate, "DD-MM-YYYY"), "DD-MM-YYYY"));
			} else {
				insert = false;
				nc = (NumberingControlOthers) existingslno.get();
				nc.setLastno(mVchNo);
				nc.setLastrunningno(new BigDecimal(mLastRunningNo));
				nc.setLastnumberdate(mLastVoucherDate);
			}
			if (NumberDataGenDataList == null) {
				NumberDataGenDataList = new ArrayList();
			}
			if (returnValue.length() == 1) {
				mVchNo = returnValue;
			} else {
				HashMap map = new HashMap();
				map.put("insert", insert);
				map.put("dto", nc);
				NumberDataGenDataList.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mVchNo= instituteUnqCode+mVchNo;
		return (mVchNo);
	}
}

package com.jilit.clxacademics.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jilit.clxacademics.exceptions.CLXException;
import com.jilit.clxacademics.model.CApplicantsRegistration;
import com.jilit.clxacademics.repository.CChoiceMasterRepository;
import com.jilit.clxacademics.repository.C_CurrentRepository;
import com.jilit.clxacademics.service.OfferedBranchService;
import com.jilit.clxacademics.util.ErrorBank;
import com.jilit.clxacademics.util.Identifier;
import com.jilit.clxacademics.util.MessageBank;

@Service
public class OfferedBranchServiceImpl implements OfferedBranchService {
	@Autowired
	private CChoiceMasterRepository cChoiceMasterRepository;

	public Map getOfferedBranchList(Map jsonMap) throws CLXException {

		Map datamap = new HashMap();
		String counsellingid = jsonMap.get("counsellingid").toString();
		short counsellingno = (short) Integer.parseInt(jsonMap.get("counsellingno").toString());
		String rank = jsonMap.get("rank").toString();
		try {
			List<Map> offeredbranchList = cChoiceMasterRepository.getOfferedBranchList(counsellingid, counsellingno,
					rank);
			if (offeredbranchList.size() > 0) {

				List<Map> offeredbranch = offeredbranchList.stream().filter((Map s) -> {
					return (boolean) "Y".equals(s.get("branchalloted") == null ?"":s.get("branchalloted").toString());
				}).collect(Collectors.toList());
				
				if (offeredbranch.size() > 0) {
					Map catmap =offeredbranch.get(0);
					String category = catmap.get("allocationfromcategory") == null ?"":catmap.get("allocationfromcategory").toString();
					String allotedinstitute = catmap.get("allotedinstitute").toString();
					List<Map> allocationdetail = cChoiceMasterRepository.getAllocationDetail(counsellingid,category ,rank);
					if(allocationdetail.size()>0) {
						List<Map> feehostalstatus = cChoiceMasterRepository.getFeeHostelStatus(counsellingid, category,allotedinstitute,rank);
						datamap.put("offeredbranch", offeredbranchList);
						datamap.put("allocationdetail", allocationdetail);
						datamap.put("feehostalstatus", feehostalstatus);
					}else {
						throw new CLXException(ErrorBank.ERROR_WHILE_RETRIEVING, Identifier.OfferedBranchService);
					}

				} else {
					throw new CLXException(ErrorBank.ERROR_WHILE_RETRIEVING, Identifier.OfferedBranchService);
				}

			} 

		} catch (CLXException e) {
			throw new CLXException(e.getMessage(), Identifier.OfferedBranchService);
		} catch (Exception e) {
			throw new CLXException(ErrorBank.SOMETHING_WENT_WRONG, Identifier.OfferedBranchService);
		}
		return datamap;
	}

}

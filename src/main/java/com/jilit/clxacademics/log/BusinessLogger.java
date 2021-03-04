package com.jilit.clxacademics.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jilit.clxacademics.model.Log_Clxaudittrail_Master;
import com.jilit.clxacademics.model.Log_Clxaudittrail_MasterId;
import com.jilit.clxacademics.repository.LogCLXAuditTrailMasterRepository;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BusinessLogger {

    @Autowired
    LogCLXAuditTrailMasterRepository logCLXAuditTrailMasterRepository;


    @Async
    @Transactional
    public void saveAuditLogs(String pModuleName, String pRightsName, String pTableOrObjectName, String pOperation, String pPKColName, String pPKValues, Object dto, String pLogStatusS_F, Date pActionDateTime, String pRemarks, Map map) throws UnknownHostException, JsonProcessingException {
       	Log_Clxaudittrail_Master logData;
    	Log_Clxaudittrail_MasterId logId;
        String memeberid = map.get("memberid").toString();
        String memebercode = map.get("membercode").toString();
        String memebername = map.get("membername").toString();
        String memebertype = map.get("membertype").toString();
        String ipaddress = map.get("ipaddress").toString();
        String macaddress = map.get("macaddress").toString();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = mapper.writeValueAsString(dto);
        logData = new Log_Clxaudittrail_Master();
        logId = new Log_Clxaudittrail_MasterId();
        try {
            String logid = getRandomNumber();
            logId.setLogentryid(logid);
            logId.setLogid(new BigDecimal("1"));
            logData.setLog_Clxaudittrail_MasterPK(logId);
            logData.setLogbymembercode(memebercode);
            logData.setLogbymemberid(memeberid);
            logData.setLogbymembername(memebername);
            logData.setLogbymembertype(memebertype);
            logData.setLogdate(new Date());
            logData.setLogstatus(pLogStatusS_F);
            logData.setMenuname(pRightsName);
            logData.setModulecode(pModuleName);
            logData.setNewvalue(json);
            logData.setActivity(pOperation);
            logData.setIpaddress(ipaddress);
            logData.setMacaddress(macaddress);
            logData.setOntable(pTableOrObjectName);
            logData.setPkcolumnname(pPKColName);
            logData.setMacaddress("jsonLogData.toString()");
            logData.setPkvalues(pPKValues);
            logData.setRemarks(pRemarks);
            //  Thread.sleep(2222);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        logCLXAuditTrailMasterRepository.save(logData);
    }

    @Async
    @Transactional
    public void saveAuditLogs(String pModuleName, String pRightsName, List pTableOrObjectName, List pOperation, List dto, Date pActionDateTime, String pRemarks, Map map) throws UnknownHostException, JsonProcessingException {

    	Log_Clxaudittrail_Master logData;
    	Log_Clxaudittrail_MasterId logId;
        String memeberid = map.get("memberid").toString();
        String memebercode = map.get("membercode").toString();
        String memebername = map.get("membername").toString();
        String memebertype = map.get("membertype").toString();
        String ipaddress = map.get("ipaddress").toString();
        String macaddress = map.get("macaddress").toString();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String logid = getRandomNumber();
        for (int i =0; i < pTableOrObjectName.size(); i++) {
            logData = new Log_Clxaudittrail_Master();
            logId = new Log_Clxaudittrail_MasterId();
            try {
                String json = mapper.writeValueAsString(dto.get(i));
                logId.setLogentryid(logid);
                logId.setLogid(new BigDecimal(String.valueOf(i+1)));
                logData.setLog_Clxaudittrail_MasterPK(logId);
                logData.setLogbymembercode(memebercode);
                logData.setLogbymemberid(memeberid);
                logData.setLogbymembername(memebername);
                logData.setLogbymembertype(memebertype);
                logData.setLogdate(new Date());
                logData.setLogstatus("S");
                logData.setMenuname(pRightsName);
                logData.setModulecode(pModuleName);
                logData.setNewvalue(json);
                logData.setActivity(pOperation.get(i).toString());
                logData.setIpaddress(ipaddress);
                logData.setMacaddress(macaddress);
                logData.setOntable(pTableOrObjectName.get(i).toString());
                logData.setMacaddress("jsonLogData.toString()");
                logData.setRemarks(pRemarks);
                //  Thread.sleep(2222);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            logCLXAuditTrailMasterRepository.save(logData);
        }
    }

    public String getRandomNumber() {

        DateFormat df = new SimpleDateFormat("HH:mm:ss.SSSSSS");
        String processingId = "LOG" + (df.format(new Date())).replace(":", "").replace(".", "") + (int) (Math.random() * 973) + (int) (Math.random() * 591) + 137;
        processingId = processingId.substring(0, 20);
        return processingId;
    }   
}

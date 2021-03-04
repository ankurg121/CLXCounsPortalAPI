package com.jilit.clxacademics.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.jilit.clxacademics.exceptions.EntityNotFoundException;
//import com.jilit.clxacademics.model.Notification_SmsSetUp;
//import com.jilit.clxacademics.repository.Notification_SmsSetUpRepository;
import com.jilit.clxacademics.service.impl.UserServiceImpl;
import com.jilit.clxacademics.util.Identifier;
import com.jilit.clxacademics.util.MessageBank;

@SuppressWarnings("unused")
@Component
public class SmsMailUtil {
	public static final Logger log = LoggerFactory.getLogger(SmsMailUtil.class);

//	@Autowired
//	private Notification_SmsSetUpRepository notification_SmsSetUpRepository;

	/**
	 * 
	 * @param <K>
	 * @param <V>
	 * @param data
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	  @Async
	public <K, V> String sendSMS(Map<K, V> data) throws UnsupportedEncodingException, IOException {
		String stst="";
	/*	String encodedMsg = URLEncoder.encode(data.get("msgtxt").toString(), "UTF-8");
		Notification_SmsSetUp smsSetUp = (Notification_SmsSetUp) notification_SmsSetUpRepository
				.findById(data.get("tempaltecode").toString()).get();
		// String v =
		// "http://sms.jitconsulting.in/sendsms?uname=ITER&pwd=password&senderid=SOAUNI&to=901517986&msg=Dear%20Candidate%20your%20complete%20SAAT%202013%20Application%20No.%20500001%20must%20reach%20us%20by%20post%20before%2015.04.2013.%20Contact%20:%209437035916.%20SOA%20University&route=T";
		StringBuilder url = new StringBuilder();
		url.append(smsSetUp.getTemplateurl()).append("?uname=").append(smsSetUp.getUname()).append("&pwd=")
				.append(smsSetUp.getPwd());
		url.append("&senderid=").append(smsSetUp.getSenderid()).append("&to=").append(data.get("MobileNo"));
		url.append("&msg=").append(encodedMsg).append("&route=").append(smsSetUp.getRoute());
		// comment to send sms
		String stst = "";
		// String stst= sendToServer(url.toString());
		System.out.println(url);*/
		return stst;
	}
	  @Async
	public String sendToServer(String targetURL) throws IOException {
		String responsTxt = "";
		URL url = null;
		HttpURLConnection conn = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			url = new URL(targetURL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.connect();
			Thread.sleep(100);
			out = conn.getOutputStream();
			in = conn.getInputStream();
			// sender.s
			responsTxt = IOUtils.toString(in);
		} catch (IOException | InterruptedException e) {
		} finally {
			IOUtils.closeQuietly(out);
			if (conn != null) {
				conn.disconnect();
			}
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
		return responsTxt;
	}// String from, String pass, String to, String subject, String msgtxt

  	 
	  @Async
	  public void sendEmailToApplicant(Map map) {		  
	        try {
	        	 
				String from=map.get("fromemailid").toString();
				String fromemailpass=map.get("fromemailpwd").toString();
				String counsellingemailhost=map.get("fromemailhost").toString();
				String counsellingemailport=map.get("fromemailport").toString();
				String to=map.get("toemailid").toString();
				String subject=map.get("subject").toString();
				String name=map.get("name").toString();
				String applno=map.get("applno").toString();
	        	String password=map.get("password").toString();	        	
	        	 
	        	StringBuffer body = new StringBuffer();
	        	body.append("<b><u>It is an auto generated email, please do not reply</u></b>");
                body.append("<p><b>Dear Candidate,</b></p>");
                body.append("<p>Thank you for creationg your Password and shwoing interest for <b> Admission in  Jaypee Enginnering College</b></p>");
                body.append("<p>Your log-in ID will be your <b>Application No</b> or <b/Your JEE Rank</b> </p>");
                body.append("<p>Password: <b>" + password + "</b></p>");//encryption.decode(record4.get(0)[1].toString()) + "</p>");
                body.append("<p>APPLICATION NO:<b>" + applno+ "</b> (Please quote this Application NO in all future correspondences)</p>");
                body.append("<p>Please log on to http://jiit.ac.in/admission/....  with the above log-in id and password for further activities.</p>");
                body.append("<p>Keep visiting our websites regularly for updates:</p>");
                body.append("<p>http://admissions.jiit.ac.in/CLXCounsPortal/onindex.html, www.jiit.ac.in</p><br/>");
                body.append("<p><b>(Admissions Office)</b></p>");
                body.append("<p><b>JAYPEE INSTITUTE OF INFORMATION TECHNOLOGY</B></p>");
                body.append("<p>A-10, Sector-62, , Noida-201 309, Uttar Pradesh, India. </p>");
                body.append("<p>Ahmedabad: 382481 </p>");
                body.append("<p>Gujarat, India</p>");
                body.append("<p>Email: Email Us – webadmin@jiit.ac.in </p>");
                body.append("<p><b>HELPLINE NOS</b> : +91120 2400973-976  (WEEKDAYS - 9.30 A.M. TO 5.00 P.M., SATURDAY - 9.30 A.M. TO 1.00 P.M.)</p>");
               // body.append("<p>Fax: 0000000000000</p>");
                
                try {
                    
                    sendEmailWithfullParameter(from, fromemailpass, to, subject, body.toString(), counsellingemailhost, counsellingemailport);
               
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    /////////////////////////////////////////////////////////////////////////////////////////
    }
	  @Async
	  public void sendEmailWithfullParameter(String from, String pass, String to, String subject, String msgtxt, String host, String port) {
	        try {
	            Properties props = System.getProperties();
	            //  String host = "smtp.gmail.com";
	            //String host = "50.23.255.131";
	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.host", host);
	            props.put("mail.smtp.user", from);
	            props.put("mail.smtp.password", pass);
	            props.put("mail.smtp.port", port);
	            props.put("mail.smtp.auth", "true");
	            Session session = Session.getDefaultInstance(props);
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(from));
	            message.addRecipients(Message.RecipientType.TO, to);
	            message.addRecipient(Message.RecipientType.BCC, new InternetAddress("ashoksingh1975.delhi@gmail.com"));
	            message.setSubject(subject);
	            message.setContent(msgtxt, "text/html");
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        } catch (Exception e) {
	            System.out.println(" Problem in mail sending......." + e);
	        }
	  }
}

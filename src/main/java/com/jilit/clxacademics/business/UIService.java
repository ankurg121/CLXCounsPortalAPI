package com.jilit.clxacademics.business;

import org.springframework.stereotype.Component;

@Component
public class UIService {
public String amountToWord(double mValue, String mCurrencyId) {
	        String cr;
	        String la;
	        String th;
	        String tth;
	        String hu;
	        String te;
	        String one;
	        String word;
	        double thbrk;
	        double val;
	        String thbrkv;
	        double fval;
	        String pval;


	        fval = Double.parseDouble(String.valueOf(mValue).split("\\.")[0]);
	        pval = String.valueOf(Double.parseDouble(String.valueOf(mValue).split("\\.")[1].length() == 2 ? String.valueOf(mValue).split("\\.")[1] : String.valueOf(mValue).split("\\.")[1] + "0"));

	        val = Math.floor(mValue);
	        cr = String.valueOf(Math.floor(val / 10000000));
	        val = val - (Double.parseDouble(cr) * 10000000);
	        la = String.valueOf(Math.floor(val / 100000));
	        val = val - (Double.parseDouble(la) * 100000);
	        th = String.valueOf(Math.floor(val / 1000));
	        val = val - (Double.parseDouble(th) * 1000);
	        hu = String.valueOf(Math.floor(val / 100));
	        val = val - (Double.parseDouble(hu) * 100);
	        one = String.valueOf(val);
	        val = val - Double.parseDouble(one);
	        tth = " ";
	        if (Double.parseDouble(cr) > 0) {
	            if (Double.parseDouble(cr) > 20) {
	                thbrk = Double.parseDouble(cr);
	                word = String.valueOf(Math.floor(thbrk / 10) * 10);
	                thbrkv = String.valueOf(Double.parseDouble(cr) - (Math.floor(thbrk / 10) * 10));
	                tth = tth + spellout(word) + " " + spellout(thbrkv) + " CRORE ";
	            } else {
	                tth = tth + spellout(cr) + " CRORE ";
	            }
	        }
	        if (Double.parseDouble(la) > 0) {
	            if (Double.parseDouble(la) > 20) {
	                thbrk = Double.parseDouble(la);
	                word = String.valueOf(Math.floor(thbrk / 10) * 10);
	                thbrkv = String.valueOf(Double.parseDouble(la) - (Math.floor(thbrk / 10) * 10));
	                tth = tth + spellout(word) + ' ' + spellout(thbrkv) + " LAKH ";
	            } else {
	                tth = tth + spellout(la) + " LAKH ";
	            }
	        }
	        if (Double.parseDouble(th) > 0) {
	            if (Double.parseDouble(th) > 20) {
	                thbrk = Double.parseDouble(th);
	                word = String.valueOf(Math.floor(thbrk / 10) * 10);
	                thbrkv = String.valueOf(Double.parseDouble(th) - (Math.floor(thbrk / 10) * 10));
	                tth = tth + spellout(word) + " " + spellout(thbrkv) + " THOUSAND ";
	            } else {
	                tth = tth + spellout(th) + " THOUSAND ";
	            }
	        }
	        if (Double.parseDouble(hu) > 0) {
	            if (Double.parseDouble(hu) > 20) {
	                thbrk = Double.parseDouble(hu);
	                word = String.valueOf(Math.floor(thbrk / 10) * 10);
	                thbrkv = String.valueOf(Double.parseDouble(hu) - (Math.floor(thbrk / 10) * 10));
	                tth = tth + spellout(word) + " " + spellout(thbrkv) + " HUNDRED ";
	            } else {
	                tth = tth + spellout(hu) + " HUNDRED ";
	            }
	        }

	        if (Double.parseDouble(one) > 0) {
	            if (Double.parseDouble(one) > 20) {
	                thbrk = Double.parseDouble(one);
	                word = String.valueOf(Math.floor(thbrk / 10) * 10);
	                thbrkv = String.valueOf(Double.parseDouble(one) - (Math.floor(thbrk / 10) * 10));
	                if(mCurrencyId!=null && mCurrencyId.equals("INR")){
	                tth = tth + spellout(word) + " " + spellout(thbrkv) + " RUPEES ";
	                }else
	                {
	                    tth = tth + spellout(word) + " " + spellout(thbrkv) + " DOLLAR ";
	                }
	            //tth = tth + spellout(word) + " " + spellout(thbrkv);
	            } else {
	                 if(mCurrencyId!=null && mCurrencyId.equals("INR")){
	                tth = tth + spellout(one) + " RUPEES ";
	                 }else
	                 {
	                       tth = tth + spellout(one) + " DOLLAR ";
	                 }
	            //tth = tth + spellout(one);
	            }
	        }else
	        {
	             if(mCurrencyId!=null && mCurrencyId.equals("INR")){
	                tth = tth + spellout(one) + " RUPEES ";
	                 }else
	                 {
	                       tth = tth + spellout(one) + " DOLLAR ";
	                 }
	        }
	        if (Double.parseDouble(pval) > 0) {
	            if (Double.parseDouble(pval) > 20) {
	                thbrk = Double.parseDouble(pval);
	                word = String.valueOf(Math.floor(thbrk / 10) * 10);
	                thbrkv = String.valueOf(Double.parseDouble(pval) - (Math.floor(thbrk / 10) * 10));
	                if (fval > 0) {// Change by Sourabh Kanojiya
	                     if(mCurrencyId.equals("INR")){
	                    tth = tth + " and " + spellout(word) + " " + spellout(thbrkv) + " PAISE";
	                     }else
	                     {
	                          tth = tth + " and " + spellout(word) + " " + spellout(thbrkv) + " CENTS";
	                     }
	                } else {
	                    if(mCurrencyId.equals("INR")){
	                    tth = spellout(word) + " " + spellout(thbrkv) + " PAISE";
	                    }else
	                    {
	                         tth = spellout(word) + " " + spellout(thbrkv) + " CENTS";
	                    }
	                }
	            } else {
	                if (fval > 0) {// Change by Sourabh Kanojiya
	                    if(mCurrencyId.equals("INR")){
	                    tth = tth + " and " + spellout(pval) + " PAISA";
	                    }else
	                    {
	                        tth = tth + " and " + spellout(pval) + " CENTS";
	                    }
	                } else {
	                     if(mCurrencyId!=null && mCurrencyId.equals("INR")){
	                    tth = spellout(pval) + " PAISA";
	                     }else
	                     {
	                          tth = spellout(pval) + " CENTS";
	                     }
	                }
	            }
	        }
	        System.err.println("tth is " + tth);
	        return (tth + " ONLY");
	    }

	 
	  private String spellout(String wrd) {
	        String xwrd = "";
	        System.out.println(" Word " + wrd);
	        xwrd = wrd.trim();
	        if (xwrd.equals("1.0")) {
	            return ("ONE");
	        }
	        if (xwrd.equals("2.0")) {
	            return ("TWO");
	        }
	        if (xwrd.equals("3.0")) {
	            return ("THREE");
	        }
	        if (xwrd.equals("4.0")) {
	            return ("FOUR");
	        }
	        if (xwrd.equals("5.0")) {
	            return ("FIVE");
	        }
	        if (xwrd.equals("6.0")) {
	            return ("SIX");
	        }
	        if (xwrd.equals("7.0")) {
	            return ("SEVEN");
	        }
	        if (xwrd.equals("8.0")) {
	            return ("EIGHT");
	        }
	        if (xwrd.equals("9.0")) {
	            return ("NINE");
	        }
	        if (xwrd.equals("10.0")) {
	            return ("TEN");
	        }
	        if (xwrd.equals("11.0")) {
	            return ("ELEVEN");
	        }
	        if (xwrd.equals("12.0")) {
	            return ("TWELVE");
	        }
	        if (xwrd.equals("13.0")) {
	            return ("THIRTEEN");
	        }
	        if (xwrd.equals("14.0")) {
	            return ("FOURTEEN");
	        }
	        if (xwrd.equals("15.0")) {
	            return ("FIFTEEN");
	        }
	        if (xwrd.equals("16.0")) {
	            return ("SIXTEEN");
	        }
	        if (xwrd.equals("17.0")) {
	            return ("SEVENTEEN");
	        }
	        if (xwrd.equals("18.0")) {
	            return ("EIGHTEEN");
	        }
	        if (xwrd.equals("19.0")) {
	            return ("NINETEEN");
	        }
	        if (xwrd.equals("20.0")) {
	            return ("TWENTY");
	        }
	        if (xwrd.equals("30.0")) {
	            return ("THIRTY");
	        }
	        if (xwrd.equals("40.0")) {
	            return ("FOURTY");
	        }
	        if (xwrd.equals("50.0")) {
	            return ("FIFTY");
	        }
	        if (xwrd.equals("60.0")) {
	            return ("SIXTY");
	        }
	        if (xwrd.equals("70.0")) {
	            return ("SEVENTY");
	        }
	        if (xwrd.equals("80.0")) {
	            return ("EIGHTY");
	        }
	        if (xwrd.equals("90.0")) {
	            return ("NINETY");
	        }
	        if (xwrd.equals("0.0")) {
	            return (" ");
	        }
	        return ("FAULT");

	    }
}

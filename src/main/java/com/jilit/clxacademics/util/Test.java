/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jilit.clxacademics.util;

import java.security.InvalidKeyException;


public class Test extends Thread {
    
    public static void main(String arr[]) throws OLTEncryption.EncryptionException, InvalidKeyException, Exception
    {
        
       OLTEncryption ol = new OLTEncryption();
       
       try
       {
      
       //System.out.println(ol.decode("PTUtWaa61uw="));//S
       //System.out.println(ol.decode("qXpZekfK2a9wQJwVYr678w=="));//S
       
       //System.out.println(ol.encode("E"));//S
     //  System.out.println(ol.decode("hjVlcPumeUg="));//E
       System.out.println(ol.encode("admin@campus"));//E
       System.out.println(ol.encode("ADMIN"));//
    // System.out.println(ol.decode("ITERSTUT1607A0000064"));//E
     //System.out.println(ol.decode("FUnvyCp7IVRzim589yJarQ=="));//E
    //System.out.println(ol.decode("8dpwG5n4/+w="));//E
//     System.out.println(ol.decode("jPg8zapkqPrpp85k67sSZg=="));//E
// //    System.out.println(ol.decode("xP1gmGNEmB10hKP2iJo+TpaIw1MwJ9DU"));//E
//       System.out.println(ol.encode("ITERSTUT1607A0000064"));//E
//       System.out.println(ol.encode("123456"));//E

      
           //System.out.println("finally block");
       }finally
       {
          // System.out.println("finally block");
       }
       //  System.out.println(ol.decrypt("2wHokMAfjHBzKD+PwbS8UA=="));
       
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jilit.clxacademics.util;

import java.util.Map;


public class PrinterRunnable implements  Runnable{
    private String serverName;
    private int  port;
    private Map map;
    private Map map2;


    public PrinterRunnable( String serverName, int port, Map map, Map map2) {
//        super(name);
        this.serverName = serverName;
        this.port = port;
        this.map = map;
        this.map2 = map2;
    }

    @Override
    public void run(){
        map2 =  new PrintServiceNew().printFile(serverName, port, map);
    }

}

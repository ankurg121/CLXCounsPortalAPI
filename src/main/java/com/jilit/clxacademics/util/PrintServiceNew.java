/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jilit.clxacademics.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class PrintServiceNew {

    public Map printFile(String serverName, int port, Map map) {
        Map resultMap = new HashMap();
        Map outMap = new HashMap();
        try {
            Socket client = new Socket(serverName, port);
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            outMap.putAll(map);
            outMap.put("servicetype", "print");
            outMap.put("method", "printfile");
            oos.writeObject(outMap);
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            resultMap = (Map) ois.readObject();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
            resultMap.put("status", "failure");
            resultMap.put("message", e.getMessage());
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("status", "failure");
            resultMap.put("message", e.getMessage());
            return resultMap;
        }
        return resultMap;
    }
}

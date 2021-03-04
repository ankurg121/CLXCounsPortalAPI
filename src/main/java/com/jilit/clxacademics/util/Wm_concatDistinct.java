package com.jilit.clxacademics.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Wm_concatDistinct {
public static Set<String> distinctRecord(String data){

          String strArray[] = (data != null ? data.toString() : "").split(",");

          Set<String> strSet =  new HashSet<String>();
          strSet.addAll(Arrays.asList(strArray));
          return strSet;
}

}
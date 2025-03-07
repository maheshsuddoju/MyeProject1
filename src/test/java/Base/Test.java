package Base;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        String str = "hello how are you how are";

        String[] strAr = str.split("\\s+");

        int len = strAr.length;

        Map<String,Integer> strMap = new HashMap<String,Integer>();
        int count = 1;



        for(int i=0;i<len;i++){

            for(int j=0;j<len;j++){


                if(strAr[i].equals(strAr[j])){
                    if(strMap.containsKey(strAr[i])){
                        strMap.put(strAr[i],count +1);

                    }else{
                        strMap.put(strAr[i],count);

                    }


                }
            }
        }
        for(Map.Entry<String, Integer> e : strMap.entrySet()){

            if(e.getValue() > 1){
                System.out.println("Duplicate String" + e.getKey());
            }else{
                System.out.println("Unique String" + e.getKey());
            }
        }
    }
}

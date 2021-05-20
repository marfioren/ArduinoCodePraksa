/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataarduino.dataarduino;
import static dataarduino.dataarduino.Time.returnTime;
/**
 *
 * @author m
 */
public class Buffer {
     
    public String outputString;
    static int cutoffASCII = 10; 
    static String bufferReadToString = ""; 
            
    public static void parseByteArray(byte[] readBuffer) {
                int l=readBuffer.length;
                String s = new String(readBuffer);
                bufferReadToString = bufferReadToString.concat(s);
                
   
                    String outputString = bufferReadToString.substring(0, bufferReadToString.indexOf(cutoffASCII) + 1);
                    bufferReadToString = bufferReadToString.substring(bufferReadToString.indexOf(cutoffASCII) + 1);
                    String time=Time.returnTime();
                    if(outputString.contains("h")){
                     outputString=removeSubstring(outputString, "h"); 
                     FirebaseConnection.insertDataCurr(outputString, time, "HumCurr");
                     FirebaseConnection.insertHist(outputString, time, "HumHistory");                     
                    }
                    if(outputString.contains("t")){
                     outputString=removeSubstring(outputString, "t");                    
                     FirebaseConnection.insertDataCurr(outputString, time, "TempCurr");
                     FirebaseConnection.insertHist(outputString, time, "TempHistory");
                    }
                    
                    
                  //  FirebaseConnection.insertData(outputString);
                     
              
      }
   static private String removeSubstring(String original, String sub){
      String removed=original.replaceAll(sub, "");
      return removed;
    }
    
}

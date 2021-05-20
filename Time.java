/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataarduino.dataarduino;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author m
 */
public class Time {
     public static String returnTime() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        String time=formatter.format(date);
        return time;
    }
}

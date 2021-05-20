/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataarduino.dataarduino;
import com.fazecast.jSerialComm.*;
/**
 *
 * @author m
 */
public class Listener implements SerialPortDataListener{
    @Override
    public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_AVAILABLE; }
                   
    @Override
    public void serialEvent(SerialPortEvent event)
         {
           byte[] buffer = new byte[event.getSerialPort().bytesAvailable()];
           event.getSerialPort().readBytes(buffer, buffer.length);                      
           Buffer.parseByteArray(buffer);
          }
}

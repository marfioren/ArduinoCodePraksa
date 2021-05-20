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
public class DataArduino {
    
    public static SerialPort firstAvailableComPort;
    public static void main(String[] args) {
        FirebaseConnection.connect();
       
         SerialPort[] allAvailableComPorts = SerialPort.getCommPorts();
          for(SerialPort eachComPort:allAvailableComPorts)
            System.out.println("List of all available serial ports: " + eachComPort.getDescriptivePortName());
        
        firstAvailableComPort = allAvailableComPorts[0];
        
        firstAvailableComPort.openPort();
        System.out.println("Opened the first available serial port: " + firstAvailableComPort.getDescriptivePortName());

        Listener listenerObject = new Listener();       
        firstAvailableComPort.addDataListener((SerialPortDataListener) listenerObject);
    }
}

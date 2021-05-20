/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataarduino.dataarduino;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.fazecast.jSerialComm.*;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author m
 */
public class FirebaseConnection {
    static Firestore db;
    
    public static void connect(){
        
        try {
            FileInputStream serviceAccount;
            serviceAccount = new FileInputStream("key.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredentials(GoogleCredentials.fromStream(serviceAccount))
          .setDatabaseUrl("https://praksaasseco-default-rtdb.europe-west1.firebasedatabase.app")
          .build();

        FirebaseApp.initializeApp(options);
        db=FirestoreClient.getFirestore();
        System.out.println("Connected");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FirebaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FirebaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean insertDataCurr(String dat, String time, String coll){
        try{
        String col=coll;
        Map<String, Object> data = new HashMap<>();
        data.put("data:", dat);
        data.put("time:", time);
        DocumentReference docRef=db.collection(coll).document("Current");
        docRef.set(data);
           }
           catch(Exception e){
           return false;
           }
       return true;
    }
   public static boolean insertHist(String dat, String time, String coll){
     try{
     String col=coll;
     Map<String, Object> data = new HashMap<>();     
     data.put("data:", dat);
     data.put("time:", time);
     db.collection(col).add(data);
     return true;
        }
        catch(Exception e){
        return false;
        }
    
    }
    
}

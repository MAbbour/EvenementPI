/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Utils;
/*
/**
 *
 * @author Acer
 */

/*import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.util.EncodingUtil;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;*/
public class ExempleClientHttpApi {
    
    

 

 
 public ExempleClientHttpApi() {
     super();
 }
 /*
 public static void main(String[] args) {
 
     String url = "https://api.smsmode.com/http/1.6/sendSMS.do?accessToken=9OQKzL5uQzrVdtq7xfaI4E8ptNrysP3h\n" +
"Bonjour+Maman&numero=33653620655\n" ;
//"https://api.smsmode.com/http/1.6/sendSMS.do?accessToken=Ab1CD2efg3Hi&message=Bon+\n" +
//"anniversaire&numero=33658966021&date_envoi=22022020-12:40";
     String pathSendSms = "/sendSMS.do";
     String pathSendSmsBatch = "/sendSMSBatch.do";
     String accessToken = "xxxxYYYYYYAAAAAZZZZZZ"; //modify (Required)
     String message = "My Message €€ éé ££££ ùùùù";
     String destinataires = "06XXXXXXXXX,07YYYYYYYY"; //Receivers separated by a comma
     String emetteur = "MySenderId"; //Optional parameter, allows to deal with the sms sender
     String optionStop = "1"; //Deal with the STOP sms when marketing send (cf. API HTTP documentation)
     String batchFilePath = "pathCSVFile"; //modify to define the path of CSV file for sms i Batch Mode
 
     ExempleClientHttpApi client = new ExempleClientHttpApi();
 
     client.send_sms_get(url, pathSendSms, accessToken, message, destinataires, emetteur, optionStop);
     client.send_sms_post(url, pathSendSms, accessToken, message, destinataires, emetteur, optionStop);
     client.send_sms_batch(url, pathSendSmsBatch, accessToken, batchFilePath, optionStop);
 }
 
 // send SMS with GET method
 public void send_sms_get(String url, String path, String accessToken, String message, String destinataires, String emetteur, String optionStop) {
     try {
         HttpClient httpClient = new HttpClient();
         String finalUrl = url + path;
         GetMethod httpMethod = new GetMethod(finalUrl);
         httpMethod.addRequestHeader("Content-Type", "plain/text; charset=ISO-8859-15");
 
         NameValuePair params[] = {
             new NameValuePair("accessToken", accessToken),
             new NameValuePair("message", message),
             new NameValuePair("numero", destinataires),
             new NameValuePair("emetteur", emetteur),
             new NameValuePair("stop", optionStop)
         };
 
         httpMethod.setQueryString(EncodingUtil.formUrlEncode(params, "ISO-8859-15"));
         int codeReponse = httpClient.executeMethod(httpMethod);
         if (codeReponse == HttpStatus.SC_OK || codeReponse == HttpStatus.SC_ACCEPTED) {
             System.out.println(convertToString(httpMethod.getResponseBodyAsStream()));
         }
     } catch (Exception e) {
         e.printStackTrace();
         System.err.println("Error during API call");
     }
 }
 
 // send SMS with POST method
 public void send_sms_post(String url, String path, String accessToken, String message, String destinataires, String emetteur, String optionStop) {
     try {
         HttpClient httpClient = new HttpClient();
         String finalUrl = url + path;
         PostMethod httpMethod = new PostMethod(finalUrl);
         httpMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=ISO-8859-15");
  
         NameValuePair data[] = {
             new NameValuePair("accessToken", accessToken),
             new NameValuePair("message", message),
             new NameValuePair("numero", destinataires),
             new NameValuePair("emetteur", emetteur),
             new NameValuePair("stop", optionStop)
         };
 
         httpMethod.setRequestBody(data);
         int codeReponse = httpClient.executeMethod(httpMethod);
         if (codeReponse == HttpStatus.SC_OK || codeReponse == HttpStatus.SC_ACCEPTED) {
             System.out.println(convertToString(httpMethod.getResponseBodyAsStream()));
         }
     } catch (Exception e) {
         e.printStackTrace();
         System.err.println("Error during API call");
     }
 }
 
 // send SMS with POST method (Batch)
 public void send_sms_batch(String url, String path, String accessToken, String batchFilePath, String optionStop) {
     try {
         HttpClient httpClient = new HttpClient();
         String finalUrl = url + path + "?accessToken=" + accessToken + "&stop=" + optionStop;
         PostMethod httpMethod = new PostMethod(finalUrl);
 
         File file = new File(batchFilePath);
         Part[] parts = new Part[1];
         parts[0] = new FilePart(file.getName(), file, "text/csv", null);
 
         httpMethod.setRequestEntity(new MultipartRequestEntity(parts, httpMethod.getParams()));
         int codeReponse = httpClient.executeMethod(httpMethod);
         if (codeReponse == HttpStatus.SC_OK || codeReponse == HttpStatus.SC_ACCEPTED) {
             System.out.println(convertToString(httpMethod.getResponseBodyAsStream()));
         }
     } catch (Exception e) {
         e.printStackTrace();
         System.err.println("Error during API call");
     }
 }
 
 private String convertToString(InputStream stream) {
     Scanner sc = new Scanner(stream);
     StringBuffer sb = new StringBuffer();
     while(sc.hasNext()){
         sb.append(sc.nextLine());
     }
     return sb.toString();
 }*/
}
    


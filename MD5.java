package M11;

import java.io.FileInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Hex;


public class MD5 {

	public static void main(String[] unused) throws Exception{
	    String datafile = "integrity_original_msg.txt";
	    String received_msg1 = "integrity_recieved_msg1.txt";
	    String received_msg2 = "integrity_recieved_msg2.txt";

	    KeyGenerator kg = KeyGenerator.getInstance("DES");
	    kg.init(56);
	    SecretKey key = kg.generateKey();

	    Mac mac = Mac.getInstance("HmacMD5");
	   
	    mac.init(key);

	    FileInputStream fis = new FileInputStream(datafile);
	    byte[] dataBytes = new byte[1024];
	    int nread = fis.read(dataBytes);
	    while (nread > 0) {
	      mac.update(dataBytes, 0, nread);
	      nread = fis.read(dataBytes);
	    };
	  byte[] macbytes = mac.doFinal();
	  System.out.println("MAC(in hex):: " + Hex. encodeHexString(macbytes));
	  
	  FileInputStream fis1 = new FileInputStream(received_msg1);
	    byte[] dataBytes1 = new byte[1024];
	    int nread1 = fis1.read(dataBytes1);
	    while (nread1 > 0) {
	      mac.update(dataBytes1, 0, nread1);
	      nread1 = fis1.read(dataBytes1);
	    };
	  byte[] macbytes1 = mac.doFinal();
	  System.out.println("MAC(in hex)  1:: " + Hex.encodeHexString(macbytes1));
	  
	  FileInputStream fis2 = new FileInputStream(received_msg2);
	    byte[] dataBytes2 = new byte[1024];
	    int nread2 = fis2.read(dataBytes2);
	    while (nread2 > 0) {
	      mac.update(dataBytes2, 0, nread2);
	      nread2 = fis2.read(dataBytes2);
	    };
	  byte[] macbytes2 = mac.doFinal();
	  System.out.println("MAC(in hex) 2:: " + Hex.encodeHexString(macbytes2));
	  
	  if(Hex.encodeHexString(macbytes).equalsIgnoreCase(Hex.encodeHexString(macbytes1)))
	  {
		  System.out.println("Transit 1 was received successfully");
	  }else
	  {
		  System.out.println("Transit 1 was not received successfully");
	  }
	  
	  if(Hex.encodeHexString(macbytes).equalsIgnoreCase(Hex.encodeHexString(macbytes2)))
	  {
		  System.out.println("Transit 2 was received successfully");
	  }else
	  {
		  System.out.println("Transit 2 was not received successfully");
	  }
	  
	  }
}
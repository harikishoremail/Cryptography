package m4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ElectronicCodeBookCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File filePlainText = new File("src/m4/plaintext.txt");
		
		File fileCipherText = new File("src/m4/CipherText.txt");
		
		try
		{
			if(!fileCipherText.exists())
			{			
				fileCipherText.createNewFile();
				//System.out.println(fileCipherText.getAbsolutePath());
			}
		
			BufferedReader brPlainText = new BufferedReader(new FileReader((new File(filePlainText.getAbsolutePath().toString()))));
			BufferedWriter bwCipher = new BufferedWriter(new FileWriter(((new File(fileCipherText.getAbsolutePath().toString())))));
			
			String strBlockKey = "MSITJNTU";
			
			String line = "";
			int i=0;
			while((line=brPlainText.readLine())!=null)
			{
				
				//boolean endOfLine = false;
				int j=0;
				while(i<line.length())
				{
					String strPlainBlock = "";
					while((j<strBlockKey.length()))
					{
						if((i+j)<line.length())
						{
							strPlainBlock = strPlainBlock + line.charAt(i+j);
							
						}
						j++;
						//i++;
					}
					i = i + j;
					j=0;
					//System.out.println(strPlainBlock);
					String encryptedText = encryptionECB(strPlainBlock,strBlockKey);					
					bwCipher.write(convertToChars(encryptedText));				
					
				}
				bwCipher.newLine();
				i=0;	
				
			}
			brPlainText.close();
			bwCipher.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// Decryption
		try
		{
			BufferedReader brCipher = new BufferedReader(new FileReader(fileCipherText));
			String line="";
			String strBlockKey = "MSITJNTU";
			int i=0;
			while((line=brCipher.readLine())!=null)
			{
				int j=0;
				while(i<line.length())
				{
					String strPlainBlock = "";
					while((j<strBlockKey.length()))
					{
						if((i+j)<line.length())
						{
							strPlainBlock = strPlainBlock + line.charAt(i+j);
							
						}
						j++;
						//i++;
					}
					i = i + j;
					j=0;
					//System.out.println(strPlainBlock);
					String decryptedText = decryption(strPlainBlock,strBlockKey);
					//String encryptedText = encryptionECB(strPlainBlock,strBlockKey);					
					//bwCipher.write(convertToChars(encryptedText));				
					System.out.print(convertToChars(decryptedText));
				}
				//bwCipher.newLine();
				System.out.println("");
				i=0;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	private static String decryption(String strPlainBlock, String strBlockKey) {
		// TODO Auto-generated method stub
		
		String encryptText = "";
		String plain = convertToBin(strPlainBlock);
		String blockKey = convertToBin(strBlockKey);
		
		encryptText = performXOR(plain,blockKey);
		
		return encryptText;
		//return null;
	}

	private static String convertToChars(String encryptedText) {
		// TODO Auto-generated method stub
		int len = 0;
		String ch ="";	
		while(len<(encryptedText.length()/8))
		{
			String charat = encryptedText.substring(len*8, (len+1)*8);
			String rev = new StringBuffer(charat).reverse().toString();
			//System.out.println(rev);
			
			double decimal=0;
			int b=0;
			while(b<8)
			{
				
				decimal = decimal + ((Math.pow(2, b))*Double.parseDouble(rev.substring(b,b+1).toString()));
				b++;
			}
			ch=ch+(char)(decimal);
			len++;
		}
		return ch;
	}

	private static String encryptionECB(String strPlainBlock, String strBlockKey) {
		// TODO Auto-generated method stub
		String encryptText = "";
		String plain = convertToBin(strPlainBlock);
		String blockKey = convertToBin(strBlockKey);
		
		encryptText = performXOR(plain,blockKey);
		
		return encryptText;
	}

	private static String performXOR(String plain, String key) {
		// TODO Auto-generated method stub
		int tem =0 ;
		String cipher="";
		while(tem<plain.length())
		{
			
				char ch1 = plain.charAt(tem);
				char ch2 = key.charAt(tem);
				
				if(ch1=='1' && ch2=='1')
				{
					cipher = cipher+'0';
				}else if(ch1=='1' && ch2=='0')
				{
					cipher = cipher+'1';
				}else if((ch1=='0' && ch2=='1'))
				{
					cipher = cipher+'1';
				}else if((ch1=='0' && ch2=='0'))
				{
					cipher = cipher+'0';
				}
				
				//cipher = cipher+(ch1^ch2);
				
			tem++;
		}
		return cipher;
	}

	private static String convertToBin(String str) {
		// TODO Auto-generated method stub
		int ch = 0;
		String retGeneratedBin = "";
		
		while(ch<str.length())
		{
			int charAt = (int)str.charAt(ch);
			int bit =0;
			String strTemp="";
			while(bit<8)
			{
				strTemp = strTemp + (charAt%2);
				charAt = charAt/2;
				bit++;
			}
			String rev = new StringBuilder(strTemp).reverse().toString();
			retGeneratedBin = retGeneratedBin + rev;
			ch++;
		}
		
		return retGeneratedBin;
	}

}

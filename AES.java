package Week2M10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AES {
	String result;
	String keyresult;
	String keyMatrix[][]=new String[5][5];
	String messageMatrix[][]=new String[5][5];
	public AES() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AES aes=new AES();
		System.out.println("Welcome to Advancede Encrypted Standerd");
		System.out.println("1.Encrypt");
		System.out.println("2.Decrypt");
		System.out.println("Type your Choice.");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		if(choice==1){aes.encryptAES();
		}else if(choice==2){ aes.decryptAES();}else
		{System.out.println("You have enter the wrong Option :( "); return;}
	}

	private void decryptAES() {
		// TODO Auto-generated method stub
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("integrity_original_msg.txt"));
			String fileString=br.readLine();
			while(fileString != null){
				System.out.println(fileString.replaceAll("\\s+",""));
				fileString=br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void encryptAES(){
		// TODO Auto-generated method stub
		BufferedReader br;
		AES aes1=new AES();
		try {
			br = new BufferedReader(new FileReader("Plaintext.txt"));
			String fileString=br.readLine();
			String key="just a cup";
			while(fileString != null){
				//System.out.println(fileString);
				this.result=decimalToHexadecimal(fileString);
				this.keyresult=decimalToHexadecimal(key);	
				fileString=br.readLine();
				break;
			}
			aes1.insertIntoMatrix(this.result,this.keyresult);
			//System.out.println(this.result);
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	private void insertIntoMatrix(String result2, String keyresult) {
		// TODO Auto-generated method stub\
		int count=0;
		String arrmessage[]=result2.split(" ");
		String arrkey[]=keyresult.split(" ");
		int length=arrkey.length;
		for(int i=0;i<keyMatrix.length;i++){
			for(int j=0;j<keyMatrix.length;j++){
				System.out.println(arrkey[count]);
				if(count<length){
					this.keyMatrix[i][j]=arrkey[count];
					this.messageMatrix[j][i]=arrmessage[count];
					count++;
				}else {
					break;
				}
			}
			if(count<length){
				break;
			}
			
		}

	}

	private String decimalToHexadecimal(String string){
		int rem;
		char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		String str2=""; 
		String result1="";

		for(int i =0;i<string.length();i++){
			int num=0;
			str2="";
			num=(int)(string.charAt(i));
			//System.out.println(num);
			while(num>0)
			{
				rem=num%16; 
				str2=hex[rem]+str2;
				num=num/16;
				//System.out.print(string.charAt(i)+" ");				
			}
			//System.out.println(str2);
			result1+=str2+" ";  

		}
		System.out.print(result1);
		return result1;
	}	

}

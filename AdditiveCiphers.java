package Week1M4;

import java.util.Scanner;

public class AdditiveCiphers {
	static Scanner sc=null;
	public void encrypt(){
		System.out.println("Enter String to Ciper");
		String str=sc.next();
		System.out.println("Enter the key");
		int key=sc.nextInt();
		for(int i=0;i<str.length();i++){
			int alp=(int)str.charAt(i)+key;
			if(alp>=90){
				alp=64+(alp-90);
			}
			System.out.println((char)alp);
		}
			
	}
	public void decrypt(){
		System.out.println("Enter String to DEcrypt");
		String str=sc.next();
		System.out.println("Enter the key");
		int key=sc.nextInt();
		for(int i=0;i<str.length();i++){
			int alp=(int)str.charAt(i)-key;
			if(alp<65){
				alp=91-(65-alp);
			}
			System.out.println((char)alp);
		}
	}
	AdditiveCiphers(){
		sc=new Scanner(System.in);
	}
	public static void main(String ars[]){
		
		AdditiveCiphers a=new AdditiveCiphers();
		System.out.println("1.Encrypt\n2.Decrypt");
		int ch=sc.nextInt();
		if(ch==1){
			a.encrypt();
		}else if(ch==2){
			a.decrypt();
		}else {
			System.out.println("You Enter the Wrong Option");
		}
		//
		
		
	}
}

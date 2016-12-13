package M5;

import java.util.Scanner;

public class VignereSubstitution {
	public static char arr[][]=new char[26][26];
	static int kle;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag=true;
		int start=0;

		while(flag){
			int count=0;
			for(int i=0;i<26;i++){
				if(start!=0){
					if((i+start<26)){
						//System.out.print((char)(i+start+65)+" ");
						arr[start][i]=(char)(i+start+65);
					}else {
						//System.out.print((char)(count+65)+" ");
						arr[start][i]=(char)(count+65);
						count++;
					}
				}else{
					//System.out.print((char)(i+65)+" ");
					arr[start][i]=(char)(i+65);
				}

			}
			start++;
			//System.out.println(count);
			if(start==26){
				flag=false;
			}
		}
		//		for(int i=0;i<26;i++){
		//			for(int j=0;j<26;j++){
		//				System.out.print(arr[i][j]+" ");
		//			}
		//			System.out.println();
		//		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Type the Message : ");
		Scanner s=new Scanner(System.in);
		String message=sc.next();
		System.out.println("Type your Key : ");
		String key = s.next();
		kle=key.length();
		int c=0;
		int keylen=key.length();
		while(key.length()!=message.length()){
			if(c==keylen){
				c=0;
			}
			key+=key.charAt(c);
			c++;
		}
		key=key.toUpperCase();
		message=message.toUpperCase();
		//System.out.println(key);
		VignereSubstitution v=new VignereSubstitution();
		System.out.println("1.Encrypt\n2.Decrypt");
		
		int ss=s.nextInt();
		if(ss==1){
			v.Enrypt(key,message);
		}else if(ss==2) {
			v.Dycrypt(key,message);
		}else{System.out.println("Wrong option");}

	}

	private void Dycrypt(String key, String message) {
//		message=message.replaceAll("\\s+","");
//		// TODO Auto-generated method stub
//		for(int i=0;i<arr[0].length;i++){
//			int i1=Math.abs(65-(int)(message.charAt(i)));	
//			System.out.print(message.charAt(i)+" ");
//			//System.out.print(arr[i1][j1]+" ");
//		}

	}

	private void Enrypt(String key, String message) {
		// TODO Auto-generated method stub
		message=message.replaceAll("\\s+","");
		for(int i=0;i<message.length();i++){
				int j1=Math.abs(65-(int)(message.charAt(i)));
				int i1=Math.abs(65-(int)(key.charAt(i)));
				//System.out.print(i1+" "+j1);
				System.out.print(arr[i1][j1]+" ");
			}
	}

}


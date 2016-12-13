package Week1M4;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ColumnarTransposition {
	public String  sorted(String string){
		Collator col = Collator.getInstance(new Locale("en", "EN"));
		String[] s1= string.split("");
		Arrays.sort(s1, col);
		String sorted = "";
		for (int i = 0; i < s1.length; i++)
		{
			sorted += s1[i];
		}
		System.out.println(sorted);
		return sorted;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ColumnarTransposition a=new ColumnarTransposition();
		System.out.println("1.Encrypt\n2.Decrypt");
		int ch=sc.nextInt();
		if(ch==1){
			a.encrypt();
		}else if(ch==2){
			a.decrypt();
		}else {
			System.out.println("You Enter the Wrong Option");
		}
	}

	private void decrypt() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String to Ciper");
		ColumnarTransposition a=new ColumnarTransposition();
		String message=sc.nextLine();

		System.out.println("Enter the key");
		String key=sc.next();
		String sortkey=a.sorted(key);
		int keylen=key.length(),messagelen=message.length();
		while(messagelen%keylen!=0){
			messagelen++;
		}
		int column= messagelen/keylen;
		char[][] ch=new char[key.length()][column];
		char[][] ch1=new char[column][key.length()];
		int j=0;
		int k=0;
		for(int i=0;i<message.length();i++){
			ch[j][k]=message.charAt(i);
			if(k==column-1){

				k=0;
				j++;
				System.out.println();
			}else{
				k++;
			}
		}
		/**for(int i = 0; i < ch[0].length; i++) {
	        for(int j1 = 0; j1 <ch.length; j1++) {
	           
	           ch1[i][j1]=ch[j1][i];
	           System.out.print(ch1[i][j1]+" ");
	        }System.out.println();
	    }**/
		int arr[]=new int[key.length()];
		k=0;
		for(k=0;k<key.length();k++){
			for(int i=0;i<key.length();i++){
				if(key.charAt(k)==sortkey.charAt(i)){
					arr[k]=i;
					//System.out.println(arr[k]);
					break;
				}

			}
		}
		String messaageencrypt="";

		for(int i1 = 0; i1 < ch1.length; i1++) {
	        for(int j1 = 0; j1 <ch1[0].length; j1++) {
	            messaageencrypt+=ch1[i1][arr[j1]];
	        }
	    }
		System.out.println(messaageencrypt);
		

	}

	private void encrypt() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ColumnarTransposition a=new ColumnarTransposition();
		System.out.println("Enter String to Ciper");
		String message=sc.nextLine();

		System.out.println("Enter the key");
		String key=sc.next();
		String sortkey=a.sorted(key);
		message=message.replaceAll("\\s+","");
		int keylen=key.length(),messagelen=message.length();
		while(messagelen%keylen!=0){
			messagelen++;
		}
		int column= messagelen/keylen;
		char[][] ch=new char[column][key.length()];
		int j=0,k=0;
		for(j=0;j<column;j++){
			for(k=0;k<key.length();k++){

				ch[j][k]='x';
			}
		}
		j=0;
		k=0;
		for(int i=0;i<message.length();i++){
			ch[j][k]=message.charAt(i);
			if(k==key.length()-1){

				k=0;
				j++;
				System.out.println();
			}else{
				k++;
			}
		}
		String messaageencrypt="";
		k=0;j=0;
		int arr[]=new int[key.length()];
		for(k=0;k<ch[j].length;k++){
			for(int i=0;i<key.length();i++){
				if(sortkey.charAt(k)==key.charAt(i)){
					arr[k]=i;
					break;
				}

			}
		}
		for(int i = 0; i < ch[0].length; i++) {
	        for(int j1 = 0; j1 <ch.length; j1++) {
	            messaageencrypt+=ch[j1][arr[i]];
	        }
	    }
		System.out.println(messaageencrypt);
	} 

}

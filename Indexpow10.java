package Week1;

import java.util.Scanner;

public class Indexpow10 {
	public void Less(float input){
		int count=0;
		while(input<1){
			input=input*10;
			count++;
		}
		String result = String.format("%.1f", input);
		System.out.println(result+"*"+10+"^-"+count);
	}
	public void Great(float input){
		int count=0;
		while(input>10){
			input=input/10;
			count++;
		}
		String result = String.format("%.1f", input);
		System.out.println(result+"*"+10+"^"+count);
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		Indexpow10 ind=new Indexpow10();
		float input=sc.nextFloat();
		if(input>10){
			ind.Great(input);
		}else if(input<1){
			ind.Less(input);
		}
		
		
	}

}

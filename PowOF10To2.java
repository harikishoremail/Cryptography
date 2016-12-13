package Week1;

import java.util.Scanner;

public class PowOF10To2 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int res;
		double input = sc.nextDouble();
		int count=0;
		while(input>100){
			input=input/10;
			count++;
		}
		String result = String.format("%.0f", input);
		res=Integer.parseInt(result);
		System.out.println("1. "+result+"*"+10+"^"+count);
		count=(count/3)*10;
		System.out.println("2. "+2+"^"+count);
		while(res>0){
			res=res/2;
			count++;
		}
		System.out.println("3. "+2+"^"+count);
	}

}

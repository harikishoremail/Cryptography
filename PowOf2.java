package Week1;
import java.util.Scanner;
public class PowOf2 {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
		int count=0;
		while(input>0){
			input=input/2;
			count++;
		}
		System.out.println(2+"^"+count);
	}
}

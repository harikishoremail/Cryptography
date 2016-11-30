package Week1;
import java.util.Scanner;

public class PrimeFraction {

	public boolean checkPrime(int num){
		for(int i=2;i<=num/2;i++){if(num%i==0) {
			return false;} }return true;
	}

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		PrimeFraction p=new PrimeFraction();
		int input=sc.nextInt();
		int index=0;
		int primenumbers[]=new int[input];
		for(int i=2;i<input;i++){
			if(p.checkPrime(i)){
				primenumbers[index]=i;
				index++;
			}
		}
		int count;
		for(int i=0;i<primenumbers.length;i++){
			count=0;
			while(primenumbers[i]!=0 && input%primenumbers[i]==0){
				input=input/primenumbers[i];
				//System.out.println(input);
				count++;
				if(input%primenumbers[i]!=0){
					System.out.print(primenumbers[i]+"^"+count+"*");
					break;
				}
				
			}
		}
		
	}

}

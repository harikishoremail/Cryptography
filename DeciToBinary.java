package Week1;

import java.util.Scanner;

public class DeciToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int num=sc.nextInt();
		int binary[]=new int[16];
		String bn=String.valueOf(num);
		
			
		try{
		
			int index=0;
			while(num>0){
				binary[index++]=num%2;
				num=num/2;
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Given Number is 32bit it support only 16 bit");
			return;
		}
		for(int i =0;i<binary.length;i++){
			System.out.print(binary[i]+" ");
		}
	}

}

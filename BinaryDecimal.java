package Week1;

import java.util.Scanner;

public class BinaryDecimal {

	  public int BinaryToDecimal(int binaryNumber){
	 
	    int decimal = 0;
	    int p = 0;
	    while(true){
	      if(binaryNumber == 0){
	        break;
	      } else {
	          int temp = binaryNumber%10;
	          decimal += temp*Math.pow(2, p);
	          binaryNumber = binaryNumber/10;
	          p++;
	       }
	    }
	    return decimal;
	  }
	public static void main(String[] args){
		Scanner sc =new Scanner(System.in);
		int num=sc.nextInt();
		BinaryDecimal b=new BinaryDecimal();
		System.out.println(b.BinaryToDecimal(num));
	}

}

package Week1;

import java.util.Scanner;

 class SubTwoBinary {
	 public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	
	int i,m,n,sum,carry=0;
	System.out.println ("enter 1st binary number");
	int n1 = sc.nextInt();
	System.out.println ("enter 2nd binary number");
	int n2 = sc.nextInt();
	
	int arr[] = new int[16];
	for(int j=0;j<arr.length;j++){
		arr[j]=0;
	}
	for(i=15;i>=0;i--){
		m=n1%10;
		n=n2%10;
		n1=n1/10;
		n2=n2/10;
		int sub = (m+ carry)-n;
	    arr[i] = (sub + 2) % 2;	
	    carry = (sub < 0 ? 1 : 0);
	}
	for(i=0;i<arr.length;i++){
		System.out.print(arr[i]);
	}
}

}

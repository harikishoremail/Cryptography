package M12;

import java.util.*;
public class DiffieHellman
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the prime module and generater");
		int Xa=sc.nextInt();
		int Xb=sc.nextInt();
		System.out.println("Enter Alice random number : ");
		int p=sc.nextInt();
		System.out.println("Enter Bob random number : ");
		int a=sc.nextInt();
		int Ya=(int)((Math.pow(Xa,p))%Xb);
		int Yb=(int)((Math.pow(Xa,a))%Xb);
		System.out.println(Ya+" "+Yb);
		int Ka=(int)((Math.pow(Yb,p))%Xb);
		int Kb=(int)((Math.pow(Ya,a))%Xb);
		System.out.println(Ka+" "+Kb );
		if(Ka==Kb)
		{
			System.out.println("successful");
		}
		else
		{
			System.out.println("failed");
		}
	}
}
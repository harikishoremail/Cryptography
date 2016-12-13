package Week2M9;

import java.io.IOException;
import java.util.Scanner;

public class TEA {

    private static int delta = 0x9E3779B9; 

    private static int[] key = { 78945677, 87678687, 234234, 234234 };

    public void encrypt(int[] v, int[] k) {

        int v0 = v[0], v1 = v[1], sum = 0, n = 32;
        int k0 = k[0], k1 = k[1], k2 = k[2], k3 = k[3]; 
        while (n-- > 0) {
            sum += delta;
            v0 += ((v1 << 4) + k0) ^ (v1 + sum) ^ ((v1 >>> 5) + k1);
            v1 += ((v0 << 4) + k2) ^ (v0 + sum) ^ ((v0 >>> 5) + k3);
        }
        v[0] = v0;
        v[1] = v1;
        System.out.println("Encrypt"+v0 + "," + v1);

    }

    public void decrypt(int[] v, int[] k) {
        int v0 = v[0], v1 = v[1], sum = 0xC6EF3720, n = 32; 
        int k0 = k[0], k1 = k[1], k2 = k[2], k3 = k[3]; 
        while (n-- > 0) {
            v1 -= ((v0 << 4) + k2) ^ (v0 + sum) ^ ((v0 >>> 5) + k3);
            v0 -= ((v1 << 4) + k0) ^ (v1 + sum) ^ ((v1 >>> 5) + k1);
            sum -= delta;
        }
        v[0] = v0;
        v[1] = v1;

        System.out.println("Decrypt"+v0 + "," + v1);
    }

    public static void main(String[] args) throws IOException {

        TEA tea = new TEA();
        int n = 0;
        int cc[] = new int[100];

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.println("Enter 4 number to encrypt: ");
            n = input.nextInt();
            cc[i] = n;

        }

        tea.encrypt(cc, key);
        tea.decrypt(cc, key);

    }

}

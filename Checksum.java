package M11;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Checksum {
	
	public static void main(String args[]) {
		BufferedReader br,br1;
		try {
			br = new BufferedReader(new FileReader("integrity_original_msg.txt"));
			br1 = new BufferedReader(new FileReader("integrity_recieved_msg2.txt"));
			String fileString=br.readLine();
			String fileString1=br1.readLine();
			String result="";
			String result1="";
			while(fileString != null && fileString1 !=null){
				//System.out.println(fileString.replaceAll("\\s+",""));
				//System.out.println(fileString1.replaceAll("\\s+",""));
				int checksum = generateChecksum(fileString.replaceAll("\\s+",""));
				int checksum1 = generateChecksum(fileString1.replaceAll("\\s+",""));
				
				//System.out.println("The checksum generated is = "
				//+ Integer.toHexString(checksum));
				result+=Integer.toHexString(checksum);
				result1+=Integer.toHexString(checksum1);
				fileString=br.readLine();
				fileString1=br1.readLine();
			}
			if(result.equalsIgnoreCase(result1)){
				System.out.println("Data is received without error.");
			}else{System.out.println("There is an error in the received data.");}
			//System.out.println(result);
			br.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static int generateChecksum(String s) {
		String hex_value = new String();
		int x = 0,i = 0, checksum=0;
		for(i=0 ; i < s.length()-2 ; i=i+2) {
			x = (int) (s.charAt(i));
			hex_value = Integer.toHexString(x);
			x = (int) (s.charAt(i+1));
			hex_value = hex_value + Integer.toHexString(x);
			// Extract two characters and get their hexadecimal ASCII values
			
			System.out.println(s.charAt(i)+""+s.charAt(i+1) + " : "
								+ hex_value);
			x = Integer.parseInt(hex_value, 16);
			checksum += x;
		}

		checksum += x;
		hex_value = Integer.toHexString(checksum);
		
		if(hex_value.length() > 4) {
			int carry = Integer.parseInt((""+hex_value.charAt(0)), 16);
			hex_value = hex_value.substring(1,5);
			checksum = Integer.parseInt(hex_value, 16);
			checksum += carry;
		}
		checksum = generateComplement(checksum);
		return checksum;
	}
	private static int generateComplement(int checksum) {
		checksum = Integer.parseInt("FFFF", 16) - checksum;
		return checksum;
	}
}

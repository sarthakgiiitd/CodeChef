import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * @author Sarthak Goyal
 * 21-May-2017 10:07:49 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			int S = Integer.parseInt(br.readLine());
			while (S-- > 0) {
				int len = Integer.parseInt(br.readLine());
				String inputtmp = br.readLine();
				boolean valid = true;
				if (len % 2 == 0) {
					valid = false;
					System.out.println("no");
					continue;
				}
				String[] input = inputtmp.split(" ");
				int[] inputint = new int[input.length];
				for (int q = 0; q < input.length; q++) {
					inputint[q] = Integer.parseInt(input[q]);
				}
				
				if ((inputint[0] != 1) || (inputint[inputint.length -1] != 1)) {
					valid = false;
					System.out.println("no");
					continue;
				}
				
				int mid = inputint.length / 2;
				for (int i = 1; i <= mid; i++) {
					if (inputint[i] != i+1) {
						valid = false;
						break;
					}
				}
				
				int q = 2;
				for (int j = inputint.length -2; j >= mid; j--) {
					if (inputint[j] != q) {
						valid = false;
						break;
					}
				q++;
				}
				if (valid == false) {
					System.out.println("no");
				} else {
					System.out.println("yes");
				}
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

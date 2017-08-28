import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * @author Sarthak Goyal
 * 01-Jun-2017 5:04:11 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			int T = Integer.parseInt(br.readLine());
			while (T-- > 0) {
				int n = Integer.parseInt(br.readLine());
				String row1 = br.readLine();
				String row2 = br.readLine();
				int count1 = 0;
				int count2 = 0;
				int countf = 0;
				int hello = 0;
				for (int i = 0; i < row2.length(); i++) {
					int val1 = row1.charAt(i);
					int val2 = row2.charAt(i);
					boolean cond1 = (val1 == '*');
					boolean cond2 = (val2 == '*');
					if (cond1) {
						count1++;
					}
					if (cond2) {
						count2++;
					}
					if (cond1 || cond2 ) {
						countf++;
					}
					
					if (cond1 && cond2) {
						hello++;
					}
				}
				
				if (((count1 == 0) && (count2 == 1)) || ((count1 == 1) && (count2 == 0))) {
					System.out.println(1);
					continue;
				}
				if (countf > 0) {
					countf--;
				}
				
				if (hello > 0) {
					countf++;
				}
				System.out.println(countf);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

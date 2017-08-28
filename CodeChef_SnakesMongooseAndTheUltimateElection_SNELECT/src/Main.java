import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * @author Sarthak Goyal
 * 01-Jun-2017 2:46:01 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			int T = Integer.parseInt(br.readLine());
			while (T-- > 0) {
				String input = br.readLine();
				StringBuilder sb = new StringBuilder(input);
				//sb.replace(1,2,"india");
				//System.out.println(sb);
				for (int i = 0; i < sb.length()-1; i++) {
					char val = sb.charAt(i);
					char val2 = sb.charAt(i+1);
					if (val == 's') {
						if (val2 == 'm') {
							sb.replace(i, i+2, "M");
						}
					} else if (val == 'm') {
						if (val2 == 's') {
							sb.replace(i, i+2, "M");
						}
					}
				}
				
				int countsnakes = 0;
				int countmongoose = 0;
				for(int j = 0; j < sb.length(); j++) {
					char val = sb.charAt(j);
					if ((val == 'm') || (val == 'M')) {
						countmongoose++;
					} else {
						countsnakes++;
					}
				}
				
				System.out.println("mongoose : " + countmongoose);
				System.out.println("snakes : " + countsnakes);
				
				if (countmongoose > countsnakes) {
					System.out.println("mongooses");
				} else if (countmongoose == countsnakes) {
					System.out.println("tie");
				} else {
					System.out.println("snakes");
				}
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Sarthak Goyal
 * 02-Jun-2017 5:23:47 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			int T = Integer.parseInt(br.readLine());
			while (T-- > 0) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				int[] a = new int[5];
				int q = 0;
				while (st.hasMoreTokens()){
					int num = Integer.parseInt(st.nextToken());
					a[q] = num;
					System.out.println(num);
				q++;
				}
//				for (int i = 500; i > 500 - n; i--) {
//					System.out.print(i);
//					if (i != 501 - n) {
//						System.out.print(" ");
//					}
//				}
//				System.out.println();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * @author Sarthak Goyal
 * 19-May-2017 12:51:04 AM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			int T = Integer.parseInt(br.readLine());
			while (T-- > 0) {
				String nmtmp = br.readLine();
				String[] nm = nmtmp.split(" ");
				int n = Integer.parseInt(nm[0]);
				int m = Integer.parseInt(nm[1]);
				if (n == 0) {
					System.out.println();
					System.out.println();
				} else {
					if (m == 0) {
//						System.out.println("n : " + n);
//						System.out.println("m : " + m);
						for (int i = 0; i < n; i = i+2) {
							System.out.print(i+1);
							System.out.print(" ");
						}
						System.out.println();
						for (int j = 1; j < n; j = j+2) {
							System.out.print(j+1);
							System.out.print(" ");
						}
						System.out.println();
						
					} else {
						String minputtmp = br.readLine();
						String[] minput = minputtmp.split(" ");
						int[] minput2 = new int[minput.length];
						for(int k = 0; k < minput.length; k++) {
							minput2[k] = Integer.parseInt(minput[k]);
						}
						for (int i = 0; i< minput.length; i++) {
							int val = minput2[i];
							for (int j = i+1; j < minput.length; j++) {
								int val2 = minput2[j];
								if (val2 < val) {
									minput2[i] = val2;
									minput2[j] = val;
								}
							}
						}
//						for (int i = 0; i < minput.length; i++) {
//							System.out.print(minput2[i] + " ");
//						}
						int[] jobsleft = new int[n-m];
						int q = 0;
						int p = 0;
						for (int z = 0; z < n; z++) {
							if (q < minput2.length) {
								if (z+1 == minput2[q]) {
									q++;
								} else {
									jobsleft[p] = z+1;
									p++;
								}
							} else {
								jobsleft[p] = z+1;
								p++;
							}
							
						}
//						for (int i2 = 0; i2 < jobsleft.length; i2++) {
//						System.out.print(jobsleft[i2] + " ");
//					    }
//						System.out.println();
						
						for (int s = 0; s < jobsleft.length; s = s+2) {
							System.out.print(jobsleft[s] + " ");
						}
						System.out.println();
						for (int s2 = 1; s2 < jobsleft.length; s2 = s2 + 2) {
							System.out.print(jobsleft[s2] + " ");
						}
						System.out.println();

					}
					
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			}
}

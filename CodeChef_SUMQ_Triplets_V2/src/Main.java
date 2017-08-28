import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Sarthak Goyal
 * 02-Jun-2017 6:59:09 PM
 * 
 */
public class Main {
	public static void main(String[] args) {
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			int T = Integer.parseInt(br.readLine());
			while (T-- > 0) {
				int[] length = new int[3];
				String line1 = br.readLine();
				StringTokenizer st1 = new StringTokenizer(line1);
				for (int i1 = 0; i1 < 3; i1++) {
					int val = Integer.parseInt(st1.nextToken());
					length[i1] = val;
				}
				int p = length[0];
				int q = length[1];
				int r = length[2];
				long[] A = new long[p];
				long[] B = new long[q];
				long[] C = new long[r];
				String line2 = br.readLine();
				StringTokenizer st2 = new StringTokenizer(line2);
				for (int i2 = 0; i2 < p; i2++) {
					A[i2] = Long.parseLong(st2.nextToken());
				}
				String line3 = br.readLine();
				StringTokenizer st3 = new StringTokenizer(line3);
				for (int i3 = 0; i3 < q; i3++) {
					B[i3] = Long.parseLong(st3.nextToken());
				}
				String line4 = br.readLine();
				StringTokenizer st4 = new StringTokenizer(line4);
				for(int i4 = 0; i4 < r; i4++) {
					C[i4] = Long.parseLong(st4.nextToken());
				}
				HashSet<Long> hashA = new HashSet<>();
				for(int i5 = 0; i5 < A.length; i5++) {
					long val = A[i5];
					hashA.add(val);
				}
				Long[] Acopy2 = hashA.toArray(new Long[hashA.size()]);
				long[] Acopy = new long[Acopy2.length];
				for (int i = 0; i < Acopy2.length; i++) {
					long val = Acopy2[i].longValue();
					Acopy[i] = val;
				}
				HashSet<Long> hashB = new HashSet<>();
				for(int i6 = 0; i6 < B.length; i6++) {
					long val = B[i6];
					hashB.add(val);
				}
				Long[] Bcopy2 = hashB.toArray(new Long[hashB.size()]);
				long[] Bcopy = new long[Bcopy2.length];
				for (int i = 0; i < Bcopy2.length; i++) {
					long val = Bcopy2[i].longValue();
					Bcopy[i] = val;
				}
				HashSet<Long> hashC = new HashSet<>();
				for(int i6 = 0; i6 < C.length; i6++) {
					long val = C[i6];
					hashC.add(val);
				}
				Long[] Ccopy2 = hashC.toArray(new Long[hashC.size()]);
				long[] Ccopy = new long[Ccopy2.length];
				for (int i = 0; i < Ccopy2.length; i++) {
					long val = Ccopy2[i].longValue();
					Ccopy[i] = val;
				}
				Arrays.sort(Acopy);
				Arrays.sort(Bcopy);
				Arrays.sort(Ccopy);
				long finalans = 0;
				for (int i = 0; i < Bcopy.length; i++) {
					long y = Bcopy[i];
					long sumx = 0;
					int county = Acopy.length;
					
					for (int j = 0; j < Acopy.length; j++) {
						long val = Acopy[j];
						if (val > y) {
							county = j;
							
							break;	
						} else {
							sumx = sumx + val;
						}
					}
					long brack1 = (y*county) + sumx;
					brack1 = brack1 % 1000000007;
					long sumz = 0;
					int county2 = Ccopy.length;
					for (int k = 0; k < Ccopy.length; k++) {
						long val = Ccopy[k];
						if (val > y) {
							county2 = k;
							break;
						} else {
							sumz = sumz + val;
						}
					}
					long brack2 = (y*county2 + sumz) % 1000000007;
					long ans = ((brack1*brack2) % 1000000007);
					finalans = finalans + ans;
					finalans = finalans % 1000000007;
				}
				finalans = finalans % 1000000007;
				System.out.println(finalans);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void printarray(long[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}

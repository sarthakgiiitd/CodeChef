import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
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
				
				Arrays.sort(A);
				Arrays.sort(B);
				Arrays.sort(C);
//				System.out.println("A printing----");
//				printarray(A);
				
				int alencopy = 0;
				long[] Acopy = new long[A.length];
				Acopy[0] = A[0];
				for(int g = 1; g < A.length; g++) {
					if (A[alencopy] != A[g]) {
						alencopy++;
						Acopy[alencopy] = A[g];
					} 
				}
				alencopy++;

				int clencopy = 0;
				long[] Ccopy = new long[C.length];
				Ccopy[0] = C[0];
				for(int h = 1; h < C.length; h++) {
					if (C[clencopy] != C[h]) {
						clencopy++;
						Ccopy[clencopy] = C[h];
					} 
				}
				clencopy++;
				
				int blencopy = 0;
				long[] Bcopy = new long[B.length];
				Bcopy[0] = B[0];
				for (int k = 1; k < B.length; k++) {
					if (B[blencopy] != B[k]) {
						blencopy++;
						Bcopy[blencopy] = B[k];
					}
				}
				blencopy++;
				
				long finalans = 0;
				for (int i = 0; i < blencopy; i++) {
					long y = Bcopy[i];
					long ysquare = y*y;
					int alen = alencopy;	// apparent length of A
					int clen = clencopy;	// apparent length of C
					
					for (int i1 = 0; i1 < alencopy; i1++) {
						long num = Acopy[i1];
						if (num > y){
							alen = i1;
							break;
						}
					}
					
					for (int i2 = 0; i2 < clencopy; i2++) {
						long num = C[i2];
						if (num > y){
							clen = i2;
							break;
						}
					}
					
					for (int j = 0; j < alen; j++) {
						long x = Acopy[j];
						for (int k = 0; k < clen; k++) {
							long z = Ccopy[k];
							long sum = x+z;
							long product = x*z;
							long ans = ysquare + sum*y + product;
//							System.out.println("x : " + x + " y: " + y + " z: " + z + " ans: " + ans );
							
							finalans = finalans + ans;
							finalans = finalans % 1000000007;
						}
					}
				}	// B (for)
				finalans = finalans % 1000000007;
				System.out.println(finalans);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	private static void printarray(long[] array) {
//		for(int i = 0; i < array.length; i++) {
//			System.out.print(array[i] + " ");
//		}
//		System.out.println();
//	}

}

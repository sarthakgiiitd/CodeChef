import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

//ATM_prob.java
//Sarthak Goyal
//January 21, 2017
public class Main{
	public static void main(String[] args) throws java.lang.Exception{
		try{
			 Reader.init(System.in);
			 int cash = Reader.nextInt();
			 double balance = Reader.nextDouble();
			 double cashd = (double) cash;
			 double newbalance = balance;
			 if ((cash % 5 == 0)&&(cashd <= balance-0.5)){
				 newbalance = balance - cashd - 0.50;
			 }
			 
			 double newbalance2 = newbalance*100;
			 newbalance2 = (int) newbalance2;
			 newbalance2 = newbalance2/100;
			 DecimalFormat df = new DecimalFormat("#0.00"); 
			 System.out.print(df.format(newbalance2));
			 
			 
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
    	return Double.parseDouble( next() );
    }
}
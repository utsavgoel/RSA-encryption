import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;

public class Solution {
   
	static long  gcd(long phin,long b)
	{
		if(b==0L)
			return phin;
		return gcd(b,phin%b);
	}
	
	
	public static void main(String []args) throws IOException{
      
		//Initialisation
	   BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	   //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   //System.out.println("How many tests?");
		//int T = Integer.parseInt(br.readLine());
		//while(T--> 0){
       String s1;
       long msg=0L,p=0L,q=0L,e=0L;
       genPrime gp=new genPrime(); //for generating a random prime using miller rabin
       totientFun tot = new totientFun();//totient fun for two primes
       modExp enc=new modExp();//modular exponentiation
       modExp dec=new modExp();
              
       System.out.println("Enter the message:");
       s1=input.readLine();
       
       
       //converting long to biginteger
       msg=Long.parseUnsignedLong(s1);
       BigInteger str= new BigInteger(s1);
       
       //generating first prime
       p=gp.doIt(msg);
       //second prime
       while(true)
       {	
    	   q=gp.doIt(msg);
    	   if(p!=q)
    		   break;
       }
     
       BigInteger p1 = BigInteger.valueOf(p);
       System.out.println("First Prime: "+p1);
       
       BigInteger p2 = BigInteger.valueOf(q);
       System.out.println("Second Prime: "+p2);
       
       /* two primes calculated*/
       
       //totient function
       BigInteger phin;
       phin=tot.totient(p1,p2);
       System.out.println("Phi(n): "+phin);
       
       //generating e
       while(msg!=0)
		{
			long random=(long)(Math.random()*(phin.longValue()-1));
			if(random>1L && gcd((long)random,phin.longValue())==1L)
			{
				e=(long)random;
				break;
			}
		}
       System.out.println("Public Key(e): "+e);
       System.out.println("Public Key(n): "+(p1.multiply(p2)));
       BigInteger eb = BigInteger.valueOf(e);
       
       //generating d
       BigInteger d=eb.modInverse(phin);
       System.out.println("Private Key(d): " +d);
       
       //Encryption
       BigInteger encrypt=enc.doIt(str,eb, p1.multiply(p2));
       System.out.println("Cipher: "+encrypt);
       
       //Decryption
       BigInteger decrypt=dec.doIt(encrypt,d,p1.multiply(p2));
       System.out.println("Original String: " + decrypt);
		//}
   }
}
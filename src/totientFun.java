import java.math.BigInteger;

public class totientFun {
	//P1^k1.P2^k2...(1-1/P1)*(1-1/P2)...(1-1/Pn)
	public BigInteger totient(BigInteger p1,BigInteger p2)
	{
		 
		   BigInteger bi1=new BigInteger("1");
	       
	       p1=p1.subtract(bi1);//p-1
	       p2=p2.subtract(bi1);//q-1
	       
	       BigInteger phin1= new BigInteger(p1.toString());
	       BigInteger phin2= new BigInteger(p2.toString());
	       
	       BigInteger phin=phin1.multiply(phin2);
	       return phin; 
	       
	}
}

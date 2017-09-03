import java.math.BigInteger;

public class modExp {
	
	public BigInteger doIt(BigInteger x, BigInteger y, BigInteger d)
	{
		return x.modPow(y, d);
	}
}

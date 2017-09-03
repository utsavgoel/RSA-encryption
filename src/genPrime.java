
public class genPrime {
	
	private long power(long x,long y, long d) //modular exponentiation
	{
		if(x==0L)
			return 0L;
		if(y==0L || x==1L)
			return 1L;
		long temp=power(x,(long)y/2L,d);
		if(y%2==0)
			return ((temp%d)*(temp%d))%d;
		else
			return ((x%d)*(temp%d)*(temp%d))%d;
	}
	
	private boolean millerTest(long d, long n)
	{
		long random= (long) (Math.random()*(n-4)+2);
		long x= power(random,d,n);
		if(x==1L || x==n-1)
			return true;
		
		while(d!=n-1)
		{
			x=((x%n)*(x%n))%n;
			d*=2L;
			if(x==1L)
				return false;
			if(x==n-1)
				return true;
		}
		return false;
	}
	
	private boolean isPrime(long n)
	{
		if(n<=1L)
			return false;
		if(n==4L)
			return false;
		if(n<=3L)
			return true;
		long d=n-1;
		while(d%2==0L)
			d/=2L;
		
		for(long i=0L;i<200L;i++)
		{
			if(millerTest(d,n)==false)
				return false;
		}
		return true;
	}
	public long doIt(long msg)
	{	
		long p;
		while(true)//any trivial condition
		{
			long random=(long)(Math.random()*(msg-1)); //taking a random prime under the range 1 to msg
			p=(long)random;
			
			if(isPrime(p)==true)
				return p;
		}
	}
}

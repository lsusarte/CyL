import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Cifrado {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		String s="This is a test";
	         MessageDigest m=MessageDigest.getInstance("MD5");
	          m.update(s.getBytes(),0,s.length());
	          System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
	          
	}

}

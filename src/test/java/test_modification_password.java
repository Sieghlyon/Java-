import org.junit.Test;
import org.junit.Assert;

public class test_modification_password {
	
	//tester si 8 char, 1 maj , 1 minusucle et un nombre
	String password = "iuvzbuiv69fbuovf";
	
	@Test
	public void longueur() {
		int length = password.length();
		
		Assert.assertTrue(length >= 8);
	}
	
	@Test
	public void majuscule() {
		boolean maj = false;
		
		for (int p = 0; p < password.length(); p++) {
            if (Character.isUpperCase(password.charAt(p))) {
            	maj = true;
            }
        }
		
		Assert.assertTrue(maj == true);
	}
	
	@Test
	public void minuscule() {
		boolean min = false;
		
		for (int p = 0; p < password.length(); p++) {
            if (Character.isLowerCase(password.charAt(p))) {
            	min = true;
            }
        }
		
		Assert.assertTrue(min == true);
	}
	
	@Test
	public void chiffre() {
		boolean digit = false;
		
		for (int r = 0; r < password.length(); r++) {
            if (Character.isDigit(password.charAt(r))) {
            	digit = true;
            }
        }
		
		Assert.assertTrue(digit == true);
	}
	
}

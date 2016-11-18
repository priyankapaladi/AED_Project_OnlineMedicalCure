/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author Priyanka
 */
public class EmailValidator {
    private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validate(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
        
        public boolean checkIfItIsAuthentic(String email) {
		boolean isValid = false;
		try {
                    System.out.println("checkIfItIsAuthentic:  " + email);
			//
			// Create InternetAddress object and validated the supplied
			// address which is this case is an email address.
			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
                        System.out.println("validate: ");
			isValid = true;
                        
		} catch (AddressException e) {
			System.out.println("You are in catch block -- Exception Occurred for: " + email);
                       
		}
		return isValid;
	}

}

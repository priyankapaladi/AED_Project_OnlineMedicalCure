/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import EmailValidation.SendMail;
import Logging.LogReports;
import java.io.File;
import java.util.ArrayList;
import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.swing.JOptionPane;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author raunak
 */
public class UserAccountDirectory {

    private ArrayList<UserAccount> userAccountList;
    static int a = 0;
    private static final char[] PASSWORD = "enfldsgbnlsngdlksdsgm".toCharArray();
    private static final byte[] SALT = {
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,
        (byte) 0xde, (byte) 0x33, (byte) 0x10, (byte) 0x12,};
    LogReports log;
    SendMail sendMail;
//     String alphabet = "0123456789ABCDE";
//    final int N;
    String randomPassword;
    static int number = 200;
    Random r = new Random();
    String passwordEnc;
    int flag;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
        log = new LogReports();
        sendMail = new SendMail();

    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public String loadIPAddress(String username, String password) throws GeneralSecurityException, UnsupportedEncodingException {
        String enc;
        String ip = null;
        enc = encrypt(password);
        System.out.println("Loading IP");
        for (UserAccount ua : userAccountList) {

            if (ua.getUsername().equals(username) && ua.getPassword().equals(enc)) {
                ip = ua.getIpAddress();

            } else {
                ip = "";
            }

        }
        return ip;
    }
    
    public String loadWrongIPAddress (String username, String password) throws GeneralSecurityException, UnsupportedEncodingException {
        String enc;
        enc = encrypt(password);
        int i = 50;
        System.out.println("Loading IP");
        String ip = "206.100.100."+i;
        i++;
        for (UserAccount ua : userAccountList) {

            if (ua.getUsername().equals(username) && ua.getPassword().equals(enc)) {
                ip = ua.getIpAddress();

            } else {
                ip = "";
            }

        }
        return ip;
        
    }

    public void modifyDetails(UserAccount userAccount, String username, String password, String emailID) {
        try {
            String encryptPassword = encrypt(password);
            userAccount.setUsername(username);
            userAccount.setEmail(emailID);

            userAccount.setPassword(encryptPassword);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(UserAccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserAccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public UserAccount authenticateUser(String username, String password, String ipAddress) {
        String enc;
        try {
            enc = encrypt(password);
            System.out.println("encryted password :" + enc);
            for (UserAccount ua : userAccountList) {
                if (ua.getUsername().equals(username) && ua.getPassword().equals(enc)) {

                    // check location based on ip
                    File file = new File("C:\\resources\\location\\GeoLiteCity.dat");

                    LookupService lookupService = new LookupService(file, LookupService.GEOIP_MEMORY_CACHE);

                    Location location = lookupService.getLocation(ua.getIpAddress());
                    System.out.println(location);
                    location = lookupService.getLocation(ipAddress);
                    if (location != null) {
                        location.region = regionName.regionNameByCode(location.countryCode, location.region);
                        System.out.println(location.region + "-" + location.city + "-" + location.postalCode);

                    } else {
                        System.out.println("No such IP address exists");
                    }

                    // check if the same ip is used while logging
                    if (ua.getIpAddress().equals(ipAddress)) {
                        System.out.println("Same IP Address");

                    } else {
                        System.out.println("Report the IP Address");
//                        log.logReportCheck(ua.getUsername() + "-" + ua.getIpAddress()
//                                + " logged in through a different address      " + ipAddress + "        "
//                                + location.region + "-" + location.city + "-" + location.postalCode);

                    }
                    return ua;

                } 
                
            }
            
            checkForUser(username, password);
                
           

        } catch (GeneralSecurityException ex) {
            Logger.getLogger(UserAccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserAccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void checkForUser(String username, String password){
        System.out.println("Inside checkForUser");
                            for (final UserAccount userAccount : userAccountList) {
                        if (username.equals(userAccount.getUsername())) {
                            if (!password.equals(userAccount.getPassword())) {
                                flag = userAccount.getFlag() + 1;
                                userAccount.setFlag(flag);
                                a++;
                                if (flag == 3) {
                                    try {
                                        userAccount.setFlag(0);
                                        String newPassword = userAccount.getPassword() + a;
                                        randomPassword = new StringBuilder(decrypt(newPassword)).reverse().toString();
                                        // number = number + r.nextInt();
                                        // System.out.println("new password: "+randomPassword);
                                        System.out.println("new password is:   " + randomPassword
                                        );
                                        
                                        passwordEnc = encrypt(randomPassword);
                                        userAccount.setPassword(passwordEnc);
                                        
                                        JOptionPane.showMessageDialog(null, "The password to this user account is reset and password is mailed to the "
                                                + "registered user emailid.");
                                        
                                        new Thread(new Runnable() {
                                            public void run() {
                                                // System.out.println("Look at me, look at me...");
                                                sendMail.notifyUserForLogin(userAccount.getEmail(), randomPassword);
                                            }
                                        }).start();
                                        
                                        System.out.println("The account to which this email-id is registered "
                                                + "tried logging in thrice with wrong password!");
                                    } catch (GeneralSecurityException ex) {
                                        Logger.getLogger(UserAccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (IOException ex) {
                                        Logger.getLogger(UserAccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                }

                               // return null;
                            }
                        }
                    }
                             System.out.println("Number of wrong login attempts" + flag);
                            System.out.println("End Of checkForUser");

    }

    public UserAccount createUserAccount(String username,
            String password, Employee employee, Role role, String ipAddress, String emailID) {
        UserAccount userAccount = new UserAccount();
        String enc;

        System.out.println("Creating user for" + role);
        userAccount.setUsername(username);
        System.out.println("check" + checkIfUsernameIsUnique(username));
        if (checkIfUsernameIsUnique(username)) {

        } else {
            JOptionPane.showMessageDialog(null, "Username exists. Please choose a different username.");
            return null;
        }

        try {
            enc = encrypt(password);
            System.out.println("encryted password while creation:" + enc + "   actual:" + password);
            userAccount.setPassword(enc);

        } catch (GeneralSecurityException ex) {
            Logger.getLogger(UserAccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserAccountDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
        userAccount.setIpAddress(ipAddress);
        System.out.println("UserAccountDirectory--" + ipAddress);
        userAccount.setEmail(emailID);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);

        return userAccount;
    }

    public boolean checkIfUsernameIsUnique(String username) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    private static String encrypt(String property) throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return base64Encode(pbeCipher.doFinal(property.getBytes("UTF-8")));
    }

    private static String base64Encode(byte[] bytes) {
        // NB: This class is internal, and you probably should use another impl
        return new BASE64Encoder().encode(bytes);
    }

    public static String decrypt(String property) throws GeneralSecurityException, IOException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(new PBEKeySpec(PASSWORD));
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(SALT, 20));
        return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
    }

    private static byte[] base64Decode(String property) throws IOException {
        // NB: This class is internal, and you probably should use another impl
        return new BASE64Decoder().decodeBuffer(property);
    }

//    public String reverseString(String value){
//        String a = new StringBuilder(value).reverse().toString();
//        return a;
//    }
}

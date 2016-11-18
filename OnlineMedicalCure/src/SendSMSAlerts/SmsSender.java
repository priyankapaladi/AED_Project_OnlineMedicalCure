package SendSMSAlerts;
import java.util.Map;
import java.util.HashMap;
 
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
public class SmsSender {
 
    /* Find your sid and token at twilio.com/user/account */
    public static final String ACCOUNT_SID = "AC752cfe3dea76e9dc4c7cccb4ccb8a815";
    public static final String AUTH_TOKEN = "ee284fe3d87ce67f7d5ec690fd7e19a5";
 
    public  void sendingSMS(String toNumber)  {
 
        try {
            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
            
            Account account = client.getAccount();
            
            MessageFactory messageFactory = account.getMessageFactory();
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("To", "+1"+toNumber)); // Replace with a valid phone number for your account.
            params.add(new BasicNameValuePair("From", "+18572731878")); // Replace with a valid phone number for your account.
            params.add(new BasicNameValuePair("Body", "Your Prescription has been mailed!"));
            Message sms = messageFactory.create(params);
        } catch (TwilioRestException ex) {
            Logger.getLogger(SmsSender.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "The number that has been given was not an authentic number!");
        }
    }
}
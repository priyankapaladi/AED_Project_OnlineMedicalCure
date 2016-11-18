/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author raunak
 */
public class PharmacyWorkRequest extends WorkRequestPharmacy{
    
    private String availibilityOfMedicines;
    private String patientName;
    private String requestId;
    private int countOfRequests;
    private int numberOfTimesItIsOpened;
    static int count;
    static int open;

    public int getNumberOfTimesItIsOpened() {
        return numberOfTimesItIsOpened;
    }

    public void setNumberOfTimesItIsOpened() {
        this.numberOfTimesItIsOpened = open++;
    }

    public int getCountOfRequests() {
        return countOfRequests;
    }

    public void setCountOfRequests() {
        this.countOfRequests = count++;
    }
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getAvailability() {
        return availibilityOfMedicines;
    }

    public void setAvailability(String testResult) {
        this.availibilityOfMedicines = testResult;
    }
    
    
}

package PDFCreation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JavaPdf {

    public void createPDF(String message, String PatientName, String requestID) throws IOException {

        Document document = new Document();

        try {
            String USER_PASSWORD = requestID;
            String OWNER_PASSWORD = "Doctor";

            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            //String timeLog = "check";
            String fileNameID;
            fileNameID = requestID;

            File myOutputDir = new File("F:\\Logs_Prescriptions\\" + PatientName);

            if (!myOutputDir.exists()) {
                myOutputDir.mkdir();
            }
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(myOutputDir + "/" + fileNameID));
            writer.setEncryption(USER_PASSWORD.getBytes(),
                    OWNER_PASSWORD.getBytes(), PdfWriter.ALLOW_PRINTING,
                    PdfWriter.ENCRYPTION_AES_128);

            document.open();
            document.add(new Paragraph(timeLog + new Paragraph() + message));
            document.close();

            writer.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}

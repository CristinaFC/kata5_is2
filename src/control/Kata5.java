
package control;

import java.sql.SQLException;
import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReaderBD;

public class Kata5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        List<Mail> mailList = MailListReaderBD.read();
        
        Histogram<String> mailHistogram = MailHistogramBuilder.build(mailList);
        
        HistogramDisplay histo = new HistogramDisplay("Histogram", mailHistogram);
        histo.execute();
    }
}

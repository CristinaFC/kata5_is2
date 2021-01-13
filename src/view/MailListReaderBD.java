package view;

import model.Mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MailListReaderBD {

    public static List<Mail> read() throws ClassNotFoundException, SQLException {
        List<Mail>mail = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        try (
            Connection connection = DriverManager.getConnection("jdbc:sqlite:db/us500.db"); 
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT email FROM people");
            while(result.next()){
                String email = result.getString("email");
                Mail aux_mail = new Mail(email);
                mail.add(aux_mail);
            }
        }
        return mail;
    }
}

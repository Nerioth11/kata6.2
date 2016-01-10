
package kata6;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Kata6 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
 
        String nameFile = "emails.txt";
        
        
        MailReader mailReader = new MailReader(nameFile);
        
        ArrayList <Person> mailarray = mailReader.getArrayList();
        ArrayList <Person1> lista = PersonLoader.read();
        
        HistogramBuilder<Person> builder = new HistogramBuilder(mailarray);
        HistogramBuilder<Person1> builder1 = new HistogramBuilder(lista);
        
        Histogram<String> domains = builder.build(new Attribute<Person, String>() {

            @Override
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {

            @Override
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });
        
        Histogram<String> domains1 = builder1.build(new Attribute<Person1, String>() {

            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Float> pesos = builder1.build(new Attribute<Person1, Float>() {

            @Override
            public Float get(Person1 item) {
                return item.getPeso();
            }
        });
        
        new HistogramDisplay(domains, "DOMINIOS").execute();
        new HistogramDisplay(letters, "CARACTER").execute();
        new HistogramDisplay(domains1, "DOMINIOS1").execute();
        new HistogramDisplay(pesos, "PESO").execute();
        
        //Histogram<String> histo = MailHistogramBuilder.build(mailarray);
        //HistogramDisplay histogramDisplay = new HistogramDisplay(histo);
        //new histogramDisplay(histo).execute();
    }
    
}

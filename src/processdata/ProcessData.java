package processdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Wies Kueter WiesKueter.com
 */
public class ProcessData {
    
    public static void main(String[] args) {
        
        try {
            /**
             * Read file
             */
            String path = System.getProperty("user.dir");
            
            BufferedReader br = new BufferedReader(new FileReader(path +"/src/processdata/data/salary.txt"));
            StringBuilder sb = new StringBuilder();
            
            try {
                String line = br.readLine();
                String[] lineData;
                List<Rank> ranks = new ArrayList<>();
                Set<String> allRanks = new HashSet<>();
                List<Employee> list = new ArrayList<>();
                
                int rankIndex = 0;
                
                while(line != null) {
                    sb.append(System.lineSeparator());
                    /**
                     * Get data from each line in the file and split it on space
                     */
                    lineData = line.split(" ");
                    
                    /**
                     * Create a list of all the ranks
                     * Check if it exists already so there are no duplicates
                     */
                    if( !allRanks.contains( lineData[2] ) ) {
                        ranks.add( new Rank(lineData[2], 0 ) );
                    }
                    
                    allRanks.add( lineData[2] );
                    
                    // Get the index of the rank
                    rankIndex = new ArrayList( allRanks ).indexOf( lineData[2] );
                    
                    // Create a list of all the employees
                    list.add( new Employee( lineData[0], lineData[1], rankIndex, lineData[3] ) );
                    
                    line = br.readLine();
                }
                
                for(Employee m: list) {

                    double salary = Double.parseDouble( m.getSalary() );
                    Rank rank = ranks.get( m.getRank() );

                    // Get the amount per unique rank so it can be devided later on to get the average
                    rank.setAmount();

                    // Add the total salary earned per rank
                    rank.setSalary( salary );
                }
                
                /**
                 * Show all ranks
                 */
               System.out.format("%-30s %-30s \n",
                    "Rank:",
                    "Average"
                );
                for(Rank m : ranks) {
                    System.out.format("%-30s %-30s \n",
                        m.getRank(),
                        m.getAverageSalary()
                    );
                }
                
                /**
                 * Close the buffer
                 */
                if(line == null) {
                    br.close();
                }
            } catch(IOException e) {
                System.out.println("Whoops, kan bestand niet lezen.");
            }
        } catch(FileNotFoundException e) {
            System.out.println("Whoops, Kan bestand niet vinden!");
        }
    }
}

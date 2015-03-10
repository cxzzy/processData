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
 * @author Kueter
 */
public class ProcessData {
    
    public static void main(String[] args) {
        
        try {
            /**
             * Read file
             */
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/Kueter/Documents/NetBeansProjects/ProcessData/src/processdata/data/salary.txt"));
            StringBuilder sb = new StringBuilder();
            
            try {
                String line = br.readLine();
                String[] lineData;
                List<Rank> ranks = new ArrayList<>();
                Set<String> ranksTest = new HashSet<>();
                List<Employee> list = new ArrayList<>();
                
                int rankIndex = 0;
                
                while(line != null) {
                    //sb.append(line);
                    sb.append(System.lineSeparator());
                    lineData = line.split(" ");
                    
                    /**
                     * Create a list of all the ranks
                     * Check if it exists already so there are no duplicates
                     */
                    if( !ranksTest.contains( lineData[2] ) ) {
                        ranks.add( new Rank(lineData[2], 0 ) );
                    }
                    
                    ranksTest.add( lineData[2] );
                    
                    // Get the index of the rank
                    rankIndex = new ArrayList(ranksTest).indexOf( lineData[2] );
                    
                    // Create a list of all the employees
                    list.add( new Employee(lineData[0], lineData[1], rankIndex, lineData[3]) );
                    
                    line = br.readLine();
                }
                
                /*int j = 0;
                while(list.size() > j) {
                    if(ranks.contains( list.get(j).getRank() )) {
                        System.out.println(list.get(j).getSalary());
                    }
                    j++;
                }*/
                
                if(1 == 1) {
                    for(Employee m: list) {
                        
                        double salary = Double.parseDouble( m.getSalary() );
                        Rank rank = ranks.get( m.getRank() );
                        
                        // Get the amount per unique rank so it can be devided later on to get the average
                        rank.setAmount();
                        
                        // Add the total salary earned per rank
                        rank.setSalary( salary );
                    }   
                }
                
                /**
                 * Show all data for every employee
                 */
                if(1 == 2) {
                    System.out.format("%-30s %-30s %-30s %-30s \n\n",
                        "Firstname",
                        "Lastname",
                        "Rank",
                        "Salary"
                    );
                    
                    for(Employee m: list) {
                        System.out.format("%-30s %-30s %-30s %-30s \n",
                            m.getFirstName(),
                            m.getLastName(),
                            m.getRank(),
                            m.getSalary()
                        );
                    }
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
                        //m.setAmount()
                        m.getAverageSalary()
                    );
                }
                
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

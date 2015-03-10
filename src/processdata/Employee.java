package processdata;

/**
 *
 * @author Wies Kueter WiesKueter.com
 */
public class Employee {
    
    public String firstname;
    public String lastname;
    public int rank;
    public String salary;
    
    public Employee(String firstname, String lastname, int rank, String salary) {
        
        this.firstname = firstname;
        this.lastname = lastname;
        this.rank = rank;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstname;
    }
    
    public String getLastName() {
        return this.lastname;
    }
    
    public int getRank() {
        return this.rank;
    }
    
    public String getSalary() {
        return this.salary;
    }
}

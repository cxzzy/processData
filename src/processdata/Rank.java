package processdata;

/**
 *
 * @author Wies Kueter WiesKueter.com
 */
public class Rank {
    
    public String rank;
    public double salary;
    public int amount;
    
    public Rank(String rank, double salary) {
        
        this.rank = rank;
        this.salary = salary;
    }
    
    public String getRank() {
        return this.rank;
    }
    
    public void setSalary(double salary) {
        this.salary += salary;
    }
    
    public int setAmount() {
        return this.amount++;
    }
    
    public double getAverageSalary() {
        return this.salary/ this.amount;
    }
}

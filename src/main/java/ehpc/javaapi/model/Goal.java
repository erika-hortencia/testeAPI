package ehpc.javaapi.model;

import jakarta.persistence.Entity;

@Entity(name = "tb_goal")
public class Goal extends Event{
    
    public String deadline;
    public String periodicity;

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }
    
}

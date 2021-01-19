import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "assignments")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Assignments {
    private List<Assignment> assignments;

    public Assignments(){}
    public Assignments(List<Assignment> assignments){
        this.assignments = assignments;
    }

    @XmlElement(name ="assignment")
    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}

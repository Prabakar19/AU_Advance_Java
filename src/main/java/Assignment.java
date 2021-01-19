import javax.xml.bind.annotation.XmlAttribute;
import java.time.LocalDate;

public class Assignment {

    int id;

    @ToUpper(toUpper = true)
    String name;

    @ToUpper(toUpper = true)
    String prog_lang;

    String status_update;

    @AddDate(addDate = true)
    private LocalDate localDate = null;

    public Assignment(){}
    public Assignment(int id, String name, String prog_lang, String status_update){
        this.id = id;
        this.name = name;
        this.prog_lang = prog_lang;
        this.status_update = status_update;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getprog_lang() {
        return prog_lang;
    }

    public void setprog_lang(String prog_lang) {
        this.prog_lang = prog_lang;
    }

    public String getstatus_update() {
        return status_update;
    }

    public void setstatus_update(String status_update) {
        this.status_update = status_update;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}

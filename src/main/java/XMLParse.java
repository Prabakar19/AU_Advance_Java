import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.*;
import java.util.List;

public class XMLParse {

    public static void main(String[] args) throws ClassNotFoundException {
        try{
            File file = new File("src\\main\\java\\assignment.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Assignments.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Assignments assignments = (Assignments) jaxbUnmarshaller.unmarshal(file);
            List<Assignment> assignment = assignments.getAssignments();

            System.out.println("Id\t\tName\t\t\tLanguage\t\tStatus\t\tDate");
            for(Assignment assign: assignment){
                ToUpperCaseChange.toUpper(assign);
                AddDateChange.addDate(assign);
                System.out.println(assign.getId() +"\t"+ assign.getName() +"\t\t"+assign.getprog_lang()+"\t\t"+assign.getstatus_update()+"\t\t"+assign.getLocalDate());
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleDB?","root", "Lucifer19+")){

                XMLParse xmlParse = new XMLParse();
                xmlParse.createTables(connection);
                xmlParse.insertData(connection, assignments);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }catch (Exception e){
                e.printStackTrace();
        }
    }
    void createTables(Connection con) {
        try (Statement stmt = con.createStatement()) {
            String sql = "create table assignment(asgmt_id int PRIMARY KEY, name varchar(100), ProgLanguage varchar(100), Status varchar(20), AssignmentDate date)";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertData(Connection con, Assignments assignments) {
        String sql = "insert into assignment(asgmt_id, name, ProgLanguage, Status, AssignmentDate) values(?, ?, ?, ?, ?)";

        List<Assignment> assignment = assignments.getAssignments();
        for(Assignment assign : assignment) {
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, assign.getId());
                stmt.setString(2, assign.getName());
                stmt.setString(3, assign.getprog_lang());
                stmt.setString(4, assign.getstatus_update());
                stmt.setDate(5, Date.valueOf(assign.getLocalDate()));
                stmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

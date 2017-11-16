package io.github.aarvedahl;


import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class StudentBean implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<DtoStudent> studentList;
    private static Client client = ClientBuilder.newClient();
    private static WebTarget baseTarget = client.target("http://localhost:8080/SchoolManagement/studentService/list");

    public List<DtoStudent> getStudentList() {
        if(studentList == null) {
            studentList = baseTarget.request().get(new GenericType<List<DtoStudent>>() {});
        }
        return studentList;
    }
}

package pfe.annuaireldap.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;


import javax.naming.Name;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entry(base="ou=structures" ,objectClasses = { "linidtStructure", "govStructure", "organizationalUnit","top"})
final public class Structure {
    @Id
    @JsonIgnore
    private Name id;
    @DnAttribute(value="ou", index=1)
    private @Attribute(name = "ou") String ou;

    private @Attribute(name = "StructureName") String structureName;
    private @Attribute(name = "StructureType") String structureType;
    private @Attribute(name = "Website") String website;
    private @Attribute(name = "SocialNetwork") String socialNetwork;
    private @Attribute(name = "Contact") String contact;


    private @Attribute(name = "EmployeeList")
    Set<Name> employeeList;
    public void addEmployee (Name employee) {
        if(this.employeeList==null) {
            this.employeeList= new HashSet<>();
        }
        employeeList.add(employee);
    }
    public void removeEmployee(Name employee) {

        employeeList.remove(employee);
    }



}

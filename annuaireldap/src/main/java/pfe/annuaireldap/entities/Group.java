package pfe.annuaireldap.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.slf4j.event.Level;
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
@Entry(base="ou=groups",objectClasses = {"groupOfNames","top","linIdStaticGroup"})
final public class Group {

    @Id
    @JsonIgnore
    private Name id;
    @DnAttribute(value="cn", index=1)
    private @Attribute(name="cn") String cn;
    private @Attribute(name="description") String description;
    @JsonIgnore
    private @Attribute(name="member")
    Set<Name> members;
    public void addMember(Name member){
        if (this.members==null){
            this.members=new HashSet<>();
        }
        members.add(member);

    }
    public void removeMember(Name member){
        members.remove(member);
    }


}

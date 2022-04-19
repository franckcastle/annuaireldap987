package pfe.annuaireldap.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entry(base="ou=users", objectClasses = { "person", "inetOrgPerson", "top", "govPerson", "linidPeople", "organizationalPerson"})
final public class User {

    @Id
    @JsonIgnore
    private Name id;
    //private LdapName id;
//@DnAttribute(value = "uid", index = 1)
    private @Attribute(name = "uid")
    String uid;
    //private @DnAttribute(value = "uid") String uid;
    private @Attribute(name = "govCNRPS")
    String govCNRPS;
    private @Attribute(name = "govCIN")
    String govCIN;
    private @Attribute(name = "cn")
    String cn;
    private @Attribute(name = "sn")
    String sn;
    private @Attribute(name = "givenName")
    String givenName;
    private @Attribute(name = "cn;lang-fr")
    String cnLangFr;
    private @Attribute(name = "cn;lang-ar")
    String cnLangAr;
    private @Attribute(name = "sn;lang-fr")
    String snLangFr;
    private @Attribute(name = "sn;lang-ar")
    String snLangAr;
    private @Attribute(name = "givenName;lang-fr")
    String givenNameLangFr;
    private @Attribute(name = "givenName;lang-ar")
    String givenNameLangAr;
    private @Attribute(name = "mail")
    String mail;
    private @Attribute(name = "userPassword", type = Attribute.Type.BINARY)
    byte[] userPassword;

    @JsonIgnore
//private @Attribute(name = "memberOf") String memberOf;
    private @Attribute(name = "memberOf")
    Set<Name> memberOf;


}

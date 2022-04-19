package pfe.annuaireldap.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
@Getter
@Setter
@ToString
public class UserDto {
    private String id;
    private String uid;
    private String GovCNRPS;
    private String GovCIN;
    private String cn;
    private String sn;
    private String givenName;
    private String cnLangFr;
    private String cnLangAr;
    private String snLangFr;
    private String snLangAr;
    private String givenNameLangFr;
    private String givenNameLangAr;
    private String mail;
    private String userPassword;
    private Set<String> memberOf;
}

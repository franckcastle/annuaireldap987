package pfe.annuaireldap.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
@Getter
@Setter
@ToString
public class GroupRequest {
    private String id;
    private String cn;
    private String description;
    private Set<String> members;

}

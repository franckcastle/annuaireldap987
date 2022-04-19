package pfe.annuaireldap.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
@Getter
@Setter
@ToString
public class GroupDto {
    private String id;
    private String cn;
    private String description;
    private Set<String> members;
}

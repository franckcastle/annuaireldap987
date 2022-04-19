package pfe.annuaireldap.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class StructureDto {
    private String id;
    private String ou;
    private String structureName;
    private String  structureType;
    private String  website;
    private String socialNetwork;
    private String contact;
    private Set<String> employeeList;
}

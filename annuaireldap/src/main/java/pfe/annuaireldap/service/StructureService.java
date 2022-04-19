package pfe.annuaireldap.service;

import pfe.annuaireldap.dto.GroupDto;
import pfe.annuaireldap.dto.StructureDto;
import pfe.annuaireldap.request.StructureRequest;

import javax.naming.InvalidNameException;
import java.util.List;

public interface StructureService {
    public StructureDto getStructureByStructureName(String req);
    public String addStructure(StructureRequest structureReq) throws InvalidNameException;
    public List<StructureDto> getAllStructure();
    public String updateStructureWithoutDeleteEmployeeList(StructureDto dto) throws InvalidNameException;
    public String updateStructureWithDeleteEmployeeList(StructureDto dto) throws InvalidNameException;

}

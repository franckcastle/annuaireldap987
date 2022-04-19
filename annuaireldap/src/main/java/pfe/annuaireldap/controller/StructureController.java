package pfe.annuaireldap.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pfe.annuaireldap.dto.StructureDto;
import pfe.annuaireldap.request.StructureRequest;
import pfe.annuaireldap.service.GroupService;
import pfe.annuaireldap.service.StructureService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class StructureController {
    @Autowired
    MessageSource messageSource;
    @Autowired
    StructureService structureService;
    @GetMapping(path = "/find-all-structure")
    public List<StructureDto> findAllUser () throws Exception{
        List<StructureDto> structureList = structureService.getAllStructure();
        return structureList;

    }
    @GetMapping(path = "/find-structure-by-structureName")
    public StructureDto findByStructureName() throws Exception{
        StructureDto structureDto = structureService.getStructureByStructureName("wajdiStructure");
        return structureDto;
    }
    @PostMapping(path="/add-structure")
    public String addStructure() throws Exception{
        StructureRequest structureRequest = new StructureRequest();
        structureRequest.setId("structureName=wajdiAddStructure,ou=structures");
        structureRequest.setStructureName("wajdiAddStructure");
        structureRequest.setOu("structures");
        structureRequest.setStructureType("type");
        Set<String> employee = new HashSet<String>();
        employee.add("uid=003,ou=users,dc=cni,dc=tn");
        structureRequest.setEmployeeList(employee);
        return structureService.addStructure(structureRequest);
    }
}

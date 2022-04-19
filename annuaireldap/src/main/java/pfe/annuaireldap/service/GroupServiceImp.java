package pfe.annuaireldap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;
import pfe.annuaireldap.dto.GroupDto;
import pfe.annuaireldap.entities.Group;
import pfe.annuaireldap.repo.GroupRepo;
import pfe.annuaireldap.request.GroupRequest;
import pfe.annuaireldap.util.ConvertUtilitiesGroup;

import javax.naming.InvalidNameException;
import java.util.List;
@Service
public class GroupServiceImp implements GroupService {
    @Autowired
    GroupRepo groupRepo;
    @Autowired
    private LdapTemplate ldapTemplate;



    @Override
    public List<GroupDto> getAllGroup(){
        List<Group> GroupsList = groupRepo.findAll();
        List<GroupDto> GroupsDtoList = ConvertUtilitiesGroup.convertListGroupToListGroupDto(GroupsList);
        return GroupsDtoList;
    }
    @Override
    public GroupDto getGroupByCn(String req) {
        Group g = groupRepo.findByCn(req);
        GroupDto groupDto = ConvertUtilitiesGroup.ConvertGroupToGroupDto(g);
        return groupDto;
    }
    @Override
    public String addGroup(GroupRequest groupReq) throws InvalidNameException {

        Group newGroup = ConvertUtilitiesGroup.convertGroupRequestToGroup(groupReq);
        ldapTemplate.create(newGroup);
        return newGroup.getId().toString();
    }
    @Override
    public String updateGroupWithoutDeleteMembers(GroupDto dto) throws InvalidNameException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String updateGroupWithDeleteMembers(GroupDto dto) throws InvalidNameException {
        // TODO Auto-generated method stub
        return null;
    }
}

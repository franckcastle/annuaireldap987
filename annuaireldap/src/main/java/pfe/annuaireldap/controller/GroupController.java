package pfe.annuaireldap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pfe.annuaireldap.dto.GroupDto;
import pfe.annuaireldap.request.GroupRequest;
import pfe.annuaireldap.service.GroupService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class GroupController {
    @Autowired
    MessageSource messageSource;
    @Autowired
    GroupService groupService;

    @GetMapping(path="/find-all-group")
    public List <GroupDto> findAllUser () throws Exception{
        List<GroupDto> groupList =groupService.getAllGroup();
        return groupList;
    }
    @GetMapping (path="/find-group-by-cn")
    public GroupDto findGroupByCn() throws Exception{
        GroupDto groupDto =groupService.getGroupByCn("wajdiGroup");
        return groupDto;
    }
    @PostMapping(path = "/add-group")
    public String addGroup() throws Exception{
        GroupRequest groupRequest = new GroupRequest();
        groupRequest.setId("cn=faouziGroup, ou=Groups");
        groupRequest.setDescription("description");
        Set<String> members = new HashSet<String>();
        members.add("uid=003,ou=users,dc=cni,dc=tn");
        groupRequest.setMembers(members);
        return groupService.addGroup(groupRequest);
    }
}

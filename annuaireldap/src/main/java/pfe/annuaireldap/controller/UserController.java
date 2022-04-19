package pfe.annuaireldap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pfe.annuaireldap.dto.UserDto;
import pfe.annuaireldap.entities.User;
import pfe.annuaireldap.request.UserRequest;
import pfe.annuaireldap.service.UserService;

import javax.naming.InvalidNameException;
import javax.naming.NamingException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    MessageSource messageSource;
    @Autowired
    UserService userService;
    @GetMapping(path="/find-user-by-govcnrps")
    public UserDto findUserByGovCnrps() throws Exception{
        UserDto user =userService.getUserByCnrps("009");
        return user;
    }

    @GetMapping (path="/find-all-user")
    public List <UserDto> findAllUser () throws Exception{
        List <UserDto> userList =userService.getAllUser();
        return userList;
    }
    @PostMapping (path ="/add-user")
    public String adduser () throws InvalidNameException {
        UserRequest userRequest = new UserRequest();

        userRequest.setId("uid=009,ou=users");
        userRequest.setCn("cn");
        userRequest.setSn("Sn");
        userRequest.setGovCNRPS("009");


        return userService.addUser(userRequest);
    }


}

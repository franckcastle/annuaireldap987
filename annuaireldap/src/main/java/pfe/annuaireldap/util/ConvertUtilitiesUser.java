package pfe.annuaireldap.util;

import pfe.annuaireldap.dto.UserDto;
import pfe.annuaireldap.entities.User;
import pfe.annuaireldap.request.UserRequest;

import javax.naming.InvalidNameException;
import javax.naming.Name;
import javax.naming.ldap.LdapName;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ConvertUtilitiesUser {
    public static UserDto convertUserToUserDto(User u) {
        UserDto userDto = new UserDto();
        userDto.setId(u.getId().toString());
        userDto.setCn(u.getCn());
        userDto.setUid(u.getUid());
        userDto.setGovCNRPS(u.getGovCNRPS());
        userDto.setGovCIN(u.getGovCIN());
        userDto.setCnLangFr(u.getCnLangFr());
        userDto.setCnLangAr(u.getCnLangAr());
        userDto.setSn(u.getSn());
        userDto.setSnLangAr(u.getSnLangAr());
        userDto.setSnLangFr(u.getSnLangFr());
        HashSet<String> setMemberOF = new HashSet<String>();
        for(Name dn:u.getMemberOf()){
            setMemberOF.add(dn.toString());
        }
        return userDto;
    }
    public static List<UserDto> convertListUserToListUserDto(List<User> listUser) {
        List<UserDto> listUserDto = new ArrayList<UserDto>();
        for(User u:listUser){
            listUserDto.add(convertUserToUserDto(u));
        }
        return listUserDto;
    }
    public static User convertUserRequestToUser(UserRequest req) throws InvalidNameException {
        User user = new User();
        user.setId(new LdapName(req.getId()));
        user.setUid(req.getUid());
        user.setCn(req.getCn());
        user.setCnLangAr(req.getCnLangAr());
        user.setCnLangFr(req.getSnLangFr());
        user.setSn(req.getSn());
        user.setSnLangAr(req.getSnLangAr());
        user.setSnLangFr(req.getSnLangFr());
        user.setGivenName(req.getGivenName());
        user.setGivenNameLangAr(req.getGivenNameLangAr());
        user.setGivenNameLangFr(req.getGivenNameLangFr());
        user.setGovCNRPS(req.getGovCNRPS());
        user.setMail(req.getMail());
        //password

        return user;

    }
    public static User convertUserDtoToUser(UserDto u) throws InvalidNameException {
        User user = new User();
        user.setId(new LdapName(u.getId()));
        user.setCn(u.getCn());
        user.setUid(u.getUid());
        user.setGovCNRPS(u.getGovCNRPS());
        user.setGovCIN(u.getGovCIN());
        user.setCnLangFr(u.getCnLangFr());
        user.setCnLangAr(u.getCnLangAr());
        user.setSn(u.getSn());
        user.setSnLangAr(u.getSnLangAr());
        user.setSnLangFr(u.getSnLangFr());

        return user;
    }
}

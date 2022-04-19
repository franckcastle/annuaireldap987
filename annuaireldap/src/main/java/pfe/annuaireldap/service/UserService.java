package pfe.annuaireldap.service;

import pfe.annuaireldap.dto.UserDto;
import pfe.annuaireldap.entities.User;
import pfe.annuaireldap.request.UserRequest;

import javax.naming.InvalidNameException;
import java.util.List;

public interface UserService {
    public UserDto getUserByCnrps(String req);

    public String addUser(UserRequest uReq) throws InvalidNameException;

    public String updateUser(UserDto userDto) throws InvalidNameException;

    public List<UserDto> getAllUser();
}

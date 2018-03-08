package person.liuxx.demo.login.service;

import java.util.Optional;

import person.liuxx.demo.login.domain.User;
import person.liuxx.demo.login.dto.UserDTO;

/** 
* @author  刘湘湘 
* @version 1.0.0<br>创建时间：2018年3月8日 下午4:48:08
* @since 1.0.0 
*/
public interface UserService
{
    Optional<User> getUser(UserDTO userDTO);
}

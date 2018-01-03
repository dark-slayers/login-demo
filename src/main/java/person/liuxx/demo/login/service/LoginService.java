package person.liuxx.demo.login.service;

import person.liuxx.demo.login.dto.UserDTO;

/** 
* @author  刘湘湘 
* @version 1.0.0<br>创建时间：2018年1月3日 下午4:04:30
* @since 1.0.0 
*/
public interface LoginService
{
    String login(UserDTO user);
}

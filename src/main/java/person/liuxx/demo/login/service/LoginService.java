package person.liuxx.demo.login.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import person.liuxx.demo.login.dto.UserDTO;
import person.liuxx.demo.login.vo.TestVO;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月3日 下午4:04:30
 * @since 1.0.0
 */
public interface LoginService
{
    String LOGIN_USER_NAME = "user";
    String ADDRESS = "address";

    Optional<TestVO> loginSession(HttpSession session, UserDTO user);

    /** 
    * @author  刘湘湘 
    * @version 1.0.0<br>创建时间：2018年1月30日 下午4:11:13
    * @since 1.0.0 
    * @param user
    * @return
    */
    Optional<TestVO> loginToken(UserDTO user);
}

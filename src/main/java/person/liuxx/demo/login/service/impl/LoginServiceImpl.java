package person.liuxx.demo.login.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import person.liuxx.demo.login.controller.LoginController;
import person.liuxx.demo.login.dto.UserDTO;
import person.liuxx.demo.login.service.LoginService;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月3日 下午4:04:19
 * @since 1.0.0
 */
@Service
public class LoginServiceImpl implements LoginService
{
    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @Override
    public String login(UserDTO user)
    {
        log.info("用户尝试登录：{}", user);
        return "OK";
    }
}

package person.liuxx.demo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import person.liuxx.demo.login.dto.UserDTO;
import person.liuxx.demo.login.service.LoginService;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月3日 下午3:58:21
 * @since 1.0.0
 */
@RestController
public class LoginController
{
    @Autowired
    private LoginService service;

    @PostMapping("/session")
    public String login(@RequestBody UserDTO user)
    {
        return service.login(user);
    }
}

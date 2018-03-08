package person.liuxx.demo.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import person.liuxx.demo.login.dto.UserDTO;
import person.liuxx.demo.login.service.LoginService;
import person.liuxx.demo.login.vo.TestVO;
import person.liuxx.util.service.exception.SaveException;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月3日 下午3:58:21
 * @since 1.0.0
 */
@RestController
@Api(value = "登录控制器")
public class LoginController
{
    @Autowired
    private LoginService service;

    @ApiOperation(value = "登录，将登录信息保存至session", notes = "登录，将登录信息保存至session")
    @ApiImplicitParam(name = "user", value = "用户名和密码", required = true, dataType = "UserDTO")
    @PostMapping("/session")
    public TestVO loginSession(HttpSession session, @RequestBody UserDTO user)
    {
        return service.loginSession(session, user).<SaveException>orElseThrow(() ->
        {
            throw new SaveException("登录失败！");
        });
    }

    @PostMapping("/token")
    public TestVO loginToken(HttpSession session, @RequestBody UserDTO user)
    {
        return service.loginToken(user).<SaveException>orElseThrow(() ->
        {
            throw new SaveException("登录失败！");
        });
    }
}

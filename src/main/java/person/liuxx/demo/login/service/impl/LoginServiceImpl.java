package person.liuxx.demo.login.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import person.liuxx.demo.login.controller.LoginController;
import person.liuxx.demo.login.dto.UserDTO;
import person.liuxx.demo.login.dto.UserJWT;
import person.liuxx.demo.login.service.LoginService;
import person.liuxx.demo.login.vo.TestVO;

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
    public Optional<TestVO> loginSession(HttpSession session, UserDTO user)
    {
        log.info("SecurityContextHolder.getContext().getAuthentication()：{}", SecurityContextHolder.getContext().getAuthentication());
        log.info("用户尝试登录：{}", user);
        session.setAttribute(LoginService.LOGIN_USER_NAME, user.getUsername());
        log.info("session.getId()：{}", session.getId());
        log.info("LoginService.LOGIN_USER_NAME：{}", session.getAttribute(
                LoginService.LOGIN_USER_NAME));
        Optional<TestVO> result = authV1(user).map(u ->
        {
            Authentication request = new UsernamePasswordAuthenticationToken(user.getUsername(),
                    user.getPassword());
            AuthenticationManager am = new SampleAuthenticationManager();
            Authentication res = am.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(res);
            TestVO vo = new TestVO();
            vo.setMessage("OK");
            return vo;
        });
        return result;
    }

    private Optional<UserJWT> authV1(UserDTO user)
    {
        UserJWT result = new UserJWT();
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<TestVO> loginToken(UserDTO user)
    {
        // TODO 自动生成的方法存根
        return null;
    }
}

class SampleAuthenticationManager implements AuthenticationManager
{
    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
    static
    {
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public Authentication authenticate(Authentication auth) throws AuthenticationException
    {
        return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(),
                AUTHORITIES);
    }
}
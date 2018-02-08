package person.liuxx.demo.login.config.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import person.liuxx.demo.login.service.LoginService;
import person.liuxx.util.log.LogUtil;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月8日 下午1:36:35
 * @since 1.0.0
 */
public class LoginFilter implements Filter
{
    private Logger log = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        try
        {
            Optional<String> nameOptional = Optional.ofNullable(request)
                    .map(r -> (HttpServletRequest) request)
                    .map(r -> r.getSession())
                    .map(s -> s.getAttribute(LoginService.LOGIN_USER_NAME))
                    .map(o -> o.toString());
            String username = nameOptional.orElse("");
            String address = request.getRemoteAddr();
            ThreadContext.put(LoginService.LOGIN_USER_NAME, username);
            ThreadContext.put(LoginService.ADDRESS, address);
            chain.doFilter(request, response);
        } catch (Exception e)
        {
            log.error(LogUtil.errorInfo(e));
        }
    }

    @Override
    public void destroy()
    {
    }
}

package person.liuxx.demo.login.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import person.liuxx.demo.login.config.filter.LoginFilter;

/**
 * 初始化配置
 * 
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年9月29日 下午2:57:49
 * @since 1.0.0
 */
@Configuration
public class InitConfig
{
    private int filterOrder = 100;

    @Bean
    public ServletRegistrationBean servletRegistrationBean()
    {
        // Druid数据源配置
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        // Druid数据源配置
        registrationBean.setFilter(new WebStatFilter());
        registrationBean.setOrder(filterOrder);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean userFilterRegistrationBean()
    {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new LoginFilter());
        registrationBean.setOrder(filterOrder - 1);
        registrationBean.addUrlPatterns("/*");
        // registrationBean.addInitParameter("paramName", "paramValue");
        registrationBean.setName("loginFilter");
        return registrationBean;
    }
}

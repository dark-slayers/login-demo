package person.liuxx.demo.login.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import person.liuxx.demo.login.vo.TestVO;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月8日 上午10:19:15
 * @since 1.0.0
 */
@RestController
public class TestController
{
    private Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public TestVO test(HttpSession session)
    {
        log.info("GET /test");
        TestVO vo = new TestVO();
        vo.setMessage("TEST !");
        return vo;
    }
}

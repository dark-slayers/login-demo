package person.liuxx.demo.login.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import person.liuxx.demo.login.dao.UserRepository;
import person.liuxx.demo.login.domain.User;
import person.liuxx.demo.login.dto.UserDTO;
import person.liuxx.demo.login.service.UserService;
import person.liuxx.util.base.StringUtil;
import person.liuxx.util.log.LogUtil;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年3月8日 下午4:40:33
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService
{
    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userDao;

    @Override
    public Optional<User> getUser(UserDTO userDTO)
    {
        return Optional.ofNullable(userDTO)
                .filter(d -> !StringUtil.isBlank(d.getUsername()))
                .filter(d -> !StringUtil.isBlank(d.getPassword()))
                .map(d -> userDao.findByUsername(d.getUsername()))
                .filter(u -> checkUser(u, userDTO));
    }

    private boolean checkUser(User user, UserDTO userDTO)
    {
        Objects.requireNonNull(user);
        switch (user.getPasswordVersion())
        {
        case 1:
            {
                return Objects.equals(encryptV1(userDTO), user.getPassword());
            }
        case 2:
            {
                return Objects.equals(encryptV2(userDTO), user.getPassword());
            }
        }
        return false;
    }

    private String encryptV2(UserDTO userDTO)
    {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        String in = username + password;
        int key = 12;
        String one = SHA2(in);
        String encryOne = one.substring(0, key) + one.substring(one.length() - key) + username;
        String two = SHA5(encryOne);
        String encryTwo = two.substring(0, key) + password + two.substring(one.length() - key);
        String three = SHA2(encryTwo);
        return three.toLowerCase();
    }

    private String encryptV1(UserDTO userDTO)
    {
        String username = userDTO.getUsername();
        String password = userDTO.getPassword();
        String in = username + password;
        int key = 7;
        String one = SHA2(in);
        String encryOne = one.substring(0, key) + one.substring(one.length() - key) + username;
        String two = SHA2(encryOne);
        String encryTwo = two.substring(0, key) + password + two.substring(one.length() - key);
        String three = SHA2(encryTwo);
        return three.toLowerCase();
    }

    private String SHA2(String in)
    {
        return jdkSecurity(in, "SHA-256");
    }

    private String SHA5(String in)
    {
        return jdkSecurity(in, "SHA-512");
    }

    private String jdkSecurity(String in, String algorithm)
    {
        StringBuilder result = new StringBuilder();
        try
        {
            MessageDigest currentAlgorithm = MessageDigest.getInstance(algorithm);
            currentAlgorithm.reset();
            currentAlgorithm.update(in.getBytes());
            byte[] hash = currentAlgorithm.digest();
            for (int i = 0; i < hash.length; i++)
            {
                int v = hash[i] & 0xFF;
                if (v < 16)
                {
                    result.append("0");
                }
                result.append(Integer.toString(v, 16).toUpperCase());
            }
        } catch (NoSuchAlgorithmException e)
        {
            log.error(LogUtil.errorInfo(e));
        }
        return result.toString();
    }
}

package person.liuxx.demo.login.dto;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月3日 下午3:59:33
 * @since 1.0.0
 */
public class UserDTO
{
    private String username;
    private String password;

    public UserDTO()
    {
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "UserDTO [username=" + username + ", password=" + password + "]";
    }
}

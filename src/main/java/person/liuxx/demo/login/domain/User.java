package person.liuxx.demo.login.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年3月8日 下午4:47:44
 * @since 1.0.0
 */
@Entity
public class User
{
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false, length = 50)
    private String username;
    @Column(nullable = false, length = 500)
    private String password;
    @Column(length = 30)
    private String name;
    @Column(length = 20)
    private String role;
    @Column(length = 5)
    private int passwordVersion;

    public User()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPasswordVersion()
    {
        return passwordVersion;
    }

    public void setPasswordVersion(int passwordVersion)
    {
        this.passwordVersion = passwordVersion;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    @Override
    public String toString()
    {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", name="
                + name + ", role=" + role + ", passwordVersion=" + passwordVersion + "]";
    }
}

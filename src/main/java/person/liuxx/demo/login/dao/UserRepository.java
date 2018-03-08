package person.liuxx.demo.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import person.liuxx.demo.login.domain.User;

/** 
* @author  刘湘湘 
* @version 1.0.0<br>创建时间：2018年3月8日 下午4:53:00
* @since 1.0.0 
*/
public interface UserRepository extends JpaRepository<User,Long>
{
    User findByUsername(String username);
}

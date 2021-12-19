package per.poacher.service;

import org.springframework.stereotype.Service;
import per.poacher.pojo.User;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-14:12
 */

public interface UserService {

    /**
     *添加用户
     * @param user 用户信息
     * @return 返回1表示添加成功
     */
    int addUser(User user);

    /**
     * 通过用户名删除用户
     * @param userName 待删除用户的用户名
     * @return 返回1表示删除成功
     */
    int deleteUserByUserName(String userName);

    /**
     *更新用户信息
     * @param user 待更新的用户信息
     * @return 返回1表示更新成功
     */
    int updateUserByUserName(User user);

    /**
     *通过用户名查找用户
     * @param userName 用户名
     * @return 查找到的用户信息
     */
    User getUserByUserName(String userName);

    /**
     *根据用户名获取用户密码
     * @param userName 用户名
     * @return 返回对应的用户密码
     */
    String getPassword(String userName);

    /**
     *查询所有用户
     * @return 用户列表
     */
    List<User> getAllUser();
}

package per.poacher.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import per.poacher.pojo.User;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-12:50
 */
@Repository
public interface UserMapper {

    /**
     * 添加用户
     * @param user 待添加的用户信息
     * @return 返回1表示添加成功
     */
    int addUser(User user);

    /**
     * 通过用户名删除用户
     * @param username 待删除用户的用户名
     * @return 返回1表示删除成功
     */
    @Delete("delete from user where user_name = #{username}")
    int deleteUserByUserName(String username);

    /**
     * 根据用户id删除用户
     * @param id 待删除用户的id
     * @return 返回1表示删除成功
     */
    @Delete("delete from user where user_id = #{id}")
    int deleteUserByUserId(Integer id);

    /**
     *修改用户信息
     * @param user 待修改的用户信息
     * @return 返回1表示修改成功
     */
    int updateUserByUserName(User user);

    /**
     * 通过用户id查找用户
     * @param id 待查找的用户id
     * @return 查找到的用户
     */
    @Select("select * from user where user_id = #{id}")
    User findUserByUserId(Integer id);

    /**
     *通过用户名查找用户
     * @param username 待查找的用户名
     * @return 查找到的用户
     */
    @Select("select * from user where user_name = #{username}")
    User findUserByUserName(String username);

    /**
     *通过用户名获取用户密码
     * @param username 用户名
     * @return 返回对应的密码
     */
    @Select("select password from user where user_name = #{username}")
    String getUserPasswordByUserName(String username);

    /**
     *查询所有用户
     * @return用户列表
     */
    @Select("select * from user")
    List<User> getAllUserInfo();
}

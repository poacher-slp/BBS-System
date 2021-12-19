package per.poacher.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import per.poacher.pojo.UserLoginLog;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-12:51
 */
@Repository
public interface UserLoginLogMapper {

    /**
     *获取所有用户的登录日志
     * @return 日志列表
     */
    @Select("select * from login_log")
    List<UserLoginLog> listAllUserLoginLog();

    /**
     * 添加登录日志
     * @param userLoginLog 登录日志
     * @return 返回1表示添加成功
     */

    int addUserLoginLog(UserLoginLog userLoginLog);
}

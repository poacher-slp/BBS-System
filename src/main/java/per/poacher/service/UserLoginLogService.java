package per.poacher.service;

import per.poacher.pojo.UserLoginLog;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-15:07
 */
public interface UserLoginLogService {

    /**
     * 查询所有用户的登录日志
     * @return 登录日志列表
     */
    List<UserLoginLog> listAllUserLoginLog();

    /**
     * 添加登录日志
     * @param userLoginLog 待添加的登录日志
     * @return 返回1表示添加成功
     */
    int addUserLoginLog(UserLoginLog userLoginLog);
}

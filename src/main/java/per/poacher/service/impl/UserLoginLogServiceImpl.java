package per.poacher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.poacher.mapper.UserLoginLogMapper;
import per.poacher.pojo.UserLoginLog;
import per.poacher.service.UserLoginLogService;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-15:07
 */
@Service
public class UserLoginLogServiceImpl implements UserLoginLogService {

    private UserLoginLogMapper userLoginLogMapper;

    @Autowired
    public void setUserLoginLogMapper(UserLoginLogMapper userLoginLogMapper) {
        this.userLoginLogMapper = userLoginLogMapper;
    }

    @Override
    public List<UserLoginLog> listAllUserLoginLog() {
        List<UserLoginLog> userLoginLogs = userLoginLogMapper.listAllUserLoginLog();
        return userLoginLogs;
    }

    @Override
    public int addUserLoginLog(UserLoginLog userLoginLog) {
        int i = userLoginLogMapper.addUserLoginLog(userLoginLog);
        return i;
    }
}

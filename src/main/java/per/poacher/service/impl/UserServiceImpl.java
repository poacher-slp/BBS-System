package per.poacher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.poacher.mapper.UserMapper;
import per.poacher.pojo.User;
import per.poacher.service.UserService;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-14:13
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int addUser(User user) {
        int i = userMapper.addUser(user);
        return i;
    }

    @Override
    public int deleteUserByUserName(String userName) {
        int i = userMapper.deleteUserByUserName(userName);
        return i;
    }

    @Override
    public int updateUserByUserName(User user) {
        int i = userMapper.updateUserByUserName(user);
        return i;
    }

    @Override
    public User getUserByUserName(String userName) {
        User user = userMapper.findUserByUserName(userName);
        return user;
    }

    @Override
    public String getPassword(String userName) {
        String password = userMapper.getUserPasswordByUserName(userName);
        return password;
    }

    @Override
    public List<User> getAllUser() {
        List<User> allUserInfo = userMapper.getAllUserInfo();
        return allUserInfo;
    }
}

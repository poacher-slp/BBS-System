package per.poacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import per.poacher.pojo.User;
import per.poacher.pojo.UserLoginLog;
import per.poacher.service.UserLoginLogService;
import per.poacher.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * @author poacher
 * @create 2021-12-19-16:12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserLoginLogService loginLogService;

    @Autowired
    public UserController(UserService userService, UserLoginLogService loginLogService) {
        this.userService = userService;
        this.loginLogService = loginLogService;
    }

    /**
     * 用户登录
     * @param loginUser 登录的用户
     * @param request   请求
     * @return 返回页面
     */
    @PostMapping("/userLogin")
    public String userLogin(User loginUser, HttpServletRequest request) {
        // 通过用户名查找User对象
        User user = userService.getUserByUserName(loginUser.getUserName());
        String password = "";
        if (user != null) {
            password = userService.getPassword(user.getUserName());
        }
        // 判断登录信息是否正确
        if (user != null && loginUser.getPassword().equals(password)) {
            // 获取登录基本信息
            String lastIp = request.getRemoteAddr();
            String userName = user.getUserName();
            Timestamp lastLoginTime = new Timestamp(System.currentTimeMillis());
            // 更新用户信息
            user.setLastIp(lastIp);
            user.setLastLoginTime(lastLoginTime);
            user.setCredit(5 + user.getCredit());
            userService.updateUserByUserName(user);
            // 更新用户登录日志
            UserLoginLog userLoginLog = new UserLoginLog();
            userLoginLog.setUserName(userName);
            userLoginLog.setLoginIp(lastIp);
            userLoginLog.setLoginDateTime(lastLoginTime);
            loginLogService.addUserLoginLog(userLoginLog);
            // 登陆成功，跳转到主页
            request.getSession().setAttribute("username", user.getUserName());
            return "redirect:/main";
        }
        // 登录失败，跳转页面
        request.setAttribute("Msg", "登录失败");
        return "error";
    }

    /**
     * 用户注册
     * @param userRegister 注册的用户
     * @param request      请求
     * @return 返回页面
     */
    @PostMapping("/register")
    public String userRegister(User userRegister, HttpServletRequest request) {
        User user = userRegister;
        if (user != null) {
            try {
                String username = user.getUserName();
                String ip = request.getRemoteAddr();
                // 如果数据库中没有该用户，可以注册，否则跳转页面
                if (userService.getUserByUserName(username) == null) {
                    // 添加用户
                    user.setLastIp(ip);
                    Timestamp createLoginTime = new Timestamp(System.currentTimeMillis());
                    user.setCreateTime(createLoginTime);
                    user.setLastLoginTime(createLoginTime);
                    userService.addUser(user);

                    // 添加用户登录日志
                    UserLoginLog userLoginLog = new UserLoginLog();
                    userLoginLog.setUserName(username);
                    userLoginLog.setLoginIp(ip);
                    userLoginLog.setLoginDateTime(createLoginTime);
                    loginLogService.addUserLoginLog(userLoginLog);

                    // 注册成功跳转
                    request.setAttribute("username", username);
                    return "index";
                } else {
                    request.setAttribute("Msg", "注册失败，用户名已被占用！");
                    return "error";
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("Msg", "发生未知错误！");
                return "error";
            }
        }

        request.setAttribute("Msg", "发生未知错误！");
        return "error";
    }

    /**
     * 显示个人信息
     * @param username 用户名
     * @param model
     * @return 返回页面
     */
    @RequestMapping("/listUserInfo")
    public String listUserInfo(String username, Model model) {
        User user = userService.getUserByUserName(username);
        model.addAttribute("user", user);
        return "user/userInfo";
    }

    /**
     * 修改个人信息页面
     * @param username 用户名
     * @param model
     * @return 返回页面
     */
    @GetMapping("/userUpdateInfo")
    public String userUpdateInfoPage(String username, Model model) {
        User user = userService.getUserByUserName(username);
        model.addAttribute("user", user);
        return "user/userUpdateInfo";
    }

    /**
     * 提交用户修改信息
     * @param user 修改后的用户
     * @param redirectAttributes 重定向
     * @return 重定向页面
     */
    @PostMapping("/updateUserInfo")
    public String updateUserInfo(User user, RedirectAttributes redirectAttributes) {
        User newUser = user;
        userService.updateUserByUserName(newUser);
        redirectAttributes.addAttribute("username", newUser.getUserName());
        return "redirect:/user/listUserInfo";
    }

    /**
     * 用户注销功能
     * @param request 请求
     * @return 返回页面
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request, HttpSession session) {
        session.removeAttribute("username");
        return "index";
    }
}

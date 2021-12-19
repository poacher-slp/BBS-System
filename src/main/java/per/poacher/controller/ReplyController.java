package per.poacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import per.poacher.pojo.Reply;
import per.poacher.service.ReplyService;
import per.poacher.service.UserService;

/**
 * @author poacher
 * @create 2021-12-19-16:13
 */
@Controller
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyService replyService;
    private final UserService userService;

    @Autowired
    public ReplyController(ReplyService replyService, UserService userService) {
        this.replyService = replyService;
        this.userService = userService;
    }

    /**
     * 添加回复
     * @param reply 新增的回复
     * @return 重定向页面
     */
    @PostMapping("/addReply")
    public String addReply(Reply reply) {
        replyService.addReply(reply);
        return "redirect:/post/postContent/" + reply.getReplyPostId();
    }
}

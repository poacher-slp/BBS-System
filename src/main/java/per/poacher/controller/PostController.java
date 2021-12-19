package per.poacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import per.poacher.pojo.Post;
import per.poacher.pojo.Reply;
import per.poacher.service.BoardService;
import per.poacher.service.PostService;
import per.poacher.service.ReplyService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-16:13
 */
@Controller
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final BoardService boardService;
    private final ReplyService replyService;

    @Autowired
    public PostController(PostService postService, BoardService boardService, ReplyService replyService) {
        this.postService = postService;
        this.boardService = boardService;
        this.replyService = replyService;
    }

    /**
     * 添加帖子
     * @param post 新增的文章
     * @return 返回页面
     */
    @RequestMapping("/addPost")
    public String addPost(Post post) {
        if (post != null) {
            Timestamp createLoginTime = new Timestamp(System.currentTimeMillis());
            post.setPostCreateTime(createLoginTime);
            post.setPostUpdateTime(createLoginTime);
            postService.addPostByPost(post);
            boardService.updatePostNum(post.getPostBoardId());
            return "redirect:/post/postContent/" + post.getPostId();
        }
        return "error";
    }

    /**
     * 查看帖子
     * @param postId  帖子 id
     * @param model
     * @return 返回页面
     */
    @RequestMapping("/postContent/{postId}")
    public String intoPost(@PathVariable("postId") int postId, Model model) {
        Post post = postService.listPostContent(postId);
        List<Reply> replies = replyService.listReplyByPostId(postId);
        if (post == null) {
            return "/error";
        }
        // 帖子有回复则添加回复信息
        if (replies != null) {
            model.addAttribute("replies", replies);
        }
        model.addAttribute("post", post);
        return "post/postContent";
    }
}

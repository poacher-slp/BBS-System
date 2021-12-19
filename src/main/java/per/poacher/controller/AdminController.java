package per.poacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import per.poacher.pojo.Board;
import per.poacher.pojo.Post;
import per.poacher.pojo.User;
import per.poacher.service.BoardService;
import per.poacher.service.PostService;
import per.poacher.service.ReplyService;
import per.poacher.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-16:23
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private BoardService boardService;
    private UserService userService;
    private PostService postService;
    private ReplyService replyService;

    @Autowired
    public AdminController(BoardService boardService, UserService userService, PostService postService, ReplyService replyService) {
        this.boardService = boardService;
        this.userService = userService;
        this.postService = postService;
        this.replyService = replyService;
    }

    /**
     * 论坛管理中心
     * @param session 请求
     * @return 页面
     */
    @RequestMapping("/manageCenter")
    public String manageCenter(HttpSession session) {
        if (session.getAttribute("username").equals("admin")) {
            return "admin/manageCenter";
        }
        return "redirect:/error";
    }

    /**
     * 论坛版块管理中心
     * @param session
     * @param model
     * @return 页面
     */
    @RequestMapping("/manageBoard")
    public String manageBoard(HttpSession session, Model model) {
        if (session.getAttribute("username").equals("admin")) {
            List<Board> boards = boardService.listAllBoard();
            model.addAttribute("boards", boards);
            return "admin/manageBoard";
        }
        return "redirect:/error";
    }

    /**
     * 添加论坛板块
     * @param board 新增的论坛版块
     * @param session
     * @return 页面
     */
    @PostMapping("/addBoard")
    public String addBoard(Board board, HttpSession session) {
        if (board != null) {
            boardService.addBoardByBoard(board);
            return "redirect:/admin/manageBoard";
        }
        session.setAttribute("Msg", "添加板块出错！");
        return "admin/error";
    }

    /**
     * 修改板块信息
     * @param board 修改的板块
     * @return 页面
     */
    @PostMapping("/updateBoard")
    public String updateBoard(Board board) {
        if (board != null) {
            boardService.updateBoardInfo(board);
            // 成功更新数据后跳转页面
            return "redirect:/admin/manageBoard";
        }
        // 更新数据失败跳转到错误页面
        return "redirect:/error";
    }

    /**
     * 管理用户信息
     * @param model
     * @return 页面
     */
    @RequestMapping("/manageUser")
    public String manageUser(Model model) {
        List<User> users = userService.getAllUser();
        if (users != null) {
            model.addAttribute("users", users);
            return "admin/allUserInfo";
        }

        return "redirect:/error";
    }

    /**
     * 管理发表的主题
     * @param model
     * @return 页面
     */
    @RequestMapping("/managePost")
    public String managePost(Model model) {
        List<Post> posts = postService.listAllPost();
        if (posts != null) {
            model.addAttribute("posts", posts);
            return "/admin/allPostInfo";
        }
        return "redirect:/error";
    }

    /**
     * 删除已经发表的文章
     * @param postId 文章 id
     * @param postBoardId 板块 id
     * @return 页面
     */
    @RequestMapping("/deletePost")
    public String deletePost(int postId, int postBoardId) {
        postService.deletePost(postId);
        return "redirect:/board/listPosts/" + postBoardId;
    }

    /**
     * 删除回复
     * @param replyId 回复 id
     * @param replyPostId 回复的文章 id
     * @return 页面
     */
    @RequestMapping("/deleteReply")
    public String deleteReply(int replyId, int replyPostId) {
        replyService.deleteReply(replyId);
        return "redirect:/post/postContent/" + replyPostId;
    }

    /**
     * 删除板块
     * @param boardId 板块 id
     * @return 页面
     */
    @RequestMapping("/deleteBoard")
    public String deleteBoard(int boardId) {
        boardService.deleteBoard(boardId);
        return "redirect:/admin/manageBoard";
    }
}

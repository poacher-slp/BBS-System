package per.poacher.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import per.poacher.pojo.Board;
import per.poacher.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-16:24
 */
@Controller
public class MainController {

    private BoardService boardService;

    @Autowired
    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 显示内容主页
     *
     * @param model
     * @return 返回页面
     */
    @RequestMapping("/main")
    public String mainPage(Model model) {
        List<Board> boards = boardService.listAllBoard();
        model.addAttribute("board", boards);
        return "mainPage";
    }


    /**
     * 显示添加文章的页面
     * @param userName 用户名
     * @param boardId  板块 id
     * @param model    请求
     * @return 返回页面
     */
    @RequestMapping("/addPost")
    public String addPost(String userName, String boardId, Model model) {
        if (userName != null && boardId != null) {
            model.addAttribute("username", userName);
            model.addAttribute("boardId", boardId);
            return "/post/addPost";
        }
        return "redirect:/error";
    }

    /**
     * 显示添加回复的页面
     * @param replyPostId   回复的文章的 id
     * @param replyUserName 回复用户的姓名
     * @param model         请求
     * @return 返回页面
     */
    @RequestMapping("/addReply")
    public String addReply(int replyPostId, String replyUserName, Model model) {
        if (replyPostId > 0 && replyUserName != null) {
            model.addAttribute("replyPostId", replyPostId);
            model.addAttribute("replyUserName", replyUserName);
            return "reply/reply";
        }
        return "redirect:/error";
    }

    /**
     * 显示板块
     * @param boardId 板块 id
     * @param model
     * @return 返回页面
     */
    @RequestMapping("/updateBoardPage")
    public String updateBoardPage(int boardId, Model model) {
        Board board = boardService.intoBoardByBoardId(boardId);
        if (board != null) {
            model.addAttribute("boardName", board.getBoardName());
            model.addAttribute("boardDesc", board.getBoardDesc());
            model.addAttribute("boardId", board.getBoardId());
            model.addAttribute("boardPostNum", board.getBoardPostNum());
            return "/admin/updateBoard";
        }
        return "/admin/updateBoard";
    }
}

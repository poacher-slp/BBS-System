package per.poacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import per.poacher.pojo.Board;
import per.poacher.service.BoardService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author poacher
 * @create 2021-12-19-16:13
 */
@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 显示指定板块的文章
     * @param boardId 板块 id
     * @param model
     * @return 返回页面
     */
    @RequestMapping("/listPosts/{boardId}")
    public String intoBoard(@PathVariable("boardId") int boardId, Model model) {
        Board board = boardService.listAllPostOfBoard(boardId);
        model.addAttribute("board", board);
        model.addAttribute("boardId", boardId);
        return "post/postMain";
    }
}

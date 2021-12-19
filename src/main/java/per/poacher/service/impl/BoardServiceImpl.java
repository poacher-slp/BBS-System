package per.poacher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.poacher.mapper.BoardMapper;
import per.poacher.pojo.Board;
import per.poacher.service.BoardService;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-15:58
 */
@Service
public class BoardServiceImpl implements BoardService {

    private BoardMapper boardMapper;

    @Autowired
    public void setBoardMapper(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public int addBoardByBoard(Board board) {
        int i = boardMapper.addBoard(board);
        return i;
    }

    @Override
    public int deleteBoardByBoardName(String boardName) {
        return 0;
    }

    @Override
    public List<Board> listAllBoard() {
        List<Board> boards = boardMapper.listAllBoard();
        return boards;
    }

    @Override
    public Board listAllPostOfBoard(int boardId) {
        Board board = boardMapper.listAllPostsOfBoard(boardId);
        return board;
    }

    @Override
    public Board intoBoardByBoardId(int boardId) {
        Board board = boardMapper.findBoardByBoardId(boardId);
        return board;
    }

    @Override
    public Board intoBoardByBoardName(String boardName) {
        Board board = boardMapper.findBoardByBoardName(boardName);
        return board;
    }

    @Override
    public int updatePostNum(int boardId) {
        Board board = boardMapper.findBoardByBoardId(boardId);
        board.setBoardPostNum(board.getBoardPostNum() + 1);
        int i = boardMapper.updateBoardByBoard(board);
        return i;
    }

    @Override
    public int updateBoardInfo(Board board) {
        int i = boardMapper.updateBoardByBoard(board);
        return i;
    }

    @Override
    public int deleteBoard(int boardId) {
        int i = boardMapper.deleteBoardById(boardId);
        return i;
    }
}

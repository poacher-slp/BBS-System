package per.poacher.service;

import per.poacher.pojo.Board;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-15:58
 */
public interface BoardService {

    /**
     * 添加板块
     * @param board 待添加的板块
     * @return 返回1表示添加成功
     */
    int addBoardByBoard(Board board);

    /**
     * 通过版块名删除板块
     * @param boardName 待删除的板块的板块名
     * @return 返回1表示删除成功
     */
    int deleteBoardByBoardName(String boardName);

    /**
     * 获取所有板块
     * @return 板块列表
     */
    List<Board> listAllBoard();

    /**
     * 获取指定板块的帖子
     * @param boardId 板块的id
     * @return 帖子列表
     */
    Board listAllPostOfBoard(int boardId);

    /**
     * 通过id获取板块
     * @param boardId 待查找的板块的id
     * @return 查找到的板块
     */
    Board intoBoardByBoardId(int boardId);

    /**
     * 通过板块名获取板块
     * @param boardName 待查找的板块的版块名
     * @return 查找到的板块
     */
    Board intoBoardByBoardName(String boardName);

    /**
     * 更新板块的帖子数量内容
     * @param boardId 板块的id
     * @return 返回1表示更新成功
     */
    int updatePostNum(int boardId);

    /**
     * 更新板块信息
     * @param board 待更新的板块内容
     * @return 返回1表示更新成功
     */
    int updateBoardInfo(Board board);

    /**
     * 根据id删除板块
     * @param boardId 待删除的板块id
     * @return 返回1表示删除成功
     */
    int deleteBoard(int boardId);
}

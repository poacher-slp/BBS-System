package per.poacher.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import per.poacher.pojo.Board;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-12:50
 */
@Repository
public interface BoardMapper {

    /**
     *添加板块
     * @param board 待添加的板块
     * @return 返回1表示添加成功
     */
    int addBoard(Board board);

    /**
     * 获取所有板块
     * @return 板块列表
     */
    @Select("select * from board")
    List<Board> listAllBoard();

    /**
     * 根据主题id获取主题板块的所有帖子
     * @param boardId 待查询的板块的id
     * @return 帖子列表
     */

    Board listAllPostsOfBoard(int boardId);

    /**
     * 通过板块id查找指定的主题
     * @param boardId 待查找的板块id
     * @return 查找到的板块
     */
    @Select("select * from board where board_id = #{boardId}")
    Board findBoardByBoardId(int boardId);

    /**
     * 通过板块名查找板块
     * @param boardName 板块名
     * @return 查找到的板块
     */
    @Select("select * from board where board_id = #{boardId}")
    Board findBoardByBoardName(String boardName);

    /**
     *更新板块信息
     * @param board 更新的板块内容
     * @return 返回1表示更新成功
     */
    int updateBoardByBoard(Board board);

    /**
     * 根据板块id删除板块
     * @param boardId 但删除的板块id
     * @return 返回1表示删除成功
     */
    @Delete("DELETE FROM board WHERE board_id = #{boardId}")
    int deleteBoardById(int boardId);

    /**
     *查找相应版块的帖子数量
     * @param boardId 板块的id
     * @return 返回板块下的帖子数
     */
    @Select("select board_post_num from board where board_id = #{boardId}")
    int boardPostNum(int boardId);
}

package per.poacher.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import per.poacher.pojo.Reply;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-12:50
 */
@Repository
public interface ReplyMapper {

    /**
     *添加回复
     * @param reply 需要添加的回复
     * @return 返回1表示添加成功
     */
    @Insert("insert into reply(reply_post_id,reply_user_name,reply_content,reply_create_time) " +
            "values(#{replyPostId}, #{replyUserName}, #{replyContent}, #{replyCreateTime})")
    int addReply(Reply reply);

    /**
     * 根据帖子id删除回复
     * @param postId 待删除帖子的id
     * @return 返回1表示删除成功
     */
    @Delete("delete from reply where reply_id = #{postId}")
    int deleteReplyById(int postId);

    /**
     * 根据指定帖子id查询回复
     * @param postId 待查询回复的帖子的id
     * @return 回复列表
     */
    @Select("select * from reply where reply_post_id = #{postId}")
    List<Reply> listReplyByPostId(int postId);

    /**
     *通过回复id查找回复
     * @param replyId 回复的id
     * @return 查找到的回复
     */
    @Select("select * from reply where reply_id = #{replyId}")
    Reply findReplyByReplyId(int replyId);

    /**
     *查询所有回复
     * @return 回复列表
     */
    @Select("select * from reply")
    List<Reply> listAllReply();
}

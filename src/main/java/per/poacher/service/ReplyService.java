package per.poacher.service;

import per.poacher.pojo.Post;
import per.poacher.pojo.Reply;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-15:23
 */
public interface ReplyService {

    /**
     *添加回复
     * @param reply 回复的内容
     * @return 返回1表示添加成功
     */
    int addReply(Reply reply);

    /**
     * 根据回复的id删除删除
     * @param replyId 待删除的回复的id
     * @return 返回1表示删除成功
     */
    int deleteReply(int replyId);

    /**
     * 根据帖子id获取回复的内容
     * @param postId 帖子的id
     * @return 回复列表
     */
    List<Reply> listReplyByPostId(int postId);
}

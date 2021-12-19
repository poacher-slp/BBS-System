package per.poacher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.poacher.mapper.PostMapper;
import per.poacher.mapper.ReplyMapper;
import per.poacher.pojo.Post;
import per.poacher.pojo.Reply;
import per.poacher.service.ReplyService;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-15:24
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    private ReplyMapper replyMapper;
    private PostMapper postMapper;

    @Autowired
    public ReplyServiceImpl(ReplyMapper replyMapper, PostMapper postMapper) {
        this.replyMapper = replyMapper;
        this.postMapper = postMapper;
    }

    @Override
    public int addReply(Reply reply) {
//        更新帖子信息
        Integer postId = reply.getReplyPostId();
        Post post = postMapper.findPostByPostId(postId);
        post.setPostReplyCount(post.getPostReplyCount() + 1);
        int i = postMapper.updatePostByPost(post);
//        添加回复
        reply.setReplyCreateTime(new Timestamp(System.currentTimeMillis()));
        int addReply = replyMapper.addReply(reply);
        return addReply;
    }

    @Override
    public int deleteReply(int replyId) {
        Reply reply = replyMapper.findReplyByReplyId(replyId);
        Post post = postMapper.findPostByPostId(reply.getReplyPostId());
        post.setPostReplyCount(post.getPostReplyCount() - 1);
        int i = postMapper.updatePostByPost(post);
        int deleteReplyById = replyMapper.deleteReplyById(replyId);
        return deleteReplyById;
    }

    @Override
    public List<Reply> listReplyByPostId(int postId) {
        List<Reply> replies = replyMapper.listReplyByPostId(postId);
        return replies;
    }
}

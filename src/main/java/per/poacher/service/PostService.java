package per.poacher.service;

import per.poacher.pojo.Post;
import per.poacher.pojo.Reply;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-15:23
 */
public interface PostService {



    /**
     * 添加帖子
     * @param post 待添加的帖子内容
     * @return 返回1表示添加成功
     */
    int addPostByPost(Post post);

    /**
     * 根据id删除帖子
     * @param postId 待删除帖子的id
     * @return 返回1表示删除成功
     */
    int deletePost(int postId);

    /**
     * 根据帖子id获取帖子内容
     * @param postId 带查询的帖子的id
     * @return 查找到的帖子
     */
    Post listPostContent(int postId);

    /**
     * 获取所有帖子
     * @return 帖子列表
     */
    List<Post> listAllPost();
}

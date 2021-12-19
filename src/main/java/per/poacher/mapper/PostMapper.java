package per.poacher.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import per.poacher.pojo.Post;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-12:50
 */
@Repository
public interface PostMapper {

    /**
     *添加帖子
     * @param post 待添加的帖子信息
      * @return 返回1表示添加成功
     */
    int addPost(Post post);

    /**
     * 通过帖子id删除帖子
     * @param postId 待删除帖子的id
     * @return 返回1表示删除成功
     */
    @Delete("DELETE FROM post WHERE post_id = #{postId}")
    int deletePostById(int postId);

    /**
     * 更新帖子内容
     * @param post 待更新的帖子内容
     * @return 返回1表示更新成功
     */
    @Update("UPDATE post SET post_reply_count = #{postReplyCount} WHERE post_id = #{postId}")
    int updatePostByPost(Post post);

    /**
     * 通过帖子id查找帖子
     * @param postId 待查找的帖子id
     * @return 查找到的帖子
     */
    @Select("SELECT * FROM post WHERE post_id = #{postId}")
    Post findPostByPostId(int postId);

    /**
     * 查找所有帖子信息
     * @return 帖子列表
     */
    @Select("select * from post")
    List<Post> listAllPostInfo();
}

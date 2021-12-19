package per.poacher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.poacher.mapper.BoardMapper;
import per.poacher.mapper.PostMapper;
import per.poacher.pojo.Board;
import per.poacher.pojo.Post;
import per.poacher.pojo.Reply;
import per.poacher.service.PostService;

import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-15:24
 */
@Service
public class PostServiceImpl implements PostService {

    private PostMapper postMapper;
    private BoardMapper boardMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper, BoardMapper boardMapper) {
        this.postMapper = postMapper;
        this.boardMapper = boardMapper;
    }

    @Override
    public int addPostByPost(Post post) {
        int i = postMapper.addPost(post);
        return i;
    }

    @Override
    public int deletePost(int postId) {
        Integer boardId = postMapper.findPostByPostId(postId).getPostBoardId();
        Board board = boardMapper.findBoardByBoardId(boardId);
        board.setBoardPostNum(board.getBoardPostNum() - 1);
        boardMapper.updateBoardByBoard(board);
        int i = postMapper.deletePostById(postId);
        return i;
    }

    @Override
    public Post listPostContent(int postId) {
        Post post = postMapper.findPostByPostId(postId);
        return post;
    }

    @Override
    public List<Post> listAllPost() {
        List<Post> posts = postMapper.listAllPostInfo();
        return posts;
    }
}

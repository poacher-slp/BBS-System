package per.poacher.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-12:40
 */
public class Board implements Serializable {

    private Integer boardId;
    private String boardName;
    private String boardDesc;
    private long boardPostNum;
    private List<Post> posts;   //文章列表

    public Board() {
    }

    public Board(Integer boardId, String boardName, String boardDesc, long boardPostNum, List<Post> posts) {
        this.boardId = boardId;
        this.boardName = boardName;
        this.boardDesc = boardDesc;
        this.boardPostNum = boardPostNum;
        this.posts = posts;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardDesc() {
        return boardDesc;
    }

    public void setBoardDesc(String boardDesc) {
        this.boardDesc = boardDesc;
    }

    public long getBoardPostNum() {
        return boardPostNum;
    }

    public void setBoardPostNum(long boardPostNum) {
        this.boardPostNum = boardPostNum;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", boardName='" + boardName + '\'' +
                ", boardDesc='" + boardDesc + '\'' +
                ", boardPostNum=" + boardPostNum +
                ", posts=" + posts +
                '}';
    }
}

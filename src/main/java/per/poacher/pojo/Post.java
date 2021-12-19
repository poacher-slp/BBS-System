package per.poacher.pojo;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author poacher
 * @create 2021-12-19-12:41
 */
public class Post {

    private User user;
    private Integer postId;
    private Integer postBoardId;
    private String postUserName;
    private String postTitle;
    private String postContent;
    private Integer postGoodCount;
    private Integer postBadCount;
    private Integer postViewCount;
    private Integer postReplyCount;
    private Integer postStatus;
    private Timestamp postCreateTime;
    private Timestamp postUpdateTime;
    private List<Reply> replies;

    public Post() {
    }

    public Post(User user, Integer postId, Integer postBoardId, String postUserName, String postTitle, String postContent, Integer postGoodCount, Integer postBadCount, Integer postViewCount, Integer postReplyCount, Integer postStatus, Timestamp postCreateTime, Timestamp postUpdateTime, List<Reply> replies) {
        this.user = user;
        this.postId = postId;
        this.postBoardId = postBoardId;
        this.postUserName = postUserName;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postGoodCount = postGoodCount;
        this.postBadCount = postBadCount;
        this.postViewCount = postViewCount;
        this.postReplyCount = postReplyCount;
        this.postStatus = postStatus;
        this.postCreateTime = postCreateTime;
        this.postUpdateTime = postUpdateTime;
        this.replies = replies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getPostBoardId() {
        return postBoardId;
    }

    public void setPostBoardId(Integer postBoardId) {
        this.postBoardId = postBoardId;
    }

    public String getPostUserName() {
        return postUserName;
    }

    public void setPostUserName(String postUserName) {
        this.postUserName = postUserName;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Integer getPostGoodCount() {
        return postGoodCount;
    }

    public void setPostGoodCount(Integer postGoodCount) {
        this.postGoodCount = postGoodCount;
    }

    public Integer getPostBadCount() {
        return postBadCount;
    }

    public void setPostBadCount(Integer postBadCount) {
        this.postBadCount = postBadCount;
    }

    public Integer getPostViewCount() {
        return postViewCount;
    }

    public void setPostViewCount(Integer postViewCount) {
        this.postViewCount = postViewCount;
    }

    public Integer getPostReplyCount() {
        return postReplyCount;
    }

    public void setPostReplyCount(Integer postReplyCount) {
        this.postReplyCount = postReplyCount;
    }

    public Integer getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    public Timestamp getPostCreateTime() {
        return postCreateTime;
    }

    public void setPostCreateTime(Timestamp postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    public Timestamp getPostUpdateTime() {
        return postUpdateTime;
    }

    public void setPostUpdateTime(Timestamp postUpdateTime) {
        this.postUpdateTime = postUpdateTime;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    @Override
    public String toString() {
        return "Post{" +
                "user=" + user +
                ", postId=" + postId +
                ", postBoardId=" + postBoardId +
                ", postUserName='" + postUserName + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postGoodCount=" + postGoodCount +
                ", postBadCount=" + postBadCount +
                ", postViewCount=" + postViewCount +
                ", postReplyCount=" + postReplyCount +
                ", postStatus=" + postStatus +
                ", postCreateTime=" + postCreateTime +
                ", postUpdateTime=" + postUpdateTime +
                ", replies=" + replies +
                '}';
    }
}

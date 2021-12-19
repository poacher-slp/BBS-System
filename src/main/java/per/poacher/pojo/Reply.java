package per.poacher.pojo;

import java.sql.Timestamp;

/**
 * @author poacher
 * @create 2021-12-19-12:42
 */
public class Reply {

    private Integer replyId;
    private Integer replyPostId;
    private String replyUserName;
    private String replyContent;
    private Integer replyGoodCount;
    private Integer replyBadCount;
    private Timestamp replyCreateTime;

    public Reply() {
    }

    public Reply(Integer replyId, Integer replyPostId, String replyUserName, String replyContent, Integer replyGoodCount, Integer replyBadCount, Timestamp replyCreateTime) {
        this.replyId = replyId;
        this.replyPostId = replyPostId;
        this.replyUserName = replyUserName;
        this.replyContent = replyContent;
        this.replyGoodCount = replyGoodCount;
        this.replyBadCount = replyBadCount;
        this.replyCreateTime = replyCreateTime;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getReplyPostId() {
        return replyPostId;
    }

    public void setReplyPostId(Integer replyPostId) {
        this.replyPostId = replyPostId;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getReplyGoodCount() {
        return replyGoodCount;
    }

    public void setReplyGoodCount(Integer replyGoodCount) {
        this.replyGoodCount = replyGoodCount;
    }

    public Integer getReplyBadCount() {
        return replyBadCount;
    }

    public void setReplyBadCount(Integer replyBadCount) {
        this.replyBadCount = replyBadCount;
    }

    public Timestamp getReplyCreateTime() {
        return replyCreateTime;
    }

    public void setReplyCreateTime(Timestamp replyCreateTime) {
        this.replyCreateTime = replyCreateTime;
    }

    @Override
    public String toString() {
        return "ReplyServiceImpl{" +
                "replyId=" + replyId +
                ", replyPostId=" + replyPostId +
                ", replyUserName='" + replyUserName + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", replyGoodCount=" + replyGoodCount +
                ", replyBadCount=" + replyBadCount +
                ", replyCreateTime=" + replyCreateTime +
                '}';
    }
}

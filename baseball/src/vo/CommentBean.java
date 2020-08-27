package vo;

import java.sql.Date;

public class CommentBean {
	private int comment_no;
	private int sajahu_no;
	private String memberbb_id;
	private String comment_content;
	private Date comment_date;
	private int commentAvilable;
	
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public int getSajahu_no() {
		return sajahu_no;
	}
	public void setSajahu_no(int sajahu_no) {
		this.sajahu_no = sajahu_no;
	}
	public String getMemberbb_id() {
		return memberbb_id;
	}
	public void setMemberbb_id(String memberbb_id) {
		this.memberbb_id = memberbb_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public int getCommentAvilable() {
		return commentAvilable;
	}
	public void setCommentAvilable(int commentAvilable) {
		this.commentAvilable = commentAvilable;
	}
	
}

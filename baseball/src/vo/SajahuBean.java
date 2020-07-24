package vo;

import java.sql.Date;

public class SajahuBean {
	private int sajahu_no;
	private String sajahu_id;
	private String sajahu_title;
	private String sajahu_content;
	private int sajahu_readcount;
	private Date sajahu_date;
	private long commentCount;
	
	public long getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}
	public int getSajahu_no() {
		return sajahu_no;
	}
	public void setSajahu_no(int sajahu_no) {
		this.sajahu_no = sajahu_no;
	}
	public String getSajahu_id() {
		return sajahu_id;
	}
	public void setSajahu_id(String sajahu_id) {
		this.sajahu_id = sajahu_id;
	}
	public String getSajahu_title() {
		return sajahu_title;
	}
	public void setSajahu_title(String sajahu_title) {
		this.sajahu_title = sajahu_title;
	}
	public String getSajahu_content() {
		return sajahu_content;
	}
	public void setSajahu_content(String sajahu_content) {
		this.sajahu_content = sajahu_content;
	}
	public int getSajahu_readcount() {
		return sajahu_readcount;
	}
	public void setSajahu_readcount(int sajahu_readcount) {
		this.sajahu_readcount = sajahu_readcount;
	}
	public Date getSajahu_date() {
		return sajahu_date;
	}
	public void setSajahu_date(Date sajahu_date) {
		this.sajahu_date = sajahu_date;
	}
	
	
}

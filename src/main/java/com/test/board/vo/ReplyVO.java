package com.test.board.vo;

public class ReplyVO {
	
	private String replySeq;
	private String boardSeq;
	private String id;
	private String content;
	private String regdate;
	
	
	
	public ReplyVO() {
		super();
	}

	public ReplyVO(String replySeq, String boardSeq, String id, String content, String regdate) {
		super();
		this.replySeq = replySeq;
		this.boardSeq = boardSeq;
		this.id = id;
		this.content = content;
		this.regdate = regdate;
	}

	public String getReplySeq() {
		return replySeq;
	}

	public void setReplySeq(String replySeq) {
		this.replySeq = replySeq;
	}

	public String getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(String boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "ReplyVO [replySeq=" + replySeq + ", boardSeq=" + boardSeq + ", id=" + id + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}
	
	

}

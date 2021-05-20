package com.test.board.vo;

public class BoardVO {
	
	private String boardSeq;
	private String title;
	private String content;
	private String id;
	private String regdate;
	
	public BoardVO() {}
	
	public BoardVO(String boardSeq, String title, String content, String id, String regdate) {
		super();
		this.boardSeq = boardSeq;
		this.title = title;
		this.content = content;
		this.id = id;
		this.regdate = regdate;
	}

	public String getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(String boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Board [boardSeq=" + boardSeq + ", title=" + title + ", content=" + content + ", id=" + id + ", regdate="
				+ regdate + "]";
	}
	
	

}

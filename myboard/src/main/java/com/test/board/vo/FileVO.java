package com.test.board.vo;

public class FileVO {
	
	private String fileSeq;
	private String boardSeq;
	private String orgName;
	private String savName;
	
	public FileVO(String fileSeq, String boardSeq, String orgName, String savName) {
		super();
		this.fileSeq = fileSeq;
		this.boardSeq = boardSeq;
		this.orgName = orgName;
		this.savName = savName;
	}
	public FileVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFileSeq() {
		return fileSeq;
	}
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	public String getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(String boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getSavName() {
		return savName;
	}
	public void setSavName(String savName) {
		this.savName = savName;
	}
	@Override
	public String toString() {
		return "FileVO [fileSeq=" + fileSeq + ", boardSeq=" + boardSeq + ", orgName=" + orgName + ", savName=" + savName
				+ "]";
	}
	
	
	

}

package com.test.board.vo;


public class DonateVO {
	
	
	private String imp_uid;
	private String buyer_name;
	private String paid_amount;
	public DonateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getImp_uid() {
		return imp_uid;
	}
	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(String paid_amount) {
		this.paid_amount = paid_amount;
	}
	@Override
	public String toString() {
		return "DonateVO [imp_uid=" + imp_uid + ", buyer_name=" + buyer_name + ", paid_amount=" + paid_amount + "]";
	}
	
	
	
	
	
	
	
	
	

	
	
}

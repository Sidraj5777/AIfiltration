package com.vertoz.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Creative {

	 private String id;
	    private List<SeatBid> seatbid;
	    private String cur;
	    private Ext ext;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public List<SeatBid> getSeatbid() {
			return seatbid;
		}
		public void setSeatbid(List<SeatBid> seatbid) {
			this.seatbid = seatbid;
		}
		public String getCur() {
			return cur;
		}
		public void setCur(String cur) {
			this.cur = cur;
		}
		public Ext getExt() {
			return ext;
		}
		public void setExt(Ext ext) {
			this.ext = ext;
		}
	    
	    
	
}

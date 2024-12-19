package com.vertoz.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bid {
	 private String id;
	    private String impid;
	    private double price;
	    private String nurl;
	    private String adm;
	    private String adid;
	    private List<String> adomain;
	    private String iurl;
	    private String cid;
	    private String crid;
	    private List<String> cat;
	    private int w;
	    private int h;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getImpid() {
			return impid;
		}
		public void setImpid(String impid) {
			this.impid = impid;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getNurl() {
			return nurl;
		}
		public void setNurl(String nurl) {
			this.nurl = nurl;
		}
		public String getAdm() {
			return adm;
		}
		public void setAdm(String adm) {
			this.adm = adm;
		}
		public String getAdid() {
			return adid;
		}
		public void setAdid(String adid) {
			this.adid = adid;
		}
		public List<String> getAdomain() {
			return adomain;
		}
		public void setAdomain(List<String> adomain) {
			this.adomain = adomain;
		}
		public String getIurl() {
			return iurl;
		}
		public void setIurl(String iurl) {
			this.iurl = iurl;
		}
		public String getCid() {
			return cid;
		}
		public void setCid(String cid) {
			this.cid = cid;
		}
		public String getCrid() {
			return crid;
		}
		public void setCrid(String crid) {
			this.crid = crid;
		}
		public List<String> getCat() {
			return cat;
		}
		public void setCat(List<String> cat) {
			this.cat = cat;
		}
		public int getW() {
			return w;
		}
		public void setW(int w) {
			this.w = w;
		}
		public int getH() {
			return h;
		}
		public void setH(int h) {
			this.h = h;
		}
	    
	    
}

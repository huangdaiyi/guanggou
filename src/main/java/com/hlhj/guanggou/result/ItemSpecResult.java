package com.hlhj.guanggou.result;

import java.math.BigDecimal;

/**
 * 规格返回类型
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class ItemSpecResult {
	private Integer id;

	private String productid;

	private String speccolor;

	private String specsize;

	private String specstock;

	private BigDecimal specprice;

	private String specstatus;

	private String specmodel;

	private String specspec;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid == null ? null : productid.trim();
	}

	public String getSpeccolor() {
		return speccolor;
	}

	public void setSpeccolor(String speccolor) {
		this.speccolor = speccolor == null ? null : speccolor.trim();
	}

	public String getSpecsize() {
		return specsize;
	}

	public void setSpecsize(String specsize) {
		this.specsize = specsize == null ? null : specsize.trim();
	}

	public String getSpecstock() {
		return specstock;
	}

	public void setSpecstock(String specstock) {
		this.specstock = specstock == null ? null : specstock.trim();
	}

	public BigDecimal getSpecprice() {
		return specprice;
	}

	public void setSpecprice(BigDecimal specprice) {
		this.specprice = specprice;
	}

	public String getSpecstatus() {
		return specstatus;
	}

	public void setSpecstatus(String specstatus) {
		this.specstatus = specstatus == null ? null : specstatus.trim();
	}

	public String getSpecmodel() {
		return specmodel;
	}

	public void setSpecmodel(String specmodel) {
		this.specmodel = specmodel == null ? null : specmodel.trim();
	}

	public String getSpecspec() {
		return specspec;
	}

	public void setSpecspec(String specspec) {
		this.specspec = specspec == null ? null : specspec.trim();
	}

}

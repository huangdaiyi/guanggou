package com.hlhj.guanggou.result;

import java.math.BigDecimal;

/**
 * 收藏商品
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class FavoriteProduct {
	private int id;
	private String name;
	private BigDecimal price;
	private String picture;
	private String catalogId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

}

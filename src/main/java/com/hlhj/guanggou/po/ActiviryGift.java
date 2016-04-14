package com.hlhj.guanggou.po;

import java.math.BigDecimal;

/**
 * 赠品
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class ActiviryGift {

	private int id;

	private String name;

	private String imageUrl;

	private BigDecimal price;

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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}

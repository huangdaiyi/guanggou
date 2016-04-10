package com.hlhj.guanggou.result;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 类型说明
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class ProductDetailWithSpec {

	private Integer id;

	private String name;

	private String code;

	private String sku;

	private String productno;

	private String barcode;

	private String introduce;

	private BigDecimal price;

	private BigDecimal nowprice;

	private String picture;

	private Date createtime;

	private String createaccount;

	private String updateaccount;

	private Date updatetime;

	private String service;

	private String isnew;

	private String sale;

	private Integer hit;

	private Integer status;

	private String maxpicture;

	private String images;

	private String catalogid;

	private Integer sellcount;

	private Integer stock;

	private String searchkey;

	private String title;

	private String description;

	private String keywords;

	private String activityid;

	private String unit;

	private Integer score;

	private String istimepromotion;

	private String giftid;

	private String marketid;

	private String shopid;

	private String explosion;

	private String salepromotion;

	private String hotsale;

	private Integer attentioncount;

	private String updateprice;

	private String delflag;

	private BigDecimal deposit;

	private BigDecimal appprice;

	private String ispaydelivery;

	private String isdeposit;
	
	private List<String> catalogType;
	
	private List<ItemSpecResult> listmap;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku == null ? null : sku.trim();
	}

	public String getProductno() {
		return productno;
	}

	public void setProductno(String productno) {
		this.productno = productno == null ? null : productno.trim();
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode == null ? null : barcode.trim();
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce == null ? null : introduce.trim();
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getNowprice() {
		return nowprice;
	}

	public void setNowprice(BigDecimal nowprice) {
		this.nowprice = nowprice;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture == null ? null : picture.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreateaccount() {
		return createaccount;
	}

	public void setCreateaccount(String createaccount) {
		this.createaccount = createaccount == null ? null : createaccount
				.trim();
	}

	public String getUpdateaccount() {
		return updateaccount;
	}

	public void setUpdateaccount(String updateaccount) {
		this.updateaccount = updateaccount == null ? null : updateaccount
				.trim();
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service == null ? null : service.trim();
	}

	public String getIsnew() {
		return isnew;
	}

	public void setIsnew(String isnew) {
		this.isnew = isnew == null ? null : isnew.trim();
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale == null ? null : sale.trim();
	}

	public Integer getHit() {
		return hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMaxpicture() {
		return maxpicture;
	}

	public void setMaxpicture(String maxpicture) {
		this.maxpicture = maxpicture == null ? null : maxpicture.trim();
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images == null ? null : images.trim();
	}

	public String getCatalogid() {
		return catalogid;
	}

	public void setCatalogid(String catalogid) {
		this.catalogid = catalogid == null ? null : catalogid.trim();
	}

	public Integer getSellcount() {
		return sellcount;
	}

	public void setSellcount(Integer sellcount) {
		this.sellcount = sellcount;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getSearchkey() {
		return searchkey;
	}

	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey == null ? null : searchkey.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords == null ? null : keywords.trim();
	}

	public String getActivityid() {
		return activityid;
	}

	public void setActivityid(String activityid) {
		this.activityid = activityid == null ? null : activityid.trim();
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getIstimepromotion() {
		return istimepromotion;
	}

	public void setIstimepromotion(String istimepromotion) {
		this.istimepromotion = istimepromotion == null ? null : istimepromotion
				.trim();
	}

	public String getGiftid() {
		return giftid;
	}

	public void setGiftid(String giftid) {
		this.giftid = giftid == null ? null : giftid.trim();
	}

	public String getMarketid() {
		return marketid;
	}

	public void setMarketid(String marketid) {
		this.marketid = marketid == null ? null : marketid.trim();
	}

	public String getShopid() {
		return shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid == null ? null : shopid.trim();
	}

	public String getExplosion() {
		return explosion;
	}

	public void setExplosion(String explosion) {
		this.explosion = explosion == null ? null : explosion.trim();
	}

	public String getSalepromotion() {
		return salepromotion;
	}

	public void setSalepromotion(String salepromotion) {
		this.salepromotion = salepromotion == null ? null : salepromotion
				.trim();
	}

	public String getHotsale() {
		return hotsale;
	}

	public void setHotsale(String hotsale) {
		this.hotsale = hotsale == null ? null : hotsale.trim();
	}

	public Integer getAttentioncount() {
		return attentioncount;
	}

	public void setAttentioncount(Integer attentioncount) {
		this.attentioncount = attentioncount;
	}

	public String getUpdateprice() {
		return updateprice;
	}

	public void setUpdateprice(String updateprice) {
		this.updateprice = updateprice == null ? null : updateprice.trim();
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag == null ? null : delflag.trim();
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public BigDecimal getAppprice() {
		return appprice;
	}

	public void setAppprice(BigDecimal appprice) {
		this.appprice = appprice;
	}

	public String getIspaydelivery() {
		return ispaydelivery;
	}

	public void setIspaydelivery(String ispaydelivery) {
		this.ispaydelivery = ispaydelivery == null ? null : ispaydelivery
				.trim();
	}

	public String getIsdeposit() {
		return isdeposit;
	}

	public void setIsdeposit(String isdeposit) {
		this.isdeposit = isdeposit == null ? null : isdeposit.trim();
	}

	public List<ItemSpecResult> getListmap() {
		return listmap;
	}

	public void setListmap(List<ItemSpecResult> listmap) {
		this.listmap = listmap;
	}

	public List<String> getCatalogType() {
		return catalogType;
	}

	public void setCatalogType(List<String> catalogType) {
		this.catalogType = catalogType;
	}

}

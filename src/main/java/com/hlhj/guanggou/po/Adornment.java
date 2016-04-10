package com.hlhj.guanggou.po;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Adornment {
    private String id;

    private String name;

    private String imageUrl;

    private String description;

    private String shopId;

    private String marketId;
    
    @JsonProperty("userId")
    private String createUser;

    private Long createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    
    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    
    @NotBlank
    @Length(max=224)
    public String getImageUrl() {
        return imageUrl;
    }
    
   
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }
    
    @Length(max=224)
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    //@NotBlank
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }
    
    //@NotBlank
    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId == null ? null : marketId.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
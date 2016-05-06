package com.jcin.cms.modules.pro.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductWithBLOBs extends Product implements Serializable {
    /**
     *   所属表字段为pro_product.content
     *
     * @mbggenerated 2016年05月06日 12时25分22秒 星期五
     */
    private String content;

    /**
     *   所属表字段为pro_product.description
     *
     * @mbggenerated 2016年05月06日 12时25分22秒 星期五
     */
    private String description;

    /**
     *  售后服务 所属表字段为pro_product.afert_service
     *
     * @mbggenerated 2016年05月06日 12时25分22秒 星期五
     */
    private String afertService;

    /**
     * 该字段对应数据库表 pro_product
     *
     * @mbggenerated 2016年05月06日 12时25分22秒 星期五
     */
    private static final long serialVersionUID = 1L;

    /**
     * 所属表字段为 pro_product.content
     *
     * @return 返回 pro_product.content
     *
     * @mbggenerated 2016年05月06日 12时25分22秒 星期五
     */
    public String getContent() {
        return content;
    }

    /**
     * setter方法 pro_product.content
     *
     * @param content 赋值 pro_product.content
     *
     * @mbggenerated 2016年05月06日 12时25分22秒 星期五
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 所属表字段为 pro_product.description
     *
     * @return 返回 pro_product.description
     *
     * @mbggenerated 2016年05月06日 12时25分22秒 星期五
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter方法 pro_product.description
     *
     * @param description 赋值 pro_product.description
     *
     * @mbggenerated 2016年05月06日 12时25分22秒 星期五
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 所属表字段为 pro_product.afert_service
     *
     * @return 返回 pro_product.afert_service
     *
     * @mbggenerated 2016年05月06日 12时25分22秒 星期五
     */
    public String getAfertService() {
        return afertService;
    }

    /**
     * setter方法 pro_product.afert_service
     *
     * @param afertService 赋值 pro_product.afert_service
     *
     * @mbggenerated 2016年05月06日 12时25分22秒 星期五
     */
    public void setAfertService(String afertService) {
        this.afertService = afertService == null ? null : afertService.trim();
    }
    
    public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	private List<Images>images =new ArrayList<Images>();
}
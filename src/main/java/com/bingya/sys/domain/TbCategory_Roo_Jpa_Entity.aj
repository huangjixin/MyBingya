// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bingya.sys.domain;

import com.bingya.sys.domain.TbCategory;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

privileged aspect TbCategory_Roo_Jpa_Entity {
    
    declare @type: TbCategory: @Entity;
    
    declare @type: TbCategory: @Table(name = "tb_category");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 120)
    private String TbCategory.id;
    
    public String TbCategory.getId() {
        return this.id;
    }
    
    public void TbCategory.setId(String id) {
        this.id = id;
    }
    
}

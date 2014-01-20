// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bingya.sys.domain;

import com.bingya.sys.domain.TbArticle;
import com.bingya.sys.domain.TbComment;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

privileged aspect TbComment_Roo_DbManaged {
    
    @OneToMany(mappedBy = "parentId")
    private Set<TbComment> TbComment.tbComments;
    
    @ManyToOne
    @JoinColumn(name = "tb_article_id", referencedColumnName = "id")
    private TbArticle TbComment.tbArticleId;
    
    @ManyToOne
    @JoinColumn(name = "parentId", referencedColumnName = "id", insertable = false, updatable = false)
    private TbComment TbComment.parentId;
    
    @Column(name = "content")
    private String TbComment.content;
    
    public Set<TbComment> TbComment.getTbComments() {
        return tbComments;
    }
    
    public void TbComment.setTbComments(Set<TbComment> tbComments) {
        this.tbComments = tbComments;
    }
    
    public TbArticle TbComment.getTbArticleId() {
        return tbArticleId;
    }
    
    public void TbComment.setTbArticleId(TbArticle tbArticleId) {
        this.tbArticleId = tbArticleId;
    }
    
    public TbComment TbComment.getParentId() {
        return parentId;
    }
    
    public void TbComment.setParentId(TbComment parentId) {
        this.parentId = parentId;
    }
    
    public String TbComment.getContent() {
        return content;
    }
    
    public void TbComment.setContent(String content) {
        this.content = content;
    }
    
}

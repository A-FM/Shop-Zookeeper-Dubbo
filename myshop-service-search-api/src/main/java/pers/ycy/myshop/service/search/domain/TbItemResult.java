package pers.ycy.myshop.service.search.domain;

import java.io.Serializable;


public class TbItemResult implements Serializable {
    private Long id;
    private Long tbItemCid;
    private String tbItemCname;
    private String tbItemTitle;
    private String tbItemSellPoint;
    private String tbItemDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTbItemCid() {
        return tbItemCid;
    }

    public void setTbItemCid(Long tbItemCid) {
        this.tbItemCid = tbItemCid;
    }

    public String getTbItemCname() {
        return tbItemCname;
    }

    public void setTbItemCname(String tbItemCname) {
        this.tbItemCname = tbItemCname;
    }

    public String getTbItemTitle() {
        return tbItemTitle;
    }

    public void setTbItemTitle(String tbItemTitle) {
        this.tbItemTitle = tbItemTitle;
    }

    public String getTbItemSellPoint() {
        return tbItemSellPoint;
    }

    public void setTbItemSellPoint(String tbItemSellPoint) {
        this.tbItemSellPoint = tbItemSellPoint;
    }

    public String getTbItemDesc() {
        return tbItemDesc;
    }

    public void setTbItemDesc(String tbItemDesc) {
        this.tbItemDesc = tbItemDesc;
    }
}
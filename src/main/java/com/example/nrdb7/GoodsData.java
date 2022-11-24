package com.example.nrdb7;

public class GoodsData  {
    private String title;
    private String tag;
    private Integer cost;
    private Integer amount;

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTag(){
        return tag;
    }
    public void setTag(String tag){
        this.tag = tag;
    }

    public Integer getCost(){
        return cost;
    }
    public void setCost(Integer cost){
        this.cost = cost;
    }
    public Integer getAmount(){
        return amount;
    }
    public void setAmount(Integer amount){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "GoodsData{" +
                "title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", cost=" + cost +
                ", amount=" + amount +
                '}';
    }
}

package com.example.nrdb7;

public class OrdersData {


    private Integer number;
    private String client;
    private Long cellphone;
    private String clientGoods;
    private String date;
    private Integer cost;
    private String status;
    
    public Integer getNumber(){
        return number;
    }
    public String getClient(){
        return client;
    }
    public Long getCellphone(){
        return cellphone;
    }
    public  String getClientGoods(){
        return clientGoods;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    public void setClientGoods(String clientGoods) {
        this.clientGoods = clientGoods;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrdersData{" +
                "number=" + number +
                ", client='" + client + '\'' +
                ", cellphone=" + cellphone +
                ", clientGoods='" + clientGoods + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

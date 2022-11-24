package com.example.nrdb7;

public class ClientsData {
    private String client;
    private Integer summaryOrders;
    private Long cellphone;

    public String getClient() {
        return client;
    }

    public int getSummaryOrders() {
        return summaryOrders;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setSummaryOrders(Integer summaryOrders) {
        this.summaryOrders = summaryOrders;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "client='" + client + '\'' +
                ", summaryOrders=" + summaryOrders +
                ", cellphone=" + cellphone +
                '}';
    }
}

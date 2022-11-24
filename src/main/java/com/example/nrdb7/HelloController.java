package com.example.nrdb7;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import javafx.scene.control.cell.PropertyValueFactory;
import org.bson.Document;


import java.util.ArrayList;
import java.util.logging.Level;

public class HelloController {
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField3;

    @FXML
    private TextField textField4;
    @FXML
    private TextField textField5;
    @FXML
    private TextField textField6;
    @FXML
    private TextField textField7;

    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuItem goodsMenu;
    @FXML
    private MenuItem clientsMenu;
    @FXML
    private MenuItem ordersMenu;

    @FXML
    private TableColumn<OrdersData, String> clientColumn;

    @FXML
    private Tab ordersTab;

    @FXML
    private TableColumn<OrdersData, String> orderDateColumn;

    @FXML
    private TableColumn<GoodsData, Integer> amountColumn;

    @FXML
    private TableView<GoodsData> tableView;

    @FXML
    private TableColumn<GoodsData, String> tagColumn;

    @FXML
    private Label welcomeText;

    @FXML
    private TableColumn<OrdersData, Integer> numberColumn;

    @FXML
    private TableColumn<ClientsData, String> clientNameColumn;

    @FXML
    private TableView<OrdersData> tableView1;

    @FXML
    private Tab clientsTab;

    @FXML
    private TableView<ClientsData> tableView2;

    @FXML
    private Tab goodsTab;

    @FXML
    private TableColumn<ClientsData, Integer> clientOrdersColumn;

    @FXML
    private TableColumn<GoodsData, Integer> costColumn;

    @FXML
    private TableColumn<GoodsData, String> titleColumn;

    @FXML
    private TableColumn<OrdersData, Integer> orderCostColumn;

    @FXML
    private TableColumn<OrdersData, String> goodsListColumn;

    @FXML
    private TableColumn<OrdersData, String> statusColumn;

    @FXML
    private TableColumn<ClientsData, Long> ccellphoneColumn;

    @FXML
    private Button button1;

    @FXML
    private TableColumn<OrdersData, Long> cellphoneColumn;

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            var database = mongoClient.getDatabase("test_db");

            if (menuButton.getText().equals("Goods")){
                MongoCollection<Document> collection = database.getCollection("Products");
                var d1 = new Document();
                d1.append("title", (String) textField1.getText());
                d1.append("cost",  Integer.parseInt(textField3.getText()));
                d1.append("amount", Integer.parseInt(textField4.getText()));
                d1.append("tag", (String) textField2.getText());
                collection.insertOne(d1);
                hideAdnClearAnyFields();
                refreshGoodsTable();
            }
            else if (menuButton.getText().equals("Orders")){
                MongoCollection<Document> collection = database.getCollection("Orders");
                var d1 = new Document();
                d1.append("number", Integer.parseInt(textField1.getText()));
                d1.append("client", (String) textField2.getText());
                d1.append("cellphone", Long.parseLong(textField3.getText()));
                d1.append("clientGoods", (String) textField4.getText());
                d1.append("date", (String) textField5.getText());
                d1.append("cost", Integer.parseInt(textField6.getText()));
                d1.append("status", (String) textField7.getText());
                collection.insertOne(d1);
                hideAdnClearAnyFields();
                refreshOrdersTable();
            }
            else if(menuButton.getText().equals("Clients")){
                MongoCollection<Document> collection = database.getCollection("Clients");
                var d1 = new Document();
                d1.append("client", (String) textField1.getText());
                d1.append("summaryOrders", Integer.parseInt(textField2.getText()));
                d1.append("cellphone", Long.parseLong(textField3.getText()));
                collection.insertOne(d1);
                hideAdnClearAnyFields();
                refreshClientTable();

            }
        }
    }

    @FXML
    void goodsOnDrugDone(ActionEvent event) {
    }

    @FXML
    void ordersOnDrugDone(ActionEvent event) {
    }

    @FXML
    void clientsOnDrugDone(ActionEvent event) {
    }
    @FXML
    void setOnActionGoodsMenu(ActionEvent event) {
        System.out.println("goods menu");
        menuButton.setText("Goods");
        hideAdnClearAnyFields();
        textField1.setVisible(true);
        textField1.setText("Title");
        textField2.setVisible(true);
        textField2.setText("Tag");
        textField3.setVisible(true);
        textField3.setText("Cost");
        textField4.setVisible(true);
        textField4.setText("Amount");
    }

    @FXML
    void setOnActionOrdersMenu(ActionEvent event) {
        System.out.println("orders menu");
        hideAdnClearAnyFields();
        menuButton.setText("Orders");
        textField1.setVisible(true);
        textField1.setText("№");
        textField2.setVisible(true);
        textField2.setText("Client");
        textField3.setVisible(true);
        textField3.setText("Cellphone");
        textField4.setVisible(true);
        textField4.setText("Client's Good");
        textField5.setVisible(true);
        textField5.setText("Date");
        textField6.setVisible(true);
        textField6.setText("Cost");
        textField7.setVisible(true);
        textField7.setText("Status");
        button1.setVisible(true);
    }

    @FXML
    void setOnActionClientsMenu(ActionEvent event) {
        System.out.println("clients menu");
        hideAdnClearAnyFields();
        menuButton.setText("Clients");
        textField1.setVisible(true);
        textField1.setText("Name");
        textField2.setVisible(true);
        textField2.setText("Summary Orders");
        textField3.setVisible(true);
        textField3.setText("Cellphone");
        button1.setVisible(true);

    }
    void hideAdnClearAnyFields(){
        textField1.setVisible(false);
        textField2.setVisible(false);
        textField3.setVisible(false);
        textField4.setVisible(false);
        textField5.setVisible(false);
        textField6.setVisible(false);
        textField7.setVisible(false);
        textField1.clear();
        textField2.clear();
        textField3.clear();
        textField4.clear();
        textField5.clear();
        textField6.clear();
        textField7.clear();
        button1.setVisible(true);
    }

    @FXML
    private void initialize() {
        // table type initialize
        titleColumn.setCellValueFactory(new PropertyValueFactory<GoodsData, String>("title"));
        tagColumn.setCellValueFactory(new PropertyValueFactory<GoodsData, String>("tag"));
        costColumn.setCellValueFactory(new PropertyValueFactory<GoodsData, Integer>("cost"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<GoodsData, Integer>("amount"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<OrdersData, Integer>("number"));
        clientColumn.setCellValueFactory(new PropertyValueFactory<OrdersData, String>("client"));
        cellphoneColumn.setCellValueFactory(new PropertyValueFactory<OrdersData, Long>("cellphone"));
        goodsListColumn.setCellValueFactory(new PropertyValueFactory<OrdersData, String>("clientGoods"));
        orderDateColumn.setCellValueFactory(new PropertyValueFactory<OrdersData, String >("date"));
        orderCostColumn.setCellValueFactory(new PropertyValueFactory<OrdersData, Integer>("cost"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<OrdersData, String>("status"));
        clientNameColumn.setCellValueFactory(new PropertyValueFactory<ClientsData, String>("client"));
        clientOrdersColumn.setCellValueFactory(new PropertyValueFactory<ClientsData, Integer>("summaryOrders"));
        ccellphoneColumn.setCellValueFactory(new PropertyValueFactory<ClientsData, Long>("cellphone"));

        //db logger
        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.OFF);
        refreshGoodsTable();
        refreshOrdersTable();
        refreshClientTable();
    }

    public static DBObject createDBObject(GoodsData goodsData){
        BasicDBObjectBuilder dbObjectBuilder = BasicDBObjectBuilder.start();
        dbObjectBuilder.append("title", goodsData.getTitle());
        dbObjectBuilder.append("tag", goodsData.getTag());
        dbObjectBuilder.append("cost", goodsData.getCost());
        dbObjectBuilder.append("amount", goodsData.getAmount());
        return dbObjectBuilder.get();
    }

    public static GoodsData createGood(String title, String tag, Integer cost, Integer amount){
        GoodsData goodsData = new GoodsData();
        goodsData.setTitle(title);
        goodsData.setTag(tag);
        goodsData.setCost(cost);
        goodsData.setAmount(amount);
        return goodsData;
    }

    public static OrdersData createOrder(
             Integer number,
             String client,
             Long cellphone,
             String clientGoods,
             String date,
             Integer cost,
             String status)
    {
        OrdersData ordersData = new OrdersData();

        ordersData.setNumber(number);
        ordersData.setClient(client);
        ordersData.setCellphone(cellphone);
        ordersData.setClientGoods(clientGoods);
        ordersData.setDate(date);
        ordersData.setCost(cost);
        ordersData.setStatus(status);
        return ordersData;
    }

    public static ClientsData createClient(String client, Integer summaryOrders, Long cellphone){
        ClientsData clientsData = new ClientsData();
        clientsData.setClient(client);
        clientsData.setSummaryOrders(summaryOrders);
        clientsData.setCellphone(cellphone);
        return clientsData;
    }

    public void refreshGoodsTable(){
        try (var mongoClient = MongoClients.create("mongodb://localhost:27017")){
            var database = mongoClient.getDatabase("test_db");
            System.out.println("database name -> " + database.getName());
            for(String name: database.listCollectionNames()){
                if (name.equals("Products")){
                    System.out.println("-> " + name);
                }
                else {
                    System.out.println(name);
                }
            }
            var docs = new ArrayList<Document>();
            MongoCollection<Document> collection = database.getCollection("Products");
            ObservableList<GoodsData> goodsList = FXCollections.observableArrayList();
            try (MongoCursor<Document> cursor = collection.find().iterator()) {
                while (cursor.hasNext()){
                    var doc = cursor.next();
                    var goods = new ArrayList<>(doc.values());
                    goodsList.add(createGood((String) goods.get(1), (String) goods.get(4),
                            (Integer) goods.get(2), (Integer) goods.get(3)));

                    //System.out.printf("%s: %s  %s   %s  %n", goods.get(1), goods.get(2), goods.get(3), goods.get(4));
                }
            }
            for (GoodsData gd :
                    goodsList) {
                System.out.println(gd.toString());
            }
            tableView.setItems(goodsList);
        }
    }

    public void refreshClientTable(){
        try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            var database = mongoClient.getDatabase("test_db");
            System.out.println("database name -> " + database.getName());
            for (String name : database.listCollectionNames()) {
                if (name.equals("Clients")){
                    System.out.println("-> " + name);
                }
                else {
                    System.out.println(name);
                }
            }
            var docs = new ArrayList<Document>();
            MongoCollection<Document> collection = database.getCollection("Clients");
            ObservableList<ClientsData> clientsList = FXCollections.observableArrayList();
            try (MongoCursor<Document> cursor = collection.find().iterator()) {
                while (cursor.hasNext()){
                    var doc = cursor.next();
                    var orders = new ArrayList<>(doc.values());
                    clientsList.add(createClient((String) orders.get(1), (Integer) orders.get(2), (Long) orders.get(3)));
                    System.out.printf("%s: %s %s %n", orders.get(1), orders.get(2), orders.get(3));
                }
                tableView2.setItems(clientsList);
            }
        }
    }

    public void refreshOrdersTable(){
        try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            var database = mongoClient.getDatabase("test_db");
            System.out.println("database name -> " + database.getName());
            for (String name : database.listCollectionNames()) {
                if (name.equals("Orders")){
                    System.out.println("-> " + name);
                }
                else {
                    System.out.println(name);
                }
            }
            var docs = new ArrayList<Document>();
            MongoCollection<Document> collection = database.getCollection("Orders");
            ObservableList<OrdersData> ordersList = FXCollections.observableArrayList();
            try (MongoCursor<Document> cursor = collection.find().iterator()) {
                while (cursor.hasNext()){
                    var doc = cursor.next();
                    var orders = new ArrayList<>(doc.values());
                    ordersList.add(createOrder((Integer) orders.get(1), (String) orders.get(2), (Long) orders.get(3),
                            (String) orders.get(4), (String) orders.get(5), (Integer) orders.get(6),
                            (String) orders.get(7)
                            ));
                    System.out.printf("%s: %s %s %s %s %s %s %n", orders.get(1), orders.get(2), orders.get(3), orders.get(4),
                            orders.get(5), orders.get(6), orders.get(7));
                }
                tableView1.setItems(ordersList);
            }
        }

    }

}

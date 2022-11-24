package com.example.nrdb7;

import com.mongodb.client.*;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.bson.Document;
import org.bson.conversions.Bson;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DbHandler {

    public void goodsConnect(){
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = client.getDatabase("test_db");
        MongoCollection<Document> doc = database.getCollection("Products");
        //var todoDocument = new Document(Map.of("_id", "task", "Do Something", "date"));
        Bson projectionFieldds = Projections.fields(
                Projections.include("title", "cost", "amount", "tag"),
                Projections.excludeId());
        MongoCursor<Document> cursor = doc.find().projection(projectionFieldds)
                .sort(Sorts.descending("title")).iterator();
    }
}

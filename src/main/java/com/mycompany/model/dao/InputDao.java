package com.mycompany.model.dao;

import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.mycompany.model.entity.NotebookEntity;
import org.springframework.stereotype.Component;

@Component
public class InputDao extends AbstractDao {
    public synchronized Integer getCountEntries(){
        N1qlQueryResult result = this.notebooks.query(N1qlQuery.simple("SELECT count(*) FROM notebook"));
        N1qlQueryRow row = result.allRows().get(0);
        JsonObject json = row.value();
        return (int)json.get("$1");
    }

    public NotebookEntity getEntryForRXJava(int offset){
        String query = "SELECT * FROM notebook LIMIT 1 OFFSET $1";
        N1qlQueryResult result = this.notebooks.query(N1qlQuery.parameterized(query, JsonArray.from(offset)));
        JsonObject json = (JsonObject) result.allRows().get(0).value().get("notebook");
        return new NotebookEntity(json.getString("brand"), json.getInt("serialNumber"));
    }
}

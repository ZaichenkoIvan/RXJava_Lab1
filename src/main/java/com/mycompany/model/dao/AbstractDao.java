package com.mycompany.model.dao;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;

public abstract class AbstractDao {
    protected Bucket notebooks = CouchbaseCluster.create("127.0.0.1")
            .authenticate("Ivan", "passwordPassword")
            .openBucket("notebook");
}

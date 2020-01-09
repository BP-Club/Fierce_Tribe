package com.nr.fierce_tribe.util;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Point.Builder;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;

/**
 * 时序数据库 InfluxDB 连接
 *
 * @author Dai_LW
 */
public class InfluxDBConnect {

    private String username;//用户名
    private String password;//密码
    private String openurl;//链接地址
    private String database;//数据库

    private InfluxDB influxDB;


    public InfluxDBConnect(String username, String password, String openurl, String database) {
        this.username = username;
        this.password = password;
        this.openurl = openurl;
        this.database = database;
    }

    public InfluxDB influxDbBuild() {
        if (influxDB == null) {
            influxDB = InfluxDBFactory.connect(openurl, username, password);
            influxDB.createDatabase(database);

        }
        return influxDB;
    }

    public void createRetentionPolicy() {
        String command = String.format("CREATE RETENTION POLICY \"%s\" ON \"%s\" DURATION %s REPLICATION %s DEFAULT",
                "defalut", database, "2d", 1);
        this.query(command);
    }

    public QueryResult query(String command) {
        return influxDB.query(new Query(command, database));
    }


    public void insert(String measurement, Map<String, String> tags, Map<String, Object> fields, long time) {
        Builder builder = Point.measurement(measurement);
        builder.tag(tags);
        builder.fields(fields);
        builder.time(time, TimeUnit.MINUTES);
        influxDB.write(database, "", builder.build());
    }

    public String deleteMeasurementData(String command) {
        QueryResult result = influxDB.query(new Query(command, database));
        return result.getError();
    }

    public void createDB(String dbName) {
        influxDB.createDatabase(dbName);
    }

    public void deleteDB(String dbName) {
        influxDB.deleteDatabase(dbName);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOpenurl() {
        return openurl;
    }

    public void setOpenurl(String openurl) {
        this.openurl = openurl;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
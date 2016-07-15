package com.example.hanshu.systemsms.smsinfo;

/**
 * Created by HanShu on 2016/7/15.
 */
public class Smsinfor {
    private long data;
    private int type;
    private  String body;
    private String address;
    private int id;
    public Smsinfor(){}
    public Smsinfor(long data,int type,String body,String address,int id){
        this.data=data;
        this.type=type;
        this.body=body;
        this.address=address;
        this.id=id;
    }
    public Smsinfor(long data,int type,String body,String address){
        this.data=data;
        this.type=type;
        this.body=body;
        this.address=address;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}

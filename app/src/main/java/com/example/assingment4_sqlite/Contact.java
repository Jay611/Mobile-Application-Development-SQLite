package com.example.assingment4_sqlite;

import java.io.Serializable;

public class Contact implements Serializable {
    private int _id;
    private String _name;
    private String _phone_number;
    private String _street;

    Contact(){}

    Contact(int id, String name, String _phone_number, String _street){
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
        this._street = _street;
    }

    Contact(String name, String _phone_number, String _street){
        this._name = name;
        this._phone_number = _phone_number;
        this._street = _street;
    }
    int getID(){
        return this._id;
    }

    void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    String getPhoneNumber(){
        return this._phone_number;
    }

    void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }

    String getStreet(){
        return this._street;
    }

    void setStreet(String street){
        this._street = street;
    }
}

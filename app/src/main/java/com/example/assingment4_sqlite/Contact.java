package com.example.assingment4_sqlite;

public class Contact {
    int _id;
    String _name;
    String _phone_number;
    String _street;

    public Contact(){}

    public Contact(int id, String name, String _phone_number, String _street){
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
        this._street = _street;
    }

    public Contact(String name, String _phone_number, String _street){
        this._name = name;
        this._phone_number = _phone_number;
        this._street = _street;
    }
    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public String getPhoneNumber(){
        return this._phone_number;
    }

    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }

    public String getStreet(){
        return this._street;
    }

    public void setStreet(String street){
        this._street = street;
    }
}

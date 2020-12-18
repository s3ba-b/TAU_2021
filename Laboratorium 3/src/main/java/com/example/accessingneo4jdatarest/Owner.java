package com.example.accessingneo4jdatarest;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.lang.UnsupportedOperationException;

@NodeEntity
public class Owner {

    @Id
    @GeneratedValue
    private Long id;
    private String _Name;
    private String _Surname;

    public Owner(String _Name, String _Surname) {
        this._Name = _Name;
        this._Surname = _Surname;
    }

    public Owner() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return _Name;
    }

    public void setName(String _Name) {
        this._Name = _Name;
    }

    public String getSurname() {
        return _Surname;
    }

    public void setSurname(String _Surname) {
        this._Surname = _Surname;
    }

    public void NotImplementedMethod() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}

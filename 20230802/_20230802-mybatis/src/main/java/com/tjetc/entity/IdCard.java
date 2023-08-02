package com.tjetc.entity;

public class IdCard {
    private Integer id;
    private String code;
    //    直接使用Person
    private Person person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", person=" + person +
                '}';
    }
}

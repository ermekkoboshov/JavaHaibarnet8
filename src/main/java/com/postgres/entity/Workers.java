package com.postgres.entity;

import javax.persistence.*;

@Entity
@Table(name = "workers")

public class Workers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String workers;
    private int age;

    public Workers(String name, String surname, String workers, int age) {
        this.name = name;
        this.surname = surname;
        this.workers = workers;
        this.age = age;
    }

    public Workers() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getWorkers() {
        return workers;
    }

    public void setWorkers(String workers) {
        this.workers = workers;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\n Workers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", workers='" + workers + '\'' +
                ", age=" + age +
                '}';
    }
}

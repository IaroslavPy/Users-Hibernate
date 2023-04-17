package org.example.app.entities;

import jakarta.persistence.*;

// Класс-модель объекта, который является записью в БД.
// Набор переменных (свойств объекта) соответствует
// столбцам в таблице БД.
//
// @Entity
// Указывает, что класс является сущностью.
//
// @Table(name = "contacts")
// Указывает таблицу в БД, с которой сопоставлен этот объект.
@Entity
@Table(name = "contacts")
public class User {

    // @Id
    // Определяет первичный ключ объекта.
    //
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Для автоматического генерирования значения первичного ключа.
    // Определяет стратегии генерации значений первичных ключей.
    // GenerationType.IDENTITY указывает, что первичные ключи для сущности
    // должны назначаться, используя столбец идентификации в БД.
    // Они автоматически увеличиваются.
    //
    // @Column(name = "id")
    // Указывает на сопоставление столбцов в БД.
    // Атрибут name используется для указания имени столбца таблицы.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Здесь, наименование столбца в БД
    // не совпадает с наименованием переменной.
    // Атрибут name решает эту проблему.
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(int id, String firstName, String lastName, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

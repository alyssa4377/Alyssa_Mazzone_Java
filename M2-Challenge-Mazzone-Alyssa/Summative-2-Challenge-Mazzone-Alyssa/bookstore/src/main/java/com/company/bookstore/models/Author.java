package com.company.bookstore.models;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "author")
public class Author implements Serializable {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int author_id;

    private String first_name;
    private String last_name;
    private String street;
    private String city;
    private String state;
    private String postal_code;
    private String phone;
    private String email;

    public int getAuthorId() {
        return author_id;
    }

    public void setAuthorId(int id) {
        this.author_id = author_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postal_code;
    }

    public void setPostalCode(String postalCode) {
        this.postal_code = postalCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return getAuthorId() == author.getAuthorId() &&
                Objects.equals(getFirstName(), author.getFirstName()) &&
                Objects.equals(getLastName(), author.getLastName()) &&
                Objects.equals(getStreet(), author.getStreet()) &&
                Objects.equals(getCity(), author.getCity()) &&
                Objects.equals(getState(), author.getState()) &&
                Objects.equals(getPostalCode(), author.getPostalCode()) &&
                Objects.equals(getPhone(), author.getPhone()) &&
                Objects.equals(getEmail(), author.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorId(),
                getFirstName(),
                getLastName(),
                getStreet(),
                getCity(),
                getState(),
                getPostalCode(),
                getPhone(),
                getEmail());
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postal_code + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

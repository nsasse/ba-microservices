package de.nsasse.microadvisor.contract.model;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "prename")
    private String prename;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "PORTFOLIO_ID")
    private Long portfolioId;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

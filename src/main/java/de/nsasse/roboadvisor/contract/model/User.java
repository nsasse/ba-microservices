package de.nsasse.roboadvisor.contract.model;

import javax.persistence.*;

@Entity
@Table(name = "user_profile")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "prename")
    private String prename;

    @Column(name = "mail")
    private String mail;

    @Column(name = "age")
    private Integer age;

    @Column(name = "portfolio_id")
    private Long portfolioId;

    public User() {
    }

    public User(String name, String prename, String mail, Integer age, Long portfolioId) {
        this.name = name;
        this.prename = prename;
        this.mail = mail;
        this.age = age;
        this.portfolioId = portfolioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }
}

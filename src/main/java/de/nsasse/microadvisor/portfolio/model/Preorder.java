package de.nsasse.microadvisor.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "preorder")
public class Preorder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "mail")
    private String mail;

    @ManyToMany
    @JoinTable(
            name = "preorder_product",
            joinColumns = {@JoinColumn(name = "preorder")},
            inverseJoinColumns = {@JoinColumn(name = "product")}
    )
    @JsonIgnore
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

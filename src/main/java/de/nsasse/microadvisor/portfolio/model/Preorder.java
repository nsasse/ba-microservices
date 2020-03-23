package de.nsasse.microadvisor.portfolio.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PREORDER")
public class Preorder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MAIL")
    private String mail;

    @ManyToMany
    @JoinTable(
            name = "PREORDER_PRODUCT",
            joinColumns = {@JoinColumn(name = "PREORDER")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT")}
    )
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

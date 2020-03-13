package de.nsasse.microadvisor.portfolio.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "PORTFOLIO")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LEVEL_START")
    private Long levelStart;

    @Column(name = "LEVEL_NOW")
    private Long levelNow;

    @ManyToMany
    @JoinTable(
            name = "PORTFOLIO_PRODUCT",
            joinColumns = {@JoinColumn(name = "PORTFOLIO")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT")}
    )
    private List<Product> products;

    @Column(name = "VERIFICATED")
    private boolean verificated;

    @Column(name = "ORDER_DATE")
    private Timestamp orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLevelStart() {
        return levelStart;
    }

    public void setLevelStart(Long levelStart) {
        this.levelStart = levelStart;
    }

    public Long getLevelNow() {
        return levelNow;
    }

    public void setLevelNow(Long levelNow) {
        this.levelNow = levelNow;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isVerificated() {
        return verificated;
    }

    public void setVerificated(boolean verificated) {
        this.verificated = verificated;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
}

package de.nsasse.microadvisor.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "level_start")
    private Long levelStart;

    @ManyToMany
    @JoinTable(
            name = "portfolio_product",
            joinColumns = {@JoinColumn(name = "portfolio")},
            inverseJoinColumns = {@JoinColumn(name = "product")}
    )
    @JsonIgnore
    private List<Product> products;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "product_value_json")
    private String productValueJson;

    @Column(name = "risk_value")
    private Integer riskValue;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getProductValueJson() {
        return productValueJson;
    }

    public void setProductValueJson(String productValueJson) {
        this.productValueJson = productValueJson;
    }

    public Integer getRiskValue() {
        return riskValue;
    }

    public void setRiskValue(Integer riskValue) {
        this.riskValue = riskValue;
    }
}

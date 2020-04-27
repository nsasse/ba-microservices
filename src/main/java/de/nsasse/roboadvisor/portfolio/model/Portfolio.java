package de.nsasse.roboadvisor.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.nsasse.roboadvisor.portfolio.model.Enum.PortfolioWeighting;

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

    @Column(name = "weighting")
    private PortfolioWeighting weighting;

    public Portfolio() {
    }

    public Portfolio(Long levelStart, List<Product> products, Timestamp orderDate, PortfolioWeighting weighting) {
        this.levelStart = levelStart;
        this.products = products;
        this.orderDate = orderDate;
        this.weighting = weighting;
    }

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

    public PortfolioWeighting getWeighting() {
        return weighting;
    }

    public void setWeighting(PortfolioWeighting weighting) {
        this.weighting = weighting;
    }
}

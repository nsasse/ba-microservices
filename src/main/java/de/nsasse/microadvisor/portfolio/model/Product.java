package de.nsasse.microadvisor.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "isin")
    private String isin;

    @Column(name = "product_name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_type")
    private ProductType productType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region")
    private Region region;

    @Column(name = "index_level")
    private Double indexLevel;

    @Column(name = "performance_total")
    private Double performanceTotal;

    @Column(name = "performance_this_year")
    private Double performanceThisYear;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Portfolio> portfolios;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Preorder> preorders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Double getIndexLevel() {
        return indexLevel;
    }

    public void setIndexLevel(Double indexLevel) {
        this.indexLevel = indexLevel;
    }

    public Double getPerformanceTotal() {
        return performanceTotal;
    }

    public void setPerformanceTotal(Double performanceTotal) {
        this.performanceTotal = performanceTotal;
    }

    public Double getPerformanceThisYear() {
        return performanceThisYear;
    }

    public void setPerformanceThisYear(Double performanceThisYear) {
        this.performanceThisYear = performanceThisYear;
    }

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }
}

package de.nsasse.microadvisor.portfolio.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ISIN")
    private String isin;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_TYPE")
    private ProductType productType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REGION")
    private Region region;

    @Column(name = "INDEX_LEVEL")
    private Double indexLevel;

    @Column(name = "PERFORMANCE_TOTAL")
    private Double performanceTotal;

    @Column(name = "PERFORMANCE_THIS_YEAR")
    private Double performanceThisYear;

    @ManyToMany(mappedBy = "products")
    private List<Portfolio> portfolios;

    @ManyToMany(mappedBy = "products")
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

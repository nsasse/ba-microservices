package de.nsasse.microadvisor.portfolio.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "ISIN")
    private String isin;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "ISSUER")
    private String issuer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_TYPE")
    private ProductType productType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REGION")
    private Region region;

    @Column(name = "INDEX_LEVEL")
    private Double indexLevel;

    @Column(name = "NAV")
    private Double nav;

    @Column(name = "PERFORMANCE_THIS_YEAR")
    private Double performanceThisYear;

    @ManyToMany(mappedBy = "products")
    private List<Portfolio> portfolios;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
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

    public Double getNav() {
        return nav;
    }

    public void setNav(Double nav) {
        this.nav = nav;
    }

    public Double getPerformanceThisYear() {
        return performanceThisYear;
    }

    public void setPerformanceThisYear(Double performanceThisYear) {
        this.performanceThisYear = performanceThisYear;
    }
}

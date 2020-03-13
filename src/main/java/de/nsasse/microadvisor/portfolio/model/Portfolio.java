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
    private long id;

    @Column(name = "LEVEL_START")
    private long levelStart;

    @Column(name = "LEVEL_NOW")
    private long levelNow;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLevelStart() {
        return levelStart;
    }

    public void setLevelStart(long levelStart) {
        this.levelStart = levelStart;
    }

    public long getLevelNow() {
        return levelNow;
    }

    public void setLevelNow(long levelNow) {
        this.levelNow = levelNow;
    }
}

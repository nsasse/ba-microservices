package de.nsasse.microadvisor.portfolio.service;

import de.nsasse.microadvisor.portfolio.model.Portfolio;

import java.util.List;

public interface PortfolioService {
    void create(Portfolio portfolio);

    void update(Portfolio portfolio);

    void delete(Portfolio portfolio);

    List<Portfolio> findAll();

    Portfolio findById(long id);
}

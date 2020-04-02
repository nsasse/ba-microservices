package de.nsasse.roboadvisor.portfolio.service;

import de.nsasse.roboadvisor.portfolio.model.Portfolio;

import java.util.List;

public interface PortfolioService {
    void create(Portfolio portfolio);

    void update(Portfolio portfolio);

    void delete(Portfolio portfolio);

    List<Portfolio> findAll();

    Portfolio findById(long id);
}

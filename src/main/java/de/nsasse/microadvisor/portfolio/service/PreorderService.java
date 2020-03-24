package de.nsasse.microadvisor.portfolio.service;

import de.nsasse.microadvisor.portfolio.model.Preorder;

import java.util.List;

public interface PreorderService {
    void create(Preorder preorder);

    void update(Preorder preorder);

    void delete(Preorder preorder);

    List<Preorder> findAll();

    Preorder findById(long id);
}

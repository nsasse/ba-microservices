package de.nsasse.roboadvisor.portfolio.service;

import de.nsasse.roboadvisor.portfolio.model.Preorder;

import java.util.List;

public interface PreorderService {
    void create(Preorder preorder);

    void update(Preorder preorder);

    void delete(Preorder preorder);

    List<Preorder> findAll();
}

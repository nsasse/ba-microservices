package de.nsasse.roboadvisor.portfolio.service;

import de.nsasse.roboadvisor.portfolio.model.Region;

import java.util.List;

public interface RegionService {
    void create(Region region);

    void update(Region region);

    void delete(Region region);

    List<Region> findAll();

    Region findById(long id);
}

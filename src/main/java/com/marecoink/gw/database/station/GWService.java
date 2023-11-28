package com.marecoink.gw.database.station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GWService {

    private final GWRepository gWRepository;

    @Autowired
    public GWService(GWRepository gWRepository) {
        this.gWRepository = gWRepository;
    }

    public List<Station> getStations() {
        return gWRepository.findAll();

    }

    public void addNewStation(Station station) {
        gWRepository.save(station);
    }


}

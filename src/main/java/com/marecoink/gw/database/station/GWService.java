package com.marecoink.gw.database.station;

import com.marecoink.gw.database.station.rain.Rain;
import com.marecoink.gw.database.station.rain.RainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GWService {

    private final GWRepository gWRepository;
    private final RainRepository rainRepository;

    @Autowired
    public GWService(GWRepository gWRepository, RainRepository rainRepository) {
        this.gWRepository = gWRepository;
        this.rainRepository = rainRepository;
    }

    public List<Station> getStations() {
        return gWRepository.findAll();

    }

    public void addNewStation(Station station) {
        gWRepository.save(station);
    }

    public ResponseEntity<List<Rain>> getRainDataForStation(Long no, String dateString) {
        try {
            Station station = gWRepository.findStationByNo(no)
                    .orElseThrow(() -> new GWExceptionController.StationNotFoundException("Station not found with no: " + no));

            LocalDate date = LocalDate.parse(dateString);
            List<Rain> rainData = rainRepository.findRainDataByStationAndDate(station, date);

            return ResponseEntity.ok(rainData);
        } catch (Exception e) {
            // Convert the RuntimeException to Exception for the generic handler
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}

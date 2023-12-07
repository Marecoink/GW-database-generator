package com.marecoink.gw.database.station.rain;

import com.marecoink.gw.database.station.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RainRepository extends JpaRepository<Rain, Long> {

    List<Rain> findRainDataByStationAndDate(Station station, LocalDate date);

}

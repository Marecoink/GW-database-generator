package com.marecoink.gw.database.station;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GWRepository extends JpaRepository<Station, Long> {

    Optional<Station> findStationByNo(Long no);
}

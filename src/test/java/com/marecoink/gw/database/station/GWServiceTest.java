package com.marecoink.gw.database.station;

import com.marecoink.gw.database.station.rain.Rain;
import com.marecoink.gw.database.station.rain.RainRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GWServiceTest {

    @Mock
    private GWRepository gWRepository;
    @Mock
    private RainRepository rainRepository;
    @InjectMocks
    private GWService underTest;

    @BeforeEach
    void setUp() {
    }

    @Test
    void canGetStations() {
        //when
        underTest.getStations();
        //then
        verify(gWRepository).findAll();
    }

    @Test
    void canAddNewStation() {
        //given
        Station station = new Station(
                1,
                "Test Station",
                true,
                true,
                true,
                false,
                false,
                false,
                false,
                false,
                false,
                false
        );

        //when
        underTest.addNewStation(station);

        //then
        ArgumentCaptor<Station> stationArgumentCaptor = ArgumentCaptor.forClass(Station.class);
        verify(gWRepository).save(stationArgumentCaptor.capture());
        Station capturedStation = stationArgumentCaptor.getValue();
        assertEquals(capturedStation, station);
    }

    @Test
    void canGetRainDataForStation() {
        // given
        Long stationNo = 1L;
        String dateString = "2023-12-01";
        Station station = new Station(stationNo, "Test Station", true, true, true, false, false, false, false, false, false, false);
        LocalDate date = LocalDate.parse(dateString);
        Rain expectedRain = new Rain(station, date, 10.5);

        when(gWRepository.findStationByNo(stationNo)).thenReturn(Optional.of(station));
        when(rainRepository.findRainDataByStationAndDate(station, date)).thenReturn(Collections.singletonList(expectedRain));

        // when
        ResponseEntity<List<Rain>> result = underTest.getRainDataForStation(stationNo, dateString);

        // then
        verify(gWRepository).findStationByNo(stationNo);
        verify(rainRepository).findRainDataByStationAndDate(station, date);

        assertEquals(200, result.getStatusCodeValue());
        List<Rain> rainData = result.getBody();
        assertEquals(1, rainData.size());
        assertEquals(expectedRain, rainData.get(0));
    }

}
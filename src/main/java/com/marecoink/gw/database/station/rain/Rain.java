package com.marecoink.gw.database.station.rain;

import com.marecoink.gw.database.station.Station;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "rain")
@IdClass(Rain.RainId.class)
public class Rain {

    @Id
    @ManyToOne
    @JoinColumn(name = "station_no", referencedColumnName = "no")
    private Station station;

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "rain_date")
    private LocalDate date;

    @Column(name = "rain_value")
    private double value;

    public Rain(Station station, LocalDate date, double value) {
        this.station = station;
        this.date = date;
        this.value = value;
    }

    public static class RainId implements Serializable {
        private Long station;  // Corresponds to the 'station_no' column
        private LocalDate date;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Rain{" +
                "station=" + station +
                ", localDate=" + date +
                ", value=" + value +
                '}';
    }


}

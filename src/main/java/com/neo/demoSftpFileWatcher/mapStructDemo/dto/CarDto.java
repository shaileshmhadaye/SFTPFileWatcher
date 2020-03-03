package com.neo.demoSftpFileWatcher.mapStructDemo.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CarDto {
    private String manufacturer;
    private int seatCount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mfgDateString;

    public CarDto(String manufacturer, int seatCount, Date mfgDateString) {
        this.manufacturer = manufacturer;
        this.seatCount = seatCount;
        this.mfgDateString = mfgDateString;
    }

    public CarDto() {
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public Date getMfgDateString() {
        return mfgDateString;
    }

    public void setMfgDateString(Date mfgDateString) {
        this.mfgDateString = mfgDateString;
    }
}

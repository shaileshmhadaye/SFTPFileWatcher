package com.neo.demoSftpFileWatcher.mapStructDemo.model;

public class Car {
    private String manufacturer;
    private int seatCount;
    private String mfgDateString;

    public Car(String manufacturer, int seatCount, String mfgDateString) {
        this.manufacturer = manufacturer;
        this.seatCount = seatCount;
        this.mfgDateString = mfgDateString;
    }

    public Car() {
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

    public String getMfgDateString() {
        return mfgDateString;
    }

    public void setMfgDateString(String mfgDateString) {
        this.mfgDateString = mfgDateString;
    }
}

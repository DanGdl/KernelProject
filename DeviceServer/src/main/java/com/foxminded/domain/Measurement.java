package com.foxminded.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int destinationAddress;
    private int sourceAddress;
    private int gasPressure;
    private int valvesState;
    private int pipeTemperature;
    private String payload;

    @ManyToOne
    @JoinColumn(name="device_id")
	private Device device;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(int destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public int getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(int sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public int getGasPressure() {
        return gasPressure;
    }

    public void setGasPressure(int gasPressure) {
        this.gasPressure = gasPressure;
    }

    public int getValvesState() {
        return valvesState;
    }

    public void setValvesState(int valvesState) {
        this.valvesState = valvesState;
    }

    public int getPipeTemperature() {
        return pipeTemperature;
    }

    public void setPipeTemperature(int pipeTemperature) {
        this.pipeTemperature = pipeTemperature;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
}

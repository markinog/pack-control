package br.com.packcontrol.model;

import jakarta.persistence.Id;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "packcontrol")
@Builder
public class PackageHistory {

    @Id
    private String id;
    private String residentName;
    private String authorizedReceiverName;
    private String doormanName;
    private String residentCpf;
    private String authorizedReceiverCpf;
    private LocalDateTime deliveryTime;
    private LocalDateTime receiveTime;

    public String getAuthorizedReceiverCpf() {
        return authorizedReceiverCpf;
    }

    public void setAuthorizedReceiverCpf(String authorizedReceiverCpf) {
        this.authorizedReceiverCpf = authorizedReceiverCpf;
    }

    public String getAuthorizedReceiverName() {
        return authorizedReceiverName;
    }

    public void setAuthorizedReceiverName(String authorizedReceiverName) {
        this.authorizedReceiverName = authorizedReceiverName;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDoormanName() {
        return doormanName;
    }

    public void setDoormanName(String doormanName) {
        this.doormanName = doormanName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(LocalDateTime receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getResidentCpf() {
        return residentCpf;
    }

    public void setResidentCpf(String residentCpf) {
        this.residentCpf = residentCpf;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }
}

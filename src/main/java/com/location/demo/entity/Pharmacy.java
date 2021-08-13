package com.location.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pharmacy implements Comparable<Pharmacy> {

    @Id
    private String licenseNo;
    private String pName;
    private String address;
    private String phone;
    private String email;
    private float latitude;
    private float longitude;
    private double distance;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double lat1, double lon1, Pharmacy pharmacy)
    {
        double dist=0;
        if ((lat1 == pharmacy.getLatitude()) && (lon1 == pharmacy.getLongitude()))
        {
            dist=(double)Math.round(dist*1000d)/1000d;
            this.distance = 0;
        }
        else
        {
            double radlat1 = Math.PI * lat1 / 180;
            double radlat2 = Math.PI * pharmacy.getLatitude() / 180;
            double theta = lon1 - pharmacy.getLongitude();
            double radtheta = Math.PI * theta / 180;
            dist = Math.sin(radlat1) * Math.sin(radlat2) + Math.cos(radlat1) * Math.cos(radlat2) * Math.cos(radtheta);
            if (dist > 1) {
                dist = 1;
            }
            dist = Math.acos(dist);
            dist = dist * 180 / Math.PI;
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;
            dist=(double)Math.round(dist*1000d)/1000d;
            this.distance = dist;
        }
    }

    @Override
    public int compareTo(Pharmacy o) {
        return Double.compare(this.distance, o.distance);
    }
}

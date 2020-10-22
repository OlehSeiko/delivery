package ua.delivery.model.entity;

import java.sql.Date;
import java.util.Objects;

public class Delivery {
    private int id;
    private String downloadCity;
    private String cityOfUnloading;
    private int distance;
    private Date download;
    private Date unloading;
    private int weight;
    private int category;

    public Delivery() {
    }

    public Delivery(int id, String downloadCity, String cityOfUnloading, int distance, Date download, Date unloading
            , int weight, int category) {
        this.id = id;
        this.downloadCity = downloadCity;
        this.cityOfUnloading = cityOfUnloading;
        this.distance = distance;
        this.download = download;
        this.unloading = unloading;
        this.weight = weight;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDownloadCity() {
        return downloadCity;
    }

    public void setDownloadCity(String downloadCity) {
        this.downloadCity = downloadCity;
    }

    public String getCityOfUnloading() {
        return cityOfUnloading;
    }

    public void setCityOfUnloading(String cityOfUnloading) {
        this.cityOfUnloading = cityOfUnloading;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Date getDownload() {
        return download;
    }

    public void setDownload(Date download) {
        this.download = download;
    }

    public Date getUnloading() {
        return unloading;
    }

    public void setUnloading(Date unloading) {
        this.unloading = unloading;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id == delivery.id &&
                distance == delivery.distance &&
                weight == delivery.weight &&
                category == delivery.category &&
                downloadCity.equals(delivery.downloadCity) &&
                cityOfUnloading.equals(delivery.cityOfUnloading) &&
                download.equals(delivery.download) &&
                unloading.equals(delivery.unloading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, downloadCity, cityOfUnloading, distance, download, unloading, weight, category);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", downloadCity='" + downloadCity + '\'' +
                ", cityOfUnloading='" + cityOfUnloading + '\'' +
                ", distance=" + distance +
                ", download=" + download +
                ", unloading=" + unloading +
                ", weight=" + weight +
                ", category=" + category +
                '}';
    }
}

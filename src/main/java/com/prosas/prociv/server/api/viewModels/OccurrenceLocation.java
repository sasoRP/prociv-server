
package com.prosas.prociv.server.api.viewModels;

/**
 *     
 * @author Smith Micro
 */
public class OccurrenceLocation {

    private int districtId;
    private String districtName;
    private int councilId;
    private String councilName;
    private int parishId;
    private String parishName;
    private double latitude;
    private double longitude;

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getCouncilId() {
        return councilId;
    }

    public void setCouncilId(int councilId) {
        this.councilId = councilId;
    }

    public String getCouncilName() {
        return councilName;
    }

    public void setCouncilName(String councilName) {
        this.councilName = councilName;
    }

    public int getParishId() {
        return parishId;
    }

    public void setParishId(int parishId) {
        this.parishId = parishId;
    }

    public String getParishName() {
        return parishName;
    }

    public void setParishName(String parishName) {
        this.parishName = parishName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OccurrenceLocation that = (OccurrenceLocation) o;

        if (districtId != that.districtId) {
            return false;
        }
        if (councilId != that.councilId) {
            return false;
        }
        if (parishId != that.parishId) {
            return false;
        }
        if (Double.compare(that.latitude, latitude) != 0) {
            return false;
        }
        if (Double.compare(that.longitude, longitude) != 0) {
            return false;
        }
        if (districtName != null ? !districtName.equals(that.districtName) : that.districtName != null) {
            return false;
        }
        if (councilName != null ? !councilName.equals(that.councilName) : that.councilName != null) {
            return false;
        }
        return parishName != null ? parishName.equals(that.parishName) : that.parishName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = districtId;
        result = 31 * result + (districtName != null ? districtName.hashCode() : 0);
        result = 31 * result + councilId;
        result = 31 * result + (councilName != null ? councilName.hashCode() : 0);
        result = 31 * result + parishId;
        result = 31 * result + (parishName != null ? parishName.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "OccurrenceLocation{" +
                "districtId=" + districtId +
                ", districtName='" + districtName + '\'' +
                ", councilId=" + councilId +
                ", councilName='" + councilName + '\'' +
                ", parishId=" + parishId +
                ", parishName='" + parishName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
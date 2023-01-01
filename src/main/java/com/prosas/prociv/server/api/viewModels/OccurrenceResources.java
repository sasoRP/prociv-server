
package com.prosas.prociv.server.api.viewModels;

/**
 *     
 * @author sasoRP
 */
public class OccurrenceResources {

    private int totalAerialMeans;
    private int totalTerrestrialMeans;
    private int totalAerialHumans;
    private int totalTerrestrialHumans;

    public int getTotalAerialMeans() {
        return totalAerialMeans;
    }

    public void setTotalAerialMeans(int totalAerialMeans) {
        this.totalAerialMeans = totalAerialMeans;
    }

    public int getTotalTerrestrialMeans() {
        return totalTerrestrialMeans;
    }

    public void setTotalTerrestrialMeans(int totalTerrestrialMeans) {
        this.totalTerrestrialMeans = totalTerrestrialMeans;
    }

    public int getTotalAerialHumans() {
        return totalAerialHumans;
    }

    public void setTotalAerialHumans(int totalAerialHumans) {
        this.totalAerialHumans = totalAerialHumans;
    }

    public int getTotalTerrestrialHumans() {
        return totalTerrestrialHumans;
    }

    public void setTotalTerrestrialHumans(int totalTerrestrialHumans) {
        this.totalTerrestrialHumans = totalTerrestrialHumans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OccurrenceResources that = (OccurrenceResources) o;

        if (totalAerialMeans != that.totalAerialMeans) {
            return false;
        }
        if (totalTerrestrialMeans != that.totalTerrestrialMeans) {
            return false;
        }
        if (totalAerialHumans != that.totalAerialHumans) {
            return false;
        }
        return totalTerrestrialHumans == that.totalTerrestrialHumans;
    }

    @Override
    public int hashCode() {
        int result = totalAerialMeans;
        result = 31 * result + totalTerrestrialMeans;
        result = 31 * result + totalAerialHumans;
        result = 31 * result + totalTerrestrialHumans;
        return result;
    }

    @Override
    public String toString() {
        return "OccurrenceResources{" +
                "totalAerialMeans=" + totalAerialMeans +
                ", totalTerrestrialMeans=" + totalTerrestrialMeans +
                ", totalAerialHumans=" + totalAerialHumans +
                ", totalTerrestrialHumans=" + totalTerrestrialHumans +
                '}';
    }
}
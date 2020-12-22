package com.prosas.prociv.server.api.viewModels;

/**
 *     
 * @author prosas
 */
public class Occurrence {

    private String externalId;
    public String getExternalId() {
        return externalId;
    }

    private int councilId;
    public int getCouncilId() {
        return councilId;
    }

    private String description;
    public String getDescription() {
        return description;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setCouncilId(int councilId) {
        this.councilId = councilId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Occurrence() {
    }

    public Occurrence(String externalId, int councilId, String description) {
        this.externalId = externalId;
        this.councilId = councilId;
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        builder.append(String.format("ExternalId: %s, ", externalId));
        builder.append(String.format("Council: %d, ", councilId));
        builder.append(String.format("Description: %s ", description));
        builder.append("}\n");

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Occurrence that = (Occurrence) o;

        if (councilId != that.councilId) {
            return false;
        }
        if (externalId != null ? !externalId.equals(that.externalId) : that.externalId != null) {
            return false;
        }
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = externalId != null ? externalId.hashCode() : 0;
        result = 31 * result + councilId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
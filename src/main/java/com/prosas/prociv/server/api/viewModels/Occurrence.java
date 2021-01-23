package com.prosas.prociv.server.api.viewModels;

import java.util.Date;

/**
 * @author sasoRP
 */
public class Occurrence {

    private String externalId;
    private String description;
    private String status;
    private Date date;
    private OccurrenceLocation location;
    private OccurrenceResources resources;

    public static class Builder {

        private String externalId;
        private String description;
        private String status;
        private OccurrenceLocation location;
        private OccurrenceResources resources;
        private Date date;

        public Builder(String externalId) {
            this.externalId = externalId;
        }

        public Builder withDescription(String description) {
            this.description = description;

            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;

            return this;
        }

        public Builder withDate(Date date) {
            this.date = date;

            return this;
        }

        public Builder withLocation(OccurrenceLocation location) {
            this.location = location;

            return this;
        }

        public Builder withResources(OccurrenceResources resources) {
            this.resources = resources;

            return this;
        }

        public Occurrence build() {
            Occurrence occurrence = new Occurrence();
            occurrence.externalId = this.externalId;
            occurrence.description = this.description;
            occurrence.status = this.status;
            occurrence.date = this.date;
            occurrence.location = this.location;
            occurrence.resources = this.resources;

            return occurrence;
        }
    }

    // Getters and Setters

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OccurrenceLocation getLocation() {
        return location;
    }

    public void setLocation(OccurrenceLocation location) {
        this.location = location;
    }

    public OccurrenceResources getResources() {
        return resources;
    }

    public void setResources(OccurrenceResources resources) {
        this.resources = resources;
    }

    private Occurrence() {
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

        if (externalId != null ? !externalId.equals(that.externalId) : that.externalId != null) {
            return false;
        }
        if (description != null ? !description.equals(that.description) : that.description != null) {
            return false;
        }
        if (status != null ? !status.equals(that.status) : that.status != null) {
            return false;
        }
        if (date != null ? !date.equals(that.date) : that.date != null) {
            return false;
        }
        if (location != null ? !location.equals(that.location) : that.location != null) {
            return false;
        }
        return resources != null ? resources.equals(that.resources) : that.resources == null;
    }

    @Override
    public int hashCode() {
        int result = externalId != null ? externalId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (resources != null ? resources.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Occurrence{" +
                "externalId='" + externalId + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", location=" + location +
                ", resources=" + resources +
                '}';
    }
}
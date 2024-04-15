package ru.shabanov.githab.helpingbanker.model;

import java.util.Objects;

public record ExternalClient(Long id, String clientFirstName, String clientLastName) {

    public ExternalClient {
        Objects.requireNonNull(id);
        Objects.requireNonNull(clientFirstName);
        Objects.requireNonNull(clientLastName);
    }
}
//  @JsonProperty("clientLastName")

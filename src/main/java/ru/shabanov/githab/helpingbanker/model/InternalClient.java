package ru.shabanov.githab.helpingbanker.model;

import java.util.Objects;


public record InternalClient(Long id, String fullName) {
    public InternalClient {
        Objects.requireNonNull(id);
        Objects.requireNonNull(fullName);
    }




}

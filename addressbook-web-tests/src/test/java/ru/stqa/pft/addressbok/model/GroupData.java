package ru.stqa.pft.addressbok.model;

import java.util.Objects;

public record GroupData( String name, String header, String footer) {



    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    @Override
    public String name() {
        return name;
    }
}
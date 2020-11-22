package com.rubenskj.core.server.constants;

public enum Type {
    JAVA("Java"),
    REACT("React"),
    MONGO("Mongo"),
    UBUNTU("Ubuntu"),
    NODE("Node");

    private String label;

    Type(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

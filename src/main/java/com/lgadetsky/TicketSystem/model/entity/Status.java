package com.lgadetsky.TicketSystem.model.entity;

public enum Status {
    CREATED(-1, "Created"), PERFOMED(0, "Perfomed"), COMPLETED(1, "Comlpeted");

    private Status(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    private Integer id;
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public static Status createStatusbyId(Integer id) {
        switch (id) {
            case -1: {
                return Status.CREATED;
            }
            case 0: {
                return Status.PERFOMED;
            }
            case 1: {
                return Status.COMPLETED;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + id);
        }
    }
}

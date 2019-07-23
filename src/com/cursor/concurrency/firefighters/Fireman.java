package com.cursor.concurrency.firefighters;

    class Fireman {
    private boolean isFree;
    private String name;

    Fireman(String name) {
        this.name = name;
        isFree = true;
    }

    boolean isFree() {
        return isFree;
    }

    void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    String getName() {
        return name;
    }
}

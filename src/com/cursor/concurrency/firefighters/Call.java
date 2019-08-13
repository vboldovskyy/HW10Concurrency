package com.cursor.concurrency.firefighters;

public class Call implements Runnable {
    private String address;
    private FireDepartment department;

    public Call(String address, FireDepartment department) {
        this.address = address;
        this.department = department;
        new Thread(this).start();
    }

    String getAddress() {
        return address;
    }

    public void run() {
        System.out.println("Call at address " + address + " accepted");
        department.processCall(this);
        department.extinguishFire();
    }
}

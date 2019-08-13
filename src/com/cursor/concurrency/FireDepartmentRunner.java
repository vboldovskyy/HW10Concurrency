package com.cursor.concurrency;

import com.cursor.concurrency.firefighters.Call;
import com.cursor.concurrency.firefighters.FireDepartment;

public class FireDepartmentRunner {
    public void run()
    {
        System.out.println("Now let's go to fire department and make a few fire calls");
        FireDepartment department = new FireDepartment();
        new Call("Downing street 10", department);
        new Call("The white house", department);
        new Call("Verkhovna rada", department);
    }
}

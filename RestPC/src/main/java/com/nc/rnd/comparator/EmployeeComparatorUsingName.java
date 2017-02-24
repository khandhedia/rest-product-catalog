package com.nc.rnd.comparator;

import java.util.Comparator;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class EmployeeComparatorUsingName implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        if (o1 instanceof EmployeeEntity && o2 instanceof EmployeeEntity) {
            EmployeeEntity e1 = (EmployeeEntity) o1;
            EmployeeEntity e2 = (EmployeeEntity) o2;

            return e1.getName().compareTo(e2.getName());

        } else
            return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}

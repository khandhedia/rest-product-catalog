package com.nc.rnd.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nirk0816 on 2/6/2017.
 */
public class EmployeeComparableEntitySortTest {

    public static void main(String args[]) {

        EmployeeComparableEntity e1 = new EmployeeComparableEntity(102, "Nirav", "RnD");
        EmployeeComparableEntity e2 = new EmployeeComparableEntity(11, "Mirav", "RND2");

        List<EmployeeComparableEntity> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);

        Collections.sort(list);

        Iterator itr = list.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }


    }
}

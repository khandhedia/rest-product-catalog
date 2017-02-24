package com.nc.rnd.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nirk0816 on 2/10/2017.
 */
public class GenericTest {

    public static void main(String[] args) {
        GenericTest genericTest = new GenericTest();
        genericTest.testSimpleGeneric();
        genericTest.testBoundedGeneric();
        genericTest.testBoundedGenericInMethodSignature();

    }

    private void testSimpleGeneric()
    {
        List<com.nc.rnd.statics.Car> list = new ArrayList<>();
        //list.add(new Vehicle("Junk"));
        list.add(new com.nc.rnd.statics.Car("Maruti")); // Same object as Generic Definition
        list.add(new Maruti("WagonR")); //Child object of Generic Definition
    }

    private void testBoundedGeneric()
    {

        List<com.nc.rnd.statics.Car> list =  new ArrayList<>();
        //list.add(new Vehicle("Junk"));
        list.add(new com.nc.rnd.statics.Car("Maruti")); // Same object as Generic Definition
        list.add(new Maruti("WagonR")); //Child object of Generic Definition

        getCarMakeRegularList(list);

        List<Vehicle> listVehicle =  new ArrayList<>();
        listVehicle.add(new Vehicle("GhdoaGadi"));
        listVehicle.add(new Vehicle("Auto"));
        listVehicle.add(new Maruti("WagonR"));
        listVehicle.add(new com.nc.rnd.statics.Car("TVS"));


        List<Maruti> listExtendsMaruti = new ArrayList<>();
        listExtendsMaruti.add(new Maruti("WagonR"));
        listExtendsMaruti.add(new Maruti("800"));

        List<Scoda> listExtendsScoda = new ArrayList<>();
        listExtendsScoda.add(new Scoda("City"));
        listExtendsScoda.add(new Scoda("Jazz"));

        List<com.nc.rnd.statics.Car> listMixedCarChildren = new ArrayList<>();
        listMixedCarChildren.add(new Maruti("WagonR"));
        listMixedCarChildren.add(new com.nc.rnd.statics.Car("Mahindra"));

        getCarMakeExtends(listExtendsMaruti); //List of Car Child
        getCarMakeExtends(listExtendsScoda); //List of Car Child
        getCarMakeExtends(list); //List of car
        getCarMakeExtends(listMixedCarChildren); //List of Mixed Children of Car
        //getCarMakeExtends(listVehicle); //List of Vehicle - Parent object of Car - Fails


        getCarMakeSuper(listVehicle); //List of Parent class of Generic defintion object
        getCarMakeSuper(list); //List of Car - Generic Definition object


        List <Vehicle> vehicleList1 = new ArrayList<>(); // Super
        List <com.nc.rnd.statics.Car> carList = new ArrayList<>(); //Child

        //vehicleList1 = carList; //Doesn't work because this operation would mean something like below:
        //List<Vehicle> vehicleList1 = List<Car>;
        //Looking at reference varible one would decide what the list can accept, and hence he may choose to add any object of Vehichle or its child.
        //But fact is.. the real list object would allow to contain only CAR objects, which breaks the contract
        //Hence java doesn't allow this operation.
        //Technically.. You can only assign list objects to list references which have same List Generic types.

        List vehicleList2 = new ArrayList();
        vehicleList2 = carList; //This is supported.. becasue List here is having no type check at compile time.

        List<?> vehicleList3 = new ArrayList<>();
        vehicleList3 = carList;

        List<? extends Vehicle> vehicleList4 = new ArrayList<>();
        vehicleList3 = carList;

        List<? super com.nc.rnd.statics.Car> vehicleList5 = new ArrayList<>();
        vehicleList3 = listVehicle;


    }

    private void getCarMakeRegularList(List<com.nc.rnd.statics.Car> list)
    {
        Iterator itr = list.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }

    private void getCarMakeExtends(List<? extends com.nc.rnd.statics.Car> list)
    {
        Iterator itr = list.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }

    private void getCarMakeSuper(List<? super com.nc.rnd.statics.Car> list)
    {
        Iterator itr = list.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }


    private void getCarMake(com.nc.rnd.statics.Car car)
    {
        System.out.println(car.getMake());
    }

    private void testBoundedGenericInMethodSignature()
    {

    }


}

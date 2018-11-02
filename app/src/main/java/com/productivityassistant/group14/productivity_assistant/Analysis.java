package com.productivityassistant.group14.productivity_assistant;

import com.google.firebase.database.DataSnapshot;

import java.util.Map;

public class Analysis extends DBMS
{
DataSnapshot dataSnapshot;
    DBMS dbms;
    int sum = 0;

    double average = 0;
    //get data average for the week.
double findAverage(double average)
{
//get sum of full table
    for(DataSnapshot child : dataSnapshot.getChildren())
    {
       Map<String,Object> map = (Map<String,Object>) dataSnapshot.getValue();
       Object hour = map.get("hour");
       int value = Integer.parseInt(String.valueOf("hour"));
        sum += value;
    }
    sum = sum/168;
    //divide by 168 and assign to average
    return average;
}

//compare hour's work rating to average and return a boolean
    boolean determineIfFree(double average)
    {
    return false;

    }

}

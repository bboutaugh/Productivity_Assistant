package com.productivityassistant.group14.productivity_assistant;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBMS extends CurrentTime
{
     FirebaseDatabase database = FirebaseDatabase.getInstance();

     final DatabaseReference databaseReference = database.getReference();



//hour and day will need to be assigned values from timestamp information before being passed to methods
     String hour = "";
     String day = "";
     int workMetric = 0;

     //retrieve hours from day tables////////////////////////////////////////////////////////
     public int getWorkMetric(DataSnapshot dataSnapshot, String day, String hour)
        {
         int workMetric = dataSnapshot.child(day).child(hour).getValue(Integer.class);
         return workMetric;
     }


     //set work metric for particular day hour///////////////////////////////////////

     public void updateWorkMetric(DataSnapshot dataSnapshot, String day, String hour, DatabaseReference dRef)
     {
        int  workMetric = dataSnapshot.child(day).child(hour).getValue(Integer.class);
        workMetric += 1;
        dRef.child(day).child(hour).setValue(workMetric);
     }

     public void clearWorkMetric(DataSnapshot dataSnapshot, String day, String hour, DatabaseReference dRef)
     {
        int workMetric = dataSnapshot.child(day).child(hour).getValue(Integer.class);
        workMetric = 0;
        dRef.child(day).child(hour).setValue(workMetric);
     }


}

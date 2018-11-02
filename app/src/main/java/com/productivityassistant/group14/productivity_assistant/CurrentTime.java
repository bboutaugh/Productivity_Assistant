package com.productivityassistant.group14.productivity_assistant;

import java.util.Calendar;
import java.util.Date;

public class CurrentTime
{


    Date date = new Date();
    Calendar calendar = Calendar.getInstance();




    public String getHour()
    {
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        String s_Hour = Integer.toString(currentHour);
        return s_Hour;
    }

    public String getDay()
    {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String currentDay = "";
        String weekdays[] = {"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
        for(int i = 0;i<6;i++)
        {
            if(dayOfWeek == i)
            {
                currentDay = weekdays[i];

            }
        }
        return currentDay;

    }
}

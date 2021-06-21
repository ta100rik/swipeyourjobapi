package com.Swipeyourjob.Rest_api.Controllers.request.SubclassesJob;

import java.lang.reflect.Field;

public class Availbility {
     public boolean morning;
     public boolean afternoon;
     public boolean evening;
     public boolean night;

     public boolean isMorning() {
          return morning;
     }

     public void setMorning(boolean morning) {
          this.morning = morning;
     }

     public boolean isAfternoon() {
          return afternoon;
     }

     public void setAfternoon(boolean afternoon) {
          this.afternoon = afternoon;
     }

     public boolean isEvening() {
          return evening;
     }

     public void setEvening(boolean evening) {
          this.evening = evening;
     }

     public boolean isNight() {
          return night;
     }

     public void setNight(boolean night) {
          this.night = night;
     }
     public boolean  checkNull() {
          for (Field f : getClass().getFields()) {
               f.setAccessible(true);
               try {
                    if (f.get(this) == null) {
                         System.out.println(f);
                         return true;
                    }
               } catch (IllegalAccessException e) { // shouldn't happen because I used setAccessible
                    return true;
               }
          }
          return false;
     }
}

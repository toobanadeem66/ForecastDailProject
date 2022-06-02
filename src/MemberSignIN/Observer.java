/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberSignIN;

/**
 *
 * @author Dell
 */
public interface Observer {
      public void update(String city, String country, String temp, String hightemp, String lowtemp, String humidity, String pressure, String cloudcover, String windspeed, String feelslike, String description, String visibility, String sunset,String sunrise, String precipitation, String results);
public void update(String stats);
 public void warning(String a);
}

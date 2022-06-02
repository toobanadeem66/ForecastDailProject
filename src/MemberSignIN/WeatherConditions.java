/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberSignIN;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import com.google.gson.stream.JsonWriter;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
/*
 *
 * @author 18559,18558,18562
 */

public class WeatherConditions implements Subject{
   private String temperature;
    private String pressure;
    private String humidity;
    private String precipitation;
    private String city;
    private String state;
    private String country;
    private String cloudcover;
    private String windspeed;
    private String hightemp;
    private String lowtemp;
    private String feelslike;
    private String description;
    private String visibility;
    private String Sunset;
    private String sunrise;
    public String results;
    private ArrayList<Observer> observers;
    private String lat;
    private String Long;
    private String stats;
    
  
    
    WeatherConditions() throws ParseException{
   
   observers = new ArrayList<>();
  
 
    }
    
 WeatherConditions(String lat,String Long){
     this.lat=lat;
     this.Long=Long;
     observers = new ArrayList<>();
 }
   @Override
    public void registerObserver(Observer o) {
    observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
       int i = observers.indexOf(o);
       if (i >= 0) {
       observers.remove(i);
  }
    }

    @Override
    public void notifyObservers() {
      if(! results.contains("https")){
      for (int i = 0; i < observers.size(); i++) {
   Observer observer = (Observer)observers.get(i);
   //String city, String country, String temp, String hightemp, String lowtemp, String humidity, String pressure, String cloudcover, String windspeed, String  windspeed, String description, String visibility, String sunset,String sunset,
   observer.update(city, country, temperature, hightemp, lowtemp, humidity,pressure,cloudcover, windspeed, feelslike,description,visibility,Sunset,sunrise, precipitation, results);
      }
    }
      else {
          
       for (int i = 0; i < observers.size(); i++) {
   Observer observer = (Observer)observers.get(i);
          observer.warning("error");
      }}
    }
    
    
    
    
     public void measurementsChanged() {
  notifyObservers();
 }
    

  
 public void setMeasurements() throws ParseException {
  
  this.temperature = getTemperature(results);
  this.humidity = getHumidity(results); 
  this.pressure = getPressure(results);
  this.city= getCity(results);
  this.country= getCountry(results);
  this.cloudcover= getCloudCover(results);
  this.hightemp= getHTemp(results);
  this.lowtemp= getLTemp(results);
  this.visibility=visibility(results);
  this.windspeed=getWindSpeed(results);
  this.feelslike=feelsLike(results);
  this.description=description(results);
  this.Sunset= Sunset(results);
  this.sunrise= Sunrise(results);
  this.stats = getStats();
  measurementsChanged();
 
 }
 public String current2(String location) throws IOException{
      try{
            String API_KEY = "492ddba3adb25f6cbabad40a5bc7969e";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY+"&units=metric";
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection con = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while((line = rd.readLine())!=null){ 
                result.append(line);
            }
            rd.close();
            String r= result.toString();
            if(!r.contains("https")){
             return r;
             
         
        }   else 
                return "error";}
        catch (MalformedURLException ex) {
            Logger.getLogger(WeatherConditions.class.getName()).log(Level.SEVERE, null, ex);
             return "error";
        }
 }
    
 
 
    public void currentWeatherConditions(String location) throws IOException, ParseException{
        
        try{
            String API_KEY = "492ddba3adb25f6cbabad40a5bc7969e";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY+"&units=metric";
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection con = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while((line = rd.readLine())!=null){ 
                result.append(line);
            }
            rd.close();
            this.results= result.toString();
             setMeasurements();
             
          for (int i = 0; i < observers.size(); i++) {
          Observer observer = (Observer)observers.get(i);
          observer.warning("good");}
        }   
        catch (MalformedURLException ex) {
            Logger.getLogger(WeatherConditions.class.getName()).log(Level.SEVERE, null, ex);
               for (int i = 0; i < observers.size(); i++) {
          Observer observer = (Observer)observers.get(i);
          observer.warning("error");
        }
       
    }}
    
    
    
    
    
    
     public String current3Temp(String location) throws IOException, ParseException{
        
        try{
            String API_KEY = "492ddba3adb25f6cbabad40a5bc7969e";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY+"&units=metric";
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection con = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while((line = rd.readLine())!=null){ 
                result.append(line);
            }
            rd.close();
           String results= result.toString();
           String temp = getTemperature(results);
           return temp;
         
        }   
        catch (MalformedURLException ex) {
            Logger.getLogger(WeatherConditions.class.getName()).log(Level.SEVERE, null, ex);
           return "error";
        }
       
    }
    
    public String HourlyWeather(String LAT,String LONG){
        String API_KEY = "492ddba3adb25f6cbabad40a5bc7969e";
        String urlString = "https://api.openweathermap.org/data/2.5/onecall?lat=" + LAT+ "&lon="+LONG+"&exclude=minutely,current,daily"+"&appid=" + API_KEY+"&units=metric";
            try{
                StringBuilder result = new StringBuilder();
                URL url = new URL(urlString);
                URLConnection conn = url.openConnection();
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while((line = rd.readLine())!=null){ 
                    result.append(line);
                }
                rd.close();
                System.out.println(result);
               
                String StringResults = result.toString();
                if(!StringResults.contains("https"))
                return StringResults;
                else 
                    return "error";
            } 
            catch (IOException e){
                System.out.println(e.getMessage());
                 return "error";
            }
       
    }
 
    public String getStats(){
        return stats;
    }
    
    
    public String ReadHourlyWeather(String results){
        JSONObject JsonResult = new JSONObject(results);
        JSONArray JsonResultArray = JsonResult.getJSONArray("hourly");
        String temp;
        ArrayList<String> temparray = new ArrayList();
        for(int i=0; i<JsonResultArray.length();i++){
            JSONObject hourForecast = JsonResultArray.getJSONObject(i);
            temp = hourForecast.getString("temp");
            temparray.add(temp);
        }   
        return "error";
    }    
    
   
    
    public String feelsLike(String results){
        if(!results.equals("error")){
            String[] arr = results.split(",|\\{");
            String temp="";
            for(int i=0;i< arr.length;i++){
                if(arr[i].contains("\"feels_like\"")){
                    temp = arr[i];
                }
            }
            String[] arr1 = temp.split(":");
            return arr1[1];
        } 
        else 
            return "error";
    }
    
    public String getWindSpeed(String results){
        if(!results.equals("error")){
            String[] arr = results.split(",|\\{");
            String temp="";
            for(int i=0;i< arr.length;i++){
                if(arr[i].contains("\"speed\"")){
                    temp = arr[i];
                }
            }
            String[] arr1 = temp.split(":");
            return arr1[1];
        }
        else 
            return "error";
    }
    
    public String visibility(String results){
        try{
            String[] arr = results.split(",|\\{");
            String temp="";
            for(int i=0;i< arr.length;i++){
                if(arr[i].contains("\"visibility\"")){
                    temp = arr[i];
                }
            }
            String[] arr1 = temp.split(":");
            return arr1[1];
        }
        catch(Exception e) {
           return "--";
        }
    }
    
    public String description(String results){
        if(!results.equals("error")){
        String[] arr = results.split(",|\\{");
        String temp="";
        for(int i=0;i< arr.length;i++){
            if(arr[i].contains("\"description\"")){
                temp = arr[i];
            }
        }
            String[] arr1 = temp.split(":");
            return arr1[1];
        } 
        else 
            return "error";
    }
    
    public String Sunset(String results) throws ParseException {
        String[] arr = results.split(",|\\{");
        String temp="";
        for(int i=0;i< arr.length;i++){
            if(arr[i].contains("\"sunset\"")){
                temp = arr[i];
            }
        }
        String[] arr1 = temp.split(":");
        System.out.println(arr1[1].length());
        String sunset = arr1[1].substring(0,arr1[1].length()-1);
        
        long millis = new Long(sunset);
        System.out.println(millis);
        Date date = new Date(millis*1000L); 
        SimpleDateFormat jdf = new SimpleDateFormat(" dd/MM/yyyy HH:mm:ss a");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String java_date = jdf.format(date)+" GMT";
        return  java_date;
    }
    
    public String Sunrise(String results) throws ParseException {
        String[] arr = results.split(",|\\{");
        String temp="";
        for(int i=0;i< arr.length;i++){
            if(arr[i].contains("\"sunrise\"")){
                temp = arr[i];
           }
        }
        String[] arr1 = temp.split(":");
        System.out.println(arr1[1].length());
        
        String Sunrise = arr1[1].substring(0,arr1[1].length());
        long millis = new Long(Sunrise);
        System.out.println(millis);
        Date date = new Date(millis*1000L); 
        SimpleDateFormat jdf = new SimpleDateFormat(" dd/MM/yyyy HH:mm:ss a");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String java_date = jdf.format(date)+" GMT";
        return  java_date;
    }
    
    
     public String getTemperature(String results){
         
         if(!results.equals("error")){
             
         
         
        String[] arr = results.split(",|\\{");
        
         String temp="";
        
        for(int i=0;i< arr.length;i++){
            if(arr[i].contains("\"temp\"")){
                
                temp = arr[i];
                
          }}
        
            String[] arr1 = temp.split(":");
            
            
            
            
            
            
            return arr1[1];}
         else 
             return "error";
      
    }
    
    
    public String getHTemp(String results){
          if(!results.equals("error")){
         String[] arr = results.split(",|\\{");
           String temp="";
        
        for(int i=0;i< arr.length;i++){
            if(arr[i].contains("\"temp_min\"")){
                
                temp = arr[i];
                
          }}
        
            String[] arr1 = temp.split(":");
            return arr1[1];}
          else 
              return "error";
            
     }
    
    public String getLTemp(String results){
          if(!results.equals("error")){
         String[] arr = results.split(",|\\{");
           String temp="";
        
        for(int i=0;i< arr.length;i++){
            if(arr[i].contains("\"temp_max\"")){
                
                temp = arr[i];
                
          }}
        
            String[] arr1 = temp.split(":");
            return arr1[1];}
          else return "error";
     }
    
    public void setTemperature(String temperature){
        this.temperature=temperature;
    }
    
    public String getPressure(String pressure){
        String[] array = pressure.split(",|\\{");
        String temp="";
        for(int i=0;i< array.length;i++){
            if(array[i].contains("\"pressure\"")){
                temp = array[i];
            }
        }
        String[] array1 = temp.split(":");
        return array1[1];
    }
    
    public void setPressure(String pressure){
        this.pressure=pressure;
    }
    
    public String getHumidity(String humidity){
        String[] array = humidity.split(",|\\{");
        String temp="";
        for(int i=0;i< array.length;i++){
            if(array[i].contains("\"humidity\"")){
                temp = array[i];
            }
        }
        String[] array1 = temp.split(":");
        return array1[1];
    }
    
    public void setHumidity(String humidity){
        this.humidity=humidity;
    }
    
    /*public String getPrecipitation(String precipitation){
        String[] array = precipitation.split(",|\\{");
        String temp="";
        for(int i=0;i< array.length;i++){
            if(array[i].contains("\"precipitation\"")){
                temp = array[i];
            }
        }
        String[] array1 = temp.split(":");
        return array1[0];
    }
    */
    
    public void setPrecipitation(String precipitation){
        this.precipitation=precipitation;
    }
    
    public String getCloudCover(String cloudcover){
        String[] array = cloudcover.split(",|\\{");
        String temp="";
        for(int i=0;i< array.length;i++){
            if(array[i].contains("\"description\"")){
                temp = array[i];
            }
        }
        String[] array1 = temp.split(":");
        return array1[1];
    }
    
    public void setCloudCover(String cloudcover){
        this.cloudcover=cloudcover;
    }
    
    public String getCity(String city){
        String[] array = city.split(",|\\{");
        String temp="";
        for(int i=0;i< array.length;i++){
            if(array[i].contains("name\"")){
                temp = array[i];
            }
        }
        String[] array1 = temp.split(":");
        city=array1[1];
        return city;
    }
    
    public void setCity(String city){
        this.city=city;
    }
    
    public String getState(String state){
        String[] array = state.split(",|\\{");
        String temp="";
        for(int i=0;i< array.length;i++){
            if(array[i].contains("\"name\"")){
                temp = array[i];
            }
        }
        String[] array1 = temp.split(":");
        state=array1[1];
        return state;
    }
    
    public void setState(String state){
        this.state=state;
    }
    
    public String getCountry(String country){
        String[] array = country.split(",|\\{");
        String temp="";
        for(int i=0;i< array.length;i++){
            if(array[i].contains("\"name\"")){
                temp = array[i];
            }
        }
        String[] array1 = temp.split(":");
        return array1[1];
    }
    
    public void setCountry(String country){
        this.country=country;
    }
    
    public String averageTemperature(String temperature){
        String[] array = temperature.split(",|\\{");
        String temp=null;
        for(int i=0;i< array.length;i++){
            if(array[i].contains("\"temp\"")){
                temp = array[i];
            }
        }
        String[] array1 = temp.split(":");
        String m= array1[1];
        double avg= Double.parseDouble(m)+3;
        return Double.toString(avg);
    }
    
    public String convertTemperature(String temperature){
        String[] array = temperature.split(",|\\{");
        String temp="";
        for(int i=0;i< array.length;i++){
            if(array[i].contains("\"temp\"")){
                temp = array[i];
            }
        }
        String[] array1 = temp.split(":");
        String m= array1[1];
        double f= (Double.parseDouble(m)*9/5)+32;
        return Double.toString(f);
    }
}


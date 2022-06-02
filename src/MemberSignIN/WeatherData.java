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
/**
 *
 * @author 18558,18559,18562
 */
public class WeatherData{
    
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
    public  String results;
    //private ArrayList<Observer> observers;
    private String lat;
    private String Long;
    private String stats;
  
 
    /**WeatherData() throws ParseException{
        observers = new ArrayList<>();
    }
    
    WeatherData(String lat,String Long){
        this.lat=lat;
        this.Long=Long;
        observers = new ArrayList<>();
    }**/
    
    
    public void measurementsChanged() {
       
    }
    
    public void setMeasurements() throws ParseException {
        this.temperature = getTemperature(results);
        this.humidity = getHumidity(results); 
        this.pressure = getPressure(results);
        this.city= cityname(results);
        this.country= getCountry(results);
        this.cloudcover= getCloudCover(results);
        this.hightemp=getHTemp(results);
        this.lowtemp=getLTemp(results);
        this.visibility=visibility(results);
        this.windspeed=getWindSpeed(results);
        this.feelslike=feelsLike(results);
        this.description=description(results);
        this.Sunset=getSunset(results);
        this.sunrise=getSunrise(results);
        this.stats = getStats();
        measurementsChanged();
    }
    
    public void CurrentWeatherData(String city) throws ParseException, MalformedURLException{
        String API_KEY = "492ddba3adb25f6cbabad40a5bc7969e";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY+"&units=metric";
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
            this.results = result.toString();
            System.out.println(results);
            setMeasurements();
            /**for (int i = 0; i < observers.size(); i++) {
                Observer observer = (Observer)observers.get(i);
                observer.warning("good");
            }
        } 
        catch (IOException e){
            for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.warning("error");   
            }
        }**/
        }  
        catch (IOException ex) {
            Logger.getLogger(WeatherData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void HourlyWeather(String lat, String Long) throws IOException{
        String API_KEY = "492ddba3adb25f6cbabad40a5bc7969e";
        String urlString = "https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon="+Long+"&exclude=minutely,current,daily"+"&appid=" + API_KEY+"&units=metric";
        //try{
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
            this.stats = result.toString();
            /**notifyObservers();
            for (int i = 0; i < observers.size(); i++) {
                Observer observer = (Observer)observers.get(i);
                observer.warning("good");
            }
        } 
        catch (IOException e){
            for (int i = 0; i < observers.size(); i++) {
                Observer observer = (Observer)observers.get(i);
                observer.warning("error");
            }
        }**/
    } 

    public void setStats(String stats){
        this.stats= stats;
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
        return "";
    }  
    
    public static void main(String args[]) throws ParseException{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                       
            }
        });
    }
     
    public String getTemperature(String results){
        if(!results.equals("error")){
            String[] arr = results.split(",|\\{");
            String temp="";
                for(int i=0;i< arr.length;i++){
                    if(arr[i].contains("\"temp\"")){
                        temp = arr[i];
                    }
                }
            String[] arr1 = temp.split(":");
            return arr1[1];
        }
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
            }
        }
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
            }
        }
        String[] arr1 = temp.split(":");
        return arr1[1];}
        else 
            return "error";
    }
     
    public String getCountry(String results){
        try{
            String[] arr = results.split(",|\\{");
            String temp="";
            for(int i=0;i< arr.length;i++){
                if(arr[i].contains("\"country\"")){
                    temp = arr[i];
                }  
            }
            String[] arr1 = temp.split(":");
            return arr1[1];} 
            catch(Exception e){
                return city;
            }
    }
    
    public void setTemperature(String temperature){
        this.temperature=temperature;
    }
    
    public String getPressure(String results){
        if(!results.equals("error")){
        String[] arr = results.split(",|\\{");
        String temp="";
        for(int i=0;i< arr.length;i++){
            if(arr[i].contains("\"pressure\"")){
                temp = arr[i];
            }
        }
        String[] arr1 = temp.split(":");
        return arr1[1];
        }
        else 
            return "error";
    }
    
    public void setPressure(String pressure){
        this.pressure=pressure;
    }
    
    public String getHumidity(String results){
        if(!results.equals("error")){
        String[] arr = results.split(",|\\{");
        String temp="";
        for(int i=0;i< arr.length;i++){
            if(arr[i].contains("\"humidity\"")){
                temp = arr[i];
           }
        }
            String[] arr1 = temp.split(":");
            return arr1[1];
            }
        else 
            return "error";
    }
    
    public void setHumidity(String humidity){
        this.humidity=humidity;
    }
    
    public void setPrecipitation(String precipitation){
        this.precipitation=precipitation;
    }
    
    public String getCloudCover(String results){
        if(!results.equals("error")){
            String[] arr = results.split(",|\\{");
            String temp="";
            for(int i=0;i< arr.length;i++){
                if(arr[i].contains("\"all\"")){
                    temp = arr[i];
                }
            }
            String[] arr1 = temp.split(":");
            return arr1[1];
        }
        else 
            return "error";
    }
    
    public void setCloudCover(String cloudcover){
        this.cloudcover=cloudcover;
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
    
    public String cityname(String results){
        if(!results.equals("error")){
            String[] arr = results.split(",|\\{");
            String temp="";
            for(int i=0;i< arr.length;i++){
                if(arr[i].contains("\"name\"")){
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
    
    public String getSunset(String results) throws ParseException {
        if(!results.equals("error")){
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
   //convert seconds to milliseconds
            Date date = new Date(millis*1000L); 
   // format of the date
            SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
            jdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            String java_date = jdf.format(date)+" GMT";
            return  java_date;
        }     
        else 
            return "error";
    }
     
    public String getSunrise(String results) throws ParseException {
        try{
            String[] arr = results.split(",|\\{");
            String temp="";
            for(int i=0;i< arr.length;i++){
                if(arr[i].contains("\"sunrise\"")){
                    temp = arr[i];
                }
            }
            String[] arr1 = temp.split(":");
            System.out.println(arr1[1].length());
            String sunrise = arr1[1].substring(0,arr1[1].length());
            long millis = new Long(sunrise);
            System.out.println(millis);
   //convert seconds to milliseconds
            Date date = new Date(millis*1000L); 
   // format of the date
            SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
            jdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            String java_date = jdf.format(date)+" GMT"; 
            return  java_date ;
        } 
        catch(Exception e){ 
            return "--";
        }
    }
}

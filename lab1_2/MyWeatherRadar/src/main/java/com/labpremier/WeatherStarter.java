package com.labpremier;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {
    /*
    loggers provide a better alternative to System.out.println
    https://rules.sonarsource.com/java/tag/bad-practice/RSPEC-106
     */
    protected static final Logger logger = LogManager.getLogger(WeatherStarter.class.getName());
    
    public static void  main(String[] args ) {
        /* set cityId based on received parameter (lab 1.1)
            *int cityId=1010500;
            *if(args.length != 0)
                *cityId=Integer.parseInt(args[0]);
        */

        /* set cityName based on received parameter (lab 1.2) */
        String cityName="Aveiro"; // Default cityName
        Integer cityId=1010500; // Default cityId
        if(args.length != 0)
            cityName=args[0];

        /*
        get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        IpmaService service = retrofit.create(IpmaService.class);

        // get cityId searching by name
        Call<IpmaCities> callSync_Cities = service.getAllCities();
        try{
            Response<IpmaCities> apiResponse = callSync_Cities.execute();
            IpmaCities cidades = apiResponse.body();
            for(Cidade c : cidades.getCities()) {
                String currentName = c.getCityName().toLowerCase();
                if(cityName.toLowerCase().equals(currentName)){
                    cityId=c.getGlobalIdLocal();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        Call<IpmaCityForecast> callSync_Forecast = service.getForecastForACity(cityId);

        System.out.format("******************\n\nCity's Information\n\n******************\n");

        try {
            logger.info(cityId + ": " + cityName);
            Response<IpmaCityForecast> apiResponse = callSync_Forecast.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                for(CityForecast c : forecast.getData()){
                    System.out.println("***"+c.getForecastDate()+"***");
                    logger.info("max temp for today: " + c.getTMax());
                    logger.info("min temp for today: " + c.getTMin());
                    logger.info("wind direction: " + c.getPredWindDir()); 
                    logger.info("weather type: " + c.getIdWeatherType());  
                    logger.info("classified wind speed: " + c.getClassWindSpeed());  
                    logger.info("longitude: " + c.getLongitude());   
                    logger.info("latitude: " + c.getLatitude());
                    logger.info("precipitation probability: " + c.getPrecipitaProb());
                }
            } else {
                logger.info("No results!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.exit(1);
    }
}

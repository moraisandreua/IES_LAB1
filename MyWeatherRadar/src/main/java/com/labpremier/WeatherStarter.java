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
        int cityId=1010500;
        /*
        set cityId based on received parameter
        */
        if(args.length != 0)
            cityId=Integer.parseInt(args[0]);

        /*
        get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);
        Call<IpmaCityForecast> callSync = service.getForecastForACity(cityId);

        System.out.format("******************\n\nCity's Information\n\n******************\n");

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                logger.info("max temp for today: " + forecast.getData().
                    listIterator().next().getTMax());

                logger.info("min temp for today: " + forecast.getData().
                    listIterator().next().getTMin());
                
                logger.info("wind direction: " + forecast.getData().
                    listIterator().next().getPredWindDir());
                    
                logger.info("weather type: " + forecast.getData().
                    listIterator().next().getIdWeatherType());
                    
                logger.info("classified wind speed: " + forecast.getData().
                    listIterator().next().getClassWindSpeed());
                    
                logger.info("longitude: " + forecast.getData().
                    listIterator().next().getLongitude());
                    
                logger.info("latitude: " + forecast.getData().
                    listIterator().next().getLatitude());
                    
                logger.info("forecast date: " + forecast.getData().
                    listIterator().next().getForecastDate());
                    
                logger.info("precipitation probability: " + forecast.getData().
                    listIterator().next().getPrecipitaProb());
            } else {
                logger.info("No results!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

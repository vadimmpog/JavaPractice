import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Bot {

    public static void main(String[] args) {//weather api key 841bfe391fe41c3b9a66b0a076d4a044

        String API_CALL_TEMPLATE = "http://api.openweathermap.org/data/2.5/weather?lang=ru&q=",API_KEY_TEMPLATE ="&appid=841bfe391fe41c3b9a66b0a076d4a044";




        TelegramBot bot = new TelegramBot("1175777315:AAGBN3VDb_p_Epb8l7oBWx9XfVueiGHOsSg");
        bot.setUpdatesListener(updates -> {


            long chatId = updates.get(0).message().chat().id();
            String message = updates.get(0).message().text();

            //commands
            switch (message){
                case "/start" :{
                    SendResponse response0 = bot.execute(new SendMessage(chatId,"Введите название города, чтобы получить прогноз."));
                    break;
                }
                default:{
                    String URLstring = API_CALL_TEMPLATE + message + API_KEY_TEMPLATE;
                    try {

                        URL urlobj = new URL(URLstring);
                        HttpURLConnection connection = (HttpURLConnection) urlobj.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                        int responseCode = connection.getResponseCode();
                        if (responseCode == 404) {
                            throw new IllegalArgumentException();
                        }


                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String inputLine;
                        StringBuffer response = new StringBuffer();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();


                        JSONObject jsonObject = new JSONObject(response.toString());

                        String city = jsonObject.getString("name");
                        double temperature = jsonObject.getJSONObject("main").getDouble("temp")-273.15;
                        double humidity = jsonObject.getJSONObject("main").getDouble("humidity");
                        double windspeed = jsonObject.getJSONObject("wind").getDouble("speed");
                        String overcast = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");


                        SendResponse response1 = bot.execute(new SendMessage(chatId,
                                "Погода в городе - " + city +"\n" +
                                        "Температура: "+ Math.round(temperature) + "°C\n" +
                                        "Состояние: " + overcast + "\n" +
                                        "Скорость ветра: " + windspeed + " м/с" + "\n" +
                                        "Влажность: " + humidity + "%"));

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e){
                        SendResponse response2 = bot.execute(new SendMessage(chatId,"Этот город не найден."));
                        e.printStackTrace();
                    }
                    break;
                }

            }

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });

    }
}

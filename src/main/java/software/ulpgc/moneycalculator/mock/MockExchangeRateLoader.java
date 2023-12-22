package software.ulpgc.moneycalculator.mock;

import software.ulpgc.moneycalculator.ExchangeRateLoader;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.ExchangeRate;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MockExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            String access_key = "c84debbcf915cfc2a03e3310f9a7ed98";
            String url_str = "http://api.exchangeratesapi.io/latest?access_key=" + access_key + "&base=" + from.getCode() + "&symbols=" + to.getCode();

            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();

            JsonObject rates = jsonobj.getAsJsonObject("rates");
            double rate = rates.get(to.getCode()).getAsDouble();

            return new ExchangeRate(from, to, LocalDate.now(), rate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

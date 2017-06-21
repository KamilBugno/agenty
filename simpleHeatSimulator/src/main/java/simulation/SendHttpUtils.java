package simulation;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by huber on 21.06.2017.
 */
public class SendHttpUtils {

    public static void register(String type, String myHostAddress, int deviceId, int locationId) {
        System.out.println(myHostAddress);
        try {
            Unirest.post(createURL(Config.SERVER_IP, Config.SERVER_PORT, Config.REGISTER_ROUTE))
                    .field("type", type)
                    .field("deviceId", deviceId)
                    .field("locationId", locationId)
                    .field("callback", myHostAddress)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public static String createURL(String ip, int port, String route) {
        return String.format("http://%s:%d/%s", ip, port, route);
    }

    public static String createURL(String ip, String route) {
        return String.format("http://%s/%s", ip, route);
    }
}

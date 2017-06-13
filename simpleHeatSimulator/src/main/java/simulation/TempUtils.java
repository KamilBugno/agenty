package simulation;

/**
 * Created by huber on 13.06.2017.
 */
public class TempUtils {
    public static float celsiusToKelvin(float tempCelsius) {
        return tempCelsius + 274.15f;
    }

    public static float kelvinToCelsius(float tempKelvin) {
        return tempKelvin - 274.15f;
    }
}

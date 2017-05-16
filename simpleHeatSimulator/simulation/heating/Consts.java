package simulation.heating;

/**
 * Created by huber on 25.04.2017.
 */
public class Consts {
    // k - współczynnik przenikania ciepla
    public final static float K = 1.0f;

    // wysokosc pomieszczen
    public final static float HEIGHT = 3.0f;

    // grubosc sciany w metrach
//    public final static float D = 0.5f;
    public final static float D = 5000f;

//    public final static double moleculesInCubicMeter = 2.53 * 10000000000000000000000.0;
//
//    // stala Boltzmana
//    public final static double kb = 1.38 * 0.00000000000000000000001;

    // 3 * stala Boltzmana * ilosc moli powietrza w m^3
    public final static double TRANSFER_CONSTANT = 1.04791335;
//    public final static double TRANSFER_CONSTANT = 0.00104791335;
}

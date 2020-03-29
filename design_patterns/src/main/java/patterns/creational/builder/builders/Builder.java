package patterns.creational.builder.builders;

import patterns.creational.builder.cars.Type;
import patterns.creational.builder.components.Engine;
import patterns.creational.builder.components.GPSNavigator;
import patterns.creational.builder.components.Transmission;
import patterns.creational.builder.components.TripComputer;

/**
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setType(Type type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
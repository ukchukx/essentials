package patterns.structural.bridge;

import patterns.structural.bridge.devices.Device;
import patterns.structural.bridge.devices.Radio;
import patterns.structural.bridge.devices.Tv;
import patterns.structural.bridge.remotes.AdvancedRemote;
import patterns.structural.bridge.remotes.BasicRemote;

/**
 * Bridge between devices and remote controls
 * This example shows separation between the classes of remotes and devices that they control.
 * Remotes act as abstractions, and devices are their implementations. Thanks to the common interfaces, 
 * the same remotes can work with different devices and vice versa.
 * The Bridge pattern allows changing or even creating new classes without touching the code of the opposite hierarchy.
 */

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
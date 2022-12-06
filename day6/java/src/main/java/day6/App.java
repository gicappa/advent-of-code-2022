package day6;

import java.util.HashSet;

/**
 * Client to parse soap messages and to create soap calls
 */
public class App {

    private final LoadInput loader;

    public static void main(String... args) {
        new App().run();

    }

    public App() {
        loader = new LoadInput();
    }

    public void run() {
        var dataStream = loader.load("/input.txt").get(0);
        System.out.println("Packet  Marker position: " + findPacketMarkerPosition(dataStream));
        System.out.println("Message Marker position: " + findMessageMarkerPosition(dataStream));

    }

    public int findPacketMarkerPosition(String dataStream) {
        return findMarkerPosition(dataStream, 4);
    }

    public int findMessageMarkerPosition(String dataStream) {
        return findMarkerPosition(dataStream, 14);
    }

    private int findMarkerPosition(String dataStream, int numberOfChars) {
        for (var i = 0; i < dataStream.length() - numberOfChars; i++) {
            if (!checkRepeatedChars(dataStream.substring(i, i + numberOfChars))) {
                return i + numberOfChars;
            }
        }
        return -1;
    }


    public boolean checkRepeatedChars(String string) {
        var marker = new HashSet<Character>();

        for (var c : string.toCharArray()) {
            if (marker.contains(c)) {
                return true;
            }

            marker.add(c);
        }
        return false;
    }
}

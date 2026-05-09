package utilities;

public class CommonWait {

    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // good practice
            System.out.println("Pause interrupted: " + e.getMessage());
        }
    }

}

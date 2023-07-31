import com.google.common.eventbus.EventBus;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();



        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(eventBus);
        });
    }



}

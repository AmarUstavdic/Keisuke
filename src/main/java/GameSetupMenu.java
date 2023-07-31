import com.google.common.eventbus.EventBus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSetupMenu extends JPanel {

    private EventBus eventBus;
    private GameMode gameMode;
    private JButton[] buttons;

    public GameSetupMenu(GameMode gameMode, EventBus eventBus) {
        this.gameMode = gameMode;
        this.eventBus = eventBus;

        Dimension dimension = new Dimension(200, 300);
        this.setPreferredSize(dimension); // Only use setPreferredSize

        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(4);
        gridLayout.setColumns(1);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        this.setLayout(gridLayout);

        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add 10-pixel padding
        this.setBackground(KeisukeConstants.BACKGROUND_COLOR);

        EventHandler eventHandler = new EventHandler();

        buttons = new JButton[4];
        buttons[0] = new JButton("New Game");
        buttons[1] = new JButton("Load Game");
        buttons[2] = new JButton("Costume Game");
        buttons[3] = new JButton("Go Back");

        for (JButton button : buttons) {
            button.setBackground(KeisukeConstants.MAIN_BTN_COLOR);
            button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            button.addActionListener(eventHandler);
            this.add(button);
        }
    }



    private class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();

            switch (button.getText()) {
                case "New Game":
                    eventBus.post(new BusEvent(EventType.SETUP_MENU_NEW_GAME));
                    break;
                case "Load Game":

                    break;
                case "Costume Game":

                    break;
                case "Go Back":
                    eventBus.post(new BusEvent(EventType.SETUP_MENU_GO_BACK));
                    break;
            }
        }
    }
}

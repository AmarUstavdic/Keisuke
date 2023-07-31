import com.google.common.eventbus.EventBus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {

    private EventBus eventBus;
    private JLabel gameTitle;
    private JButton classicGameBtn, endlessGameBtn;
    private JPanel titleContainer, btnContainer;

    public MainMenu(EventBus eventBus) {
        this.eventBus = eventBus;

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        EventHandler eventHandler = new EventHandler();
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // added padding here


        titleContainer = new JPanel();
        titleContainer.setLayout(new BorderLayout());
        titleContainer.setBackground(KeisukeConstants.BACKGROUND_COLOR);
        Dimension titleContainerDimension = new Dimension(400,150);
        titleContainer.setPreferredSize(titleContainerDimension);
        titleContainer.setPreferredSize(titleContainerDimension);
        titleContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // added padding here


        gameTitle = new JLabel(KeisukeConstants.GAME_TITLE);
        gameTitle.setFont(gameTitle.getFont().deriveFont(Font.BOLD,40));
        gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
        gameTitle.setVerticalAlignment(SwingConstants.CENTER);

        titleContainer.add(gameTitle, BorderLayout.CENTER);
        this.add(titleContainer, BorderLayout.NORTH);


        btnContainer = new JPanel();
        GridLayout gridLayout = new GridLayout();
        btnContainer.setLayout(gridLayout);

        btnContainer.setBackground(KeisukeConstants.BACKGROUND_COLOR);
        Dimension btnContainerDimension = new Dimension(400,150);
        btnContainer.setPreferredSize(btnContainerDimension);
        btnContainer.setPreferredSize(btnContainerDimension);

        classicGameBtn = new JButton("Classic Mode");
        classicGameBtn.addActionListener(eventHandler);
        classicGameBtn.setBackground(KeisukeConstants.MAIN_BTN_COLOR);
        btnContainer.add(classicGameBtn);

        endlessGameBtn = new JButton("Endless Mode");
        endlessGameBtn.addActionListener(eventHandler);
        endlessGameBtn.setBackground(KeisukeConstants.MAIN_BTN_COLOR);
        btnContainer.add(endlessGameBtn);


        this.add(btnContainer, BorderLayout.SOUTH);
    }



    private class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(classicGameBtn)) {
                BusEvent busEvent = new BusEvent(EventType.CLASSIC_GAME_MODE, GameMode.CLASSIC);
                eventBus.post(busEvent);

            }else if (e.getSource().equals(endlessGameBtn)) {
                BusEvent busEvent = new BusEvent(EventType.ENDLESS_GAME_MODE, GameMode.ENDLESS);
                eventBus.post(busEvent);
            }
        }
    }
}

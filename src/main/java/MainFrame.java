import com.google.common.eventbus.EventBus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private EventBus eventBus;
    private JLabel gameTitle;
    private JButton classicGameBtn, endlessGameBtn;
    private JPanel titleContainer, btnContainer;


    public MainFrame(EventBus eventBus) {
        this.eventBus = eventBus;

        // making sure that MainFrame shows in the center of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle(KeisukeConstants.GAME_TITLE);

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);


        EventHandler eventHandler = new EventHandler();


        titleContainer = new JPanel();
        titleContainer.setLayout(new BorderLayout());
        titleContainer.setBackground(KeisukeConstants.BACKGROUND_COLOR);
        Dimension titleContainerDimension = new Dimension(400,150);
        titleContainer.setPreferredSize(titleContainerDimension);
        titleContainer.setPreferredSize(titleContainerDimension);

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
        this.pack();
        this.setVisible(true);
    }




    class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(classicGameBtn)) {
                System.out.println("hello");
            }else if (e.getSource().equals(endlessGameBtn)) {

            }
        }
    }


}

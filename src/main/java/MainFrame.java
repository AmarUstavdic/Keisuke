import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    private EventBus eventBus;
    private CardLayout cardLayout;
    private JPanel cards;
    private MainMenu mainMenu;


    public MainFrame(EventBus eventBus) {
        this.eventBus = eventBus;
        eventBus.register(this);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle(KeisukeConstants.GAME_TITLE);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        mainMenu = new MainMenu(eventBus);
        cards.add(mainMenu, "mainMenu");

        this.setContentPane(cards);

        this.pack();
        this.setVisible(true);
    }


    @Subscribe
    private void processEvent(BusEvent busEvent) {
        switch (busEvent.getEventType()) {
            case ENDLESS_GAME_MODE, CLASSIC_GAME_MODE -> {
                GameSetupMenu gameSetupMenu = new GameSetupMenu(busEvent.getGameMode(), eventBus);
                cards.add(gameSetupMenu, "gameSetupMenu");

                cardLayout.show(cards, "gameSetupMenu");
                this.setSize(gameSetupMenu.getPreferredSize());
                this.setLocationRelativeTo(null);
                this.revalidate();
            }

            case SETUP_MENU_GO_BACK -> {
                cardLayout.show(cards, "mainMenu");
                this.setSize(mainMenu.getPreferredSize());
                this.setLocationRelativeTo(null);
                this.revalidate();
            }
        }
    }
}

import javax.swing.*;
import java.awt.*;

public class GameDataContainer extends JPanel {

    private JPanel across, down;

    public GameDataContainer() {
        this.setPreferredSize(KeisukeConstants.GAME_DATA_CONTAINER_DIMENSION);
        this.setLayout(new BorderLayout());

        across = new JPanel();
        down = new JPanel();

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        across.setLayout(flowLayout);

        JLabel acrossLabel = new JLabel("Across:");
        acrossLabel.setPreferredSize(new Dimension(50,50));
        across.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

        across.add(acrossLabel);


        this.add(across, BorderLayout.NORTH);





    }



}

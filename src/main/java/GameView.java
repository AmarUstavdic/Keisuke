import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    private GameBoard gameBoard;
    private GameDataContainer gameDataContainer;
    private GameBtnContainer gameBtnContainer;


    public GameView() {
        this.setPreferredSize(KeisukeConstants.GAME_VIEW_DIMENSION);
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setVgap(10);
        borderLayout.setHgap(10);
        this.setLayout(borderLayout);

        this.setBackground(KeisukeConstants.BACKGROUND_COLOR);
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // adding some padding


        gameBoard = new GameBoard();
        this.add(gameBoard, BorderLayout.CENTER);

        gameDataContainer = new GameDataContainer();
        this.add(gameDataContainer, BorderLayout.SOUTH);

        gameBtnContainer = new GameBtnContainer();
        this.add(gameBtnContainer, BorderLayout.EAST);



    }
}

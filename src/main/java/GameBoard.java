import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameBoard extends JPanel {

    private JPanel[][] tiles;
    private int[][] data;


    public GameBoard() {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                generateData();
                return null;
            }

            @Override
            protected void done() {
                createTiles();
            }
        };
        worker.execute();

        this.setPreferredSize(KeisukeConstants.GAME_BOARD_DIMENSION);


        GridLayout gridLayout = new GridLayout();
        gridLayout.setColumns(10);
        gridLayout.setRows(10);
        this.setLayout(gridLayout);



    }



    private void generateData() {
        data = new int[10][10];

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                data[i][j] = random.nextInt(9);
            }
        }

        for (int i = 0; i < 10*10*0.3; i++) {
            data[random.nextInt(10)][random.nextInt(10)] = -1;
        }
    }


    private void createTiles() {
        tiles = new JPanel[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tiles[i][j] = new JPanel();
                tiles[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                if (data[i][j] == -1) {
                    tiles[i][j].setBackground(Color.BLACK);
                } else {
                    tiles[i][j].setBackground(KeisukeConstants.MAIN_BTN_COLOR);
                }
                this.add(tiles[i][j]);
            }
        }
        this.revalidate();
        this.repaint();
    }



}

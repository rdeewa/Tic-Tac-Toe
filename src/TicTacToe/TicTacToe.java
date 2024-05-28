package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    
    // Define the necessary components and variables
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    // Constructor to initialize the game
    TicTacToe() {
        // Set up the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Set up the textfield
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        // Set up the title panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);
        title_panel.add(textfield, BorderLayout.CENTER);

        // Set up the button panel
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        // Add buttons to the button panel
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        // Add panels to the frame
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        // Determine the first turn
        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which button is clicked and handle the turn
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    // Method to decide the first turn randomly
    public void firstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    // Method to check for win conditions
    public void check() {
    	//Check X win condition
		
    			if(
    					(buttons[0].getText()=="X") &&
    					(buttons[1].getText()=="X") &&
    					(buttons[2].getText()=="X") 
    					) {
    				xWins(0,1,2);
    			}
    			
    			if(
    					(buttons[3].getText()=="X") &&
    					(buttons[4].getText()=="X") &&
    					(buttons[5].getText()=="X") 
    					) {
    				xWins(3,4,5);
    			}
    			
    			if(
    					(buttons[6].getText()=="X") &&
    					(buttons[7].getText()=="X") &&
    					(buttons[8].getText()=="X") 
    					) {
    				xWins(6,7,8);
    			}
    			
    			if(
    					(buttons[0].getText()=="X") &&
    					(buttons[3].getText()=="X") &&
    					(buttons[6].getText()=="X") 
    					) {
    				xWins(0,3,6);
    			}
    			
    			if(
    					(buttons[1].getText()=="X") &&
    					(buttons[4].getText()=="X") &&
    					(buttons[7].getText()=="X") 
    					) {
    				xWins(1,4,7);
    			}
    			
    			if(
    					(buttons[2].getText()=="X") &&
    					(buttons[5].getText()=="X") &&
    					(buttons[8].getText()=="X") 
    					) {
    				xWins(2,5,8);
    			}
    			
    			if(
    					(buttons[0].getText()=="X") &&
    					(buttons[4].getText()=="X") &&
    					(buttons[8].getText()=="X") 
    					) {
    				xWins(0,4,8);
    			}
    			
    			if(
    					(buttons[2].getText()=="X") &&
    					(buttons[4].getText()=="X") &&
    					(buttons[6].getText()=="X") 
    					) {
    				xWins(2,4,6);
    			}
    			
    			//Check O win condition
    			
    			if(
    					(buttons[0].getText()=="O") &&
    					(buttons[1].getText()=="O") &&
    					(buttons[2].getText()=="O") 
    					) {
    				oWins(0,1,2);
    			}
    			
    			if(
    					(buttons[3].getText()=="O") &&
    					(buttons[4].getText()=="O") &&
    					(buttons[5].getText()=="O") 
    					) {
    				oWins(3,4,5);
    			}
    			
    			if(
    					(buttons[6].getText()=="O") &&
    					(buttons[7].getText()=="O") &&
    					(buttons[8].getText()=="O") 
    					) {
    				oWins(6,7,8);
    			}
    			
    			if(
    					(buttons[0].getText()=="O") &&
    					(buttons[3].getText()=="O") &&
    					(buttons[6].getText()=="O") 
    					) {
    				oWins(0,3,6);
    			}
    			
    			if(
    					(buttons[1].getText()=="O") &&
    					(buttons[4].getText()=="O") &&
    					(buttons[7].getText()=="O") 
    					) {
    				oWins(1,4,7);
    			}
    			
    			if(
    					(buttons[2].getText()=="O") &&
    					(buttons[5].getText()=="O") &&
    					(buttons[8].getText()=="O") 
    					) {
    				oWins(2,5,8);
    			}
    			
    			if(
    					(buttons[0].getText()=="O") &&
    					(buttons[4].getText()=="O") &&
    					(buttons[8].getText()=="O") 
    					) {
    				oWins(0,4,8);
    			}
    			
    			if(
    					(buttons[2].getText()=="O") &&
    					(buttons[4].getText()=="O") &&
    					(buttons[6].getText()=="O") 
    					) {
    				oWins(2,4,6);
    			}
    		}

    // Method to handle X win
    public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
		

	}
	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
	}
}




/*public void check() {
    if (checkWin("X")) {
        xWins();
    } else if (checkWin("O")) {
        oWins();
    }
}

public boolean checkWin(String player) {
    return (checkRow(0, 1, 2, player) || checkRow(3, 4, 5, player) ||
            checkRow(6, 7, 8, player) || checkRow(0, 3, 6, player) ||
            checkRow(1, 4, 7, player) || checkRow(2, 5, 8, player) ||
            checkRow(0, 4, 8, player) || checkRow(2, 4, 6, player));
}

public boolean checkRow(int a, int b, int c, String player) {
    if (buttons[a].getText().equals(player) &&
        buttons[b].getText().equals(player) &&
        buttons[c].getText().equals(player)) {
        highlightWinningButtons(a, b, c);
        return true;
    }
    return false;
}

public void highlightWinningButtons(int a, int b, int c) {
    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);
}

public void xWins() {
    disableButtons();
    textField.setText("X wins");
}

public void oWins() {
    disableButtons();
    textField.setText("O wins");
}

public void disableButtons() {
    for (int i = 0; i < 9; i++) {
        buttons[i].setEnabled(false);
    }
}
}*/
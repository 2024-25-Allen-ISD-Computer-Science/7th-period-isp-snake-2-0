import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextArea;
import javax.swing.JSlider;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnPlayButton;
	private JLabel lblTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					frame.setSize(2400, 1500);
					frame.setMinimumSize(new Dimension(1100, 1000));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainFrame() {
		setTitle("Snake 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		btnPlayButton = new JButton("Play!");
		btnPlayButton.setFont(new Font("Calibri", Font.PLAIN, 50));
		btnPlayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
                    // The way I did the file paths here only works for my computer, but it works. Have to find a way to work for all computers later on.
					String command[] = {"python", "..\\snake\\snakeGame\\py.py"};  

                    ProcessBuilder processBuilder = new ProcessBuilder(command);
                    processBuilder.redirectErrorStream(true);  

                    Process process = processBuilder.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) 
					{
                        System.out.println(line);  
                    }

                    int exitCode = process.waitFor();
					System.out.println("Exit Code: " + exitCode);
                } catch (Exception ex) 
				{
                    ex.printStackTrace();
                }
			} 
		}); 
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(20,0,0,0);
		gbc.ipady = 40; 
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		contentPane.add(btnPlayButton, gbc);
		
		
		JButton btnTheme = new JButton("Change Theme");
		btnTheme.setFont(new Font("Calibri", Font.PLAIN, 50));
		gbc.gridx = 1;
		gbc.gridy = 1;
		contentPane.add(btnTheme, gbc);
		btnTheme.setVisible(false);
		
		lblTitle = new JLabel("Snake 2.0");
		lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitle.setFont(new Font("Calibri", Font.PLAIN, 200));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 255, 255));
		gbc.gridx = 1;
		gbc.gridy = 0;
		contentPane.add(lblTitle, gbc);
		
		JButton btnBack = new JButton("Back <-");
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 50));
		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPane.add(btnBack, gbc);
		btnBack.setVisible(false);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setFont(new Font("Calibri", Font.PLAIN, 50));
		gbc.gridx = 1;
		gbc.gridy = 2;
		contentPane.add(btnSettings, gbc);
		
		JTextArea txtrCredits = new JTextArea();
		txtrCredits.setEditable(false);
		txtrCredits.setFont(new Font("Calibri", Font.PLAIN, 50));
		txtrCredits.setBackground(Color.black);
		txtrCredits.setForeground(Color.white);
		txtrCredits.setText("Made by Alberto Svedvik and Tal Hlebnyak\r\nGUI: Alberto Svedvik\r\nGame Source Code: Tal Hlebnyak");
		gbc.gridx = 1;
		gbc.gridy = 1;
		contentPane.add(txtrCredits, gbc);
		txtrCredits.setVisible(false);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setFont(new Font("Calibri", Font.PLAIN, 50));
		gbc.gridx = 1;
		gbc.gridy = 3;
		contentPane.add(btnCredits, gbc);
		
		JButton btnGuide = new JButton("Guide");
		btnGuide.setFont(new Font("Calibri", Font.PLAIN, 50));
		gbc.gridx = 1;
		gbc.gridy = 4;
		contentPane.add(btnGuide, gbc);
		
		JTextArea txtrGuide = new JTextArea();
		txtrGuide.setEditable(false);
		txtrGuide.setFont(new Font("Calibri", Font.PLAIN, 50));
		txtrGuide.setBackground(Color.black);
		txtrGuide.setForeground(Color.white);
		txtrGuide.setText("Red Fruit: Normal Points, Speed\r\n"
				+ "Black Fruit: Game Over\r\n"
				+ "Yellow Fruit: Triple Points\r\n"
				+ "Cyan Fruit: Speed Boost\r\n"
				+ "Purple Fruit: Teleport to a random place on the board\r\n"
				+ "Red Square: Moving square that ends the game if touched\r\n");
		gbc.gridx = 1;
		gbc.gridy = 2;
		contentPane.add(txtrGuide, gbc);
		txtrGuide.setVisible(false);
		
		JLabel lblVolume = new JLabel("Volume");
		gbc.gridx = 1;
		gbc.gridy = 2;
		lblVolume.setBackground(Color.black);
		lblVolume.setForeground(Color.white);
		lblVolume.setFont(new Font("Calibri", Font.PLAIN, 50));
		contentPane.add(lblVolume, gbc);
		
		JSlider sliderVolume = new JSlider();
		gbc.gridx = 1;
		gbc.gridy = 3;
		contentPane.add(sliderVolume, gbc);
		lblVolume.setVisible(false);
		sliderVolume.setVisible(false);
		
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlayButton.setVisible(true);
				btnSettings.setVisible(true);
				btnCredits.setVisible(true);
				lblTitle.setVisible(true);
				btnBack.setVisible(false);
				txtrCredits.setVisible(false);
				btnTheme.setVisible(false);
				lblVolume.setVisible(false);
				sliderVolume.setVisible(false);
				btnGuide.setVisible(true);
				txtrGuide.setVisible(false);
			}
		});
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlayButton.setVisible(false);
				btnSettings.setVisible(false);
				lblTitle.setVisible(false);
				btnBack.setVisible(true);
				btnCredits.setVisible(false);
				btnTheme.setVisible(true);
				lblVolume.setVisible(true);
				sliderVolume.setVisible(true);
				btnGuide.setVisible(false);
				txtrGuide.setVisible(false);

				}
		});
		btnTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contentPane.getBackground() == Color.black) {
					contentPane.setBackground(Color.white);
					lblTitle.setForeground(Color.black);
					txtrCredits.setBackground(Color.white);
					txtrCredits.setForeground(Color.black);
					txtrGuide.setBackground(Color.white);
					txtrGuide.setForeground(Color.black);
				} else {
					contentPane.setBackground(Color.black);
					lblTitle.setForeground(Color.white);
					txtrCredits.setBackground(Color.black);
					txtrCredits.setForeground(Color.white);
					txtrGuide.setBackground(Color.black);
					txtrGuide.setForeground(Color.white);
				}
			}
		});
		sliderVolume.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                int value = source.getValue();
                System.out.println("Slider value changed: " + value);
            }
		});
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlayButton.setVisible(false);
				btnSettings.setVisible(false);
				lblTitle.setVisible(false);
				btnBack.setVisible(true);
				txtrCredits.setVisible(true);
				btnCredits.setVisible(false);
				lblVolume.setVisible(false);
				btnGuide.setVisible(false);
				txtrGuide.setVisible(false);
			}
		});
		btnGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlayButton.setVisible(false);
				btnSettings.setVisible(false);
				lblTitle.setVisible(false);
				btnBack.setVisible(true);
				txtrCredits.setVisible(false);
				btnCredits.setVisible(false);
				lblVolume.setVisible(false);
				btnGuide.setVisible(false);
				txtrGuide.setVisible(true);
			}
		});
		
	}
}

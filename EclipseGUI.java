package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
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
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnPlayButton = new JButton("Play!");
		btnPlayButton.addActionListener(new ActionListener() {
			/*public void actionPerformed(ActionEvent e) {
				
			} */
		}); 
		btnPlayButton.setBounds(178, 161, 89, 23);
		contentPane.add(btnPlayButton);
		
		JButton btnTheme = new JButton("Change Theme");
		btnTheme.setBounds(165, 55, 116, 30);
		contentPane.add(btnTheme);
		btnTheme.setVisible(false);
		
		lblTitle = new JLabel("Snake 2.0");
		lblTitle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitle.setFont(new Font("Calibri", Font.PLAIN, 50));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(100, 50, 240, 100);
		contentPane.add(lblTitle);
		
		JButton btnBack = new JButton("Back <-");
		
		btnBack.setBounds(10, 11, 90, 30);
		contentPane.add(btnBack);
		btnBack.setVisible(false);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setBounds(178, 191, 89, 23);
		
		contentPane.add(btnSettings);
		
		JTextArea txtrCredits = new JTextArea();
		txtrCredits.setEditable(false);
		txtrCredits.setBackground(Color.black);
		txtrCredits.setForeground(Color.white);
		txtrCredits.setText("Made by Alberto Svedvik and Tal Hlebnyak\r\nGUI: Alberto Svedvik\r\nGame Source Code: Tal Hlebnyak");
		txtrCredits.setBounds(100, 55, 240, 130);
		contentPane.add(txtrCredits);
		txtrCredits.setVisible(false);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setBounds(178, 221, 89, 23);
		contentPane.add(btnCredits);
		
		JLabel lblVolume = new JLabel("Volume");
		lblVolume.setBounds(165, 89, 116, 30);
		lblVolume.setBackground(Color.black);
		lblVolume.setForeground(Color.white);
		contentPane.add(lblVolume);
		
		JSlider sliderVolume = new JSlider();
		sliderVolume.setBounds(125, 130, 200, 26);
		contentPane.add(sliderVolume);
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


				}
		});
		btnTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contentPane.getBackground() == Color.black) {
					contentPane.setBackground(Color.white);
					lblTitle.setForeground(Color.black);
					txtrCredits.setBackground(Color.white);
					txtrCredits.setForeground(Color.black);
				} else {
					contentPane.setBackground(Color.black);
					lblTitle.setForeground(Color.white);
					txtrCredits.setBackground(Color.black);
					txtrCredits.setForeground(Color.white);
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
			}
		});
		
	}
}

package tech.tabpixels.pixelmod.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client {
	public static JFrame frame;
	public static JPanel contentPane;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void create() {
		frame = new JFrame();
		frame.setTitle("PixelMod ["+App.VERSION+"]");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 272, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel titleLabel = new JLabel("PixelMod");
		titleLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		titleLabel.setBounds(10, 11, 116, 21);
		panel.add(titleLabel);
		
		JButton btnInstallAMod = new JButton("Install a mod");
		btnInstallAMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleModInstaller.create();
			}
		});
		btnInstallAMod.setBounds(10, 43, 116, 23);
		panel.add(btnInstallAMod);
		
		frame.setVisible(true);
	}
}

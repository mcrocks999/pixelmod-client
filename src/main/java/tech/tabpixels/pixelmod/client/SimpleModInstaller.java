package tech.tabpixels.pixelmod.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;

public class SimpleModInstaller {
	public static JFrame frame;
	public static JPanel contentPane;
	public static JTextField txtappdataminecraft;
	public static File[] files;
	public static Boolean fileSS = false;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void create() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Simple Mod Installer");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 265, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblSimpleModInstaller = new JLabel("Simple Mod Installer");
		lblSimpleModInstaller.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblSimpleModInstaller.setBounds(10, 11, 229, 35);
		panel.add(lblSimpleModInstaller);
		
		JButton btnChooseAFile = new JButton("Select mods");
		btnChooseAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setMultiSelectionEnabled(true);
				int returnVal = fileChooser.showOpenDialog(fileChooser);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
				     files = fileChooser.getSelectedFiles();
				     fileSS = true;
				}
			}
		});
		btnChooseAFile.setBounds(10, 57, 229, 23);
		panel.add(btnChooseAFile);
		
		JLabel lblMinecraftInstallation = new JLabel("Minecraft installation / instance:");
		lblMinecraftInstallation.setBounds(10, 91, 226, 14);
		panel.add(lblMinecraftInstallation);
		
		txtappdataminecraft = new JTextField();
		txtappdataminecraft.setText(System.getenv("AppData")+"/.minecraft");
		txtappdataminecraft.setBounds(10, 116, 229, 20);
		panel.add(txtappdataminecraft);
		txtappdataminecraft.setColumns(10);
		
		JButton btnNewButton = new JButton("Install");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileSS)
				{
					try {
						for (File file : files)
						{
							Files.copy(file.toPath(), new File(txtappdataminecraft.getText()+"/mods/"+file.getName()).toPath());
						}
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Sorry! An error occured while copying the mod.");
						e1.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please select a mod first!");
				}
			}
		});
		btnNewButton.setBounds(10, 147, 229, 21);
		panel.add(btnNewButton);
		frame.setVisible(true);
	}
}
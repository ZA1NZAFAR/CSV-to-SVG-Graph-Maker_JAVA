import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	private CSVReader csvR;
	private String path, destination, fileName;
	private JPanel contentPane;
	private JTextField txtF;
	private JTextField txtF1;
	private JButton btn, btn1, btn2, btn3;
	private JComboBox<String> comboBox;
	String s1, s2;
	private JTextField txtF2;
	private JLabel Heading;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setForeground(Color.WHITE);
		setType(Type.POPUP);
		setTitle("CSV to Graph Creator");
		setFont(new Font("Bell MT", Font.PLAIN, 12));
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 430);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(null);
		setContentPane(contentPane);

		btn1 = new JButton("Ajouter");
		btn1.setBackground(Color.red);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					txtF1.setText("" + chooser.getSelectedFile());
					btn1.setBackground(Color.GREEN);
				}

				destination = txtF1.getText();

			}
		});

		btn2 = new JButton("CREATE FILE SVG");
		btn2.setBackground(Color.red);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn2.setBackground(Color.GREEN);
				int temp = comboBox.getSelectedIndex();

				try {
					if (temp == 0) {
						csvR = new CSVReader(path);
						csvR.createLineGraph(destination + "\\" + fileName);
					} else if (temp == 1) {
						csvR = new CSVReader(path);
						csvR.createBarGraph(destination + "\\" + fileName);
					}
				} catch (IOException e) {
				}
				System.exit(0);

			}
		});

		btn3 = new JButton("OK");
		btn3.setBackground(Color.red);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtF2.setEditable(false);
				btn3.setBackground(Color.green);
				fileName = txtF2.getText();

			}
		});
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		btn = new JButton("Ajouter");

		btn.setBackground(Color.red);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfcc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int val = jfcc.showOpenDialog(null);
				if (val == JFileChooser.APPROVE_OPTION) {
					File sf = jfcc.getSelectedFile();
					txtF.setText(sf.getAbsolutePath());
					btn.setBackground(Color.GREEN);
				}
				path = txtF.getText();
			}
		});

		Heading = new JLabel("CSV ==> SVG Graph");
		Heading.setForeground(Color.BLACK);
		Heading.setHorizontalAlignment(SwingConstants.CENTER);
		Heading.setLabelFor(this);
		Heading.setFont(new Font("Kristen ITC", Font.PLAIN, 11));
		contentPane.add(Heading);

		txtF = new JTextField("Selectioner le fichier source!");
		txtF.setHorizontalAlignment(SwingConstants.CENTER);
		txtF.setForeground(Color.BLACK);
		txtF.setEditable(false);
		txtF.setColumns(10);
		contentPane.add(txtF);
		contentPane.add(btn);

		txtF1 = new JTextField();
		txtF1.setHorizontalAlignment(SwingConstants.CENTER);
		txtF1.setEditable(false);
		txtF1.setText("Selectioner le le destination!");
		txtF1.setColumns(10);
		contentPane.add(txtF1);
		contentPane.add(btn1);

		txtF2 = new JTextField("Taper le nom du fichier de r\u00E9sultat");
		txtF2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				txtF2.setText("");
			}
		});
		txtF2.setDropMode(DropMode.INSERT);
		txtF2.setBackground(Color.WHITE);
		txtF2.setHorizontalAlignment(SwingConstants.CENTER);
		txtF2.setColumns(10);
		contentPane.add(txtF2);
		contentPane.add(btn3);

		comboBox = new JComboBox<String>();
		this.comboBox.addItem("Line Graph");
		this.comboBox.addItem("Bar Graph");
		contentPane.add(comboBox);
		contentPane.add(btn2);

	}
}

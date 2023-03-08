import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InputData {

	private JFrame frame;
	private JTextField link;
	private JTextField cutoff;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputData window = new InputData();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InputData() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("G:\\Assignment_3\\loading.jpg")));
		frame.setBounds(100, 100, 704, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel error = new JLabel("");
		error.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		error.setForeground(Color.RED);
		link = new JTextField();
		link.setColumns(10);

		cutoff = new JTextField();
		cutoff.setColumns(10);

		JButton btnNewButton = new JButton("Validate");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				OptimimThreads.link = link.getText();

				if (tryParse(cutoff.getText()) == null) {
					error.setText("Cutoff Thershold must be a number");
				} else {
					error.setText("waiting...");

					OptimimThreads.cutoff = Integer.parseInt(cutoff.getText());
					OptimimThreads o = new OptimimThreads();
					o.input();

				}
			}
		});

		JLabel lblNewLabel = new JLabel("Link");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));

		JLabel lblNewLabel_1 = new JLabel("Cutoff Thershold");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(23)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(10)
								.addComponent(error, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
								.addGap(111).addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 56,
																Short.MAX_VALUE)
														.addGap(152))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 142,
																Short.MAX_VALUE)
														.addGap(66)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(link, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
												.addComponent(cutoff, GroupLayout.PREFERRED_SIZE, 353,
														GroupLayout.PREFERRED_SIZE))))
				.addGap(106)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(100)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(link, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
						.addComponent(cutoff, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
						.addComponent(error, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
				.addGap(33)));
		frame.getContentPane().setLayout(groupLayout);
	}

	public static Integer tryParse(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
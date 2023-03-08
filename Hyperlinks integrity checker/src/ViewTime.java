import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ViewTime {

	private JFrame frame;
	private JTable table;
	static DefaultTableModel model;
	private JButton back;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTime window = new ViewTime();
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
	public ViewTime() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 858, 594);
		frame.setLocation(600, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("Min time");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));

		JLabel mintime = new JLabel("Min time");
		mintime.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));

		JLabel lblNewLabel_1_1 = new JLabel("Number of threads ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));

		JLabel thread = new JLabel("Min time");
		thread.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));

		JLabel lblNewLabel_1_3 = new JLabel("Invalid Link");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));

		JLabel invalid = new JLabel("Min time");
		JScrollPane scrollPane = new JScrollPane();
		JLabel lblNewLabel_1_3_1 = new JLabel("Valid Link");
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));

		JLabel valid = new JLabel("0");
		valid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));

		JLabel lblNewLabel_1_3_2 = new JLabel("All links found ");
		lblNewLabel_1_3_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));

		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = { "Number of threads ", "Time in ms" };

		Object[] row = new Object[100];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		frame.toFront();

		int i = 0;
		for (i = 0; i < OptimimThreads.timearr.size(); i++) {

			row[0] = i + 1;
			row[1] = OptimimThreads.timearr.get(i).toString() + " ms ";

			model.addRow(row);
		}
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		JLabel allLinks = new JLabel("0");
		mintime.setText(OptimimThreads.timearr.get(i - 2).toString() + " ms");
		thread.setText(Integer.toString(i - 1));
		invalid.setText(Integer.toString((ValidateURL.invalid + 1) / OptimimThreads.timearr.size()));
		valid.setText(Integer.toString((ValidateURL.valid + 1) / OptimimThreads.timearr.size()));
		allLinks.setText(Integer.toString(((ValidateURL.invalid + 1) / OptimimThreads.timearr.size())
				+ ((ValidateURL.valid + 1) / OptimimThreads.timearr.size())));

		scrollPane.setViewportView(table);

		back = new JButton("GoodBye");
		back.setBackground(new Color(219, 112, 147));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				frame.dispose();

			}
		});
		back.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 29));

		invalid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));

		allLinks.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup()
								.addContainerGap().addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 824,
										Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(groupLayout
								.createSequentialGroup().addContainerGap(131, Short.MAX_VALUE).addGroup(groupLayout
										.createParallelGroup(Alignment.TRAILING, false).addGroup(groupLayout
												.createSequentialGroup().addComponent(lblNewLabel_1_1).addGap(151))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 121,
														GroupLayout.PREFERRED_SIZE)
												.addGap(165))
										.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.TRAILING, false).addGroup(groupLayout
														.createSequentialGroup()
														.addComponent(lblNewLabel_1_3_2, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(groupLayout.createSequentialGroup().addGap(10)
														.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addComponent(lblNewLabel_1_3_1,
																		GroupLayout.PREFERRED_SIZE, 121,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lblNewLabel_1_3,
																		GroupLayout.PREFERRED_SIZE, 121,
																		GroupLayout.PREFERRED_SIZE))))
												.addGap(185)))
								.addGap(30)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(allLinks, GroupLayout.PREFERRED_SIZE, 158,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(thread, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(valid, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(invalid, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(mintime, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGap(187))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(283)
								.addComponent(back, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE).addGap(329)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE).addGap(51)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
						.addComponent(mintime, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(thread, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(valid, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(invalid, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_3_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(allLinks, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
				.addGap(42).addComponent(back, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addGap(87)));
		frame.getContentPane().setLayout(groupLayout);
	}
}

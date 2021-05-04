package hust.soict.hedspi.aims;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;

public class giaodien {
	private int i = -1;
	private itemList item = new itemList();
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giaodien window = new giaodien();
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
	public giaodien() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 527, 346);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel CDOrder = new JPanel();
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_5 = new JPanel();
		
		panel_1.setVisible(false);

		JPanel panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel_3.setBounds(280, 299, 516, 312);
		panel_3.setLocation(0, 0);
		
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JTable display = new JTable();
		display = new JTable();
		frame.getContentPane().add(display);
		DefaultTableModel displayModel = (DefaultTableModel) display.getModel();
		Object[] columnsDisplay = { "Title", "id", "type" };
		displayModel.setColumnIdentifiers(columnsDisplay);
		display.setModel(displayModel);
		display.setAutoCreateRowSorter(true);
		JScrollPane pane_2 = new JScrollPane(display);
		pane_2.setForeground(Color.WHITE);
		pane_2.setBackground(Color.WHITE);
		pane_2.setBounds(60, 30, 381, 182);
		panel_3.add(pane_2);

		JButton btnNewButton_13 = new JButton("Delete Item");
		
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(false);
				panel_1.setVisible(true);
				
				int id = Integer.parseInt(textField_3.getText());
				String NewType = textField_4.getText();

				for (int i = 0; i < item.order.get(i).itemsOrdered.size(); i++) {
					for (Media a : item.order.get(i).itemsOrdered) {

						if (NewType.equalsIgnoreCase(a.getType()) && id == a.getId()) {
							item.order.get(i).removeMedia(a);
							break;

						}

					}

				}

			}
		});
		btnNewButton_13.setBounds(60, 229, 113, 21);
		panel_3.add(btnNewButton_13);

		textField_3 = new JTextField();
		textField_3.setBounds(303, 230, 96, 19);
		panel_3.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(303, 259, 96, 19);
		panel_3.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setBounds(248, 233, 45, 13);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("type:");
		lblNewLabel_3.setBounds(248, 262, 45, 13);
		panel_3.add(lblNewLabel_3);

		JButton btnNewButton_8 = new JButton("Return");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(60, 258, 85, 21);
		panel_3.add(btnNewButton_8);

		JLabel lblNewLabel_4 = new JLabel("Cost:");
		lblNewLabel_4.setBounds(248, 285, 45, 13);
		panel_3.add(lblNewLabel_4);
		
		JLabel panel_4 = new JLabel("");
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_4.setBounds(303, 283, 96, 19);
		panel_3.add(panel_4);

		JPanel bookOrder = new JPanel();
		bookOrder.setBounds(304, 157, 516, 302);
		bookOrder.setLocation(0, 0);
		frame.getContentPane().add(bookOrder);
		bookOrder.setLayout(null);
		bookOrder.setVisible(false);
		JTable table = new JTable();
		table = new JTable();
		frame.getContentPane().add(table);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Object[] columns = { "Title", "Category", " authors", "Cost", "id" };
		tableModel.setColumnIdentifiers(columns);
		table.setModel(tableModel);
		table.setAutoCreateRowSorter(true);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(63, 24, 381, 182);
		bookOrder.add(pane);
		pane.setForeground(Color.WHITE);
		pane.setBackground(Color.WHITE);

		JButton btnNewButton = new JButton("View");
		btnNewButton.setBounds(10, 216, 85, 21);
		bookOrder.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("<< return");
		btnNewButton_2.setBounds(10, 247, 85, 21);
		bookOrder.add(btnNewButton_2);

		textField = new JTextField();
		textField.setBounds(410, 216, 96, 19);
		bookOrder.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("BookID:");
		lblNewLabel.setBounds(355, 216, 45, 13);
		bookOrder.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Order");
		btnNewButton_1.setBounds(420, 247, 85, 21);
		bookOrder.add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBounds(183, 344, 516, 302);
		panel.setLocation(0, 0);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);

		JTable table1 = new JTable();
		table1 = new JTable();
		frame.getContentPane().add(table1);
		DefaultTableModel tableModelCD = (DefaultTableModel) table1.getModel();
		Object[] columnscd = { "Title", "Category", "Director", "Artist", "Length", "Cost", "id" };
		tableModelCD.setColumnIdentifiers(columnscd);
		table1.setModel(tableModelCD);
		table1.setAutoCreateRowSorter(true);

		JScrollPane pane_1 = new JScrollPane(table1);
		pane_1.setForeground(Color.WHITE);
		pane_1.setBackground(Color.WHITE);
		pane_1.setBounds(66, 25, 381, 182);
		panel.add(pane_1);

		JButton btnNewButton_4 = new JButton("View");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = tableModelCD.getRowCount();
				// Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
					tableModelCD.removeRow(i);
				}
				for (int i = 0; i < item.CDList.size(); i++) {
					String Title = item.CDList.get(i).getTitle();
					String Category = item.CDList.get(i).getCategory();
					String Director = item.CDList.get(i).getDirector();
					String Artist = item.CDList.get(i).getArtist();
					float cos = item.CDList.get(i).getCost();
					int length = item.CDList.get(i).getLength();
					int id = item.CDList.get(i).getId();
					Object[] row = { Title, Category, Director, Artist, length, cos, id };

					tableModelCD.insertRow(i, row);

				}
			}
		});
		btnNewButton_4.setBounds(10, 217, 85, 21);
		panel.add(btnNewButton_4);

		JButton btnNewButton_2_1 = new JButton("<< return");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel.setVisible(false);
			}
		});
		btnNewButton_2_1.setBounds(10, 248, 85, 21);
		panel.add(btnNewButton_2_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(410, 217, 96, 19);
		panel.add(textField_1);

		JLabel lblNewLabel_1 = new JLabel("cdID:");
		lblNewLabel_1.setBounds(355, 221, 45, 13);
		panel.add(lblNewLabel_1);

		JButton btnNewButton_1_1 = new JButton("Order");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int idCD = Integer.parseInt(textField_1.getText());

				CompactDisc cd = new CompactDisc();
				if (item.checkIdBook(idCD)) {
					item.order.get(i).addMedia(item.getCD(idCD));

				}
			}
		});
		btnNewButton_1_1.setBounds(420, 248, 85, 21);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_14 = new JButton("Add Track");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_5.setVisible(true);
				
			}
		});
		btnNewButton_14.setBounds(105, 217, 85, 21);
		panel.add(btnNewButton_14);

		JPanel DVDOrder = new JPanel();
		DVDOrder.setVisible(false);
		DVDOrder.setBounds(891, 10, 516, 302);
		DVDOrder.setLocation(0, 0);
		frame.getContentPane().add(DVDOrder);
		DVDOrder.setLayout(null);
		JTable table2 = new JTable();
		table2 = new JTable();
		frame.getContentPane().add(table2);
		DefaultTableModel tableModeldvd = (DefaultTableModel) table2.getModel();
		Object[] columnsdvd = { "Title", "Category", "Director", "Length", "Cost", "id" };
		tableModeldvd.setColumnIdentifiers(columnsdvd);
		table2.setModel(tableModeldvd);
		table2.setAutoCreateRowSorter(true);
		JScrollPane pane_1_1 = new JScrollPane(table2);
		pane_1_1.setBounds(63, 27, 381, 182);
		pane_1_1.setForeground(Color.WHITE);
		pane_1_1.setBackground(Color.WHITE);
		DVDOrder.add(pane_1_1);

		JButton btnNewButton_4_1 = new JButton("View");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = tableModeldvd .getRowCount();
				// Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
					tableModeldvd .removeRow(i);
				}
				for (int i = 0; i < item.DVDList.size(); i++) {
					String Title = item.DVDList.get(i).getTitle();
					String Category = item.DVDList.get(i).getCategory();
					String Director = item.DVDList.get(i).getDirector();
					float cos = item.DVDList.get(i).getCost();
					int length = item.DVDList.get(i).getLength();
					int id = item.DVDList.get(i).getId();
					Object[] row = { Title, Category, Director, length, cos, id };

					tableModeldvd.insertRow(i, row);

				}
			}
		});
		btnNewButton_4_1.setBounds(10, 219, 85, 21);
		DVDOrder.add(btnNewButton_4_1);

		JButton btnNewButton_2_1_1 = new JButton("<< return");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				DVDOrder.setVisible(false);
			}
		});
		btnNewButton_2_1_1.setBounds(10, 250, 85, 21);
		DVDOrder.add(btnNewButton_2_1_1);

		textField_2 = new JTextField();
		textField_2.setBounds(410, 219, 96, 19);
		textField_2.setColumns(10);
		DVDOrder.add(textField_2);

		JLabel lblNewLabel_1_1 = new JLabel("dvdID:");
		lblNewLabel_1_1.setBounds(343, 223, 45, 13);
		DVDOrder.add(lblNewLabel_1_1);

		JButton btnNewButton_1_1_1 = new JButton("Order");
		btnNewButton_1_1_1.setBounds(420, 248, 85, 21);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int idDVD = Integer.parseInt(textField_2.getText());

				if (item.checkIdDVD(idDVD)) {
					item.order.get(i).addMedia(item.getDVD(idDVD));

				}
			}
		});
		DVDOrder.add(btnNewButton_1_1_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int idBook = Integer.parseInt(textField.getText());

				if (item.checkIdBook(idBook)) {
					item.order.get(i).addMedia(item.getBook(idBook));

				}

			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				bookOrder.setVisible(false);

			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = tableModel.getRowCount();
				// Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
					tableModel.removeRow(i);
				}
				for (int i = 0; i < item.bookList.size(); i++) {
					String Title = item.bookList.get(i).getTitle();
					String Category = item.bookList.get(i).getCategory();
					List<String> Authors = item.bookList.get(i).getAuthors();
					float cos = item.bookList.get(i).getCost();
					int id = item.bookList.get(i).getId();
					Object[] row = { Title, Category, Authors, cos, id };

					tableModel.insertRow(i, row);

				}

			}
		});

		JPanel Type = new JPanel();
		Type.setBounds(350, 0, 411, 160);
		Type.setLocation(0, 0);
		Type.setVisible(false);
		frame.getContentPane().add(Type);
		Type.setLayout(null);

		JButton btnNewButton_3 = new JButton("Book");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookOrder.setVisible(true);
				Type.setVisible(false);

			}
		});
		btnNewButton_3.setBounds(206, 25, 85, 21);
		Type.add(btnNewButton_3);

		JButton btnNewButton_5 = new JButton("CD");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				Type.setVisible(false);
			}
		});
		btnNewButton_5.setBounds(206, 71, 85, 21);
		Type.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("DVD");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DVDOrder.setVisible(true);
				Type.setVisible(false);
			}
		});
		btnNewButton_6.setBounds(206, 117, 85, 21);
		Type.add(btnNewButton_6);

		panel_1.setBounds(304, 335, 521, 197);
		panel_1.setLocation(0, 0);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_7 = new JButton("Add Item");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				Type.setVisible(true);

			}
		});
		btnNewButton_7.setBounds(206, 25, 85, 21);
		panel_1.add(btnNewButton_7);

		JButton btnNewButton_9 = new JButton("Display");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_3.setVisible(true);
				int rowCount = displayModel.getRowCount();
				// Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
					displayModel.removeRow(i);
				}
				panel_4.setText(String.valueOf(item.order.get(i).totalCost()));
				for (int i = 0; i < item.order.get(i).itemsOrdered.size(); i++) {
					for (Media a : item.order.get(i).itemsOrdered) {

						String Title = a.getTitle();
						int id = a.getId();
						String Type = a.getType();
						Object[] orderItem = { Title, id, Type };
						displayModel.addRow(orderItem);

					}

				}
				

			}
		});
		btnNewButton_9.setBounds(206, 71, 85, 21);
		panel_1.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("Return");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnNewButton_10.setBounds(206, 115, 85, 21);
		panel_1.add(btnNewButton_10);

		panel_2.setBounds(304, 357, 516, 191);
		panel_2.setLocation(0, 0);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton_11 = new JButton("Order");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				System.out.println(i);
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				if(i==5) {
					System.exit(0);

				}
			}
		});
		btnNewButton_11.setBounds(206, 25, 85, 21);
		panel_2.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("Exit");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		btnNewButton_12.setBounds(206, 71, 85, 21);
		panel_2.add(btnNewButton_12);
		
		
		panel_5.setVisible(false);
		panel_5.setBounds(709, 344, 511, 302);
		panel_5.setLocation(0, 0);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		JTable table4 = new JTable();
		table4 = new JTable();
		frame.getContentPane().add(table4);
		DefaultTableModel trackModel = (DefaultTableModel) table4.getModel();
		Object[] columnsTrack = { "Title","Length", "id" };
		trackModel.setColumnIdentifiers(columnsTrack);
		table4.setModel(trackModel);
		table4.setAutoCreateRowSorter(true);
		JScrollPane pane_3 = new JScrollPane(table4);
		pane_3.setForeground(Color.WHITE);
		pane_3.setBackground(Color.WHITE);
		pane_3.setBounds(66, 25, 381, 182);
		panel_5.add(pane_3);
		
		JButton btnNewButton_15 = new JButton("View");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = trackModel.getRowCount();
				// Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
					trackModel.removeRow(i);
				}
				for (int i = 0; i < item.TrackList.size(); i++) {
					String Title = item.TrackList.get(i).getTitle();
					float length = item.TrackList.get(i).getLength();
					int id = item.TrackList.get(i).getId();
					Object[] row = { Title, length, id };

					trackModel.insertRow(i, row);

				}
			}
		});
		btnNewButton_15.setBounds(10, 218, 85, 21);
		panel_5.add(btnNewButton_15);
		
		JLabel lblNewLabel_5 = new JLabel("TrackID:");
		lblNewLabel_5.setBounds(336, 227, 59, 13);
		panel_5.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(405, 224, 96, 19);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(405, 253, 96, 19);
		panel_5.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_16 = new JButton("Add");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idTrack = Integer.parseInt(textField_5.getText());
				int idCD = Integer.parseInt(textField_5.getText());
				item.getCD(idCD).addTrack(item.getTrackInList(idTrack));

			}
		});
		btnNewButton_16.setBounds(105, 217, 85, 21);
		panel_5.add(btnNewButton_16);
		
		JButton btnNewButton_2_2 = new JButton("<< return");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_5.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnNewButton_2_2.setBounds(10, 253, 85, 21);
		panel_5.add(btnNewButton_2_2);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("cdID:");
		lblNewLabel_6.setBounds(336, 257, 45, 13);
		panel_5.add(lblNewLabel_6);

	}
}

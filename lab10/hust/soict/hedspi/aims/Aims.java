package hust.soict.hedspi.aims;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class Aims {
	private int orderid = -1;
	private itemList item = new itemList();
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField IDItem;
	private JTextField TypeItem;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aims window = new Aims();
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
	public Aims() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 524, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel CDOrder = new JPanel();
		JPanel Menu = new JPanel();
		JPanel Main = new JPanel();
		JPanel Track = new JPanel();

		Menu.setVisible(false);

		JPanel viewOrderedItem = new JPanel();
		viewOrderedItem.setVisible(false);
		viewOrderedItem.setBounds(0, 0, 516, 312);
		// viewOrderedItem.setLocation(0, 0);

		frame.getContentPane().add(viewOrderedItem);
		viewOrderedItem.setLayout(null);

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
		pane_2.setBounds(60, 37, 381, 182);
		viewOrderedItem.add(pane_2);

		JButton DeleteItem = new JButton("Delete Item");

		DeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int delItem= 0;
					if (!IDItem.getText().isEmpty() || !TypeItem.getText().isEmpty()) {
						int id = Integer.parseInt(IDItem.getText());
						String NewType = TypeItem.getText();

						for (int i = 0; i < item.order.get(orderid).itemsOrdered.size(); i++) {
							for (Media a : item.order.get(orderid).itemsOrdered) {

								if (NewType.equalsIgnoreCase(a.getType()) && id == a.getId()) {
									item.order.get(orderid).removeMedia(a);
									 delItem++;
									break;

								}

							}
							if( delItem==0) {
								JOptionPane.showMessageDialog(null, "None of the items you ordered satisfy the condition", "Error",
										JOptionPane.ERROR_MESSAGE);
								
							}

						}
						viewOrderedItem.setVisible(false);
						Menu.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "You havent enter Item ID/ Type", "Error",
								JOptionPane.ERROR_MESSAGE);
						
					}
					

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid character", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		DeleteItem.setBounds(10, 229, 113, 21);
		viewOrderedItem.add(DeleteItem);

		IDItem = new JTextField();
		IDItem.setBounds(410, 222, 96, 19);
		viewOrderedItem.add(IDItem);
		IDItem.setColumns(10);

		TypeItem = new JTextField();
		TypeItem.setBounds(410, 251, 96, 19);
		viewOrderedItem.add(TypeItem);
		TypeItem.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setBounds(355, 233, 45, 13);
		viewOrderedItem.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("type:");
		lblNewLabel_3.setBounds(355, 254, 45, 13);
		viewOrderedItem.add(lblNewLabel_3);

		JButton btnNewButton_8 = new JButton("Return");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewOrderedItem.setVisible(false);
				Menu.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(10, 281, 113, 21);
		viewOrderedItem.add(btnNewButton_8);

		JLabel Cost = new JLabel("Cost:");
		Cost.setBounds(355, 285, 45, 13);
		viewOrderedItem.add(Cost);

		JLabel costValue = new JLabel("");
		costValue.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		costValue.setBounds(410, 283, 96, 19);
		viewOrderedItem.add(costValue);

		JButton getLucky = new JButton("getLucky");
		getLucky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float x = item.order.get(orderid).getALuckyItem(item.order.get(orderid).totalCost()).getCost();
				JOptionPane.showMessageDialog(null,
						item.order.get(orderid).getALuckyItem(item.order.get(orderid).totalCost()).getTitle());
				float count = (float) Math.round((item.order.get(orderid).totalCost() - x) * 100) / 100;
				costValue.setText(String.valueOf(count));

			}
		});
		getLucky.setBounds(10, 254, 113, 21);
		viewOrderedItem.add(getLucky);

		JPanel BOOK = new JPanel();
		BOOK.setBounds(0, 0, 516, 302);
		;
		frame.getContentPane().add(BOOK);
		BOOK.setLayout(null);
		BOOK.setVisible(false);
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
		BOOK.add(pane);
		pane.setForeground(Color.WHITE);
		pane.setBackground(Color.WHITE);

		JButton viewBook = new JButton("View");
		viewBook.setBounds(10, 216, 113, 21);
		BOOK.add(viewBook);

		JButton btnNewButton_2 = new JButton("<< return");
		btnNewButton_2.setBounds(10, 247, 113, 21);
		BOOK.add(btnNewButton_2);

		textField = new JTextField();
		textField.setBounds(410, 216, 96, 19);
		BOOK.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("BookID:");
		lblNewLabel.setBounds(355, 216, 45, 13);
		BOOK.add(lblNewLabel);

		JButton orderBook = new JButton("Order");
		orderBook.setBounds(420, 247, 85, 21);
		BOOK.add(orderBook);

		JPanel CD = new JPanel();
		CD.setBounds(0, 0, 516, 302);
		// CD.setLocation(0, 0);
		frame.getContentPane().add(CD);
		CD.setLayout(null);
		CD.setVisible(false);

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
		CD.add(pane_1);

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
		btnNewButton_4.setBounds(10, 217, 113, 21);
		CD.add(btnNewButton_4);

		JButton btnNewButton_2_1 = new JButton("<< return");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.setVisible(true);
				CD.setVisible(false);
			}
		});
		btnNewButton_2_1.setBounds(10, 248, 113, 21);
		CD.add(btnNewButton_2_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(410, 217, 96, 19);
		CD.add(textField_1);

		JLabel lblNewLabel_1 = new JLabel("cdID:");
		lblNewLabel_1.setBounds(355, 221, 45, 13);
		CD.add(lblNewLabel_1);

		JButton btnNewButton_1_1 = new JButton("Order");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!textField_1.getText().isEmpty()) {
						int idCD = Integer.parseInt(textField_1.getText());

						CompactDisc cd = new CompactDisc();
						if (item.checkIdBook(idCD)) {
							item.order.get(orderid).addMedia(item.getCD(idCD));

						} else {
							JOptionPane.showMessageDialog(null, "this item doesn't have in store", "Error",
									JOptionPane.ERROR_MESSAGE);

						}
					} else {
						JOptionPane.showMessageDialog(null, "You havent enter CD ID", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid character", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton_1_1.setBounds(410, 248, 96, 21);
		CD.add(btnNewButton_1_1);

		JButton btnNewButton_14 = new JButton("Add Track");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CD.setVisible(false);
				Track.setVisible(true);

			}
		});
		btnNewButton_14.setBounds(133, 217, 113, 21);
		CD.add(btnNewButton_14);

		JButton playCD = new JButton("play");
		playCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!textField_1.getText().isEmpty()) {
						int playCD_ID = Integer.parseInt(textField_1.getText());
						item.getCD(Integer.parseInt(textField_1.getText())).play();
					} else {
						JOptionPane.showMessageDialog(null, "You havent enter CD ID", "Error",
								JOptionPane.ERROR_MESSAGE);

					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid character", "Error", JOptionPane.ERROR_MESSAGE);

				}

			}

		});
		playCD.setBounds(133, 248, 113, 21);
		CD.add(playCD);

		JPanel DVD = new JPanel();
		DVD.setVisible(false);
		DVD.setBounds(0, 0, 516, 302);
		// DVD.setLocation(0, 0);
		frame.getContentPane().add(DVD);
		DVD.setLayout(null);
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
		DVD.add(pane_1_1);

		JButton btnNewButton_4_1 = new JButton("View");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = tableModeldvd.getRowCount();
				// Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
					tableModeldvd.removeRow(i);
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
		btnNewButton_4_1.setBounds(10, 219, 113, 21);
		DVD.add(btnNewButton_4_1);

		JButton btnNewButton_2_1_1 = new JButton("<< return");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.setVisible(true);
				DVD.setVisible(false);
			}
		});
		btnNewButton_2_1_1.setBounds(10, 250, 113, 21);
		DVD.add(btnNewButton_2_1_1);

		textField_2 = new JTextField();
		textField_2.setBounds(410, 219, 96, 19);
		textField_2.setColumns(10);
		DVD.add(textField_2);

		JLabel lblNewLabel_1_1 = new JLabel("dvdID:");
		lblNewLabel_1_1.setBounds(343, 223, 45, 13);
		DVD.add(lblNewLabel_1_1);

		JButton btnNewButton_1_1_1 = new JButton("Order");
		btnNewButton_1_1_1.setBounds(410, 250, 96, 21);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!textField_2.getText().isEmpty()) {
						int idDVD = Integer.parseInt(textField_2.getText());
						if (item.checkIdDVD(idDVD)) {
							item.order.get(orderid).addMedia(item.getDVD(idDVD));
						} else {
							JOptionPane.showMessageDialog(null, "this item doesn't have in store", "Error",
									JOptionPane.ERROR_MESSAGE);

						}
					} else {
						JOptionPane.showMessageDialog(null, "You havent enter DVD ID", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid character", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		DVD.add(btnNewButton_1_1_1);

		JButton playDVD = new JButton("play DVD");
		playDVD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!textField_2.getText().isEmpty()) {
						item.getDVD(Integer.parseInt(textField_2.getText())).play();

					} else {
						JOptionPane.showMessageDialog(null, "You havent enter DVD ID", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid character", "Error", JOptionPane.ERROR_MESSAGE);

				}
			}

		});

		playDVD.setBounds(133, 219, 113, 21);
		DVD.add(playDVD);
		orderBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (!textField.getText().isEmpty()) {
						int idBook = Integer.parseInt(textField.getText());

						if (item.checkIdBook(idBook)) {
							item.order.get(orderid).addMedia(item.getBook(idBook));
						} else {
							JOptionPane.showMessageDialog(null, "this item doesn't have in store", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "You havent enter Book ID", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid character", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.setVisible(true);
				BOOK.setVisible(false);

			}
		});
		viewBook.addActionListener(new ActionListener() {
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
				BOOK.setVisible(true);
				Type.setVisible(false);

			}
		});
		btnNewButton_3.setBounds(206, 25, 113, 21);
		Type.add(btnNewButton_3);

		JButton btnNewButton_5 = new JButton("CD");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CD.setVisible(true);
				Type.setVisible(false);
			}
		});
		btnNewButton_5.setBounds(206, 71, 113, 21);
		Type.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("DVD");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DVD.setVisible(true);
				Type.setVisible(false);
			}
		});
		btnNewButton_6.setBounds(206, 117, 113, 21);
		Type.add(btnNewButton_6);

		Menu.setBounds(304, 335, 521, 197);
		Menu.setLocation(0, 0);
		frame.getContentPane().add(Menu);
		Menu.setLayout(null);

		JButton btnNewButton_7 = new JButton("Add Item");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.setVisible(false);
				Type.setVisible(true);

			}
		});
		btnNewButton_7.setBounds(206, 25, 113, 21);
		Menu.add(btnNewButton_7);

		JButton btnNewButton_9 = new JButton("Display");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.setVisible(false);
				viewOrderedItem.setVisible(true);
				int rowCount = displayModel.getRowCount();
				// Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
					displayModel.removeRow(i);
				}
				costValue.setText(String.valueOf(item.order.get(orderid).totalCost()));
				for (int i = 0; i < item.order.get(orderid).itemsOrdered.size(); i++) {
					
						String Title = item.order.get(orderid).itemsOrdered.get(i).getTitle();
						int id = item.order.get(orderid).itemsOrdered.get(i).getId();
						String Type = item.order.get(orderid).itemsOrdered.get(i).getType();
						Object[] orderItem = { Title, id, Type };
						displayModel.addRow(orderItem);
				}

				
				
			}
		});
		btnNewButton_9.setBounds(206, 71, 113, 21);
		Menu.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("Return");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.setVisible(false);
				Main.setVisible(true);
			}
		});
		btnNewButton_10.setBounds(206, 115, 113, 21);
		Menu.add(btnNewButton_10);

		Main.setBounds(304, 357, 516, 191);
		Main.setLocation(0, 0);
		frame.getContentPane().add(Main);
		Main.setLayout(null);

		JButton btnNewButton_11 = new JButton("Order");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderid++;
				
				Menu.setVisible(true);
				Main.setVisible(false);
				if (orderid == 5) {
					System.exit(0);

				}
			}
		});
		btnNewButton_11.setBounds(206, 25, 113, 21);
		Main.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("Exit");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		btnNewButton_12.setBounds(206, 71, 113, 21);
		Main.add(btnNewButton_12);

		Track.setVisible(false);
		Track.setBounds(0, 0, 511, 302);
		// Track.setLocation(0, 0);
		frame.getContentPane().add(Track);
		Track.setLayout(null);
		JTable table4 = new JTable();
		table4 = new JTable();
		frame.getContentPane().add(table4);
		DefaultTableModel trackModel = (DefaultTableModel) table4.getModel();
		Object[] columnsTrack = { "Title", "Length", "id" };
		trackModel.setColumnIdentifiers(columnsTrack);
		table4.setModel(trackModel);
		table4.setAutoCreateRowSorter(true);
		JScrollPane pane_3 = new JScrollPane(table4);
		pane_3.setForeground(Color.WHITE);
		pane_3.setBackground(Color.WHITE);
		pane_3.setBounds(66, 25, 381, 182);
		Track.add(pane_3);

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
		btnNewButton_15.setBounds(10, 218, 113, 21);
		Track.add(btnNewButton_15);

		JLabel lblNewLabel_5 = new JLabel("TrackID:");
		lblNewLabel_5.setBounds(336, 227, 59, 13);
		Track.add(lblNewLabel_5);

		textField_5 = new JTextField();
		textField_5.setBounds(405, 224, 96, 19);
		Track.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(405, 253, 96, 19);
		Track.add(textField_6);
		textField_6.setColumns(10);

		JButton btnNewButton_16 = new JButton("Add");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!textField_5.getText().isEmpty() && !textField_6.getText().isEmpty()) {
						int idTrack = Integer.parseInt(textField_5.getText());
						int idCD = Integer.parseInt(textField_6.getText());
						item.getCD(idCD).addTrack(item.TrackList.get(idTrack - 1));
					} else {
						JOptionPane.showMessageDialog(null, "You havent enter Track/CD ID", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid character", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_16.setBounds(105, 217, 113, 21);
		Track.add(btnNewButton_16);

		JButton btnNewButton_2_2 = new JButton("<< return");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Track.setVisible(false);
				CD.setVisible(true);
			}
		});
		btnNewButton_2_2.setBounds(10, 253, 113, 21);
		Track.add(btnNewButton_2_2);

		JLabel lblNewLabel_6 = new JLabel("cdID:");
		lblNewLabel_6.setBounds(336, 257, 45, 13);
		Track.add(lblNewLabel_6);

		JButton playTrack = new JButton("playTrack");
		playTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!textField_5.getText().isEmpty()) {
						item.getTrackInList(Integer.parseInt(textField_5.getText())).play();
					} else {
						JOptionPane.showMessageDialog(null, "You havent enter Track ID", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid character", "Error", JOptionPane.ERROR_MESSAGE);

				}

			}

		});
		playTrack.setBounds(105, 252, 113, 21);
		Track.add(playTrack);

	}
}

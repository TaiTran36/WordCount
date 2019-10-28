package WordCount;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class Result extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblWordInput;
	private JLabel lblFrequency;
	private JLabel lblShowInput;
	private JLabel lblShowFrequency;
	static int count;
	static String keyword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Result dialog = new Result(count,keyword);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public static void printResult(int count){

	}
	public Result(int count, String keyWord) {
		keyword  = keyWord;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{424, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{71, 71, 71, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblResult = new JLabel("Kết quả bài toán");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblResult = new GridBagConstraints();
		gbc_lblResult.fill = GridBagConstraints.BOTH;
		gbc_lblResult.insets = new Insets(0, 0, 5, 5);
		gbc_lblResult.gridx = 0;
		gbc_lblResult.gridy = 0;
		contentPanel.add(lblResult, gbc_lblResult);

		JLabel lblWordInput = new JLabel("Từ đã nhập");
		lblWordInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblWordInput = new GridBagConstraints();
		gbc_lblWordInput.fill = GridBagConstraints.BOTH;
		gbc_lblWordInput.insets = new Insets(0, 0, 5, 5);
		gbc_lblWordInput.gridx = 0;
		gbc_lblWordInput.gridy = 1;
		gbc_lblWordInput.weightx = 1;
		contentPanel.add(lblWordInput, gbc_lblWordInput);

		JLabel lblShowInput = new JLabel(keyword);

		lblShowInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblShowInput = new GridBagConstraints();
		gbc_lblShowInput.insets = new Insets(0, 0, 5, 0);
		gbc_lblShowInput.gridx = 1;
		gbc_lblShowInput.gridy = 1;
		contentPanel.add(lblShowInput, gbc_lblShowInput);

		JLabel lblFrequency = new JLabel("Số lần xuất hiện trong văn bản");
		lblFrequency.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblFrequency = new GridBagConstraints();
		gbc_lblFrequency.insets = new Insets(0, 0, 0, 5);
		gbc_lblFrequency.fill = GridBagConstraints.BOTH;
		gbc_lblFrequency.gridx = 0;
		gbc_lblFrequency.gridy = 2;
		gbc_lblFrequency.weightx = 1;
		contentPanel.add(lblFrequency, gbc_lblFrequency);

		JLabel lblShowFrequency = new JLabel(String.valueOf(count));
		lblShowFrequency.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblShowFrequency = new GridBagConstraints();
		gbc_lblShowFrequency.gridx = 1;
		gbc_lblShowFrequency.gridy = 2;
		contentPanel.add(lblShowFrequency, gbc_lblShowFrequency);

	}
}

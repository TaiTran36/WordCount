package WordCount;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.GridBagLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.awt.GridBagConstraints;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Insets;

public class View {
    static ArrayList<String> words = new ArrayList<>();
    static LinkedList<WordCount> wl = new LinkedList<WordCount>();
    static int count_result =0;
    static String filePath = "null";
    static Model model;
    static String keyWord="";
    static String keyWordNew ="";
    private JFrame frame;

    private JPanel infoPane;

    private JPanel formPane;
    private static JButton btnChooseText;
    private JLabel lblLabel1;
    private JTextField textField;
    private JButton btnReset;
    private JButton btnSubmit;

    private JPanel exitPane;
    private JButton btnExit;
    private JButton btnCount;
    Result result ;

    private static JTextField textSave;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View window = new View();
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
    public View() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    public static void ChooseButtonMouseClicked(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            words.clear();
            wl.clear();
            File selectedFile = fileChooser.getSelectedFile();
            textSave.setText(fileChooser.getSelectedFile().getName());
            filePath = selectedFile.getPath();
            words = model.readFile(filePath);
            wl = model.wordCount(words);
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        infoPane = new JPanel();
        frame.getContentPane().add(infoPane, BorderLayout.NORTH);

        JButton btnGroupInfo = new JButton("Thông tin nhóm");
        btnGroupInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        infoPane.add(btnGroupInfo);

        formPane = new JPanel();
        formPane.setBorder(BorderFactory.createTitledBorder("Bài toán đếm từ"));
        formPane.setBorder(BorderFactory.createTitledBorder(null, "Bài toán đếm từ", TitledBorder.LEADING,
                TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 16)));
        frame.getContentPane().add(formPane, BorderLayout.WEST);
        GridBagLayout gbl_formPane = new GridBagLayout();
        gbl_formPane.columnWidths = new int[] { 0, 0, 0, 407, 0 };
        gbl_formPane.rowHeights = new int[] { 37, 35, 37, 0 };
        gbl_formPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_formPane.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        formPane.setLayout(gbl_formPane);

        btnChooseText = new JButton("Chọn văn bản");
        GridBagConstraints gbc_btnChooseText = new GridBagConstraints();
        gbc_btnChooseText.insets = new Insets(0, 0, 5, 5);
        gbc_btnChooseText.gridx = 0;
        gbc_btnChooseText.gridy = 0;
        formPane.add(btnChooseText, gbc_btnChooseText);
        btnChooseText.setHorizontalAlignment(SwingConstants.LEFT);
        btnChooseText.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnChooseText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                ChooseButtonMouseClicked(e);

            }
        });

        textSave = new JTextField();
        textSave.setEnabled(false);
        textSave.setEditable(false);
        textSave.setBackground(Color.WHITE);
        textSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GridBagConstraints gbc_textSave = new GridBagConstraints();
        gbc_textSave.insets = new Insets(0, 0, 5, 5);
        gbc_textSave.fill = GridBagConstraints.HORIZONTAL;
        gbc_textSave.gridwidth = 2;
        gbc_textSave.gridx = 1;
        gbc_textSave.gridy = 0;
        formPane.add(textSave, gbc_textSave);
        textSave.setColumns(20);

        lblLabel1 = new JLabel("Nhập từ cần đếm  ");
        GridBagConstraints gbc_lblLabel1 = new GridBagConstraints();
        gbc_lblLabel1.insets = new Insets(0, 0, 5, 5);
        gbc_lblLabel1.gridx = 0;
        gbc_lblLabel1.gridy = 1;
        formPane.add(lblLabel1, gbc_lblLabel1);
        lblLabel1.setFont(new Font("Tahoma", Font.PLAIN, 15));

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.gridwidth = 2;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 1;
        formPane.add(textField, gbc_textField);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setColumns(20);

        btnCount = new JButton("Đếm từ đã nhập");
        GridBagConstraints gbc_btnCount = new GridBagConstraints();
        gbc_btnCount.insets = new Insets(0, 0, 0, 5);
        gbc_btnCount.gridx = 0;
        gbc_btnCount.gridy = 2;
        formPane.add(btnCount, gbc_btnCount);
        btnCount.setEnabled(false);
        btnCount.setFont(new Font("Tahoma", Font.PLAIN, 15));

        btnCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyWordNew = textField.getText();
                result = new Result(count_result,keyWord);
                result.setVisible(true);

            }
        });
        btnReset = new JButton("Reset");
        GridBagConstraints gbc_btnReset = new GridBagConstraints();
        gbc_btnReset.insets = new Insets(0, 0, 0, 5);
        gbc_btnReset.gridx = 1;
        gbc_btnReset.gridy = 2;
        gbc_btnReset.weightx = 2;
        formPane.add(btnReset, gbc_btnReset);
        btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyWord = "";
                count_result =0;
                filePath = "";
                textSave.setText("");
                textField.setText("");
                btnCount.setEnabled(false);
            }
        });
        btnSubmit = new JButton("Submit");
        GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
        gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
        gbc_btnSubmit.gridx = 2;
        gbc_btnSubmit.gridy = 2;
        gbc_btnSubmit.weightx = 2;
        formPane.add(btnSubmit, gbc_btnSubmit);
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    keyWord = textField.getText();
                    if (filePath != "null" && !keyWord.isEmpty()) {
                        btnCount.setEnabled(true);
                        count_result = model.checkKeyWord(keyWord);
                    }
                } catch (NullPointerException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JPanel finalPane = new JPanel();
        frame.getContentPane().add(finalPane, BorderLayout.SOUTH);
        finalPane.setLayout(new BorderLayout(0, 0));

        exitPane = new JPanel();
        finalPane.add(exitPane, BorderLayout.EAST);
        GridBagLayout gbl_exitPane = new GridBagLayout();
        gbl_exitPane.columnWidths = new int[] { 51, 0 };
        gbl_exitPane.rowHeights = new int[] { 23, 0 };
        gbl_exitPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
        gbl_exitPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
        exitPane.setLayout(gbl_exitPane);

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        GridBagConstraints gbc_btnExit = new GridBagConstraints();
        gbc_btnExit.gridx = 0;
        gbc_btnExit.gridy = 0;
        exitPane.add(btnExit, gbc_btnExit);
        btnExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);
            }
        });

    }
}

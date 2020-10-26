import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class Main {

    private JFrame frame;
    private JFileChooser j;
    private File mFile;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
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
    public Main() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(250, 250, 800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Stats Calculator");
        lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 90));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 10, 786, 80);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Stnd Dev:");
        lblNewLabel_1.setFont(new Font("MS Gothic", Font.BOLD, 40));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setBounds(54, 120, 251, 51);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Mean:");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_1.setFont(new Font("MS Gothic", Font.BOLD, 40));
        lblNewLabel_1_1.setBounds(54, 181, 251, 51);
        frame.getContentPane().add(lblNewLabel_1_1);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("MS Gothic", Font.BOLD, 40));
        textArea.setBounds(315, 181, 450, 46);
        frame.getContentPane().add(textArea);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setFont(new Font("MS Gothic", Font.BOLD, 40));
        textArea_1.setBounds(315, 120, 450, 46);
        frame.getContentPane().add(textArea_1);

        JButton btnNewButton = new JButton("START!");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CalC temp = new CalC(mFile);
                try {
                    temp.addToList();
                    textArea.setText(String.valueOf(temp.meanC()));
                    textArea_1.setText(String.valueOf(temp.stndC()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
        btnNewButton.setFont(new Font("MS Gothic", Font.BOLD, 40));
        btnNewButton.setBounds(536, 413, 250, 50);
        frame.getContentPane().add(btnNewButton);

        JButton btnChooseFile = new JButton("Choose File!");
        btnChooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                File F = new File("C:\\Users\\charl\\IdeaProjects\\Assign05\\Txt Files");
                j = new JFileChooser(F, FileSystemView.getFileSystemView());

                int i = j.showOpenDialog(null);

                if(i == JFileChooser.APPROVE_OPTION){

                    mFile = new File(j.getSelectedFile().getAbsolutePath());

                }else{

                    JOptionPane.showMessageDialog(null, "You Have Chosen No File You Pleb");

                }


            }
        });
        btnChooseFile.setFont(new Font("MS Gothic", Font.BOLD, 40));
        btnChooseFile.setBounds(247, 260, 320, 50);
        frame.getContentPane().add(btnChooseFile);
    }
}

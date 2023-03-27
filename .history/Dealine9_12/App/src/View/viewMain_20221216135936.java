package View;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controllers.Controllers;
import Model.User;

public class viewMain extends JFrame {

    public viewMain() {
        initComponent();
        this.setSize(600, 1000);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

    }

    public void initComponent() {
        this.setTitle("App");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        // Lable
        lblname = new JLabel("Name");
        lblname.setBounds(300, 100, 100, 50);
        lbladdress = new JLabel("Address");
        lbladdress.setBounds(300, 200, 100, 50);
        lblmark = new JLabel("Mark");
        lblmark.setBounds(300, 300, 100, 50);
        panel.add(lblname);
        panel.add(lbladdress);
        panel.add(lblmark);

        // TextField
        txtName = new JTextField();
        txtName.setBounds(90, 100, 200, 50);
        txtAddress = new JTextField();
        txtAddress.setBounds(90, 200, 200, 50);
        txtMark = new JTextField();
        txtMark.setBounds(90, 300, 200, 50);

        // Button functionality
        btnAdd = new JButton("Add");
        btnAdd.setBounds(400, 100, 100, 50);
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(400, 200, 100, 50);
        btnRepair = new JButton("Repair");
        btnRepair.setBounds(400, 300, 100, 50);
        btnPre = new JButton("<");
        btnPre.setBounds(250, 400, 50, 50);
        btnNext = new JButton(">");
        btnNext.setBounds(300, 400, 50, 50);
        btnEnd = new JButton(">>");
        btnEnd.setBounds(350, 400, 50, 50);
        btnStart = new JButton("<<");
        btnStart.setBounds(200, 400, 50, 50);

        // add ActionListener
        Controllers addEvt = new Controllers(this);
        btnAdd.addActionListener(addEvt);
        btnDelete.addActionListener(addEvt);
        btnRepair.addActionListener(addEvt);
        btnPre.addActionListener(addEvt);
        btnNext.addActionListener(addEvt);
        btnEnd.addActionListener(addEvt);
        btnStart.addActionListener(addEvt);

        // Add components to panel
        panel.add(btnStart);
        panel.add(btnPre);
        panel.add(btnNext);
        panel.add(btnEnd);
        panel.add(btnAdd);
        panel.add(btnDelete);
        panel.add(btnRepair);
        panel.add(txtName);
        panel.add(txtAddress);
        panel.add(txtMark);

        // table
        Object[] col = { "Name", "Address", "Mark" };
        DefaultTableModel model = new DefaultTableModel(col, 0);
        table = new JTable(model);
        table.setBounds(200, 450, 200, 200);
        jSC = new JScrollPane(table);
        panel.add(jSC);

        this.add(panel, BorderLayout.CENTER);
        this.pack();

    }

    public User getInfor() {
        currentUser = new User(txtName.getText(), txtAddress.getText(), Double.parseDouble(txtMark.getText()));
        return currentUser;
    }

    public void showUser() {
        txtName.setText(currentUser.getName());
        txtAddress.setText(currentUser.getAddress());
        txtMark.setText(Double.toString(currentUser.getMark()));
    }

    public void setCurrentUser(User user) {
        currentUser.setName(user.getName());
        currentUser.setAddress(user.getAddress());
        currentUser.setMark(user.getMark());
    }

    private User currentUser;
    private JLabel lblname, lbladdress, lblmark;
    private JTextField txtName, txtAddress, txtMark;
    private JButton btnAdd, btnDelete, btnRepair;
    private JButton btnPre, btnNext, btnEnd, btnStart;
    private JTable table;
    private JScrollPane jSC;

}

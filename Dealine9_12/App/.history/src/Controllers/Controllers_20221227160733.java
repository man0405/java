package Controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.awt.event.*;
import Model.User;
import View.viewMain;

public class Controllers implements ActionListener {

    private viewMain v;
    private ConnectDB c;
    private static ArrayList<User> userList = new ArrayList<>();
    private User temp;
    int indexCurrent = -100000;

    public Controllers() {
    }

    public Controllers(viewMain v) {
        this.v = v;
    }

    public void getIndex() {
        temp = v.getInfor();
        for (User o : userList) {
            if (o.getName().equals(temp.getName())) {
                indexCurrent = userList.indexOf(o);
                System.out.println(indexCurrent);
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch (s) {
            case "Add":
                if (v.checkNameField()) {
                    JOptionPane.showMessageDialog(null, "Thiếu rồi kìa");
                } else {
                    userList.add(v.getInfor());
                    System.out.println(userList);
                    v.addTable();
                    c = new ConnectDB(v.getInfor(), 1, 0);
                    getIndex();
                }
                break;
            case "Delete":
                try {
                    getIndex();
                    userList.remove(indexCurrent);
                    if (userList.size() == 0) {
                        v.emptyUser();
                        // userList = new ArrayList();
                    } else {

                        if (indexCurrent > 0) {
                            v.setCurrentUser(userList.get(indexCurrent - 1));
                        } else {
                            v.setCurrentUser(userList.get(indexCurrent));
                        }
                        v.showUser();
                    }
                    v.removeTable(indexCurrent);
                    c = new ConnectDB(v.getInfor(), 2, 0);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Hết rồi sao xóa được nữa");
                }
                break;
            case "Repair":
                getIndex();
                userList.set(indexCurrent, v.getInfor());
                v.showUser();
                v.repairTable(indexCurrent);
                c = new ConnectDB(v.getInfor(), 3, 2);
                // c = new ConnectDB(v.getInfor(), 0, 0);
                System.out.println(userList);
                break;
            case "<":
                getIndex();
                if (indexCurrent == 0) {
                    JOptionPane.showMessageDialog(null, "Het roi");
                } else {
                    if (indexCurrent > 0) {
                        indexCurrent--;
                        v.setCurrentUser(userList.get(indexCurrent));
                        v.showUser();
                    }
                }
                break;
            case ">":
                getIndex();
                if (indexCurrent == userList.size() - 1) {
                    JOptionPane.showMessageDialog(null, "Hết rồi");
                } else {
                    if (indexCurrent < userList.size() - 1) {
                        indexCurrent++;
                        v.setCurrentUser(userList.get(indexCurrent));
                        v.showUser();
                    }
                }
                break;
            case "<<":
                getIndex();
                if (indexCurrent == 0) {
                    JOptionPane.showMessageDialog(null, "Hết rồi");
                } else {
                    v.setCurrentUser(userList.get(0));
                    v.showUser();
                }
                break;
            case ">>":
                getIndex();
                if (indexCurrent == userList.size() - 1) {
                    JOptionPane.showMessageDialog(null, "Hết rồi");
                } else {
                    v.setCurrentUser(userList.get(userList.size() - 1));
                    v.showUser();
                }
                break;
        }
    }
}

package Controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.awt.event.*;
import Model.User;
import View.viewMain;

public class Controllers implements ActionListener {
    private viewMain v;
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
                if (v.getInfor().getName() == "") {
                    JOptionPane.showMessageDialog(null, "Mày đéo có tên à");
                } else {

                    userList.add(v.getInfor());
                    System.out.println(userList);
                    v.addTable();
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
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Hết rồi sao xóa được nữa");
                }
                break;
            case "Repair":
                getIndex();
                userList.set(indexCurrent, v.getInfor());
                v.showUser();
                v.repairTable(indexCurrent);
                System.out.println(userList);

                break;
            case "<":
                getIndex();
                if (indexCurrent > 0) {
                    indexCurrent--;
                    v.setCurrentUser(userList.get(indexCurrent));
                    v.showUser();
                }
                break;
            case ">":
                getIndex();
                if (indexCurrent < userList.size() - 1) {
                    indexCurrent++;
                    v.setCurrentUser(userList.get(indexCurrent));
                    v.showUser();
                }
                break;
            case "<<":
                v.setCurrentUser(userList.get(0));
                v.showUser();
                break;
            case ">>":
                v.setCurrentUser(userList.get(userList.size() - 1));
                v.showUser();
                break;
        }
    }
}

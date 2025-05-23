package javaproject.Service;

import javaproject.DAO.AdminDAO;
import javaproject.DAO.MemDAO;
import javaproject.DTO.AdminDTO;
import javaproject.DTO.MemDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
//import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
//import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class SignInG extends JFrame implements ActionListener {

    JLabel title = new JLabel("회원가입");
    JLabel i_label = new JLabel("id");
    JLabel p_label = new JLabel("pw");
    JLabel n_label = new JLabel("name");
    JLabel g_label = new JLabel("gender");
    JLabel b_label = new JLabel("birth");
    JTextField i_field = new JTextField(15);
    JTextField p_field = new JTextField(15);
    JTextField n_field = new JTextField(15);
    ButtonGroup g_radio = new ButtonGroup();
    JPanel birthPanel;
    JComboBox yearCom;
    JComboBox monthCom;
    JComboBox dayCom;
    JButton submit = new JButton("가입");
    JButton ck = new JButton("중복검사");
    JPanel center = new JPanel();
    boolean idck = false; //중복체크시 true
    JRadioButton m = new JRadioButton("남자");
    JRadioButton f = new JRadioButton("여자");
    JRadioButton ad_button = new JRadioButton("관리자");
    JRadioButton mm_button = new JRadioButton("회원");
    ButtonGroup p_radio = new ButtonGroup();

    public SignInG(JFrame before) {
        this.setSize(400, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null); // 화면 중앙 배치
        this.setTitle("회원가입");
        this.add(center);


        g_radio.add(m);
        g_radio.add(f);
        JPanel radio = new JPanel();
        radio.setLayout(new GridLayout());
        radio.add(m);
        radio.add(f);


        center.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);


        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 1;
        center.add(i_label, c);


        c.gridx = 1;
        c.gridy = 1;
        center.add(i_field, c);

        c.gridx = 2;
        c.gridy = 1;
        center.add(ck, c);

        //c.fill = 0;
        c.gridx = 0;
        c.gridy = 2;
        center.add(p_label, c);

        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        center.add(p_field, c);

        c.gridx = 2;
        c.gridy = 2;
        center.add(ad_button, c); 

        //c.fill = 0;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        center.add(n_label, c);

        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        center.add(n_field, c);

        c.gridx = 2;
        c.gridy = 3;
        center.add(mm_button, c);

        //c.fill = 0;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        center.add(g_label, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        center.add(radio, c);

        //c.fill = 0;
        c.gridx = 0;
        c.gridy = 5;
        center.add(b_label, c);

        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 2;
        birthPanel = makerBirthPanel();
        center.add(birthPanel, c);


        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 3;
        center.add(submit, c);

        submit.addActionListener(this);
        ck.addActionListener(this);

        addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        before.setEnabled(true);
                    }
                }
        );
    }

    private JPanel makerBirthPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] year = new String[46];
        String[] month = new String[12];
        String[] day = new String[31];
        for (int i = 0; i < year.length; i++) {
            year[i] = String.valueOf(i + 1980);
        }
        for (int i = 0; i < month.length; i++) {
            month[i] = String.valueOf(i + 1);
        }
        for (int i = 0; i < day.length; i++) {
            day[i] = String.valueOf(i + 1);
        }
        yearCom = new JComboBox(year);
        yearCom.setBackground(Color.WHITE);
        monthCom = new JComboBox(month);
        monthCom.setBackground(Color.WHITE);
        dayCom = new JComboBox(day);
        dayCom.setBackground(Color.WHITE);
        panel.add(yearCom);
        panel.add(new JLabel("년"));
        panel.add(monthCom);
        panel.add(new JLabel("월"));
        panel.add(dayCom);
        panel.add(new JLabel("일"));
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MemDAO memDAO = new MemDAO();
        AdminDAO adminDAO = new AdminDAO();
        if (e.getSource() == ck) {
            String id = i_field.getText();
            if (ad_button.isSelected()) {
                if (adminDAO.idDuplicate(id)) {
                    idck = true;
                    JOptionPane.showMessageDialog(ck, "중복검사완료");
                } else {
                    JOptionPane.showMessageDialog(ck, "아이디중복");
                }
            } else if (mm_button.isSelected()) {
                if (memDAO.idDuplicate(id)) {
                    idck = true;
                    JOptionPane.showMessageDialog(ck, "중복검사완료");
                } else {
                    JOptionPane.showMessageDialog(ck, "아이디중복");
                }
            }
        }
        if (e.getSource() == submit) {
            if (idck) {
                signInDB();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "중복체크필수");
            }
        }
    }

    private void signInDB() {
        if (ad_button.isSelected()) {
            String adNum = JOptionPane.showInputDialog(null, "관리자비밀번호");
            AdminDTO adminDTO = new AdminDTO();
            if (adNum.equals("1111")) {
                adminDTO.setAPosition("a");
            } else if (adNum.equals("2222")) {
                adminDTO.setAPosition("b");
            } else if (adNum.equals("3333")) {
                adminDTO.setAPosition("c");
            } else {
                JOptionPane.showMessageDialog(null, "비밀번호 오류");
                dispose();
            }
            adminDTO.setAId(i_field.getText());
            adminDTO.setAPass(p_field.getText());
            adminDTO.setAName(n_field.getText());
            adminDTO.setAGender(m.isSelected() ? 1 : 0);
            String aBirth = yearCom.getSelectedItem().toString() + "-"
                    + monthCom.getSelectedItem().toString() + "-" + dayCom.getSelectedItem().toString();
            adminDTO.setBirth(aBirth);
            AdminDAO adminDAO = new AdminDAO();
            adminDAO.insert(adminDTO);
        } else if (mm_button.isSelected()) {
            MemDTO memDTO = new MemDTO();
            memDTO.setMId(i_field.getText());
            memDTO.setMPass(p_field.getText());
            memDTO.setMName(n_field.getText());
            memDTO.setMGender(m.isSelected() ? 1 : 0);
            String mBirth = yearCom.getSelectedItem().toString() + "-"
                    + monthCom.getSelectedItem().toString() + "-" + dayCom.getSelectedItem().toString();
            memDTO.setBirth(mBirth);
            System.out.println(memDTO.getMBirth().toString());
            MemDAO memDAO = new MemDAO();
            memDAO.insert(memDTO);
        }
    }
}

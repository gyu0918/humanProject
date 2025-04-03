package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GuiMain extends JFrame implements ActionListener {
    private JLabel j1 = new JLabel("휴먼 word system");
    private JButton btn1 = new JButton("Save");
    private DefaultListModel model = new DefaultListModel();
    private JList l1 = new JList(model);
    //입력할수 있는 부분
    private JTextField jt = new JTextField();

    private JPanel jp1 = new JPanel();
    //플로우 레이아웃
    private JTextField idF = new JTextField(10);
    private JTextField nameF = new JTextField(10);
    private JTextField addrF = new JTextField(10);

    public GuiMain() {
        this.setBounds(100, 100, 300, 500);
        this.setTitle("환영합니다");
        this.add("North", j1);
        this.add("East", btn1);
        this.add("Center", l1);

        //입력할수 있는 창 생성
        this.add("South", jt);
        btn1.setBackground(Color.yellow);

        //

        jp1.setLayout(new GridLayout(3,2));
        jp1.add(idF);
        jp1.add(nameF);
        jp1.add(addrF);



        //종료조건들
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        //save버튼 눌렀을떄 행동 위한 것
        btn1.addActionListener(this); //밑에 있는 actionPerformed메서드로 간다.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == btn1) {
             String id = idF.getText();
             String name = nameF.getText();
             String addr = addrF.getText();
             String msg = id + "/" + "name" + "/" + addr;
             model.addElement(msg);
             //저장누르고 입력부분 초기화 시키는
             idF.setText("");
             nameF.setText("");
             addrF.setText("");
         }
    }
}

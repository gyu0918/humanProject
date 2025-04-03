package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test extends JPanel implements ActionListener {

    private int ballX = 50, ballY = 50, ballDiameter = 30;
    private int ballSpeedX = 2, ballSpeedY = 2;
    private Timer timer;

    public test() {
        // 타이머 설정: 10 밀리초마다 액션을 호출 (게임 루프)
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 배경 그리기
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // 공 그리기
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 공의 위치 업데이트
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // 공이 벽에 부딪혔을 때 반사
        if (ballX <= 0 || ballX + ballDiameter >= getWidth()) {
            ballSpeedX = -ballSpeedX;  // X 방향 반사
        }
        if (ballY <= 0 || ballY + ballDiameter >= getHeight()) {
            ballSpeedY = -ballSpeedY;  // Y 방향 반사
        }

        // 화면 갱신
        repaint();
    }

    public static void main(String[] args) {
        // JFrame 설정
        JFrame frame = new JFrame("Bouncing Ball Game");
        test gamePanel = new test();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);  // 화면 크기
        frame.add(gamePanel);
        frame.setVisible(true);
    }
}

package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField num1Field;
    private JTextField num2Field;

    public SimpleCalculator() {
        // 프레임 설정
        setTitle("색상 가득한 계산기");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(245, 245, 255)); // 연한 파란색 배경
        setLayout(new BorderLayout(10, 10));

        // 상단 제목 및 이미지 패널
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(100, 149, 237)); // Cornflower Blue
        JLabel titleLabel = new JLabel("내 계산기", JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("나눔고딕", Font.BOLD, 20));

        // 이미지 아이콘 추가 (src/test/calc_icon.png 사용 시도)
        try {
            ImageIcon icon = new ImageIcon("src/test/calc_icon.png");
            Image scaled = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            titleLabel.setIcon(new ImageIcon(scaled));
        } catch (Exception e) {
            // 이미지 로드 실패 시 무시
        }
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // 중앙 입력 패널
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.setOpaque(false);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel lbl1 = new JLabel("숫자 1:");
        lbl1.setFont(new Font("나눔고딕", Font.BOLD, 14));
        num1Field = new JTextField();
        num1Field.setBackground(new Color(255, 250, 205)); // Lemon Chiffon

        JLabel lbl2 = new JLabel("숫자 2:");
        lbl2.setFont(new Font("나눔고딕", Font.BOLD, 14));
        num2Field = new JTextField();
        num2Field.setBackground(new Color(255, 250, 205));

        centerPanel.add(lbl1);
        centerPanel.add(num1Field);
        centerPanel.add(lbl2);
        centerPanel.add(num2Field);
        add(centerPanel, BorderLayout.CENTER);

        // 하단 버튼 패널
        JPanel btnPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        btnPanel.setOpaque(false);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        String[] ops = {"+", "-", "*", "/"};
        Color[] btnColors = {
            new Color(255, 182, 193), // Light Pink
            new Color(173, 216, 230), // Light Blue
            new Color(144, 238, 144), // Light Green
            new Color(255, 218, 185)  // Peach Puff
        };

        for (int i = 0; i < ops.length; i++) {
            JButton btn = new JButton(ops[i]);
            btn.setBackground(btnColors[i]);
            btn.setOpaque(true);
            btn.setBorderPainted(false);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(new CalcListener());
            btnPanel.add(btn);
        }
        add(btnPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class CalcListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double n1 = Double.parseDouble(num1Field.getText());
                double n2 = Double.parseDouble(num2Field.getText());
                double result = 0;
                String op = e.getActionCommand();

                switch (op) {
                    case "+": result = n1 + n2; break;
                    case "-": result = n1 - n2; break;
                    case "*": result = n1 * n2; break;
                    case "/":
                        if (n2 == 0) {
                            JOptionPane.showMessageDialog(SimpleCalculator.this, "0으로 나눌 수 없습니다!", "오류", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        result = n1 / n2;
                        break;
                }
                JOptionPane.showMessageDialog(SimpleCalculator.this, "결과: " + result, "계산 완료", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(SimpleCalculator.this, "올바른 숫자를 입력하세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}

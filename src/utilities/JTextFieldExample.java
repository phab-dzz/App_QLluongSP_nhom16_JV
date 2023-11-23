package utilities;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JTextFieldExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextField Example");
        JTextField textField = new JTextField(20);

        // Thêm DocumentListener vào JTextField
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Xử lý khi có sự thay đổi trong JTextField (khi có ký tự được thêm vào)
                System.out.println("Text changed: " + textField.getText());
                // Thực hiện các thao tác khác tại đây...
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Xử lý khi có sự thay đổi trong JTextField (khi có ký tự bị xóa)
                System.out.println("Text changed: " + textField.getText());
                // Thực hiện các thao tác khác tại đây...
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Xử lý khi có sự thay đổi trong các thuộc tính không thể chỉnh sửa
                // (không sử dụng cho JTextField vì không theo dõi các thuộc tính này)
            }
        });

        frame.add(textField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

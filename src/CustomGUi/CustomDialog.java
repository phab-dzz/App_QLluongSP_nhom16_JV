package CustomGUi;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class CustomDialog {
    public static final int ERROR_DIALOG = 0;
    public static final int SUCCESS_DIALOG = 1;
    public static final int WARNING_DIALOG = 2;

    public JDialog dialog;
    private JLabel label;

    private static final HashMap<Integer, String> iconPaths = new HashMap<>();
    private static final HashMap<Integer, String> dialogTitles = new HashMap<>();
    private static final HashMap<Integer, Color> iconPanelColors = new HashMap<>();
    
    static {
        iconPaths.put(ERROR_DIALOG, "/Icons/IconSanpham.png");
        iconPaths.put(SUCCESS_DIALOG, "/Icons/IconSanpham.png");
        iconPaths.put(WARNING_DIALOG, "/Icons/IconSanpham.png");
        
        dialogTitles.put(ERROR_DIALOG, "Lỗi");
        dialogTitles.put(SUCCESS_DIALOG, "Thành công");
        dialogTitles.put(WARNING_DIALOG, "Cảnh báo");
        
        iconPanelColors.put(ERROR_DIALOG, new Color(254, 102, 102));   // Màu lỗi: RGB(254, 102, 102)
        iconPanelColors.put(SUCCESS_DIALOG, new Color(78, 204, 99));   // Màu thành công: RGB(78, 204, 99)
        iconPanelColors.put(WARNING_DIALOG, new Color(249, 166, 26));  // Màu cảnh báo: RGB(249, 166, 26)
    }

    public CustomDialog(String message, int dialogType) {
        dialog = new JDialog();
        dialog.setSize(400, 200);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());

        JPanel iconPanel = new JPanel(new BorderLayout());
        iconPanel.setBackground(iconPanelColors.get(dialogType)); // Sử dụng màu nền dựa trên loại dialog

        ImageIcon originalIcon = new ImageIcon(CustomDialog.class.getResource(iconPaths.get(dialogType)));
        Image scaledImage = originalIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setHorizontalAlignment(JLabel.CENTER);
        iconPanel.add(iconLabel, BorderLayout.CENTER);

        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setText("<html>" + message + "</html");

        dialog.add(iconPanel, BorderLayout.NORTH);
        dialog.add(label, BorderLayout.CENTER);

        // Sử dụng dialogTitles để đặt tiêu đề cho JDialog
        dialog.setTitle(dialogTitles.get(dialogType));

        JPanel buttonPanel = new JPanel(new GridBagLayout());

        JButton closeButton = new JButton("Đóng");
        closeButton.addActionListener(e -> dialog.dispose());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(closeButton, gbc);

        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
    
    
//    public static void main(String[] args) {
//        new CustomDialog("Đây là thông báo lỗi.", CustomDialog.ERROR_DIALOG);
//        new CustomDialog("Đây là thông báo thành công.", CustomDialog.SUCCESS_DIALOG);
//        new CustomDialog("Đây là thông báo cảnh báo.", CustomDialog.WARNING_DIALOG);
//    }
}

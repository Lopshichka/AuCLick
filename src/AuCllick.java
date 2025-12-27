import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class AuCllick {
    private static TrayIcon trayIcon;
    private static boolean[] IsRunning = { true };
    private static Timer autoclicker;
    private static JButton run;
    private static JTextField ms;
    private static String selectedKey;
    private static final Map<String, Integer> keyMap = new HashMap<>();
    static {
        keyMap.put("F1", NativeKeyEvent.VC_F1);
        keyMap.put("F2", NativeKeyEvent.VC_F2);
        keyMap.put("F3", NativeKeyEvent.VC_F3);
        keyMap.put("F4", NativeKeyEvent.VC_F4);
        keyMap.put("F5", NativeKeyEvent.VC_F5);
        keyMap.put("F6", NativeKeyEvent.VC_F6);
        keyMap.put("F7", NativeKeyEvent.VC_F7);
        keyMap.put("F8", NativeKeyEvent.VC_F8);
        keyMap.put("F9", NativeKeyEvent.VC_F9);
        keyMap.put("F10", NativeKeyEvent.VC_F10);
        keyMap.put("F11", NativeKeyEvent.VC_F11);
        keyMap.put("F12", NativeKeyEvent.VC_F12);
        keyMap.put("1", NativeKeyEvent.VC_1);
        keyMap.put("2", NativeKeyEvent.VC_2);
        keyMap.put("3", NativeKeyEvent.VC_3);
        keyMap.put("4", NativeKeyEvent.VC_4);
        keyMap.put("5", NativeKeyEvent.VC_5);
        keyMap.put("6", NativeKeyEvent.VC_6);
        keyMap.put("7", NativeKeyEvent.VC_7);
        keyMap.put("8", NativeKeyEvent.VC_8);
        keyMap.put("9", NativeKeyEvent.VC_9);
        keyMap.put("0", NativeKeyEvent.VC_0);
        keyMap.put("A", NativeKeyEvent.VC_A);
        keyMap.put("B", NativeKeyEvent.VC_B);
        keyMap.put("C", NativeKeyEvent.VC_C);
        keyMap.put("D", NativeKeyEvent.VC_D);
        keyMap.put("E", NativeKeyEvent.VC_E);
        keyMap.put("F", NativeKeyEvent.VC_F);
        keyMap.put("G", NativeKeyEvent.VC_G);
        keyMap.put("H", NativeKeyEvent.VC_H);
        keyMap.put("I", NativeKeyEvent.VC_I);
        keyMap.put("J", NativeKeyEvent.VC_J);
        keyMap.put("K", NativeKeyEvent.VC_K);
        keyMap.put("L", NativeKeyEvent.VC_L);
        keyMap.put("M", NativeKeyEvent.VC_M);
        keyMap.put("N", NativeKeyEvent.VC_N);
        keyMap.put("O", NativeKeyEvent.VC_O);
        keyMap.put("P", NativeKeyEvent.VC_P);
        keyMap.put("Q", NativeKeyEvent.VC_Q);
        keyMap.put("R", NativeKeyEvent.VC_R);
        keyMap.put("S", NativeKeyEvent.VC_S);
        keyMap.put("T", NativeKeyEvent.VC_T);
        keyMap.put("U", NativeKeyEvent.VC_U);
        keyMap.put("V", NativeKeyEvent.VC_V);
        keyMap.put("W", NativeKeyEvent.VC_W);
        keyMap.put("X", NativeKeyEvent.VC_X);
        keyMap.put("Y", NativeKeyEvent.VC_Y);
        keyMap.put("Z", NativeKeyEvent.VC_Z);
        keyMap.put("SPACE", NativeKeyEvent.VC_SPACE);
        keyMap.put("ENTER", NativeKeyEvent.VC_ENTER);
        keyMap.put("ESC", NativeKeyEvent.VC_ESCAPE);
        keyMap.put("TAB", NativeKeyEvent.VC_TAB);
        keyMap.put("UP", NativeKeyEvent.VC_UP);
        keyMap.put("DOWN", NativeKeyEvent.VC_DOWN);
        keyMap.put("LEFT", NativeKeyEvent.VC_LEFT);
        keyMap.put("RIGHT", NativeKeyEvent.VC_RIGHT);
    }

    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();

        JFrame frame = new JFrame("AuCLick");
        ImageIcon icon = new ImageIcon("AuCLick.png");
        frame.setIconImage(icon.getImage());
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(245, 246, 247));
        GraphicsDevice gd = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
        Rectangle bounds = gd.getDefaultConfiguration().getBounds();
        frame.setSize(400, 300);
        Dimension windowSize = frame.getSize();
        int x = bounds.x + (bounds.width - windowSize.width) / 2;
        int y = bounds.y + (bounds.height - windowSize.height) / 2;
        frame.setLocation(x, y);
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        UIManager.put("control", new Color(30, 30, 30));
        UIManager.put("text", Color.BLACK);
        UIManager.put("nimbusFocus", new Color(240, 240, 240));
        UIManager.put("textForeground", Color.BLACK);
        UIManager.put("textBackground", new Color(240, 240, 240));
        UIManager.put("nimbusBase", new Color(240, 240, 240));

        String[] keys = { "F1", "F2", "F3", "F4", "F5", "F6",
                "F7", "F8", "F9", "F10", "F11", "F12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "A", "B", "C",
                "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z", "SPACE", "ENTER", "ESC", "TAB",
                "UP", "DOWN", "LEFT", "RIGHT", };
        String[] mouse_buttons = { "Left", "Right" };
        JButton link = new JButton("<html><u><p>View On GitHub</p></u></html>");
        run = new JButton("Start");
        JLabel title = new JLabel("AuCLick", JLabel.LEFT);
        JLabel timeout_label = new JLabel("Timeout:");
        ms = new JTextField("1000", 5);
        JLabel msLabel = new JLabel("ms");
        JLabel spaces1 = new JLabel("______________________________-");
        JLabel spaces2 = new JLabel("___________________________");
        JLabel spaces4 = new JLabel("______________________________");
        JLabel spaces3 = new JLabel("______________________________________-");
        JLabel mouse_choose_label = new JLabel("Mouse button:", JLabel.LEFT);
        JLabel hotkey_label = new JLabel("Hotkey:", JLabel.LEFT);
        JComboBox mouse_selected = new JComboBox<>(mouse_buttons);
        JPanel footer = new JPanel(new BorderLayout());
        SpinnerListModel spinnerModel = new SpinnerListModel(keys);
        JSpinner hotkey = new JSpinner(spinnerModel);
        hotkey.setPreferredSize(new Dimension(80, 30));

        String delay = ms.getText();
        autoclicker = new Timer(Integer.parseInt(delay), e -> {
            String currentSelection = (String) mouse_selected.getSelectedItem();
            if ("Left".equals(currentSelection)) {
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            } else {
                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            }
        });
        ((AbstractDocument) ms.getDocument()).setDocumentFilter(
                new DocumentFilter() {
                    @Override
                    public void insertString(FilterBypass fb, int offset,
                            String string, AttributeSet attr)
                            throws BadLocationException {
                        if (string.matches("[0-9]+")) {
                            super.insertString(fb, offset, string, attr);
                        }
                    }

                    @Override
                    public void replace(FilterBypass fb, int offset, int length,
                            String text, AttributeSet attrs)
                            throws BadLocationException {
                        if (text.matches("[0-9]+")) {
                            super.replace(fb, offset, length, text, attrs);
                        }
                    }
                });

        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IsRunning[0] = !IsRunning[0];
                if (IsRunning[0]) {
                    run.setText("Start");
                    autoclicker.setDelay(Integer.parseInt(ms.getText()));
                    autoclicker.stop();
                } else {
                    run.setText("Stop");
                    autoclicker.setDelay(Integer.parseInt(ms.getText()));
                    autoclicker.start();
                }
            }
        });

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.err.println("Error hook register: " + e.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
            @Override
            public void nativeKeyPressed(NativeKeyEvent e) {
                selectedKey = (String) hotkey.getValue();
                Integer selectedKeyCode = keyMap.get(selectedKey);
                if (selectedKeyCode != null && e.getKeyCode() == selectedKeyCode) {
                    toggleAutoClicker();
                }
            }
        });

        // Element styles:
        run.setFont(new Font("SansSerif", Font.PLAIN, 15));
        run.setForeground(new Color(47, 52, 63));
        run.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(240, 240, 240), 2), // Внешняя граница
                BorderFactory.createEmptyBorder(5, 20, 5, 20) // Внутренние отступы (padding)
        ));
        ms.setFont(new Font("DialogInput", Font.PLAIN, 12));
        ms.setForeground(Color.BLACK);
        msLabel.setForeground(new Color(47, 52, 63));
        msLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        spaces1.setForeground(new Color(245, 246, 247));
        spaces2.setForeground(new Color(245, 246, 247));
        spaces3.setForeground(new Color(245, 246, 247));
        spaces4.setForeground(new Color(245, 246, 247));
        mouse_choose_label.setForeground(new Color(47, 52, 63));
        mouse_choose_label.setFont(new Font("SansSerif", Font.PLAIN, 12));
        mouse_selected.setFont(new Font("SansSerif", Font.PLAIN, 13));
        hotkey_label.setForeground(Color.BLACK);
        hotkey_label.setFont(new Font("SansSerif", Font.PLAIN, 12));
        timeout_label.setFont(new Font("SansSerif", Font.PLAIN, 12));
        timeout_label.setForeground(new Color(47, 52, 63));
        link.setMargin(new Insets(0, 0, 0, 0));
        link.setPreferredSize(new Dimension(114, 39));
        link.setBackground(new Color(0, 0, 0, 0));
        link.setForeground(new Color(30, 144, 255));
        title.setForeground(Color.BLACK);
        title.setFont(new Font("SansSerif", Font.PLAIN, 13));
        footer.setBackground(new Color(255, 255, 255));
        footer.setPreferredSize(new Dimension(350, 40));
        title.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 3));
        mouse_selected.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus);
                label.setFont(new Font("SansSerif", Font.PLAIN, 13));
                label.setForeground(new Color(47, 52, 63));
                label.setBackground(new Color(245, 246, 247));
                if (isSelected) {
                    label.setBackground(new Color(230, 230, 230));
                    label.setForeground(new Color(30, 60, 90));
                }
                return label;
            }
        });

        // Add elements:
        frame.add(timeout_label);
        frame.add(ms);
        frame.add(msLabel);
        frame.add(spaces1);
        frame.add(mouse_choose_label);
        link.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://github.com/Lopshichka/AuCLick.git"));
            } catch (URISyntaxException ex) {
                System.getLogger(AuCllick.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (IOException ex) {
                System.getLogger(AuCllick.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });

        frame.add(mouse_selected);
        frame.add(spaces2);
        frame.add(hotkey_label);
        frame.add(hotkey);
        frame.add(spaces4);
        frame.add(run);
        frame.add(spaces3);
        frame.add(footer, BorderLayout.SOUTH);
        footer.add(new JLabel("Version: 1.3", JLabel.CENTER)).setForeground(new Color(47, 52, 63));
        footer.add(link, BorderLayout.EAST);
        footer.add(title, BorderLayout.WEST);
        frame.setSize(380, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    GlobalScreen.unregisterNativeHook();
                } catch (NativeHookException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void toggleAutoClicker() {
        IsRunning[0] = !IsRunning[0];
        if (IsRunning[0]) {
            run.setText("Start");
            autoclicker.setDelay(Integer.parseInt(ms.getText()));
            autoclicker.stop();
        } else {
            run.setText("Stop");
            autoclicker.setDelay(Integer.parseInt(ms.getText()));
            autoclicker.start();
        }
    }
}

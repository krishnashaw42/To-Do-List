import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.font.TextAttribute;
import java.util.Map;

// Task class
class Task {
    String text;
    boolean done;

    Task(String text) {
        this.text = text;
        this.done = false;
    }

    public String toString() {
        return text;
    }
}

// Renderer (checkbox in JList)
class CheckBoxRenderer extends JCheckBox implements ListCellRenderer<Task> {
    public Component getListCellRendererComponent(
            JList<? extends Task> list,
            Task value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        setText(value.text);
        setSelected(value.done);

        if (isSelected) {
            setBackground(new Color(100,150,255));
        } else {
            setBackground(new Color(69,69,69)); // center color
        }
        // TEXT STYLE (strike-through if done)
        Font baseFont = list.getFont();

        if (value.done) {
             Map attributes = baseFont.getAttributes();
            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            setFont(baseFont.deriveFont(attributes));
        } else {
            setFont(baseFont);
        }

        setForeground(Color.WHITE);

        return this;
    }
}

public class To_Do_List {

    public static void main(String[] args) {

        JFrame frame = new JFrame("TO DO LIST");
        frame.setSize(420, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new LineBorder(Color.BLACK, 2));

        // TOP
        JPanel top = new JPanel(new BorderLayout(8, 8));
        top.setBorder(new EmptyBorder(10, 10, 10, 10));
        top.setBackground(new Color(60, 120, 200));

        JTextField input = new JTextField();

        JButton addBtn = new JButton("+");
        addBtn.setBackground(new Color(0, 200, 100));
        addBtn.setForeground(Color.WHITE);

        top.add(input, BorderLayout.CENTER);
        top.add(addBtn, BorderLayout.EAST);

        // LIST MODEL
        DefaultListModel<Task> model = new DefaultListModel<>();
        JList<Task> taskList = new JList<>(model);
        taskList.setCellRenderer(new CheckBoxRenderer());
        taskList.setBackground(new Color(69, 69, 69));
        taskList.setForeground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(taskList);
        scroll.getViewport().setBackground(new Color(69, 69, 69));

        // Bottom 
        JPanel bottom = new JPanel();
        bottom.setBackground(new Color(60, 120, 200));

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(new Color(220, 50, 50));
        deleteBtn.setForeground(Color.WHITE);
        JButton deleteAllBtn = new JButton("Delete All");
        deleteAllBtn.setBackground(new Color(220, 50, 50));
        deleteAllBtn.setForeground(Color.WHITE);

        bottom.add(deleteBtn);
        bottom.add(deleteAllBtn);


        // add task
        addBtn.addActionListener(e -> {
            String text = input.getText().trim();
            if (!text.isEmpty()) {
                model.addElement(new Task(text));
                input.setText("");
            }
        });

        input.addActionListener(e -> addBtn.doClick());

        // toggle check box
        taskList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int index = taskList.locationToIndex(e.getPoint());
                if (index != -1) {
                    Task t = model.getElementAt(index);
                    t.done = !t.done;
                    taskList.repaint();
                }
            }
        });

        // delete task
        deleteBtn.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                model.remove(index);
            }
        });
        //delete all task
        deleteAllBtn.addActionListener(e -> {
             {
                model.clear();
            }
        });

        // add all to panel then panel to frame
        panel.add(top, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}
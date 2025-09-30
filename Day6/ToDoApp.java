import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("To-Do List App");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        JTextField taskInput = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(taskInput);
        centerPanel.add(addButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(deleteButton);

        frame.add(centerPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Colors
        centerPanel.setBackground(Color.LIGHT_GRAY);
        bottomPanel.setBackground(Color.GRAY);
        taskList.setBackground(new Color(230, 240, 255));
        addButton.setBackground(Color.GREEN);
        deleteButton.setBackground(Color.RED);
        addButton.setForeground(Color.WHITE);
        deleteButton.setForeground(Color.WHITE);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = taskList.getSelectedIndex();
                if (index != -1) {
                    listModel.remove(index);
                }
            }
        });

        frame.setVisible(true);
    }
}

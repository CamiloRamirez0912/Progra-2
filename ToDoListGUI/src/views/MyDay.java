package views;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDay extends JPanel {
    private JLabel titleLabel;
    private JLabel dateLabel;
    private JPanel tasksPanel;

    public MyDay() {
        setLayout(new BorderLayout());
        setOpaque(false);

        JPanel topSpace = new JPanel();
        topSpace.setOpaque(false);
        topSpace.setPreferredSize(new Dimension(1, 40));
        add(topSpace, BorderLayout.NORTH);

        JPanel leftSpace = new JPanel();
        leftSpace.setOpaque(false);
        leftSpace.setPreferredSize(new Dimension(28, 1));
        add(leftSpace, BorderLayout.WEST);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);

        titleLabel = new JLabel("Mi día");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 34));
        headerPanel.add(titleLabel, BorderLayout.NORTH);

        dateLabel = new JLabel();
        updateDate();
        headerPanel.add(dateLabel, BorderLayout.CENTER);

        contentPanel.add(headerPanel, BorderLayout.NORTH);

        tasksPanel = new JPanel();
        tasksPanel.setLayout(new BoxLayout(tasksPanel, BoxLayout.Y_AXIS));
        tasksPanel.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(tasksPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        JButton addTaskButton = new JButton("+ Adicionar tarea");
        addTaskButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(addTaskButton, BorderLayout.SOUTH);

        add(contentPanel, BorderLayout.CENTER);

        loadTasks();
    }

    public void updateDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM d");
        dateLabel.setText(sdf.format(new Date()));
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 28));
    }

    private void loadTasks() {
        addTask("Realizar diseño de sistema de información", true, false);
        addTask("Visita amigos", false, true);
    }

    private void addTask(String taskText, boolean isCompleted, boolean isImportant) {
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BorderLayout());
        taskPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        taskPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JCheckBox checkBox = new JCheckBox();
        checkBox.setSelected(isCompleted);
        taskPanel.add(checkBox, BorderLayout.WEST);

        JLabel taskLabel = new JLabel(taskText);
        taskPanel.add(taskLabel, BorderLayout.CENTER);

        JButton starButton = new JButton(isImportant ? "★" : "☆");
        starButton.setPreferredSize(new Dimension(65, 60));
        taskPanel.add(starButton, BorderLayout.EAST);

        tasksPanel.add(taskPanel);
        tasksPanel.add(Box.createVerticalStrut(5));
    }
}
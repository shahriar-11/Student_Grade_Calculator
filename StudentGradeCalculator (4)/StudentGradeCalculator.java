import javax.swing.*;
import java.awt.*;

public class StudentGradeCalculator extends JFrame {
    JLabel nameLabel, groupLabel;
    JLabel[] subjectLabels;
    JTextField nameField;
    JTextField[] subjectFields;
    JButton calculateButton, clearButton;
    JComboBox<String> groupCombo;

    String[] generalSubjects = {"Bangla", "Bangla Second", "English", "English Second", "ICT"};
    String[][] groupSubjects = {
            {"Physics", "Chemistry", "Biology", "Math", "Higher Math"},
            {"Accounting", "Business Studies", "Economics", "Math", "Finance", "Marketing"},
            {"History", "Civics", "Geography", "Economics", "Science"}
    };

    public StudentGradeCalculator() {
        setTitle("🎓 Student Grade Calculator for Y High School");
        setSize(500, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(30, 30, 120, 25);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(160, 30, 200, 25);
        add(nameField);

        groupLabel = new JLabel("Select Group:");
        groupLabel.setBounds(30, 70, 120, 25);
        add(groupLabel);
        groupCombo = new JComboBox<>(new String[]{"Science", "Commerce", "Arts"});
        groupCombo.setBounds(160, 70, 200, 25);
        groupCombo.addActionListener(e -> updateSubjects());
        add(groupCombo);

        int totalSubjects = generalSubjects.length + groupSubjects[0].length;
        subjectLabels = new JLabel[totalSubjects];
        subjectFields = new JTextField[totalSubjects];
        int yPosition = 110;
        for (int i = 0; i < totalSubjects; i++) {
            subjectLabels[i] = new JLabel();
            subjectLabels[i].setBounds(30, yPosition, 180, 25);
            add(subjectLabels[i]);
            subjectFields[i] = new JTextField();
            subjectFields[i].setBounds(220, yPosition, 200, 25);
            add(subjectFields[i]);
            yPosition += 40;
        }
        updateSubjects();

        calculateButton = new JButton("Calculate Grade");
        calculateButton.setBounds(80, yPosition, 160, 30);
        calculateButton.setBackground(Color.BLUE);
        calculateButton.setForeground(Color.WHITE);
        add(calculateButton);
        clearButton = new JButton("Clear");
        clearButton.setBounds(260, yPosition, 100, 30);
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        add(clearButton);
        setLocationRelativeTo(null);
        setVisible(true);

        // Action for Calculate Button
        calculateButton.addActionListener(e -> {
            try {
                double total = 0;
                int count = 0;
                for (JTextField field : subjectFields) {
                    String text = field.getText().trim();
                    if (!text.isEmpty()) {
                        total += Double.parseDouble(text);
                        count++;
                    }
                }
                if (count > 0) {
                    double average = total / count;
                    String grade;
                    if (average >= 80) grade = "A+";
                    else if (average >= 70) grade = "A";
                    else if (average >= 60) grade = "A-";
                    else if (average >= 50) grade = "B";
                    else if (average >= 40) grade = "C";
                    else if (average >= 33) grade = "D";
                    else grade = "F";

                    JOptionPane.showMessageDialog(this,
                            "Student: " + nameField.getText() +
                                    "\nGroup: " + groupCombo.getSelectedItem() +
                                    "\nTotal Marks: " + total +
                                    "\nAverage: " + String.format("%.2f", average) +
                                    "\nGrade: " + grade,
                            "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter marks for all subjects.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for marks.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action for Clear Button
        clearButton.addActionListener(e -> {
            nameField.setText("");
            for (JTextField field : subjectFields) {
                field.setText("");
            }
            groupCombo.setSelectedIndex(0);
            updateSubjects();
        });
    }

    private void updateSubjects() {
        int selectedGroup = groupCombo.getSelectedIndex();
        int index = 0;
        for (String subject : generalSubjects) {
            subjectLabels[index].setText(subject + " Marks:");
            subjectFields[index].setText("");
            index++;
        }

        for (String subject : groupSubjects[selectedGroup]) {
            subjectLabels[index].setText(subject + " Marks:");
            subjectFields[index].setText("");
            index++;
        }
    }

    public static void main(String[] args) {
        new StudentGradeCalculator();
    }
}

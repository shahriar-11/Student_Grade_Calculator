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
        groupCombo.addActionListener(e -> {
            updateSubjects();
        });
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

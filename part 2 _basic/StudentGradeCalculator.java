import javax.swing.*;

public class StudentGradeCalculator extends JFrame {
    JLabel nameLabel;
    JLabel[] subjectLabels = new JLabel[10];
    JTextField nameField;
    JTextField[] subjectFields = new JTextField[10];

    public StudentGradeCalculator() {
        setTitle("🎓 Student Grade Calculator");
        setSize(450, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(30, 30, 120, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(160, 30, 200, 25);
        add(nameField);

        int yPosition = 70;
        for (int i = 0; i < 10; i++) {
            subjectLabels[i] = new JLabel("Subject " + (i + 1) + " Marks:");
            subjectLabels[i].setBounds(30, yPosition, 120, 25);
            add(subjectLabels[i]);

            subjectFields[i] = new JTextField();
            subjectFields[i].setBounds(160, yPosition, 200, 25);
            add(subjectFields[i]);

            yPosition += 40;
        }

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentGradeCalculator();
    }
}



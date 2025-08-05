import javax.swing.*;

public class StudentGradeCalculator extends JFrame {
    JLabel nameLabel, subject1Label, subject2Label, subject3Label;
    JTextField nameField, subject1Field, subject2Field, subject3Field;

    public StudentGradeCalculator() {
        setTitle("🎓 Student Grade Calculator");
        setSize(420, 430);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Labels and input fields
        nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(30, 30, 120, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(160, 30, 200, 25);
        add(nameField);

        subject1Label = new JLabel("Subject 1 Marks:");
        subject1Label.setBounds(30, 70, 120, 25);
        add(subject1Label);

        subject1Field = new JTextField();
        subject1Field.setBounds(160, 70, 200, 25);
        add(subject1Field);

        subject2Label = new JLabel("Subject 2 Marks:");
        subject2Label.setBounds(30, 110, 120, 25);
        add(subject2Label);

        subject2Field = new JTextField();
        subject2Field.setBounds(160, 110, 200, 25);
        add(subject2Field);

        subject3Label = new JLabel("Subject 3 Marks:");
        subject3Label.setBounds(30, 150, 120, 25);
        add(subject3Label);

        subject3Field = new JTextField();
        subject3Field.setBounds(160, 150, 200, 25);
        add(subject3Field);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentGradeCalculator();
    }
}

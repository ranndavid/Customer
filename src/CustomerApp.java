import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerApp extends JFrame {
    private JTextField idField, lastNameField, firstNameField, phoneField;
    private JButton prevButton, nextButton;
    private int currentIndex = 0;

    private Customer[] customers = {
            new Customer(1, "Chenda", "Sovisal", "092888999"),
            new Customer(2, "Kom", "Lina", "092000999"),
            new Customer(3, "Chan", "Seyha", "092777666")
    };

    public CustomerApp() {
        setTitle("Customer");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        getContentPane().setBackground(Color.PINK);


        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(createLabel("ID:"), gbc);

        gbc.gridx = 1;
        idField = createTextField();
        add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(createLabel("Last Name:"), gbc);

        gbc.gridx = 1;
        lastNameField = createTextField();
        add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(createLabel("First Name:"), gbc);

        gbc.gridx = 1;
        firstNameField = createTextField();
        add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(createLabel("Phone:"), gbc);

        gbc.gridx = 1;
        phoneField = createTextField();
        add(phoneField, gbc);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.PINK);
        prevButton = createButton("Previous");
        nextButton = createButton("Next");
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(buttonPanel, gbc);


        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    updateFields();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < customers.length - 1) {
                    currentIndex++;
                    updateFields();
                }
            }
        });


        updateFields();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(15);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        return textField;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(120, 40));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 130, 180));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        return button;
    }

    private void updateFields() {
        Customer customer = customers[currentIndex];
        idField.setText(String.valueOf(customer.getId()));
        lastNameField.setText(customer.getLastName());
        firstNameField.setText(customer.getFirstName());
        phoneField.setText(customer.getPhone());

        prevButton.setEnabled(currentIndex > 0);
        nextButton.setEnabled(currentIndex < customers.length - 1);
    }

    public static void main(String[] args) {
        new CustomerApp();
    }
}

class Customer {
    private int id;
    private String lastName;
    private String firstName;
    private String phone;

    public Customer(int id, String lastName, String firstName, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhone() {
        return phone;
    }
}

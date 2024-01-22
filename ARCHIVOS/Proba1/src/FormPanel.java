import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel OccupationLabel;
    private JLabel addLabel;
    private JTextField nameField;
    private JTextField OccupationField;
    private JButton okButton;

    public FormPanel() {
        setLayout(new GridBagLayout());
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        GridBagConstraints c = new GridBagConstraints();

        addLabel = new JLabel("Add Person");
        nameLabel = new JLabel("Name");
        nameField = new JTextField(10);
        OccupationLabel = new JLabel("Occupation");
        OccupationField = new JTextField();

        Border inBorder = BorderFactory.createTitledBorder(addLabel.getText());
        Border outBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setBorder(BorderFactory.createCompoundBorder(outBorder, inBorder));

        c.weightx = 1;
        c.weighty = 0.1;

        //Primeira Fila
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.LINE_END;
        c.insets = new Insets(0, 0, 0, 5);
        add(nameLabel, c);

        c.gridy=1;
        add(OccupationLabel,c);

        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 0, 0);
        c.anchor = GridBagConstraints.LINE_START;
        add(nameField, c);

        c.gridy=1;
        add(nameLabel);

        c.weighty = 2.0;

        c.gridy = 2;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okButton, c);

        

    }
}
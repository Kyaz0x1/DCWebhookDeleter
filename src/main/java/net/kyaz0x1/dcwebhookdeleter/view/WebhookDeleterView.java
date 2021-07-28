package net.kyaz0x1.dcwebhookdeleter.view;

import net.kyaz0x1.dcwebhookdeleter.events.ButtonDeleteClickEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class WebhookDeleterView extends JFrame {

    private final JLabel lblTitle;
    private final JLabel lblEnterUrl;

    private final JTextField txtUrl;
    private final JButton btnDelete;

    public WebhookDeleterView(){
        super("DCWebhookDeleter v1.0.0");
        setSize(350, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        this.lblTitle = new JLabel("DCWebhookDeleter");
        lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        lblTitle.setBounds(45, 20, 235, 20);

        add(lblTitle);

        this.lblEnterUrl = new JLabel("Insira a url do webhook:");
        lblEnterUrl.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        lblEnterUrl.setBounds(90, 45, 160, 20);

        add(lblEnterUrl);

        this.txtUrl = new JTextField();
        txtUrl.setBounds(50, 70, 235, 20);

        add(txtUrl);

        this.btnDelete = new JButton("Deletar");
        btnDelete.setBounds(115, 95, 100, 25);
        btnDelete.addActionListener(new ButtonDeleteClickEvent(txtUrl));

        add(btnDelete);
    }

}
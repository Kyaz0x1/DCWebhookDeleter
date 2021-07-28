package net.kyaz0x1.dcwebhookdeleter.events;

import net.kyaz0x1.dcwebhookdeleter.api.DiscordAPI;
import net.kyaz0x1.dcwebhookdeleter.api.except.WebhookErrorException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDeleteClickEvent implements ActionListener {

    private final JTextField txtUrl;
    private final DiscordAPI api;

    public ButtonDeleteClickEvent(JTextField txtUrl){
        this.txtUrl = txtUrl;
        this.api = DiscordAPI.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String url = txtUrl.getText();
        if(url.isEmpty()){
            JOptionPane.showMessageDialog(null, "Insira a url do webhook!", "DCWebhookDeleter", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!url.startsWith("https://discord.com/api/webhooks/") && !url.startsWith("https://canary.discord.com/api/webhooks/")){
            JOptionPane.showMessageDialog(null, "A url informada é inválida!", "DCWebhookDeleter", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            api.deleteWebhook(url);
            JOptionPane.showMessageDialog(null, "Webhook deletado com sucesso!");
        }catch(WebhookErrorException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deletar o webhook! Erro: " + ex.getMessage(), "DCWebhookDeleter", JOptionPane.ERROR_MESSAGE);
        }
    }

}
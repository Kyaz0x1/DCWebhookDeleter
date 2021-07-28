package net.kyaz0x1.dcwebhookdeleter;

import net.kyaz0x1.dcwebhookdeleter.view.WebhookDeleterView;

import javax.swing.SwingUtilities;

public class DCWebhookDeleter {

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new WebhookDeleterView().setVisible(true));
    }

}
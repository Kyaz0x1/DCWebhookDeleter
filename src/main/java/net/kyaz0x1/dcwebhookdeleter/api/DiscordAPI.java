package net.kyaz0x1.dcwebhookdeleter.api;

import com.google.gson.Gson;
import net.kyaz0x1.dcwebhookdeleter.api.except.WebhookErrorException;
import net.kyaz0x1.dcwebhookdeleter.api.models.DiscordError;
import net.kyaz0x1.dcwebhookdeleter.api.service.WebService;

public final class DiscordAPI {

    private static DiscordAPI INSTANCE;

    private final WebService webService;
    private final String API_ENDPOINT = "https://discord.com/api/v9";

    private final Gson gson;

    private DiscordAPI(){
        this.webService = WebService.getInstance();
        this.gson = new Gson();
    }

    public boolean deleteWebhook(String url) throws WebhookErrorException {
        final String response = webService.delete(url, null);

        if(response.isEmpty())
            return true;

        final DiscordError error = gson.fromJson(response, DiscordError.class);
        throw new WebhookErrorException(error.getMessage());
    }

    public static DiscordAPI getInstance(){
        if(INSTANCE == null){
            synchronized(DiscordAPI.class){
                if(INSTANCE == null){
                    INSTANCE = new DiscordAPI();
                }
            }
        }
        return INSTANCE;
    }

}
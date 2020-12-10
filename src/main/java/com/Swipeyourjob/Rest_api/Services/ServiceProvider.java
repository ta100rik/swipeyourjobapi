package com.Swipeyourjob.Rest_api.Services;

public class ServiceProvider {
    private static final CardService CARD_SERVICE = new CardService();
    private static final ChatService CHAT_SERVICE = new ChatService();
    public static CardService getCardService(){return CARD_SERVICE;}
    public static ChatService getChatService() { return CHAT_SERVICE;}
}

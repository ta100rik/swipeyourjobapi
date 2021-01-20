package com.Swipeyourjob.Rest_api.Services;

public class ServiceProvider {
    private static final CardService CARD_SERVICE = new CardService();
    private static final ChatService CHAT_SERVICE = new ChatService();
    private static final HostingService HOSTING_SERVICE = new HostingService();
    private static final AuthenticationService AUTHENTICATION_SERVICE = new AuthenticationService();
    private static final CompanyService COMPANY_SERVICE = new CompanyService();
    private static final BuggService BUGG_SERVICE = new BuggService();

    public static CardService getCardService(){return CARD_SERVICE;}
    public static ChatService getChatService() { return CHAT_SERVICE;}
    public static CompanyService getCompanyService() {return COMPANY_SERVICE;}
    public static HostingService getHostingService() {return HOSTING_SERVICE;}
    public static BuggService getBuggService() {return BUGG_SERVICE;}
    public static AuthenticationService getAuthenticationService() {return AUTHENTICATION_SERVICE;}

}

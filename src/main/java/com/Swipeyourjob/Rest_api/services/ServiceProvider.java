package com.Swipeyourjob.Rest_api.services;

public class ServiceProvider {
    private static final CardService CARD_SERVICE = new CardService();
    private static final ChatService CHAT_SERVICE = new ChatService();
    private static final HostingService HOSTING_SERVICE = new HostingService();
    private static final AuthenticationService AUTHENTICATION_SERVICE = new AuthenticationService();
    private static final BuggService BUGG_SERVICE = new BuggService();
    private static final AccountPrivacyService accountPrivacyService = new AccountPrivacyService();
    private static final FirebaseService firebaseService = new FirebaseService();
    private static final CompanyService COMPANY_SERVICE = new CompanyService();
    private static final WebsiteService WEBSITE_SERVICE = new WebsiteService();
    public static CardService getCardService(){return CARD_SERVICE;}

    public static WebsiteService getWebsiteService() {        return WEBSITE_SERVICE;
    }

    public static ChatService getChatService() { return CHAT_SERVICE;}
    public static HostingService getHostingService() {return HOSTING_SERVICE;}
    public static BuggService getBuggService() {return BUGG_SERVICE;}
    public static AuthenticationService getAuthenticationService() {return AUTHENTICATION_SERVICE;}
    public static AccountPrivacyService getAccountPrivacyService() { return accountPrivacyService;}
    public static FirebaseService getFirebaseService() {return firebaseService;}

    public static CompanyService getCompanyService() {return COMPANY_SERVICE;}
}

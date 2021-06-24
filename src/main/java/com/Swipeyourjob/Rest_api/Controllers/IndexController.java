package com.Swipeyourjob.Rest_api.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "<h1>Rest Api Swipeyourjob</h1>" +
                "<ul>" +
                "   <li><a href='/app'>App list</a></li>" +
                "   <ul>" +
                "       <li>updateJobStatus - POST({\"userid\" :  ,\"jobid\":})</li>   " +
                "       <li>addBug - POST({ \"userid\":\"sdsd\", \"cardid\":2})</li>" +
                "       <li>removeData - POST({\"userid\":\"V3NKrdMNiDO6CWZPCfIMEdIhw2s2\",    \"showedjobs\":true,    \"chats\":false ,\"likejobs\":false,\"bookmarks\":false})</li>" +
                "       <li>addBug - POST({\"userid\":\"V3NKrdMNiDO6CWZPCfIMEdIhw2s2\",    \"username\":'henk',    \"description\":'dit is een test' ,\"versionnumber\":'1.0.0'})</li>" +
                "       <li><a href='/app/preloadinfo?userid=888888'>preloadinfo?userid=888888 - GET</a></li> " +
                "       <li><a href='/app/getbookmarks?userid=sdsd&lon=52.0862270277778&lat=5.17661701666667'>getbookmarks?userid=sdsd(optional: lon=52.0862270277778&lat=5.17661701666667) - GET</a></li> " +
                "       <li><a href='/app/cards?userid=sdf&start=15&amount=2&lon=52.0862270277778&lat=5.17661701666667'>cards?userid=sdf&start=15&amount=2 (optional: lon=52.0862270277778&lat=5.17661701666667) - GET</a></li> " +
                "       <li><a href='/app/cards/32242?lat=52.0862270277778&lon=5.17661701666667' >cards/{jobid}(?optional: lat=52.0862270277778&lon=5.17661701666667) - GET</a></li> " +
                "   </ul>" +
                "   <li><a href='/web'>Web</a></li>" +
                "   <ul>" +
                "       <li>login - POST({\n" +
                "    \"email\":\"barteld@swipeyourjob.nl\",\n" +
                "    \"password\":\"********\"\n" +
                "})</li> " +
                "       <li>updateCompanyProfile - POST {\n" +
                "    \"introduction\": \"test\",\n" +
                "    \"logo\": \"logourl\",\n" +
                "    \"ownerFirstName\": \"Barteld\",\n" +
                "    \"ownerLastname\": \"kuijt\",\n" +
                "    \"ownerPicture\": \"Mooiefoto\",\n" +
                "    \"weburl\": \"te\",\n" +
                "    \"instagramUrl\": \"Instagram\",\n" +
                "    \"linkedinUrl\": \"linkedin\",\n" +
                "    \"facebookUrl\": \"facebook\",\n" +
                "    \"place\": \"test\",\n" +
                "    \"streetname\": \"Oude enghweg\",\n" +
                "    \"housenumber\": 36,\n" +
                "    \"zipcode\": \"1217JD\",\n" +
                "    \"establishmentid\": 13\n" +
                "}</li>" +
                "       <li>ResetPassword - POST ({\n" +
                "    \"password\":\"test\",\n" +
                "    \"email\":\"zyadosseyran@gmail.com\",\n" +
                "    \"code\":242946145\n" +
                "\n" +
                "})</li>" +
                "       <li>forgotpassword - POST ({\n" +
                "    \"email\":\"zyadosseyran@gmail.com\"\n" +
                "})</li>" +
                "       <li>getEstablishmentProfile/{estimblishmentprofile} - GET</li>" +
                "       <li>getEstablishmentProfile - GET</li>" +
                "       <li>uploadimage - POST(\"imageFile\" : FILE )</li>" +
                "   </ul>" +
                "   <li><a href='/chat'>Chat</a></li>" +
                "   <ul>" +
                "       <li>createRoom - POST({ \"chatjobid\":32242,\n" +
                "    \"chatname\":\"sdafjlaskdfjklasdjf\",\n" +
                "    \"ownerid\":22,\n" +
                "    \"roomGuest\":[\n" +
                "        23232323,2312315\n" +
                "    ]})</li>" +
                "       <li>sendMessage  - POST ({\n" +
                "    \"userid\": 888888,\n" +
                "    \"roomid\" : 18, \n" +
                "    \"message\" : \"Hi wil graag soliciteren voor deze bijbaan\"\n" +
                "})</li>" +
                "       <li><a href='/chat/getChatMessages?userid=2312315&amount=5&roomid=18'>getChatMessages?userid=2312315&amount=5&roomid=18 - GET</a>" +
                "       <li><a href='/chat/rooms?userid=2312315&start=1&amount=100'>rooms?userid=2312315&start=1&amount=100 - GET</a>" +
                "   </ul>" +
                "</ul>";
    }
}
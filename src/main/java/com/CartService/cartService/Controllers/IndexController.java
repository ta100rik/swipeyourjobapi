package com.CartService.cartService.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
                "       <li>addLike - POST({\"userid\" :  ,\"cardid\":})</li>   " +
                "       <li>addShowed - POST({\\\"userid\\\" :  ,\\\"cardid\\\":})</li>  " +

                "       <li><a href='/app/cards?userid=sdf&start=15&amount=2&lon=52.0862270277778&lat=5.17661701666667'>cards?userid=sdf&start=15&amount=2 (optional: lon=52.0862270277778&lat=5.17661701666667) - GET</a></li> " +
                "       <li><a href='/app/cards'>cards - GET</a></li>   " +
                "   </ul>" +
                "   <li><a href='/web'>Web</a></li>" +
                "   <ul>" +
                "       <li>newCard - POST({\"cardtitel\" :  ,\"city\":  ,\"companyname\": })</li>" +
                "   </ul>" +
                "</ul>";
    }
}
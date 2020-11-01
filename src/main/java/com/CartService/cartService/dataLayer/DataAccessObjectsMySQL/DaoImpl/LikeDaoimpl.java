package com.CartService.cartService.dataLayer.DataAccessObjectsMySQL.DaoImpl;

import com.CartService.cartService.dataLayer.DataAccessObjectsMySQL.BaseDaoMySQL;
import com.CartService.cartService.dataLayer.InterfacesDao.likeDao;
import com.CartService.cartService.domain.Card;
import com.CartService.cartService.domain.CardImage;
import com.CartService.cartService.domain.ListClasses.CardImageList;
import com.CartService.cartService.domain.ListClasses.Cardlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LikeDaoimpl extends BaseDaoMySQL implements likeDao {
    @Override
    public int newLike(int userid, int cardid){
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO liketable (userid,cardid) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,userid);
            preparedStatement.setInt(2,cardid);
            return super.executeQueryReturningId(preparedStatement,connection);
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }
    @Override
    public Cardlist getCards(){
        try{
            // get connection
            Connection connection  = super.getConnection();
            // getting all the cards
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cards;");
            ResultSet result = super.executeQuery(preparedStatement,connection);

            // initiliaze domain item
            Cardlist cardlist = new Cardlist();
            while(result.next()){
                int cardid              = result.getInt("cardid");
                String cardtitle        = result.getString("cardtitle");
                String city             = result.getString("city");
                String companyname      = result.getString("companyname");
                CardImageList imagelist = getCardimagesByCardid(cardid,connection);
                Card newCard            = new Card(cardid,cardtitle,city,companyname,imagelist,"The beautiful description");
                cardlist.addCard(newCard);
            }
            return cardlist;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public CardImageList getCardimagesByCardid(int cardid,Connection connection){
        try{
            //getting the current image list
            String imagesql = "SELECT * FROM cardsimages where cardid = ?";
            PreparedStatement imageStatement = connection.prepareStatement(imagesql);
            imageStatement.setInt(1, cardid);
            ResultSet result = super.executeQuery(imageStatement,connection);

            //creating a container class for all the images
            CardImageList imagelist = new CardImageList();
            //looping through every image row
            while(result.next()){
                //creating imagerow object
                int imageId             = result.getInt("cardimageid");
                String imageurl         = result.getString("imageurl");
                int imagecardid         = result.getInt("cardid");
                CardImage image = new CardImage(imageId,imageurl,imagecardid);
                //add the image to the container class
                imagelist.addCardimage(image);
            }
            return imagelist;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int newCard(String cardtitle, String city, String companyname) {
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cards (cardtitel,city,companyname) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,cardtitle);
            preparedStatement.setString(2,city);
            preparedStatement.setString(3,companyname);
            return super.executeQueryReturningId(preparedStatement,connection);
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }
}

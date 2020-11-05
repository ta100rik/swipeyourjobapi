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
import java.util.List;

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
                String description      = result.getString("description");
                CardImageList imagelist = getCardimagesByCardid(cardid,connection);
                Card newCard            = new Card(cardid,cardtitle,city,companyname,imagelist,description);
                cardlist.addCard(newCard);
            }
            return cardlist;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Cardlist getCardsByUserid(String userid,String start, String amount){
        try{
            // get connection
            Connection connection  = super.getConnection();
            // getting all the cards
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  cards right outer join showedcards on showedcards.cardid != cards.cardid and showedcards.userid = \""+userid+"\" where cardtitle is not null " +
//                    "limit " + amount);
            int ConvertedStart = Integer.parseInt(start);
            int ConvertedAmount = Integer.parseInt(amount);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * " +
                    "FROM cards t1 " +
                    "WHERE t1.cardid NOT IN (SELECT t2.cardid from showedcards t2 where t2.userid = ?) " +
                    "and cardid > ? " +
                    "order by t1.cardid " +
                    "limit ? ");
            preparedStatement.setString(1,userid);
            preparedStatement.setInt(2,ConvertedStart);
            preparedStatement.setInt(3,ConvertedAmount);

            ResultSet result = super.executeQuery(preparedStatement,connection);

            // initiliaze domain item
            Cardlist cardlist = new Cardlist();
            while(result.next()){
                int cardid              = result.getInt("cardid");
                String cardtitle        = result.getString("cardtitle");
                String city             = result.getString("city");
                String companyname      = result.getString("companyname");
                String description      = result.getString("description");
                CardImageList imagelist = getCardimagesByCardid(cardid,connection);
                Card newCard            = new Card(cardid,cardtitle,city,companyname,imagelist,description);
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

    public int newShowed( String userid, int cardid) {
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO showedcards (userid,cardid) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,userid);
            preparedStatement.setInt(2,cardid);

            return super.executeQueryReturningId(preparedStatement,connection);
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }
    public int newCard(String cardtitle, String city, String companyname, String description, List<String> images) {
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cards (cardtitle,city,companyname,description) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,cardtitle);
            preparedStatement.setString(2,city);
            preparedStatement.setString(3,companyname);
            preparedStatement.setString(4,description);
            int result = super.executeQueryReturningId(preparedStatement,connection);
            if(result != 0){
                for (String image : images){
                    PreparedStatement imagestatement = connection.prepareStatement("INSERT INTO cardsimages (imageurl,cardid) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
                    imagestatement.setString(1,image);
                    imagestatement.setInt(2,result);
                    int imageresult = super.executeQueryReturningId(imagestatement,connection);
                }
                return result;
            }
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}

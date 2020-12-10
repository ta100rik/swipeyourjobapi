package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjectsMySQL.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjectsMySQL.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.jobDao;
import com.Swipeyourjob.Rest_api.domain.Card;
import com.Swipeyourjob.Rest_api.domain.CardImage;
import com.Swipeyourjob.Rest_api.domain.CardLocation;
import com.Swipeyourjob.Rest_api.domain.ListClasses.CardImageList;
import com.Swipeyourjob.Rest_api.domain.ListClasses.Cardlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class JobDaoImpl extends BaseDaoMySQL implements jobDao {
    @Override
    public int newLike(int userid, int cardid){
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO likedjobs (userid,jobid) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
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
        /*
        *   this function is turned off because it is decrypted
        * */
//        try{
//            // get connection
//            Connection connection  = super.getConnection();
//            // getting all the cards
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM jobs;");
//            ResultSet result = super.executeQuery(preparedStatement,connection);
//
//            // initiliaze domain item
//            Cardlist cardlist = new Cardlist();
//            while(result.next()){
//                int cardid              = result.getInt("cardid");
//                String cardtitle        = result.getString("cardtitle");
//                String city             = result.getString("city");
//                String companyname      = result.getString("companyname");
//                String companydesc      = result.getString("companydesc");
//                String companyurl       = result.getString("weburl");
//                String description      = result.getString("description");
//                float salary            = result.getFloat("salary");
//                float minHours          = result.getFloat("minhours");
//                float maxHours          = result.getFloat("maxhours");
//
//                CardImageList imagelist = getCardimagesByCardid(cardid,connection);
//                Card newCard            = new Card(cardid,cardtitle,city,companyname,imagelist,description,companydesc,companyurl,salary,minHours,maxHours);
//                cardlist.addCard(newCard);
//            }
//            return cardlist;
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }

        return null;
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

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM jobs t1 " +
                    "join companies companyinfo " +
                    "on companyinfo.company_id = t1.companyid " +
                    "join joblocation jobloc " +
                    "on jobloc.cardid = t1.jobid " +
                    "and jobloc.defaultlocation = '1' " +
                    "join webusers " +
                    "on webusers.companyid = companyinfo.company_id " +
                    "WHERE t1.jobid NOT IN (SELECT t2.jobid from showedjobs t2 where t2.userid = ?) and jobid > ? order by t1.jobid limit ?");

            preparedStatement.setString(1,userid);
            preparedStatement.setInt(2,ConvertedStart);
            preparedStatement.setInt(3,ConvertedAmount);
            ResultSet result = super.executeQuery(preparedStatement,connection);

            // initiliaze domain item
            Cardlist cardlist = new Cardlist();
            while(result.next()){
                /*
                *   later seperate a card from the company info by making a company class
                * */
                int cardid              = result.getInt("jobid");
                String cardtitle        = result.getString("jobtitle");
                String companyname      = result.getString("name");
                String companydesc      = result.getString("comanydesc");
                String companyurl       = result.getString("weburl");
                String description      = result.getString("jobdescription");
                Float salary            = result.getFloat("salary");
                int maxhours          = result.getInt("maxhours");
                int minhours          = result.getInt("minhours");
                String user             = result.getString("firstname");
//                init card images
                CardImageList imagelist = getCardimagesByCardid(cardid,connection);
//                initiliasing the card location seperated because of the seperated table in query
                String streetname           = result.getString("streetname");
                int housenumber             = result.getInt("housenumber");
                String city                 = result.getString("city");
                String zipcode              = result.getString("zipcode");
                boolean defaultlocation     = result.getBoolean("defaultlocation");
                int idjoblocation           = result.getInt("idjoblocation");
                double joblongtitude         = result.getDouble("joblongtitude");
                double joblatitude           = result.getDouble("joblatitude");

                CardLocation  cardLocation = new CardLocation(streetname,housenumber,city,zipcode,defaultlocation,idjoblocation,joblatitude,joblongtitude);
                Card newCard            = new Card(cardid,cardtitle,city,companyname,imagelist,description,companydesc,companyurl,salary,minhours,maxhours,cardLocation,user);
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
            String imagesql = "SELECT * FROM jobsimages where jobid = ?";
            PreparedStatement imageStatement = connection.prepareStatement(imagesql);
            imageStatement.setInt(1, cardid);
            ResultSet result = super.executeQuery(imageStatement,connection);

            //creating a container class for all the images
            CardImageList imagelist = new CardImageList();
            //looping through every image row
            while(result.next()){
                //creating imagerow object
                int imageId             = result.getInt("jobimageid");
                String imageurl         = result.getString("imageurl");
                int imagecardid         = result.getInt("jobid");
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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO showedjobs (userid,jobid) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
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

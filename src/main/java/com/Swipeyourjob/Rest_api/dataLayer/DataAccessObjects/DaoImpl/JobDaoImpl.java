package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.jobDao;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.Card;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.CardBookmark;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.CardImage;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.CardLocation;
import com.Swipeyourjob.Rest_api.domain.ListClasses.CardImageList;
import com.Swipeyourjob.Rest_api.domain.ListClasses.Cardlist;

import java.sql.*;
import java.util.Date;

public class JobDaoImpl extends BaseDaoMySQL implements jobDao {
    public int newBookmark(String userid, int cardid){
        try{
            Connection connection = super.getConnection();
            String query = "INSERT INTO bookmarkedjobs (userid,jobid) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,userid);
            preparedStatement.setInt(2,cardid);
            return super.executeQueryReturningId(preparedStatement,connection);
        }catch (Exception e){
            return 0;
        }
    }
    @Override
    public int newLike(String userid, int cardid){
        try{
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO likedjobs (userid,jobid) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,userid);
            preparedStatement.setInt(2,cardid);
            return super.executeQueryReturningId(preparedStatement,connection);
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }
    @Override
    public Card getCardByJobid(String jobid){
        try{
            // get connection
            int ConvertedJobid = Integer.parseInt(jobid);
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM jobs t1 " +
                    "join companies companyinfo " +
                    "on companyinfo.company_id = t1.companyid " +
                    "join joblocation jobloc " +
                    "on jobloc.cardid = t1.jobid " +
                    "and jobloc.defaultlocation = '1' " +
                    "join webusers " +
                    "on webusers.companyid = companyinfo.company_id " +
                    " where jobid = ?");
            preparedStatement.setInt(1,ConvertedJobid);
            ResultSet result = super.executeQuery(preparedStatement,connection);
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
//                System.out.println(imagelist.getCardImageList());
                CardLocation  cardLocation = new CardLocation(streetname,housenumber,city,zipcode,defaultlocation,idjoblocation,joblatitude,joblongtitude);
                Card newCard            = new Card(cardid,cardtitle,city,companyname,imagelist,description,companydesc,companyurl,salary,minhours,maxhours,cardLocation,user);
                return newCard;
            }

        }catch (Exception e){
            return null;
        }
        return null;
    }
    @Override
    public Cardlist getCardsByCompanyId(int Companyid) {
        try {
            // get connection
            Connection connection = super.getConnection();
            // getting all the cards

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM jobs t1 " +
                    "join companies companyinfo " +
                    "on companyinfo.company_id = t1.companyid " +
                    "join joblocation jobloc " +
                    "on jobloc.cardid = t1.jobid " +
                    "and jobloc.defaultlocation = '1' " +
                    "join webusers " +
                    "on webusers.companyid = companyinfo.company_id " +
                    "where companyinfo.company_id = ?");

            preparedStatement.setInt(1, Companyid);
            ResultSet result = super.executeQuery(preparedStatement, connection);

            // initiliaze domain item
            Cardlist cardlist = new Cardlist();
            while (result.next()) {
                /*
                 *   later seperate a card from the company info by making a company class
                 * */
                int cardid = result.getInt("jobid");
                String cardtitle = result.getString("jobtitle");
                String companyname = result.getString("name");
                String companydesc = result.getString("comanydesc");
                String companyurl = result.getString("weburl");
                String description = result.getString("jobdescription");
                Float salary = result.getFloat("salary");
                int maxhours = result.getInt("maxhours");
                int minhours = result.getInt("minhours");
                String user = result.getString("firstname");
//                init card images
                CardImageList imagelist = getCardimagesByCardid(cardid, connection);
//                initiliasing the card location seperated because of the seperated table in query
                String streetname = result.getString("streetname");
                int housenumber = result.getInt("housenumber");
                String city = result.getString("city");
                String zipcode = result.getString("zipcode");
                boolean defaultlocation = result.getBoolean("defaultlocation");
                int idjoblocation = result.getInt("idjoblocation");
                double joblongtitude = result.getDouble("joblongtitude");
                double joblatitude = result.getDouble("joblatitude");
//                System.out.println(imagelist.getCardImageList());
                CardLocation cardLocation = new CardLocation(streetname, housenumber, city, zipcode, defaultlocation, idjoblocation, joblatitude, joblongtitude);
                Card newCard = new Card(cardid, cardtitle, city, companyname, imagelist, description, companydesc, companyurl, salary, minhours, maxhours, cardLocation, user);
                cardlist.addCard(newCard);
            }
            return cardlist;
        } catch (Exception e) {
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
//                System.out.println(imagelist.getCardImageList());
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

    public Cardlist getCardsbyBookmark(String userid){
        try{
            // get connection
            Connection connection  = super.getConnection();
            // getting all the cards

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bookmarkedjobs " +
                    "join jobs " +
                    "on jobs.jobid = bookmarkedjobs.jobid " +
                    "join companies " +
                    "on companies.company_id = jobs.companyid " +
                    "join joblocation jobloc " +
                    "on jobloc.cardid = jobs.jobid " +
                    "and jobloc.defaultlocation = '1' " +
                    "join webusers " +
                    "on webusers.companyid = companies.company_id " +
                    "where userid = ? ");

            preparedStatement.setString(1,userid);
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

                Date bookmarktimestamp      = result.getDate("timesstamps");
                int bookmarkid              = result.getInt("idbookmarkedjobs");
                CardLocation  cardLocation  = new CardLocation(streetname,housenumber,city,zipcode,defaultlocation,idjoblocation,joblatitude,joblongtitude);
                CardBookmark  cardBookmark  = new CardBookmark(bookmarkid,bookmarktimestamp);
                Card newCard                = new Card(cardid,cardtitle,city,companyname,imagelist,description,companydesc,companyurl,salary,minhours,maxhours,cardLocation,user);
                newCard.setBookmark(cardBookmark);
                cardlist.addCard(newCard);
            }
            return cardlist;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int getBookmarkAmountuser(String userid){
        try{
            Connection connection = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) as bookmarkamount FROM bookmarkedjobs where userid = ?");
            preparedStatement.setString(1,userid);
            ResultSet result = super.executeQuery(preparedStatement,connection);
            while(result.next()){
                return result.getInt("bookmarkamount");
            }
        }catch (Exception e){
            return 0;
        }
        return 0;
    }
    @Override
    public CardImageList getCardimagesByCardid(int cardid,Connection connection){
        try{
            //getting the current image list
            String imagesql = "SELECT * FROM jobsimages where jobid = ?";
            PreparedStatement imageStatement = connection.prepareStatement(imagesql);
            imageStatement.setInt(1, cardid);
            ResultSet result = super.executeQuery(imageStatement,connection);
//            System.out.println(imageStatement);
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
    public boolean removeBookmark(int bookmarkid){
        String sql = "";
        try{
            Connection connection  = super.getConnection();
            sql = "delete from bookmarkedjobs where idbookmarkedjobs = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,bookmarkid);
            super.updateQuery(preparedStatement,connection);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
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

}

package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.Controllers.request.NewJobRequest;
import com.Swipeyourjob.Rest_api.Controllers.request.SubclassesJob.Availbility;
import com.Swipeyourjob.Rest_api.Controllers.request.SubclassesJob.Salary;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.jobDao;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.Card;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.CardBookmark;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.CardImage;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.CardLocation;
import com.Swipeyourjob.Rest_api.domain.ListClasses.CardImageList;
import com.Swipeyourjob.Rest_api.domain.ListClasses.Cardlist;
import com.Swipeyourjob.Rest_api.ResultClass;

import java.sql.*;
import java.text.SimpleDateFormat;

public class JobDaoImpl extends BaseDaoMySQL implements jobDao {
    public int newBookmark(String userid, int cardid){
        try{
            Connection connection = super.getConnection();
            PreparedStatement checkquery = connection.prepareStatement("select * FROM bookmarkedjobs where jobid = ? and userid = ?");
            checkquery.setInt(1,cardid);
            checkquery.setString(2, userid);
            ResultSet result = super.executeQuery(checkquery, connection);
            int rowsamounts = getRowCount(result);
            if(rowsamounts == 0){
                String query = "INSERT INTO bookmarkedjobs (userid,jobid) VALUES (?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,userid);
                preparedStatement.setInt(2,cardid);
                return super.executeQueryReturningId(preparedStatement,connection);
            }else{
                return 0;
            }
        }catch (Exception e){
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
                String companyLogo      = result.getString("companylogo");
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
                Card newCard            = new Card(cardid,cardtitle,city,companyname,imagelist,description,companydesc,companyurl,companyLogo,salary,minhours,maxhours,cardLocation,user);
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

                String comanydesclogo = result.getString("companylogo");
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
                Card newCard = new Card(cardid, cardtitle, city, companyname, imagelist, description, companydesc, companyurl,comanydesclogo, salary, minhours, maxhours, cardLocation, user);
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
                String companyLogo      = result.getString("companylogo");
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
                Card newCard            = new Card(cardid,cardtitle,city,companyname,imagelist,description,companydesc,companyurl,companyLogo,salary,minhours,maxhours,cardLocation,user);
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

                String companyLogo      = result.getString("companylogo");
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
                Card newCard                = new Card(cardid,cardtitle,city,companyname,imagelist,description,companydesc,companyurl,companyLogo,salary,minhours,maxhours,cardLocation,user);
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

    public ResultClass newJobHandler(NewJobRequest req,int companyid) {
        ResultClass RESULT = null;
        try{
            /*
                Jobs:
                    jobsname*
                    jobdescription*
                    salary (only when 1)*
                Salary (only when more than 1):
                    Salary*
                    age*
                Job period:
                    StartDate*
                    enddate

             */
            int insertjob = 0;
            Connection connection = super.getConnection();
            int salaryamount = req.getSalaryLength();
            if(salaryamount == 1){
                String sql = "INSERT INTO jobs (jobtitle,jobdescription,salary,minage,establishment_idestablishment,establishment_companies_company_id) VALUES (?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,req.getJobName());
                preparedStatement.setString(2,req.getJobDescription());
                preparedStatement.setDouble(3, req.getSalary().get(0).getSalary());
                preparedStatement.setInt(4, req.getSalary().get(0).getAge());
                preparedStatement.setInt(5,req.getEstamblishmentid());
                preparedStatement.setInt(6,companyid);
                insertjob = super.executeQueryReturningId(preparedStatement,connection);
                RESULT = new ResultClass(insertjob,200,"Job and salary are uploaded.");
            }else{
                String sql = "INSERT INTO JOBS (jobtitle,jobdescription,establishment_idestablishment,establishment_companies_company_id) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,req.getJobName());
                preparedStatement.setString(2,req.getJobDescription());
                preparedStatement.setInt(3,req.getEstamblishmentid());
                preparedStatement.setInt(4,companyid);
                insertjob = super.executeQueryReturningId(preparedStatement,connection);
                RESULT = new ResultClass(insertjob,200,"Job uploaded no salary");
            }
            // add additonal salary
            if(insertjob != 0){
                // Job uploaded
                if(salaryamount > 1){
                    for (Salary salary : req.getSalary()){
                        String sql = "INSERT INTO salary (salary,age,jobs_jobid) VALUES (?,?,?)";
                        PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                        statement.setDouble(1,salary.getSalary());
                        statement.setInt(2,salary.getAge());
                        statement.setInt(3,insertjob);
                        int addsalary = super.executeQueryReturningId(statement,connection);
                        if(addsalary == 0){
                            RESULT = new ResultClass(insertjob,500,"Job uploaded but salary was not completed filled.");
                            break;
                        }
                    }
                    if(RESULT.isOk()){
                        RESULT = new ResultClass(insertjob,200,"Job and salary are uploaded.");
                    }
                }
                // Uploading jobperiod
                if(RESULT.isOk()){
                    String sql = "INSERT INTO jobperiod (startdate,enddate,jobs_jobid) VALUES (?,?,?)";
                    PreparedStatement insertJobPeriod = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                    insertJobPeriod.setString(1,req.getStartdate());
                    if(req.getEnddate() != null && req.getEnddate().equals("")){
                        insertJobPeriod.setDate(2,null);
                    }else{
                        insertJobPeriod.setString(2,req.getEnddate());
                    }
                    insertJobPeriod.setInt(3,insertjob);
                    int addJobPeriod = super.executeQueryReturningId(insertJobPeriod,connection);
                    if(addJobPeriod == 0){
                        RESULT = new ResultClass(insertjob,500,"Job and Salary uploaded but jobperiod where not correct.");
                    }else{
                        RESULT = new ResultClass(insertjob,200,"Job, Salary and jobperiod are uploaded.");
                    }
                }

                if(RESULT.isOk()){
                    String sql = "INSERT INTO jobimages (imageurl,jobid) VALUES (?,?)";
                    PreparedStatement insertimage = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                    insertimage.setString(1,req.getJobImage());
                    insertimage.setInt(2,insertjob);
                    int addimage = super.executeQueryReturningId(insertimage,connection);
                    if(addimage == 0){
                        RESULT = new ResultClass(insertjob,500,"Job, period and salary uploaded but image where not correct.");
                    }else{
                        RESULT = new ResultClass(insertjob,200,"Job, period, jobimage and salary are uploaded.");
                    }
                }

                if(RESULT.isOk()){
                    for(String tag : req.getTags()){
                        // Putting the
                        String firstLetStr = tag.substring(0, 1).toUpperCase();
                        // Get remaining letter using substring
                        String remLetStr = tag.substring(1).toLowerCase();
                        tag = firstLetStr + remLetStr;
                        String searchSQL = "SELECT tagid FROM tagbox where tagname =  limit 1";
                        PreparedStatement SearchStatement = connection.prepareStatement(searchSQL);
                        SearchStatement.setString(1,tag);
                        ResultSet resultSet = super.executeQuery(SearchStatement,connection);
                        int rowcount = super.getRowCount(resultSet);
                        int tagid = 0;
                        if(rowcount == 0){
                            // insert
                            String sql = "INSERT INTO tagbox (tagname) VALUES (?)";
                            PreparedStatement newtagStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                            newtagStatement.setString(1,tag);
                            tagid = super.executeQueryReturningId(newtagStatement,connection);
                        }else{
                            // found tag
                            resultSet.first();
                            tagid = resultSet.getInt("tagid");
                        }

                        if(tagid == 0){
                            RESULT = new ResultClass(insertjob,500,"Job, period, jobimage and salary uploaded but tags where not correct.");
                            break;
                        }else{
                            String sql = "INSERT INTO job_tag (jobid,tagid) VALUES (?,?)";
                            PreparedStatement insertStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                            insertStatement.setInt(1,insertjob);
                            insertStatement.setInt(2,tagid);
                            int job_tag = super.executeQueryReturningId(insertStatement,connection);
                            if(job_tag == 0){
                                RESULT = new ResultClass(insertjob,500,"Job, period, jobimage and salary uploaded but tags where not correct.");
                                break;
                            }else{
                                RESULT = new ResultClass(insertjob,200,"Job, period, jobimage, tags and salary are uploaded.");
                            }
                        }
                    }
                }

                // TODO: insert Availbility
            }else{
                RESULT = new ResultClass(null,500,"The job can't be created.");
            }
            return RESULT;
        }catch (Exception e){
            RESULT = new ResultClass(null,500,e.getMessage());
            return RESULT;
        }
    }

}

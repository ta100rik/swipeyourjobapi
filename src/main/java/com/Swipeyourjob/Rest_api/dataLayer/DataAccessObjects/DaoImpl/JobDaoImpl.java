package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.Controllers.request.NewJobRequest;
import com.Swipeyourjob.Rest_api.Controllers.request.SubclassesJob.Availbility;
import com.Swipeyourjob.Rest_api.Controllers.request.SubclassesJob.Salary;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.jobDao;
import com.Swipeyourjob.Rest_api.domain.Cardsinfo.*;

import com.Swipeyourjob.Rest_api.domain.ListClasses.CardImageList;
import com.Swipeyourjob.Rest_api.domain.ListClasses.Joblist;
import com.Swipeyourjob.Rest_api.ResultClass;
import com.Swipeyourjob.Rest_api.domain.ListClasses.LikedJobsList;

import javax.xml.transform.Result;
import java.awt.*;
import java.sql.*;

public class JobDaoImpl extends BaseDaoMySQL implements jobDao {
    @Override
    public Job getCardByJobid(String jobid){
        try{
            // get connection
            int ConvertedJobid = Integer.parseInt(jobid);
            Connection connection  = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                    "    jobs.jobid, " +
                    "    jobs.jobtitle, " +
                    "    companies.name, " +
                    "    estam.description as comanydesc, " +
                    "    estam.url as weburl, " +
                    "    companies.companylogo, " +
                    "    jobs.jobdescription, " +
                    "    jobs.salary, " +
                    "    jobs.maxhours, " +
                    "    jobs.minhours, " +
                    "    concat(webusers.firstname , ' ' , webusers.lastname) as firstname, " +
                    "    adres.streetname, " +
                    "    adres.housenumber, " +
                    "    adres.place as city, " +
                    "    adres.zipcode, " +
                    "    adres.idestablishment_adress, " +
                    "    adres.latitude, " +
                    "    adres.longtitude " +
                    " FROM jobs " +
                    "join establishment estam " +
                    "on jobs.establishment_idestablishment  = estam.idestablishment " +
                    "join establishment_adress adres " +
                    "on estam.idestablishment = adres.establishment_idestablishment " +
                    "join companies " +
                    "on jobs.establishment_companies_company_id = companies.company_id " +
                    "join webusers  " +
                    "on estam.establishmentowner = webusers.idwebusers " +
                    "where jobs.jobid = ?");
            preparedStatement.setInt(1,ConvertedJobid);
            ResultSet result = super.executeQuery(preparedStatement,connection);
            while(result.next()){
                int cardid              = result.getInt("jobid");
                String cardtitle        = result.getString("jobtitle");
                String companyname      = result.getString("name");
                String companydesc      = result.getString("comanydesc");
                String companyurl       = result.getString("weburl");
                String companyLogo      = result.getString("companylogo");
                String description      = result.getString("jobdescription");
                Float salary            = result.getFloat("salary");
                int maxhours            = result.getInt("maxhours");
                int minhours            = result.getInt("minhours");
                String user             = result.getString("firstname");
//                init card images
                CardImageList imagelist = getCardimagesByCardid(cardid,connection);
//                initiliasing the card location seperated because of the seperated table in query
                String streetname           = result.getString("streetname");
                int housenumber             = result.getInt("housenumber");
                String city                 = result.getString("city");
                String zipcode              = result.getString("zipcode");
                boolean defaultlocation     = true;
                int idjoblocation           = result.getInt("idestablishment_adress");
                double joblongtitude         = result.getDouble("longtitude");
                double joblatitude           = result.getDouble("latitude");
//                System.out.println(imagelist.getCardImageList());
                CardLocation  cardLocation = new CardLocation(streetname,housenumber,city,zipcode,defaultlocation,idjoblocation,joblatitude,joblongtitude);
                Job newJob = new Job(cardid,cardtitle,city,companyname,imagelist,description,companydesc,companyurl,companyLogo,salary,minhours,maxhours,cardLocation,user);
                return newJob;
            }

        }catch (Exception e){
            return null;
        }
        return null;
    }
    private int StatusToStatusid(String status){
        status = status.toLowerCase();
        int RESULT = 0;
        switch (status){
            case "liked":
                RESULT = 1;
                break;
            case "denied":
                RESULT = 2;
            break;
            case "bookmarked":
                RESULT = 3;
            break;
            case "rejected":
                RESULT = 4;
            break;
            case "accepted":
                RESULT = 5;
            break;
        }
        return RESULT;
    }
    private ResultClass updateJobstatus(String newStatus,Connection connection,int rowid){
        ResultClass RESULT = null;
        int statusid = StatusToStatusid(newStatus);
        try{
            String sql = "UPDATE jobstatus_users set statusid = ? where idjobstatus_users = ?";
            PreparedStatement updatequery = connection.prepareStatement(sql);
            updatequery.setInt(1,statusid);
            updatequery.setInt(2,rowid);
            if(super.updateQuery(updatequery,connection)){
                RESULT = new ResultClass(true,200,"OK");
            }else{
                RESULT = new ResultClass(false,500,"Sorry the record wasn't updated");
            }
            return RESULT;
        }catch (Exception e){
            RESULT = new ResultClass(null,500,e.getMessage());
            return RESULT;
        }
    }
    private ResultClass updateJobstatus(String newStatus,Connection connection,int rowid,int webuser){
        ResultClass RESULT = null;
        int statusid = StatusToStatusid(newStatus);
        try{
            String sql = "UDPATE jobstatus_users set statusid = ? , webuser = ? where idjobstatus_users = ?";
            PreparedStatement updatequery = connection.prepareStatement(sql);
            updatequery.setInt(1,statusid);
            updatequery.setInt(2,rowid);
            updatequery.setInt(3,webuser);
            if(super.updateQuery(updatequery,connection)){
                RESULT = new ResultClass(true,200,"OK");
            }else{
                RESULT = new ResultClass(false,500,"Sorry the record wasn't updated");
            }
            return RESULT;
        }catch (Exception e){
            RESULT = new ResultClass(null,500,e.getMessage());
            return RESULT;
        }
    }
    private ResultClass insertJobStatus(String newStatus,Connection connection,String appuser,int jobid){
        ResultClass RESULT = null;
        int statusid = StatusToStatusid(newStatus);
        try{
            String sql = "INSERT INTO jobstatus_users (statusid,userid,jobid) VALUES (?,?,?)";
            PreparedStatement insertStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1,statusid);
            insertStatement.setString(2,appuser);
            insertStatement.setInt(3,jobid);
            int QueryResult = super.executeQueryReturningId(insertStatement,connection);
            if(QueryResult != 0){
                RESULT = new ResultClass(QueryResult,200,"OK");
            }else{
                RESULT = new ResultClass(null,500,"Something wen't wrong in the database");
            }
            return RESULT;
        }catch (Exception e){
            RESULT = new ResultClass(null,500,e.getMessage());
            return RESULT;
        }
    }

    public ResultClass updateJobStatus(String status,String appuser,int jobid,int webuser){
        ResultClass  RESULT = new ResultClass(true,500,"Something in the database wen't wrong when updating");
        try{
            Connection connection = super.getConnection();

            String sql = "SELECT * FROM jobstatus_users " +
                    "where jobid = ? " +
                    "and userid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,jobid);
            preparedStatement.setString(2,appuser);
            ResultSet QueryResult = super.executeQuery(preparedStatement,connection);
            int rowcount = super.getRowCount(QueryResult);
            if(rowcount != 0){
                QueryResult.first();
                int rowid = QueryResult.getInt("idjobstatus_users");
                if(webuser == 0){
                    RESULT = updateJobstatus(status,connection,rowid);
                }else{
                    RESULT = updateJobstatus(status,connection,rowid,webuser);
                }
            }else{
                RESULT = insertJobStatus(status,connection,appuser,jobid);
            }
            return RESULT;
//            PreparedStatement preparedStatement = ;
        }catch(Exception e){
            RESULT = new ResultClass(null,500,e.getMessage());
            return RESULT;
        }
    }

    @Override
    public Joblist getCardsByUserid(String userid, String start, String amount){
        try{
            // get connection
            Connection connection  = super.getConnection();
            // getting all the cards
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM  cards right outer join showedcards on showedcards.cardid != cards.cardid and showedcards.userid = \""+userid+"\" where cardtitle is not null " +
//                    "limit " + amount);
            int ConvertedStart = Integer.parseInt(start);
            int ConvertedAmount = Integer.parseInt(amount);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                    "    jobs.jobid, " +
                    "    jobs.jobtitle, " +
                    "    companies.name, " +
                    "    estam.description as comanydesc, " +
                    "    estam.url as weburl, " +
                    "    companies.companylogo, " +
                    "    jobs.jobdescription, " +
                    "    jobs.salary, " +
                    "    jobs.maxhours, " +
                    "    jobs.minhours, " +
                    "    concat(webusers.firstname , ' ' , webusers.lastname) as firstname, " +
                    "    adres.streetname, " +
                    "    adres.housenumber, " +
                    "    adres.place as city, " +
                    "    adres.zipcode, " +
                    "    adres.idestablishment_adress, " +
                    "    adres.latitude, " +
                    "    adres.longtitude " +
                    " FROM jobs " +
                    "join establishment estam " +
                    "on jobs.establishment_idestablishment  = estam.idestablishment " +
                    "join establishment_adress adres " +
                    "on estam.idestablishment = adres.establishment_idestablishment " +
                    "join companies " +
                    "on jobs.establishment_companies_company_id = companies.company_id " +
                    "join webusers  " +
                    "on estam.establishmentowner = webusers.idwebusers " +
                    "join jobperiod period " +
                    "on period.jobs_jobid = jobs.jobid " +
                    "and (period.enddate is null or period.enddate > now()) " +
                    "where jobs.jobid NOT IN (SELECT jobstatus_users.jobid from jobstatus_users where jobstatus_users.userid = ?) " +
                    "and jobs.jobid > ? " +
                    "order by jobs.jobid " +
                    "limit ?");

            preparedStatement.setString(1,userid);
            preparedStatement.setInt(2,ConvertedStart);
            preparedStatement.setInt(3,ConvertedAmount);
            ResultSet result = super.executeQuery(preparedStatement,connection);

            // initiliaze domain item
            Joblist joblist = new Joblist();
            while(result.next()){

                int cardid              = result.getInt("jobid");
                String cardtitle        = result.getString("jobtitle");
                String companyname      = result.getString("name");
                String companydesc      = result.getString("comanydesc");
                String companyurl       = result.getString("weburl");
                String companyLogo      = result.getString("companylogo");
                String description      = result.getString("jobdescription");
                Float salary            = result.getFloat("salary");
                int maxhours            = result.getInt("maxhours");
                int minhours            = result.getInt("minhours");
                String user             = result.getString("firstname");
//                init card images
                CardImageList imagelist = getCardimagesByCardid(cardid,connection);
//                initiliasing the card location seperated because of the seperated table in query
                String streetname           = result.getString("streetname");
                int housenumber             = result.getInt("housenumber");
                String city                 = result.getString("city");
                String zipcode              = result.getString("zipcode");
                boolean defaultlocation     = true;
                int idjoblocation           = result.getInt("idestablishment_adress");
                double joblongtitude         = result.getDouble("longtitude");
                double joblatitude           = result.getDouble("latitude");
//                System.out.println(imagelist.getCardImageList());
                CardLocation  cardLocation = new CardLocation(streetname,housenumber,city,zipcode,defaultlocation,idjoblocation,joblatitude,joblongtitude);
                Job newJob = new Job(cardid,cardtitle,city,companyname,imagelist,description,companydesc,companyurl,companyLogo,salary,minhours,maxhours,cardLocation,user);
                joblist.addCard(newJob);
            }
            return joblist;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Joblist getCardsbyBookmark(String userid){
        try{
            // get connection
            Connection connection  = super.getConnection();
            // getting all the cards

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                    "    jobs.jobid, " +
                    "    jobs.jobtitle, " +
                    "    companies.name, " +
                    "    estam.description as comanydesc, " +
                    "    estam.url as weburl, " +
                    "    companies.companylogo, " +
                    "    jobs.jobdescription, " +
                    "    jobs.salary, " +
                    "    jobs.maxhours, " +
                    "    jobs.minhours, " +
                    "    concat(webusers.firstname , ' ' , webusers.lastname) as firstname, " +
                    "    adres.streetname, " +
                    "    adres.housenumber, " +
                    "    adres.place as city, " +
                    "    adres.zipcode, " +
                    "    adres.idestablishment_adress, " +
                    "    adres.latitude, " +
                    "    adres.longtitude," +
                    "    jobstatus_users.idjobstatus_users," +
                    "    jobstatus_users.timestamps " +
                    " FROM jobs " +
                    "join establishment estam " +
                    "on jobs.establishment_idestablishment  = estam.idestablishment " +
                    "join establishment_adress adres " +
                    "on estam.idestablishment = adres.establishment_idestablishment " +
                    "join companies " +
                    "on jobs.establishment_companies_company_id = companies.company_id " +
                    "join webusers " +
                    "on estam.establishmentowner = webusers.idwebusers " +
                    "join jobstatus_users " +
                    "on jobstatus_users.userid = ? " +
                    "and jobstatus_users.jobid = jobs.jobid " +
                    "join jobstatuses " +
                    "on jobstatuses.idjobstatuses = jobstatus_users.statusid " +
                    "and jobstatuses.statusname = 'bookmarked' ");

            preparedStatement.setString(1,userid);

            ResultSet result = super.executeQuery(preparedStatement,connection);

            // initiliaze domain item
            Joblist joblist = new Joblist();
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
                boolean defaultlocation     = true;
                int idjoblocation           = result.getInt("idestablishment_adress");
                double joblongtitude         = result.getDouble("longtitude");
                double joblatitude           = result.getDouble("latitude");

                Date bookmarktimestamp      = result.getDate("timestamps");
                int bookmarkid              = result.getInt("idjobstatus_users");
                CardLocation  cardLocation  = new CardLocation(streetname,housenumber,city,zipcode,defaultlocation,idjoblocation,joblatitude,joblongtitude);
                CardBookmark cardBookmark  = new CardBookmark(bookmarkid,bookmarktimestamp);
                Job newJob = new Job(cardid,cardtitle,city,companyname,imagelist,description,companydesc,companyurl,companyLogo,salary,minhours,maxhours,cardLocation,user);
                newJob.setBookmark(cardBookmark);
                joblist.addCard(newJob);
            }
            return joblist;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int getBookmarkAmountuser(String userid){
        try{
            Connection connection = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) as bookmarkamount FROM jobstatus_users " +
                    "join jobstatuses  " +
                    "on  " +
                    "jobstatuses.idjobstatuses = jobstatus_users.statusid " +
                    "and jobstatuses.statusname = 'bookmarked' " +
                    "where jobstatus_users.userid = ?");
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
    public CardImageList getCardimagesByCardid(int jobid,Connection connection){
        try{
            //getting the current image list
            String imagesql = "SELECT * FROM jobimages where jobid = ?";
            PreparedStatement imageStatement = connection.prepareStatement(imagesql);
            imageStatement.setInt(1, jobid);
            ResultSet result = super.executeQuery(imageStatement,connection);
//            System.out.println(imageStatement);
            //creating a container class for all the images
            CardImageList imagelist = new CardImageList();
            //looping through every image row
            while(result.next()){
                //creating imagerow object
                int imageId             = result.getInt("idjobimages");
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

    @Override
    public ResultClass getLikedJobs(int webuserid, String filter,int jobid){
        ResultClass RESULT = null;
        try{
            Connection connection = super.getConnection();
            String sql = "select * FROM jobstatus_users stat " +
                    "join jobs job " +
                    "on job.jobid = stat.jobid " +
                    "join Webusers_establishment webuser " +
                    "on webuser.establishment_idestablishment = job.establishment_idestablishment " +
                    "and webusers_idwebusers = ? " +
                    "join jobstatuses jostat " +
                    "on stat.statusid =  jostat.idjobstatuses " +
                    "where jostat.statusname in ("+filter+") " +
                    "and job.jobid = ?";

            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setInt(1,webuserid);
            preparedstatement.setInt(2,jobid);

            ResultSet result = super.executeQuery(preparedstatement,connection);

            LikedJobsList likedjobslist = new LikedJobsList();
            while(result.next()){
                String userid   = result.getString("userid");
                String status   = result.getString("statusname");
                jobid       = result.getInt("jobid");
                String jobname  = result.getString("jobtitle");
                LikedJob likedjob = new LikedJob(userid,status,jobname,jobid);
                likedjobslist.addLikedJob(likedjob);
            }
            RESULT = new ResultClass(likedjobslist,200,"OK");
            return RESULT;
        }catch (Exception e){
            return RESULT;
        }
    }
    @Override
    public ResultClass getLikedJobs(int webuserid, String filter){
        ResultClass RESULT = null;
        try{
            Connection connection = super.getConnection();
            String sql = "select * FROM jobstatus_users stat " +
                    "join jobs job " +
                    "on job.jobid = stat.jobid " +
                    "join Webusers_establishment webuser " +
                    "on webuser.establishment_idestablishment = job.establishment_idestablishment " +
                    "and webusers_idwebusers = ? " +
                    "join jobstatuses jostat " +
                    "on stat.statusid =  jostat.idjobstatuses " +
                    "where jostat.statusname in ("+filter+")";

            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setInt(1,webuserid);

            ResultSet result = super.executeQuery(preparedstatement,connection);

            LikedJobsList likedjobslist = new LikedJobsList();
            while(result.next()){
                String userid   = result.getString("userid");
                String status   = result.getString("statusname");
                int jobid       = result.getInt("jobid");
                String jobname  = result.getString("jobtitle");
                LikedJob likedjob = new LikedJob(userid,status,jobname,jobid);
                likedjobslist.addLikedJob(likedjob);
            }
            RESULT = new ResultClass(likedjobslist,200,"OK");
            return RESULT;
        }catch (Exception e){
            return RESULT;
        }
    }

    @Override
    public ResultClass getCardsByCompanyUserid(int userid) {
        ResultClass RESULT = null;
        try{
            Connection connection = super.getConnection();
            String imagesql = "select *, (select count(*) from jobstatus_users jobuser where jobuser.jobid = jobs.jobid and jobuser.statusid = 1 ) as amountlikes  FROM jobs  " +
                    "join Webusers_establishment conne " +
                    "on conne.establishment_idestablishment = jobs.establishment_idestablishment " +
                    "and conne.webusers_idwebusers = ? " +
                    "join jobperiod " +
                    "on jobperiod.jobs_jobid = jobs.jobid " +
                    "where enddate > now() or enddate is null " +
                    "order by amountlikes";

            PreparedStatement imageStatement = connection.prepareStatement(imagesql);
            imageStatement.setInt(1, userid);
            System.out.println(imageStatement);
            ResultSet result = super.executeQuery(imageStatement,connection);

            Joblist jobs = new Joblist();
            while(result.next()){
                int jobid = result.getInt("jobid");
                CardImageList imagelist = getCardimagesByCardid(jobid,connection);
                String jobname = result.getString("jobtitle");
                Date startdate = result.getDate("startdate");
                Date enddate = result.getDate("enddate");
                int amountoflikes = result.getInt("amountlikes");
                JobPeriod period = new JobPeriod(startdate,enddate);
                Job newcard = new Job(jobid,jobname,null,null,imagelist,null,null,null,null,-1,-1,-1,null,null);
                newcard.setPeriod(period);
                newcard.setAmountlikes(amountoflikes);
                jobs.addCard(newcard);
            }
            RESULT = new ResultClass(jobs,200,"OK");
            return RESULT;
        }catch (Exception e){
            RESULT = new ResultClass(null,500,"We didn't found your Jobs, try again later");
            return RESULT;
        }
    }

    @Override
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
                String sql = "INSERT INTO jobs (jobtitle,jobdescription,establishment_idestablishment,establishment_companies_company_id) VALUES (?,?,?,?)";
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
                        String searchSQL = "SELECT tagid FROM tagbox where tagname = ? limit 1";
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
                if(RESULT.isOk()){
                    int dayCounter = 1;
                    for(Availbility aval : req.getAvaibility()){
                        String sql = "INSERT INTO jobavability (day,morning,afternoon,evening,night,jobid) VALUES (?,?,?,?,?,?)";
                        PreparedStatement jobavability = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                        jobavability.setInt(1,dayCounter);
                        jobavability.setBoolean(2,aval.isMorning());
                        jobavability.setBoolean(3,aval.isAfternoon());
                        jobavability.setBoolean(4,aval.isEvening());
                        jobavability.setBoolean(5,aval.isNight());
                        jobavability.setInt(6,insertjob);
                        int addavaibility = super.executeQueryReturningId(jobavability,connection);
                        if(addavaibility == 0){
                            RESULT = new ResultClass(insertjob,500,"Job, period, jobimage, tags, salary uploaded but avaibility was not correct.");
                            break;
                        }else{
                            RESULT = new ResultClass(insertjob,200,"Job, period, jobimage, tags, salary and avaibility are uploaded.");
                        }
                        dayCounter++;
                    }
                }

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

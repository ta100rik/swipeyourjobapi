package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.ResultClass;
import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.EstamblishmentDao;
import com.Swipeyourjob.Rest_api.dataLayer.ResponseClasses.Locationiq;
import com.Swipeyourjob.Rest_api.domain.Company.EstablishmentItem;
import com.Swipeyourjob.Rest_api.domain.Company.EstablishmentProfile;
import com.Swipeyourjob.Rest_api.domain.ListClasses.EstablishmentList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.IOException;
import java.sql.*;

public class EstamblishmentDaoImpl extends BaseDaoMySQL implements EstamblishmentDao {
    private int createEstamblishmentAdres(String zipcode, int companyid){
        try{
            Locationiq locationinfo = getAdressinfo(zipcode);
            if(locationinfo != null){
                if(locationinfo.error == null){
                    Connection connection  = super.getConnection();
                    PreparedStatement insertreadstatement = connection.prepareStatement("INSERT INTO establishment_adress(zipcode,establishment_idestablishment,startdate,latitude,longtitude) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    insertreadstatement.setString(1,zipcode);
                    insertreadstatement.setInt(2,companyid);
                    insertreadstatement.setDate(3,new Date(System.currentTimeMillis()));
                    insertreadstatement.setString(4,locationinfo.lat);
                    insertreadstatement.setString(5,locationinfo.lon);
                    return super.executeQueryReturningId(insertreadstatement,connection);
                }else{
                    return 0;
                }
            }

            return 0;
        }catch (Exception e){
            System.out.println("ss+");
            e.printStackTrace();
            return 0;
        }
    }
    public boolean updateEstablishmentProfile(String introduction,
                                              String weburl,
                                              String instagramUrl,
                                              String linkedinUrl,
                                              String facebookUrl,
                                              String place,
                                              String streetname,
                                              int housenumber,
                                              String zipcode,
                                              int establishmentid){
        try{
            Connection connection = super.getConnection();
            // entity Establishment
            PreparedStatement updatestatementEstablishment = connection.prepareStatement("UPDATE establishment SET description = ? ,facebookurl = ?, linkedinurl = ?, instagramurl = ?, url = ? where idestablishment = ?");
            updatestatementEstablishment.setString(1,introduction);
            updatestatementEstablishment.setString(2,facebookUrl);
            updatestatementEstablishment.setString(3,linkedinUrl);
            updatestatementEstablishment.setString(4,instagramUrl);
            updatestatementEstablishment.setString(5,weburl);
            updatestatementEstablishment.setInt(6,establishmentid);
            boolean establishmentupdate = super.updateQuery(updatestatementEstablishment,connection);
            // entity Adress
            if(!zipcode.isEmpty()){
                Locationiq location = getAdressinfo(zipcode);
                if(location != null){
                    PreparedStatement updatestatementEstablishmentAdress = connection.prepareStatement("UPDATE establishment_adress SET latitude = ?,longtitude = ?, zipcode = ?, place = ?, streetname = ?, housenumber = ? where establishment_idestablishment = ? and enddate is null");
                    updatestatementEstablishmentAdress.setString(1,location.getLat());
                    updatestatementEstablishmentAdress.setString(2,location.getLon());
                    updatestatementEstablishmentAdress.setString(3,zipcode);
                    updatestatementEstablishmentAdress.setString(4,place);
                    updatestatementEstablishmentAdress.setString(5,streetname);
                    updatestatementEstablishmentAdress.setInt(6,housenumber);
                    updatestatementEstablishmentAdress.setInt(7,establishmentid);
                    boolean establishmentAdresUpdate = super.updateQuery(updatestatementEstablishmentAdress,connection);
                }
            }
            return establishmentupdate;
        }catch (Exception e){
            return false;
        }

    }
    private Locationiq getAdressinfo(String zipcode){
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("https://us1.locationiq.com/v1/search.php?key=pk.0049f642eebaee7ea4d532292e0ece9b&postalcode="+zipcode+"&format=json&countrycode=NL")
                    .method("GET", null)
                    .addHeader("Cookie", "__cfduid=dae8202fffd24f10642c32d3bfb45186d1619104871")
                    .build();
            ResponseBody response = client.newCall(request).execute().body();
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(response.string());
            JSONObject object = (JSONObject) jsonArray.get(0);
            Locationiq location = new Locationiq((String) object.get("place_id"),(String) object.get("lat"),(String) object.get("lon"),(String) object.get("display_name"),(String) object.get("error"));

            return location;
        } catch (IOException e) {
                e.printStackTrace();
                return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }
    }
    @Override
    public int createEstamblishment(String name, int headlocation, int companyid, int ownerid,String zipcode) {
        try{
            Connection connection  = super.getConnection();
            PreparedStatement insertreadstatement = connection.prepareStatement("INSERT INTO establishment(name,headlocation,companies_company_id,establishmentowner) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            insertreadstatement.setString(1,name);
            insertreadstatement.setInt(2,headlocation);
            insertreadstatement.setInt(3,companyid);
            insertreadstatement.setInt(4,ownerid);
            int estamblishmentid = super.executeQueryReturningId(insertreadstatement,connection);
            if(!zipcode.isEmpty()){
                int addressid = this.createEstamblishmentAdres(zipcode,estamblishmentid);
            }
            return estamblishmentid;
        }catch (Exception e){
            return 0;
        }

    }
    public EstablishmentProfile getEstablishmentProfile(int estamblishmentid){
        try {
            Connection connection = super.getConnection();
            PreparedStatement Query = connection.prepareStatement("SELECT " +
                    "es.description , " +
                    "com.companylogo, " +
                    "users.firstname, " +
                    "users.lastname, " +
                    "users.profilepicture," +
                    "es.url," +
                    "es.instagramurl," +
                    "es.linkedinurl," +
                    "es.facebookurl," +
                    "adres.place," +
                    "adres.streetname," +
                    "adres.housenumber," +
                    "adres.zipcode " +
                    "FROM establishment as es " +
                    "join companies as com " +
                    "on com.company_id = es.companies_company_id " +
                    "join webusers users " +
                    "on users.idwebusers = es.establishmentowner " +
                    "join establishment_adress adres " +
                    "on es.idestablishment = adres.establishment_idestablishment " +
                    "and adres.enddate is null " +
                    "where es.idestablishment = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            Query.setInt(1,estamblishmentid);
            ResultSet result = super.executeQuery(Query,connection);
            while (result.next()){
                String description = result.getString("description");
                String companylogo = result.getString("companylogo");
                String firstname = result.getString("firstname");
                String lastname = result.getString("lastname");
                String website = result.getString("url");
                String profilepicture = result.getString("profilepicture");
                String instagramurl = result.getString("instagramurl");
                String linkedinurl = result.getString("linkedinurl");
                String facebookurl = result.getString("facebookurl");
                String place = result.getString("place");
                String streetname = result.getString("streetname");
                int housenumber = result.getInt("housenumber");
                String zipcode = result.getString("zipcode");

                EstablishmentProfile profile = new EstablishmentProfile(
                        description,
                        companylogo,
                        firstname,
                        lastname,
                        profilepicture,
                        website,
                        instagramurl,
                        linkedinurl,
                        facebookurl,
                        place,
                        streetname,
                        housenumber,
                        zipcode
                        );
                return profile;
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }
    public boolean WebUserAcces(int userid, int establishmentid){
        try{

            Connection connection  = super.getConnection();
            PreparedStatement establishmentaccess = connection.prepareStatement("SELECT * FROM swipeyourjob2.Webusers_establishment where webusers_idwebusers = ? and establishment_idestablishment = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            establishmentaccess.setInt(1,userid);
            establishmentaccess.setInt(2,establishmentid);
            ResultSet result = super.executeQuery(establishmentaccess,connection);
            int rowcount = super.getRowCount(result);
            if(rowcount > 0){
                return true;
            }else{
                return false;
            }

        }catch (Exception e){
            return false;
        }
    }
    public EstablishmentList getEstablishmentlistByUser(int userid){
        try{
            Connection connection = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT est.* FROM swipeyourjob2.Webusers_establishment  con  " +
                    "join establishment est " +
                    "on con.establishment_idestablishment = est.idestablishment " +
                    "where webusers_idwebusers =?",ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setInt(1,userid);
            ResultSet result = super.executeQuery(preparedStatement,connection);
            EstablishmentList list = new EstablishmentList();
            while (result.next()){
                int establishmentid         = result.getInt("idestablishment");
                String establishmentName    = result.getString("name");
                EstablishmentItem item      = new EstablishmentItem(establishmentid,establishmentName);
                list.addestablishment(item);
            }
            return list;
        }catch (Exception e){
            return null;
        }
    }
    public boolean WebUsertoEstamblishment(int userid, int estamblishmentid){
        try{
            Connection connection = super.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Webusers_establishment (webusers_idwebusers, establishment_idestablishment) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1,userid);
            preparedStatement.setInt(2,estamblishmentid);
            int returnedid = super.executeQueryReturningId(preparedStatement,connection);
            if(returnedid > 0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}

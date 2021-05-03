package com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.DaoImpl;

import com.Swipeyourjob.Rest_api.dataLayer.DataAccessObjects.BaseDaoMySQL;
import com.Swipeyourjob.Rest_api.dataLayer.InterfacesDao.EstamblishmentDao;
import com.Swipeyourjob.Rest_api.dataLayer.ResponseClasses.Locationiq;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

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
}

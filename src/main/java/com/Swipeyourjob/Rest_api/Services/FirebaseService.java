package com.Swipeyourjob.Rest_api.Services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.*;
import com.google.firebase.cloud.FirestoreClient;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.IOException;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.concurrent.ExecutionException;

import static io.jsonwebtoken.SignatureAlgorithm.RS256;

public class FirebaseService {
    FirebaseApp defaultApp;
    FirebaseAuth defaultAuth;
    Firestore db;
    public FirebaseService (){
        defaultApp = FirebaseApp.initializeApp();
        db = FirestoreClient.getFirestore(defaultApp);
        defaultAuth = FirebaseAuth.getInstance(defaultApp);
    }
    public boolean validateUser(String uid){
        try {
            UserRecord userRecord = defaultAuth.getUser(uid);
            DocumentReference docRef = db.collection("Users").document(userRecord.getUid());
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();
            if (document.exists()) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }


    public void getUid(){
        try{
            ListUsersPage page = defaultAuth.listUsers(null);
            while (page != null) {
                for (ExportedUserRecord user : page.getValues()) {
                    System.out.println("User: " + user.getUid());
                }
                page = page.getNextPage();
            }
        }catch (Exception e){
            System.out.println("test");
        }
    }

}

package com.Swipeyourjob.Rest_api.domain.Authentication;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Passwordservice {
    private static final String SALT = ")#(s-4a_Zs2)r:u8@Q3-kjldfslijfgdsjiogu34ojr09r31oirjfasdlkfjasidfjoieuru98412399wj993rj98w8ejf932r9328jafj9fj9we89jaw9ef8ja9efjjew9afj9weurqefadsfuw9eqru";
    private static final String JWT_SECRET = "79B4BD6CC80E212A8EDB52FBB7BE427891CA622075581961774EA48046AB0FAC4495022F9BBAE2167CAA19D060AE21ABA1B1FA1E4755061A0960C9F2AE037A34=";
    private static final int days   = 15;
    public String hashpassword(String password) {
        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), this.SALT.getBytes(), 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return  Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("deprecation")
    public String generateJWTtoken(WebUser user){

        Date validity = new Date();

        validity.setTime(validity.getTime() + days * 1000 * 60 * 60 * 24);
        String jwttoken = Jwts.builder()
                .setIssuer("Swipeyourjob")
                .setSubject("UserInfo")
                .claim("userid", user.getUserid())
                .claim("Role", user.getRole())
                // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
                .setIssuedAt(new Date())
                // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
                .setExpiration(validity)
                .signWith(
                        SignatureAlgorithm.HS256,JWT_SECRET)
                .compact();
        return jwttoken;
    }
    public Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        try{

            Claims claims = Jwts.parser()
                    .setSigningKey(JWT_SECRET)
                    .parseClaimsJws(jwt).getBody();
            return claims;
        }catch (Exception e){
            return  null;
        }
    }
//    public static boolean validatePassword(char[] password, String goodHash)
//            throws NoSuchAlgorithmException, InvalidKeySpecException
//    {
//        // Decode the hash into its parameters
//        String[] params = goodHash.split(":");
//        int iterations = Integer.parseInt(params[ITERATION_INDEX]);
//        byte[] salt = fromHex(params[SALT_INDEX]);
//        byte[] hash = fromHex(params[PBKDF2_INDEX]);
//        // Compute the hash of the provided password, using the same salt,
//        // iteration count, and hash length
//        byte[] testHash = pbkdf2(password, salt, iterations, hash.length);
//        // Compare the hashes in constant time. The password is correct if
//        // both hashes match.
//        return slowEquals(hash, testHash);
//    }

}

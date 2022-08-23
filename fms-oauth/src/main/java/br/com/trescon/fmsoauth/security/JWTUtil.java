package br.com.trescon.fmsoauth.security;

import java.security.Key;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Component;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import br.com.trescon.fmsoauth.entities.UserAcm;

@Component
public class JWTUtil {

	@Value("${jwt.expiration}")
	private Long expiration;
	
	@Autowired
	private JWKSet jwkSet;
	
	@Autowired
	private JwtEncoder jwtEncoder;
	
	private final static String KEY_ID = "fms"; // trocar para variavel config

    public JWTUtil() {
    }
	
	public String generateToken(UserAcm user) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, JOSEException {
		System.out.println("JWTSET TO STRING");
		System.out.println(jwkSet.toString(false));
		System.out.println("JWTSET TO STRING public only");
		System.out.println(jwkSet.toString(true));
		
		JWK jwk = jwkSet.getKeyByKeyId("fms");
		Key jwkKey = jwkSet.getKeyByKeyId(KEY_ID).getKeyStore().getKey("fms", "123456".toCharArray());
		PrivateKey key = (PrivateKey)jwkKey; 
		Set<String> authorities = new HashSet<String>();
		
		authorities.add("ADMIN");
		authorities.add("USER");
		authorities.add("users:read");
		
		System.out.println(jwkKey.toString());
		System.out.println(key.toString());

		JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder()
			    .subject("admin")
				.claim("user_id", user.getId())
				.claim("user_name", user.getFirstName())
				.claim("authorities", authorities)
				.issuer("http://localhost:8082")
				.expirationTime(new Date(System.currentTimeMillis() + expiration))
			    .build();
		RSAKey keyRSA = (RSAKey) jwk;
		SignedJWT jwtSign = new SignedJWT(
	            new JWSHeader.Builder(JWSAlgorithm.RS256)
	            .keyID(KEY_ID)
	            .type(JOSEObjectType.JWT)
	            .x509CertSHA256Thumbprint(jwk.getX509CertSHA256Thumbprint())
	            //.jwk(jwk.toPublicJWK())
	            .build(),
	            jwtClaims);

		RSASSASigner signer = new RSASSASigner(keyRSA.toPrivateKey());
		jwtSign.sign(signer);
		String token = jwtSign.serialize();
		System.out.println(token);
		return token;
		
	}
}

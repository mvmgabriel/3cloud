package br.com.trescon.fmsoauth.security;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import br.com.trescon.fmsoauth.config.AuthProperties;
import br.com.trescon.fmsoauth.entities.UserAcm;

@Component
public class JWTUtil {

	@Value("${jwt.expiration}")
	private Long expiration;
	
	@Autowired
	private JWKSet jwkSet;
	
	@Autowired
	private AuthProperties authProperties;
	
	private final static String KEY_ID = "fms"; // trocar para variavel config

    public JWTUtil() {
    }
	
	public String generateToken(UserAcm user) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, JOSEException {
		JWK jwk = jwkSet.getKeyByKeyId("fms");
		RSAKey keyRSA = (RSAKey) jwk;
		
		
		//TESTE
		Set<String> authorities = new HashSet<String>();
		authorities.add("ADMIN");
		authorities.add("USER");
		authorities.add("users:read");
		
		JWTClaimsSet jwtClaims = new JWTClaimsSet.Builder()
			    .subject("admin")
				.claim("user_id", user.getId())
				.claim("user_name", user.getFirstName())
				.claim("authorities", authorities)
				.issuer(authProperties.getProviderUri())
				.expirationTime(new Date(System.currentTimeMillis() + expiration))
			    .build();
		
		
		SignedJWT jwtSign = new SignedJWT(
	            new JWSHeader.Builder(JWSAlgorithm.RS256)
	            .keyID(KEY_ID)
	            .type(JOSEObjectType.JWT)
	            .x509CertSHA256Thumbprint(jwk.getX509CertSHA256Thumbprint())
	            .build(),
	            jwtClaims);

		RSASSASigner signer = new RSASSASigner(keyRSA.toPrivateKey());
		jwtSign.sign(signer);
		String token = jwtSign.serialize();
		return token;
		
	}
}

package com.jilit.clxacademics.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.jilit.clxacademics.model.User;
import com.jilit.clxacademics.util.OLTEncryption;

import static com.jilit.clxacademics.model.Constants.ACCESS_TOKEN_VALIDITY_SECONDS;
import static com.jilit.clxacademics.model.Constants.SIGNING_KEY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
//	@Autowired
//	private AuthenticationManager authenticationManager;
	@Autowired
    private OLTEncryption oLTEncryption;
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public Date getCreatedDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getIssuedAt);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);

	}

	public <T> T setTokenExpire(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		// return claimsResolver.apply(claims);
		claims.setExpiration(new Date());
		return claimsResolver.apply(claims);

	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public String generateToken(User user) {
		return doGenerateToken(user.getUsername(), user.getRole());
	}

	// private String doGenerateToken(String subject) {
	//
	// Claims claims = Jwts.claims().setSubject(subject);
	// claims.put("scopes", Arrays.asList(new
	// SimpleGrantedAuthority("ROLE_ADMIN")));
	//
	// return Jwts.builder()
	// .setClaims(claims)
	// .setIssuer("http://devglan.com")
	// .setIssuedAt(new Date(System.currentTimeMillis()))
	// .setExpiration(new Date(System.currentTimeMillis() +
	// ACCESS_TOKEN_VALIDITY_SECONDS*1000))
	// .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
	// .compact();
	// }

	private String doGenerateToken(String subject, String membertype) {

		Claims claims = Jwts.claims().setSubject(subject);
		List<String> role = new ArrayList<>();
		try {
			//if ((oLTEncryption.decode(membertype)).toString().equalsIgnoreCase("A")) {
			if (membertype.equalsIgnoreCase("A")) 
				{
					role.add("ROLE_ADMIN");
			}
			else if (membertype.equalsIgnoreCase("A")) 
			{
				role.add("ROLE_CANDIDATE");
			}
//			} else if ((oLTEncryption.decode(membertype)).toString().equalsIgnoreCase("A")) {
//				role.add("ROLE_ADMIN");
//
//			} else if ((oLTEncryption.decode(membertype)).toString().equalsIgnoreCase("E")) {
//				role.add("ROLE_EMPLOYPEE");
//
//			}
//			else if ((oLTEncryption.decode(membertype)).toString().equalsIgnoreCase("P")) {
//				role.add("ROLE_PARENT");
//
//			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority(role.get(0).toString())));

//		final Authentication authentication = authenticationManager
//				.authenticate(new UsernamePasswordAuthenticationToken(subject,null,Arrays.asList(new SimpleGrantedAuthority(role.get(0).toString()))));
//		
//		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return Jwts.builder().setClaims(claims).setIssuer("http://campuslynx.com")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
				.signWith(SignatureAlgorithm.HS256, SIGNING_KEY).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	// public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
	// final Date created = getCreatedDateFromToken(token);
	// return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
	// && !isTokenExpired(token);
	// }

	// public String refreshToken(String token) {
	// String refreshedToken;
	// try {
	// final Claims claims = getAllClaimsFromToken(token);
	// claims.put(CLAIM_KEY_CREATED, new Date());
	// refreshedToken = generateToken(claims);
	// } catch (Exception e) {
	// refreshedToken = null;
	// }
	// return refreshedToken;
	// }

}

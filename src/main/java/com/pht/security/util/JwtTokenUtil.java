package com.pht.security.util;

import com.pht.base.frame.LoggerFormator;
import com.pht.base.frame.QMENV;
import com.pht.config.utils.meta.FieldMetaUtils;
import com.pht.security.config.JwtAuthenticationTokenFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {
    private static LoggerFormator logger = LoggerFormator.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USUERNAME ="sub";
    private static final String CLAIM_KEY_CREATE_TIME="created";
    private static final String CLAIM_KEY_EXP ="exp";
    @Value("${jwt.security}")
    private String secret;//秘钥
    @Value("${jwt.expiration}")
    private Long expiration;//过去时间
    /**
     * 更具用户信息生成token
     */
    private String getCompSecret(){
        return new StringBuffer(secret).append(QMENV.getCompCode()).toString();
    }
    public  String generateToken(UserDetails userDetails){
        Map<String,Object> claims =new HashMap<>();
        claims.put(CLAIM_KEY_USUERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATE_TIME,new Date());
        return generateToken(claims);
    }
    private  String  generateToken(Map<String,Object> claim){
        return Jwts.builder().setClaims(claim).setExpiration(generateExpirationDate()).signWith(SignatureAlgorithm.HS512,getCompSecret()).compact();
    }
    /**
     * 从token中获取登录用户名
     */
    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    /**
     * 从token中获取JWT中的负载
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(getCompSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            logger.info("JWT格式验证失败:{}", token);
        }
        return claims;
    }
    /**
     * 获取过期时间
     * @return
     */
    private Date generateExpirationDate(){
        return  new Date(System.currentTimeMillis()+expiration*1000);
    }

    /**
     * 验证token是否还有效
     *
     * @param token       客户端传入的token
     * @param userDetails 从数据库中查询出来的用户信息
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
    /**
     * 判断token是否已经失效
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

}

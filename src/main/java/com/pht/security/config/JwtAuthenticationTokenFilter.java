package com.pht.security.config;

import com.pht.common.factory.datasource.DataSourceFactory;
import com.pht.config.frame.QMENV;
import com.pht.config.frame.QMRunTimeContext;
import com.pht.config.frame.UserInfo;
import com.pht.cust.entity.User;
import com.pht.cust.service.UserService;
import com.pht.security.util.JwtTokenUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * 登录验证
 * filter都默认继承OncePerRequestFilte
 * OncePerRequestFilter Filter 保证在一次请求 只执行一次
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${jwt.compHead}")
    private String compHead;
    @Autowired
    private IgnoreUrlConfig ignoreUrlsConfig;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        String authHeader = request.getHeader(this.tokenHeader);
        if(!request.getMethod().equals(HttpMethod.OPTIONS.toString())){//非option请求时需要制定compCode
            String compCode= request.getHeader(this.compHead);
            if(StringUtils.isNotBlank(compCode)){
                if(!DataSourceFactory.getCodes().contains(compCode.toUpperCase())){
                    log.info("当前公司编号不在服务提供范围内|compcode="+compCode+"|当前服务器服务范围="+ StringUtils.join(DataSourceFactory.getCodes(),","));
                    return;
                }
            }else if(StringUtils.isBlank(compCode)){
                compCode=DataSourceFactory.getDefaultServerConfig().getCompCode();
                PathMatcher pathMatcher =new AntPathMatcher();
                List<String> defSourceUrl = ignoreUrlsConfig.getDefSourceUrl();
                Boolean [] pass= {false};
                defSourceUrl.forEach(url->{
                    if(pathMatcher.match(url,request.getRequestURI())){
                        pass[0]=true;
                    }
                });
                if(!pass[0]){
                    log.info("无compCode禁止访问改路径！");
                    return;
                }
            }
            QMENV.setCompCode(compCode.toUpperCase());
        }
        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
            String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
            String username = jwtTokenUtil.getUserNameFromToken(authToken);
            log.info("checking username:{}", username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                    InitThreadUser(userDetails);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    log.info("authenticated user:{}", username);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }

    private void InitThreadUser(UserDetails userDetails ){
        UserInfo userInfo = new UserInfo();
        User user = userService.getUserByUserName(userDetails.getUsername());
        if(user ==null){
            throw new RuntimeException();
        }
        userInfo.userName =user.getUserName();
        userInfo.userCode = user.getCode();
        QMRunTimeContext.setUserInfo(userInfo);
    }
}

package com.tenghen.ireader.net;

import com.chengx.mvp.base.AppConfig;
import com.chengx.mvp.net.HttpEngine;
import com.chengx.mvp.net.RequestParam;
import com.chengx.mvp.net.ResponseCallback;
import com.chengx.mvp.utils.AppUtils;
import com.chengx.mvp.utils.PhoneUtils;
import com.chengx.mvp.utils.SPUtils;
import com.google.gson.reflect.TypeToken;
import com.tenghen.ireader.module.Book;
import com.tenghen.ireader.module.BookDetail;
import com.tenghen.ireader.module.CategoryBook;
import com.tenghen.ireader.module.RankBook;
import com.chengx.mvp.net.WXApiResponse;
import com.tenghen.ireader.module.User;


import java.lang.reflect.Type;
import java.util.List;

/**
 * 作者：chengx
 * 日期：2017/3/2
 * 描述：
 */

public class Api {
    public static final String HOST = "http://115.29.51.167:7777";
    public static final String WX_HOST = "https://api.weixin.qq.com/sns/";

    /*======= 微信接口 =======*/
    public static final String WX_ACCESS_TOKEN = "oauth2/access_token";//通过code获取access_token
    public static final String WX_USER_INFO = "userinfo";//获取用户个人信息（UnionID机制）
    /*=======================*/

    public static final String BOOK_ALL_VIEW_BOOKS =  "/book/allviewbooks";
    public static final String BOOK_RANKING_LIST =  "/book/rankinglist";
    public static final String BOOK_CATEGORY_BOOKS =  "/book/categorybooks";
    public static final String BOOK_SEARCH_BOOKS =  "/book/searchbooks";
    public static final String BOOK_BOOK_KEYWORDS =  "/book/bookkeywords";
    public static final String BOOK_INFO = "/book/info";
    public static final String USER_LOGIN = "/user/login";
    public static final String USER_REGISTER = "/user/register";
    public static final String USER_MY_BOOK_CASE = "/user/mybookcase";
    public static final String USER_MY_CONSUME_RECORD = "/user/myconsumerecord";
    public static final String USER_MY_RECHARGE_RECORD = "/user/myrechargerecord";
    public static final String USER_MY_COMMENT = "/user/mycomment";



    public static void wxGetAccessToken(String appId, String secret, String code,ResponseCallback<WXApiResponse> callback) {
        RequestParam params = new RequestParam();
        params.put("appid",appId);
        params.put("secret",secret);
        params.put("code",code);
        params.put("grant_type","authorization_code");
        HttpEngine.getInstance().wxGet(WX_HOST + WX_ACCESS_TOKEN, params, callback);
    }

    public static void wxGetUserInfo(String accessToken, String openId, ResponseCallback<WXApiResponse> callback) {
        RequestParam params = new RequestParam();
        params.put("access_token",accessToken);
        params.put("openid",openId);
        HttpEngine.getInstance().wxGet(WX_HOST + WX_USER_INFO, params, callback);
    }

    public static void getAllViewBooks(ResponseCallback<List<Book>> callback){
        Type typeOfClass = new TypeToken<List<Book>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_ALL_VIEW_BOOKS, new RequestParam(), typeOfClass, callback);
    }

    public static void getRankingList(int ranking_id,int date_id,int p, ResponseCallback<List<RankBook>> callback){
        RequestParam param = new RequestParam();
        param.put("ranking_id",String.valueOf(ranking_id));
        param.put("date_id",String.valueOf(date_id));
        param.put("p",String.valueOf(p));
        Type typeOfClass = new TypeToken<List<RankBook>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_RANKING_LIST,param,typeOfClass,callback);
    }

    public static void getCategoryBooks(int category_id,int cost,int rate,int sort,int p, ResponseCallback<List<CategoryBook>> callback){
        RequestParam param = new RequestParam();
        param.put("category_id",String.valueOf(category_id));
        param.put("cost",String.valueOf(cost));
        param.put("rate",String.valueOf(rate));
        param.put("sort",String.valueOf(sort));
        param.put("p",String.valueOf(p));
        Type typeOfClass = new TypeToken<List<CategoryBook>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_CATEGORY_BOOKS,param,typeOfClass,callback);
    }

    public static void getSearchBooks(String keyword,int p, ResponseCallback<List<CategoryBook>> callback){
        RequestParam param = new RequestParam();
        param.put("keywords",keyword);
        param.put("p",String.valueOf(p));
        Type typeOfClass = new TypeToken<List<CategoryBook>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_SEARCH_BOOKS,param,typeOfClass,callback);
    }

    public static void getBookKeywords(int p,ResponseCallback<List<String>> callback){
        RequestParam param = new RequestParam();
        param.put("p",String.valueOf(p));
        Type typeOfClass = new TypeToken<List<String>>(){}.getType();
        HttpEngine.getInstance().post(HOST + BOOK_BOOK_KEYWORDS,param,typeOfClass,callback);
    }

    public static void getBookInfo(String bookId,ResponseCallback<BookDetail> callback){
        RequestParam param = new RequestParam();
        param.put("book_id",bookId);
        param.put("user_id",getUserId());
        param.put("token",getToken());
        HttpEngine.getInstance().post(HOST + BOOK_INFO,param, BookDetail.class,callback);
    }

    public static void userLogin(int type,String email,String password,String authId,ResponseCallback<User> callback){
        RequestParam param = new RequestParam();
        param.put("type",String.valueOf(type));
        if (type == 1){
            param.put("email",email);
            param.put("password",password);
        }else {
            param.put("auth_id",authId);
        }
        HttpEngine.getInstance().post(HOST + USER_LOGIN,param, User.class,callback);
    }

    public static void userRegister(int type,String email,String password,String authId,String name,ResponseCallback<User> callback){
        RequestParam param = new RequestParam();
        param.put("type",String.valueOf(type));
        param.put("name",name);
        if (type == 1){
            param.put("email",email);
            param.put("password",password);
        }else {
            param.put("auth_id",authId);
        }
        HttpEngine.getInstance().post(HOST + USER_REGISTER,param, User.class,callback);
    }

    public static void userMyBookCase(int p,ResponseCallback<List<Book>> callback){
        RequestParam param = new RequestParam();
        param.put("p",String.valueOf(p));
        param.put("user_id",getUserId());
        param.put("token",getToken());
        Type typeOfClass = new TypeToken<List<Book>>(){}.getType();
        HttpEngine.getInstance().post(HOST + USER_MY_BOOK_CASE,param,typeOfClass,callback);
    }

    public static void userMyConsumeRecord(int p,ResponseCallback<List<Book>> callback){
        RequestParam param = new RequestParam();
        param.put("p",String.valueOf(p));
        param.put("user_id",getUserId());
        param.put("token",getToken());
        Type typeOfClass = new TypeToken<List<Book>>(){}.getType();
        HttpEngine.getInstance().post(HOST + USER_MY_BOOK_CASE,param,typeOfClass,callback);
    }

    private static String getUserId(){
        SPUtils sp = new SPUtils(AppUtils.getAppContext(), AppConfig.SP_NAME);
        User user = sp.getObject("user", null);
        if (user != null) {
            return user.getUserId();
        }
        return "";
    }

    private static String getToken(){
        SPUtils sp = new SPUtils(AppUtils.getAppContext(), AppConfig.SP_NAME);
        User user = sp.getObject("user", null);
        if (user != null) {
            return user.getToken();
        }
        return "";
    }

}
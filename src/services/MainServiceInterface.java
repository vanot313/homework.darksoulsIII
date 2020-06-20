package services;

import dao.CardPropertiesDao;
import modles.UserAccess;
import request.Answer;
import request.UserLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MainServiceInterface {
    CardPropertiesDao randomCard(CardPropertiesDao cardDao);
    int judgeRandom(int number, int correctNumber);
    UserAccess login(UserLogin login, HttpServletResponse response);
    UserAccess active(HttpServletRequest request);
    int judge(Answer answer );
}

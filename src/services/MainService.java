package services;

import dao.CardPropertiesDao;
import modles.UserAccess;
import request.Answer;
import request.UserLogin;
import util.Tools;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

public class MainService implements MainServiceInterface {

    public MainService(){
        Tools.printClassMessage(this,"init");
    }

    public CardPropertiesDao randomCard(CardPropertiesDao cardDao){
        CardPropertiesDao card = cardDao;
        int random;

        Tools.printClassMessage(this, "" + card.getProperty1());
        Tools.printClassMessage(this, "" + card.getProperty2());
        Tools.printClassMessage(this, "" + card.getProperty3());
        Tools.printClassMessage(this, "" + card.getProperty4());
        Tools.printClassMessage(this, "" + card.getProperty5());
        Tools.printClassMessage(this, "" + card.getProperty6());
        Tools.printClassMessage(this, "" + card.getProperty7());
        Tools.printClassMessage(this, "" + card.getProperty8());


        random = (int)(Math.random()*10);
        if(random == 5)
            card.setProperty1(1-card.getProperty1());
        random = (int)(Math.random()*10);
        if(random == 5)
            card.setProperty2(1-card.getProperty2());
        random = (int)(Math.random()*10);
        if(random == 5)
            card.setProperty3(1-card.getProperty3());
        random = (int)(Math.random()*10);
        if(random == 5)
            card.setProperty4(1-card.getProperty4());
        random = (int)(Math.random()*10);
        if(random == 5)
            card.setProperty5(1-card.getProperty5());
        random = (int)(Math.random()*10);
        if(random == 5)
            card.setProperty6(1-card.getProperty6());
        random = (int)(Math.random()*10);
        if(random == 5)
            card.setProperty7(1-card.getProperty7());
        random = (int)(Math.random()*10);
        if(random == 5)
            card.setProperty8(1-card.getProperty8());

        return card;
    }

    public int judgeRandom(int number, int correctNumber){
        if(number > correctNumber)
            return 2;
        if(number < correctNumber)
            return 1;
        return 0;
    }

    public int judge(Answer answer ) {
        Tools.printClassMessage(this, "judge start");

        int score = 0;

        String ans1 = answer.getQuest1();
        String ans2 = answer.getQuest2();
        String[] ans3 = answer.getQuest3();
        String[] ans4 = answer.getQuest4();
        String ans5 = answer.getQuest5();
        String ans6 = answer.getQuest6();
        String ans7 = answer.getQuest7();
        String ans8 = answer.getQuest8();

        Tools.printClassMessage(this, "1. "+ans1);
        Tools.printClassMessage(this, "2. "+ans2);
        Tools.printClassMessage(this, "3. "+ans3.length);
        Tools.printClassMessage(this, "4. "+ans4[0] + " " +ans4[1]);
        Tools.printClassMessage(this, "5. "+ans5);
        Tools.printClassMessage(this, "6. "+ans6);
        Tools.printClassMessage(this, "7. "+ans7);
        Tools.printClassMessage(this, "8. "+ans8);

        if(ans1.equals("1")){
            score+=10;
        }

        if(ans2.equals("2")){
            score+=10;
        }

        if(ans3.length == 3){
            score+=10;
        }

        if(ans4.length == 2){
            if(ans4[0].equals("2") && ans4[1].equals("3")){
                score+=10;
            }
        }

        if(ans5.equals("2")){
            score+=10;
        }

        if(ans6.equals("3")){
            score+=10;
        }

        if(ans7.equals("风暴管束者")){
            score+=20;
        }

        if(ans8.equals("大家")){
            score+=20;
        }

        return score;
    }

    public UserAccess login(UserLogin login, HttpServletResponse response){
        Tools.printClassMessage(this, "login start");

        String id = login.getId();
        String password = login.getPassword();

        Tools.printClassMessage(this,"id = " + id);
        Tools.printClassMessage(this,"password = " + password);

        if(!id.equals("jxw")){
            return null;
        }
        if(!password.equals("123456")){
            return null;
        }

        UserAccess access = createUserAccess(id);
        response.addCookie(new Cookie("token", access.getToken()));
        Tools.printClassMessage(this, "Create user access.");


        return access;
    }

    public UserAccess active(HttpServletRequest request){
        String token = null;
        Cookie[] cookies = request.getCookies();

        if(cookies == null)
            return null;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("token")) {
                token = cookie.getValue();
                break;
            }
        }

        if(token == null)
            return null;

        Tools.printClassMessage(this,"cookie token = " + token);

        UserAccess access = createUserAccess("jxw");
        access.setToken(token);

        return access;
    }

    private UserAccess createUserAccess(String id){
        UserAccess access = new UserAccess();
        access.setId(id);
        access.setToken(Tools.makeToken());
        return access;
    }
}

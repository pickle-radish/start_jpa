package com.example.jpa.start.jpa.contorller;

import com.example.jpa.start.jpa.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.jpa.start.jpa.contorller.SmsController.generateRandomNumber;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService service;

    @PostMapping("/mail/login")
    public String login(HttpServletResponse res, HttpServletRequest req, Model model) {


        String randomNum = generateRandomNumber();

        service.login(randomNum);


//        StringBuilder strBuilder = new StringBuilder(SMS_MESSAGE_PREFIX).append(randomNum).append(SMS_MESSAGE_SUFFIX);


        req.getSession().setAttribute("mailAuthNo", randomNum);


        return "mailLogin";
    }

    @PostMapping("/user/mail")
    public String mailLogin(HttpServletResponse res, HttpServletRequest request, Model model) {

        String mail = request.getParameter("mail");
        String result = "";

        String rnum = (String) request.getSession().getAttribute("mailAuthNo");

        //성공시
        if (rnum.equals(mail)) {
            result = "success";
//            request.getSession().removeAttribute("ctn");
        } else {
            result = "smsfail";
        }

//        request.getSession().setAttribute("LOGIN.SMS.AUTH.INFO", result);	//SMS 인증 확인정보 세션 저장


        if(result.equals("success")){
            model.addAttribute("result", result);
        }

        return "wellcome";

    }

}

package com.example.jpa.start.jpa.contorller;


import com.example.jpa.start.jpa.dto.UserRequestDTO;
import com.example.jpa.start.jpa.entity.User;
import com.example.jpa.start.jpa.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
//@RequestMapping("/jpa/api/v2/user")
public class SmsController {

    private final SmsService service;


    private final static String SMS_MESSAGE_PREFIX = "[EBS] 개인정보처리시스템 추가인증 휴대폰 인증번호는[";
    private final static String SMS_MESSAGE_SUFFIX = "]입니다.";

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/user/join")
    public String join() {
        return "join";
    }

    @PostMapping("/user/join")
    public String join(HttpServletResponse res, HttpServletRequest req, Model model, UserRequestDTO requestDto) {
        User user = service.join(requestDto);
        return "home";
    }



    @GetMapping("/user/login")
    public String login() {
        return "login";
    }


    @PostMapping("/user/login")
    public String login(HttpServletResponse res, HttpServletRequest req, Model model, String name) throws RestClientException {
        User user = service.login(name);

        req.getSession().setAttribute("name", user.getUserName());
        String cellular = user.getPhone().replaceAll("-", "");	//휴대폰 번호

        String randomNum = generateRandomNumber();
        StringBuilder strBuilder = new StringBuilder(SMS_MESSAGE_PREFIX).append(randomNum).append(SMS_MESSAGE_SUFFIX);


        try {
            System.out.println(strBuilder.toString());
            legacySmsApi(req, cellular, strBuilder.toString(), "15881580");
        } catch (RestClientException rce) {
//            log.error("RestClientException {}", rce.getMessage());
//            throw new RestClientException(rce);
        } catch (Exception e) {
//            log.error("Exception {}", e.getMessage());
        }

        req.getSession().setAttribute("smsAuthNo", randomNum);


        return "smsLogin";
    }

    @PostMapping("/user/sms")
    public String wellcome(HttpServletResponse response, HttpServletRequest request, Model model) {
//        request.getSession().removeAttribute("smsAuthNo");

        String sms = request.getParameter("sms");
        String result = "";

        String rnum = (String) request.getSession().getAttribute("smsAuthNo");

        //성공시
        if (rnum.equals(sms)) {
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

    public static void legacySmsApi(HttpServletRequest request, String cellPhoneNo, String message, String callerPhoneNo) throws RestClientException {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("recipient", cellPhoneNo);
        map.add("from", callerPhoneNo);
        map.add("message", message);

        restTemplate.postForObject("https://about.ebs.co.kr/osp/api/msg/sms/sendpm", map, String.class);
    }

    public static final String generateRandomNumber() {
        java.util.Random r = new java.util.Random();
        int i = 1;
        String str = "";
        while (true) {
            i = r.nextInt(100000);
            if (i > 9999)
                break;
        }
        str = str + i;

        return str;
    }
}

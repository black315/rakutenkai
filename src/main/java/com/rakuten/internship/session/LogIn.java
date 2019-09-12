package com.rakuten.internship.session;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Data
@Component
public class LogIn {

    private Integer userId;


    private Integer v_userId;
}

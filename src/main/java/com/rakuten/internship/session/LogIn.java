package com.rakuten.internship.session;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Data
public class LogIn {
    @Autowired
    private Integer userId;

    @Autowired
    private Integer v_userId;
}

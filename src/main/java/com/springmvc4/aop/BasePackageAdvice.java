package com.springmvc4.aop;

import com.springmvc4.Constants;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class BasePackageAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder ){
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATETIME_INPUT_FORMAT);
        format.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    @ModelAttribute
    public void addConstants(Model model){
        model.addAttribute("dateInputFormat", Constants.DATETIME_INPUT_FORMAT);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest req, Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        String message;
        if(ex instanceof ConstraintViolationException){
            message = "";
            for(ConstraintViolation violation : ((ConstraintViolationException)ex).getConstraintViolations()) {
                if(message.length() > 0)
                    message += "; ";
                message += violation.getMessage();
            }
        } else {
            message = ex.getLocalizedMessage();
        }
        modelAndView.addObject("errorMessage", message);
        //modelAndView.setViewName("errorPage");//cannot name this view 'error' as it conflicts some spring stuff
        //TODO Hack for now ..need to find out more
        modelAndView.setViewName("index");//cannot name this view 'error' as it conflicts some spring stuff
        return modelAndView;
    }

}

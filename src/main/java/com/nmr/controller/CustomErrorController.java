package com.nmr.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    /**
     * handleError() displays specific error pages for different error types.
     * handleError() models the exception as errorMessage to display on the error page.
     *
     * @param request
     * @return
     */
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        model.addAttribute("errorCode", request.getAttribute("javax.servlet.error.status.code"));
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String errorMessage = null;
        if (throwable != null) {
            errorMessage = throwable.getMessage();
        }
        model.addAttribute("errorMessage", errorMessage);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        return "error";
    }

    /**
     * getErrorPath overrides the implemented ErrorController's method to return a custom path to call when an error occurred.
     *
     * @return
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

}

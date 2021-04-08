package com.itchina.common.globalexception;

import com.itchina.common.vo.CommonResopnse;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Date: 2021/4/7 22:50
 * @Desc:
 */
@Controller
public class GlobalExceptionController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    private ErrorAttributes errorAttributes;
    public GlobalExceptionController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public CommonResopnse errorApiHandler(HttpServletRequest request, final Exception ex, final WebRequest req) {
        //ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> attrMap = this.errorAttributes.getErrorAttributes(req, false);
        int status = getStatus(request);
        return CommonResopnse.ofMessage(status, String.valueOf(attrMap.getOrDefault("message", "error")));
    }
    private int getStatus(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            return status;
        }
        return 500;
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
package com.donald.assessment.aop;

import com.donald.assessment.controller.SysLogController;
import com.donald.assessment.pojo.Activity;
import com.donald.assessment.pojo.User;
import com.donald.assessment.service.ActivityService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Donald
 * @data 01/07/2020 15:57
 */
@Component
@Aspect
public class LogAop {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ActivityService activityService;
    private Date startTime;
    private Class executionClass;
    private Method executionMethod;
    /**
     * join point
     */
    @Pointcut("execution(* com.donald.assessment.controller.*.*(..))")
    public void webLog(){
    }

    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        startTime = new Date();
        executionClass = joinPoint.getTarget().getClass();
        if (!executionClass.getName().equals("com.donald.assessment.controller.SysLogController")) {
            String methodName = joinPoint.getSignature().getName();
            Object[] args = joinPoint.getArgs();

            //get method object
            if (args == null || args.length == 0) {
                executionMethod = executionClass.getMethod(methodName);
            } else {
                Class[] classArgs = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    classArgs[i] = args[i].getClass();
                }
                MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
                executionMethod = methodSignature.getMethod();
            }
        }
    }
    @After(value = "webLog()")
    public void doAfter(JoinPoint jp){
        String url = "";
        if (executionClass != null && executionMethod != null && executionClass!= SysLogController.class && !executionMethod.getName().equals("register") && !executionMethod.getName().equals("logout")) {
            url = request.getRequestURL().toString();
            String activityName = getActivityName(url);
            //user
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            String username = "";
            if(null!=user){
                username =  user.getName();
            }
            Activity activity = new Activity();

            activity.setName(activityName);
            System.out.println(username);
            activityService.addActivity(activity,username,startTime);
        }

    }

    public String getActivityName(String url){
        if(url.contains("login")){
            return "Login";
        }else{
            return "View";
        }
    }
}

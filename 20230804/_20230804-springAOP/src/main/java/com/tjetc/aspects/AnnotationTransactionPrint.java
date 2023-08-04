package com.tjetc.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component //交给spring容器管理
@Aspect //表示当前类是切面类 切面=切点+通知
public class AnnotationTransactionPrint {
    //切点: 用途 过滤指定方法，需要切点表达式
    //切点表达式   * com.tjetc.service.*.*(..)
//    从左边起算
//    第一个星号表示方法的任何返回值 （过滤方法中对方法没有限制）
//    com.tjetc.service表示指定包
//    第二个星号 表示任何类 （过滤方法中对类没有限制）
//    第三个星号 表示任何名称的方法
//    (..） 表示对方法参数没有限制（包括方法参数个数和类型都没有限制）0个1个..
    @Pointcut("execution(* com.tjetc.service.*.*(..))")
//    @Pointcut("execution(*  com.tjetc.service.OrderService.add(..))")
//    @Pointcut("execution(*  com.tjetc.service.OrderService.*te(..))")
//    @Pointcut("execution(*  com.tjetc.service.OrderService.*te(String,Integer))")
    private void anyMethod() {}
    //通知
//    四大通知
//    前置通知，执行业务方法之前执行
//    @Before("anyMethod()")
    public void doBefore() {
        System.out.println("前置通知doBefore() called");
    }
//    后置通知：在成功执行业务方法之后执行
//    @AfterReturning("anyMethod()")
    public void doAfterReturning() {
        System.out.println("后置通知doAfterReturning() called");
    }

//    异常通知，在执行业务方法时出现了异常热行异常通知
//    @AfterThrowing("anyMethod()")
    public void doAfterThrowing() {
        System.out.println("异常通知doAfterThrowing() called");
    }

//  最终通知，在执行业务方法成功或者异常，最后都会执行异常通知
//    @After("anyMethod()")
    public void doAfter() {
        System.out.println("最终通知doAfter() called");
    }

//
    @Around("anyMethod()")
    public Object doAround(ProceedingJoinPoint pjp) {
        System.out.println("环绕通知doAround() called");
        try{
//            前置通知
            System.out.println("环绕前置通知.......");
            Object result = pjp.proceed();
//            后置通知
            System.out.println("环绕后置通知.......");
            return result;
        }catch (Throwable e){
//            异常通知
            System.out.println("环绕异常通知.......");
            e.printStackTrace();
            return null;
        }finally {
//            最终通知
            System.out.println("环绕最终通知.......");
        }
    }
}

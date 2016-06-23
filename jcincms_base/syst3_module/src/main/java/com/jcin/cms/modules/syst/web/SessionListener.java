package com.jcin.cms.modules.syst.web;
import javax.servlet.http.HttpSessionEvent;
   
import javax.servlet.http.HttpSessionListener;
   
public class SessionListener implements HttpSessionListener {
  private static int count = 0;
   
  @Override
public void sessionCreated(HttpSessionEvent se) {
    count++;
    System.out.println("session创建：" + new java.util.Date());
  }
   
  @Override
public void sessionDestroyed(HttpSessionEvent se) {
    count--;
    System.out.println("session销毁：" + new java.util.Date());
  }
   
  public static int getCount() {
    return count;
  }
}
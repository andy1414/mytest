package com.mytest.concurrency.chapter2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;

/**
 * Created by admin on 2016/6/8.
 */
public class CountingFactorizer implements Servlet {

    private Long lastNumber;

    private Long[] lastFactors;

    List<Long> result = new ArrayList<Long>();

    private long hits;

    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getCacheHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        Long i = Long.valueOf(servletRequest.getParameter("i"));
        Long[] factors = null;
        synchronized (this) {
            ++hits;
            if (i.equals(lastNumber)) {
                ++cacheHits;
                factors = lastFactors.clone();
            }
        }

//        if (factors == null) {
//            factors = factor(i);
//            synchronized (this) {
//                lastNumber = i;
//                lastFactors = factors.clone();
//            }
//        }
//        encodeIntoRespone(resp, factors);

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    private void fengjie(int n){
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                result.add(Long.valueOf(i));
                fengjie(n/i);
            }
        }
        result.add(Long.valueOf(n));
    }


}

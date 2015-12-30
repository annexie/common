package com.xuliugen.common.filter.encode;

/**
 * Created by xuliugen on 15/10/18.
 */
public class EncodingFilter {//implements Filter {

    //设置的编码方式
//    private String charset = "UTF-8";
//
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response,
//                         FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        if (req.getMethod().equalsIgnoreCase("GET")) {
//            if (!(req instanceof GetRequest)) {
//                req = new GetRequest(req, charset);//处理get请求编码
//            }
//        } else {
//            req.setCharacterEncoding(charset);//处理post请求编码
//        }
//        chain.doFilter(req, response);
//    }
//
//    public void init(FilterConfig fConfig) throws ServletException {
//        String charset = fConfig.getInitParameter("charset");
//        if (charset != null && !charset.isEmpty()) {
//            this.charset = charset;
//        }
//    }
}

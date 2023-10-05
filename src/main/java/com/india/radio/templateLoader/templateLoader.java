//package com.india.radio.templateLoader;
//
//import org.springframework.context.annotation.Bean;
//import org.thymeleaf.templatemode.TemplateMode;
//import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
//
//public class templateLoader {
//
//    @Bean
//    public ClassLoaderTemplateResolver adminTemplate(){
//
//        ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
//        secondaryTemplateResolver.setPrefix("adminTemplates/");
//        secondaryTemplateResolver.setSuffix(".html");
//        secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
//        secondaryTemplateResolver.setCharacterEncoding("UTF-8");
//        secondaryTemplateResolver.setOrder(1);
//        secondaryTemplateResolver.setCheckExistence(true);
//
//        return secondaryTemplateResolver;
//    }
//
//
//    @Bean
//    public ClassLoaderTemplateResolver userTemplate(){
//
//        ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
//        secondaryTemplateResolver.setPrefix("userTemplates/");
//        secondaryTemplateResolver.setSuffix(".html");
//        secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
//        secondaryTemplateResolver.setCharacterEncoding("UTF-8");
//        secondaryTemplateResolver.setOrder(1);
//        secondaryTemplateResolver.setCheckExistence(true);
//
//        return secondaryTemplateResolver;
//    }
//}

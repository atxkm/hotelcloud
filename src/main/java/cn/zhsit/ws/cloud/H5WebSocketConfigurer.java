package cn.zhsit.ws.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


/**
 * Created by Administrator on 2017/10/28.
 */

@Configuration
@EnableWebSocket
public class H5WebSocketConfigurer implements WebSocketConfigurer {

    @Autowired
    H5HandshakeInterceptor interceptor;
    @Autowired
    private H5TextWebSocketHandler h5TextWebSocketHandler;


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//    	String[] allowsOrigins = {"ws://"};
//        registry.addHandler(h5TextWebSocketHandler, "/h5ws").addInterceptors(interceptor).setAllowedOrigins(allowsOrigins);
        registry.addHandler(h5TextWebSocketHandler, "/h5ws").addInterceptors(interceptor).setAllowedOrigins("*");
    }



}

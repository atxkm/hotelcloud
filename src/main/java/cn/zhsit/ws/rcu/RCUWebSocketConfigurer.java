package cn.zhsit.ws.rcu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by Administrator on 2017/10/17.
 */
@Configuration
@EnableWebSocket
public class RCUWebSocketConfigurer implements WebSocketConfigurer {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RCUTextWebSocketHandler rcuTextWebSocketHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(rcuTextWebSocketHandler, "/tofrontdesk");
    }
}

package cn.com.yuanwei.center.component;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import cn.com.yuanwei.center.util.ValidateUtil;

@ServerEndpoint(value = "/websocket/{userId}")
@Component
public class WebSocketComponent {

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    
    /**
     * 发送文本消息
     * @param message
     * @throws IOException
     */
     public static void sendMessage(String message,String userId) throws IOException {
     	WebSocketComponent webSocket = (WebSocketComponent)CacheManager.getInstance().getValue(userId);
     	if(!ValidateUtil.isEmpty(webSocket)){
     		webSocket.getSession().getBasicRemote().sendText(message);
     	}
     	
     }
	
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("userId") String userId) {
        this.session = session;
        CacheManager.getInstance().addOrUpdateCache(userId, this);  //加入map中
    }
    
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam(value="userId") String userId) {
    	CacheManager.getInstance().evictCache(userId);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
    }

    /**
     * 发生错误时调用
     * */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
    
    
}

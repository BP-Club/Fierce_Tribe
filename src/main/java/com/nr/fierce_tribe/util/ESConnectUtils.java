package com.nr.fierce_tribe.util;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

/**
 * Created by Dai.lw on 11/16/2018.
 * ES 连接
 */
public class ESConnectUtils{
    public static final String CLUSTER_NAME = "dlw-es"; //实例名称
    private static final String IP = "127.0.0.1";
    private static final int PORT = 9300;  //端口

    //1.设置集群名称：默认是elasticsearch，并设置client.transport.sniff为true，使客户端嗅探整个集群状态，把集群中的其他机器IP加入到客户端中
    private static Settings esSettings = Settings.builder()

            .put("cluster.name", CLUSTER_NAME) //设置ES实例的名称

            .put("client.transport.sniff", true) //自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中

            .build();

    private static TransportClient client;
    //反射机制创建单例的TransportClient对象
    static {
        try {
            client = new PreBuiltTransportClient(esSettings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(IP), PORT));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    //取得实例
    public static synchronized TransportClient getTransportClient(){
        String CLUSTER_NAME_ES = "dlw-es"; //实例名称
        String ip = "dlw-es";
        int PORT = 9300;  //端口
        Settings esSettings = Settings.builder()

                .put("cluster.name", CLUSTER_NAME_ES) //设置ES实例的名称

                .put("client.transport.sniff", true) //自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中

                .build();
        TransportClient client =null;
        try {
            client = new PreBuiltTransportClient(esSettings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ip), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
}

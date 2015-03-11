/**
 * 一句话描述该类：<br/>
 * @author 黄记新
 * @date 2015-3-11,下午2:57:58
 *
 */
package com.jcin.cms.game;

import java.nio.charset.Charset;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class Server {

	private ServerBootstrap serverBootstrap;
	private EventLoopGroup bossGroup;
	private EventLoopGroup workGroup;

	public Server() {

	}

	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	public Boolean start() {
		serverBootstrap = new ServerBootstrap();
		bossGroup = new NioEventLoopGroup();
		workGroup = new NioEventLoopGroup();
		serverBootstrap.group(bossGroup, workGroup);
		serverBootstrap.channel(NioServerSocketChannel.class);
		serverBootstrap.option(ChannelOption.SO_KEEPALIVE, true);
		serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(
						new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0,
								2, 0, 2));
				ch.pipeline().addLast(new LengthFieldPrepender(2, false));
				ch.pipeline().addLast(new ServerHandler());
			}
		});
		ChannelFuture future;
		try {
			future = serverBootstrap.bind(8000).sync();
			System.err.println("IP地址为：localhost端口为：8000");
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}

}

class ServerHandler implements ChannelInboundHandler {

	@Override
	public void handlerAdded(ChannelHandlerContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void handlerRemoved(ChannelHandlerContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println(ctx.channel().remoteAddress() + "连接成功！");

	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println(ctx.channel().remoteAddress() + "掉线了！");

	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		System.out.println("接收的消息："
				+ ((ByteBuf) msg).toString(Charset.defaultCharset()));

	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.channel().flush();
	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Server---Registered");

	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Server---Unregistered");

	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx)
			throws Exception {
		System.out.println("掉线儿了，你还怎么说话？");

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		System.out.println("异常了哦！");
		cause.printStackTrace();

	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object arg1)
			throws Exception {
		System.out.println("Server---userEventTriggered");
	}

}
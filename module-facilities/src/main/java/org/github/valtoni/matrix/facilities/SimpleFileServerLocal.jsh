import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;
var server = SimpleFileServer.createFileServer(new InetSocketAddress(8080), Path.of(System.getProperty("user.home")), OutputLevel.VERBOSE);
server.start();
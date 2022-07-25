package ae.proctected.covenant.Seleniumautomation.util;

import com.jcraft.jsch.JSchException;
import com.pastdev.jsch.DefaultSessionFactory;
import com.pastdev.jsch.command.CommandRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CommunicationProtocol {

    @Value("${host.machine.api}")
    private String api;

    @Value("${host.communication.port}")
    private Integer port;


    @Value("${host.username}")
    private String username;

    @Value("${host.password}")
    private String password;


    public void powershellSSH(String command) throws JSchException, IOException {
        DefaultSessionFactory defaultSessionFactory = new DefaultSessionFactory(username, api, port);
        defaultSessionFactory.setPassword(password);
        Map props = new HashMap<String, String>();
        props.put("StrictHostKeyChecking", "no");
        defaultSessionFactory.setConfig(props);
        CommandRunner runner = new CommandRunner(defaultSessionFactory);

        runner.execute(command);
        runner.close();

    }
}

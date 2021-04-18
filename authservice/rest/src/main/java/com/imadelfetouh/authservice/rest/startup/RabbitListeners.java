package com.imadelfetouh.authservice.rest.startup;

import com.imadelfetouh.authservice.dal.rabbit.thread.AddUserThread;
import com.imadelfetouh.authservice.dal.rabbit.thread.ChangeRoleThread;
import com.imadelfetouh.authservice.dal.rabbit.thread.DeleteUserThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@WebListener
public class RabbitListeners implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Executor executor = Executors.newScheduledThreadPool(3);

        AddUserThread addUserThread = new AddUserThread();
        executor.execute(addUserThread);

        ChangeRoleThread changeRoleThread = new ChangeRoleThread();
        executor.execute(changeRoleThread);

        DeleteUserThread deleteUserThread = new DeleteUserThread();
        executor.execute(deleteUserThread);
    }
}

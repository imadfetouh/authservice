package com.imadelfetouh.authservice.dal.rabbit.delivercallback;

import com.google.gson.Gson;
import com.imadelfetouh.authservice.dal.configuration.Executer;
import com.imadelfetouh.authservice.dal.configuration.SessionType;
import com.imadelfetouh.authservice.dal.queryexecuter.ChangeRoleExecuter;
import com.imadelfetouh.authservice.model.dto.ChangeRoleDTO;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangeRoleDeliverCallback implements DeliverCallback {

    private final static Logger logger = Logger.getLogger(AddUserDeliverCallback.class.getName());

    private Gson gson;

    public ChangeRoleDeliverCallback() {
        gson = new Gson();
    }

    @Override
    public void handle(String s, Delivery delivery) throws IOException {
        try {
            String json = new String(delivery.getBody(), StandardCharsets.UTF_8);
            ChangeRoleDTO changeRoleDTO = gson.fromJson(json, ChangeRoleDTO.class);

            Executer<Void> executer = new Executer<>(SessionType.WRITE);
            executer.execute(new ChangeRoleExecuter(changeRoleDTO));
        }
        catch (Exception e) {
            logger.log(Level.ALL, e.getMessage());
        }
    }
}

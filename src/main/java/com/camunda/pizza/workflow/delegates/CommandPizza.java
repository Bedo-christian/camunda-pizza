package com.camunda.pizza.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("Save_cmd_serv")
public class CommandPizza implements JavaDelegate {

    Logger logger =  LoggerFactory.getLogger(CommandPizza.class);

    /**
     * @param delegateExecution
     * @throws Exception
     */
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("CHECK TO APPROUVE A COMMANDE CLIENT");
        delegateExecution.setVariable("isAccepted",true);
    }
}

package com.camunda.pizza.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("Send_mail_reject_serv")
public class SendRejectMAil implements JavaDelegate {


    Logger logger = LoggerFactory.getLogger(SendRejectMAil.class);
    /**
     * @param delegateExecution
     * @throws Exception
     */
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("SEND MAIL REJECTED");
    }
}

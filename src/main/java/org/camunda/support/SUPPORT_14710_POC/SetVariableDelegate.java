package org.camunda.support.SUPPORT_14710_POC;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.spin.Spin;
import org.camunda.spin.json.SpinJsonNode;
import org.springframework.stereotype.Component;

/**
 * This is an easy adapter implementation
 * illustrating how a Java Delegate can be used
 * from within a BPMN 2.0 Service Task.
 */
@Component("setVariable")
public class SetVariableDelegate implements JavaDelegate {
 
  private final Logger LOGGER = Logger.getLogger(SetVariableDelegate.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    

      String vars = "{\"B\":\"whatever\"}";
      
      SpinJsonNode spinJsonAB = Spin.JSON(vars);
      execution.setVariable("jsonvar", spinJsonAB);
      
      execution.setVariable("IntVar", new Integer(1));
      execution.setVariable("BoolVar", true);
      execution.setVariable("StringVar", "Hello!");
      execution.setVariable("DateVar", new Date());
      
     // execution.setVariable("ObjectVar", new WhatIsThisObject());
     
      
      execution.setVariable("StringVarToChange", "Hello!");
      
      
      
	  
	  
    LOGGER.info("\n\n  SetVariableDelegate invoked by "
            + "activityName='" + execution.getCurrentActivityName() + "'"
            + ", processInstanceId=" + execution.getProcessInstanceId()
            + ", businessKey=" + execution.getProcessBusinessKey()
            + ", executionId=" + execution.getId()
            + ", variables=" + execution.getVariables()
            + " \n\n");
    
  }

}

package org.camunda.support.SUPPORT_14710_POC;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication("SUPPORT-14710-POC")
public class CamundaApplication {

	private RuntimeService runtimeService;
	
  public static void main(String... args) {
    SpringApplication.run(CamundaApplication.class, args);
  }


	public CamundaApplication(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}
  
	@EventListener
	private void processPostDeploy(PostDeployEvent event) {
		
	  runtimeService.startProcessInstanceByKey(ProcessConstants.PROCESS_DEFINITION_KEY);
	
	}

	 
  
}

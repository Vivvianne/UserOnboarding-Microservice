package com.spa.useronboarding.controllers;


import com.spa.useronboarding.entities.apis.Response;
import com.spa.useronboarding.entities.apis.Request;

import com.spa.useronboarding.services.commonservices.Utilities;
import com.spa.useronboarding.services.MainService;

// import com.spa.useronboarding.repos.UserRepo;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.Valid;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.time.Instant;



@RestController
@RequestMapping("/api/spa/useronboarding")
public class MainController {


    // Class injections:

    @Autowired
    MainService mainService;

    @Autowired
    Utilities utilities;


    // Response injections:

    @Value("${useronboarding.responsecode.internal_exception}")
    private String responsecode_internal_exception="";

    @Value("${useronboarding.responsemsg.failure}")
    private String responsemsg_failure="";

    @Value("${useronboarding.detailedmsg.internal_exception}")
    private String detailedmsg_internal_exception="";





    @PostMapping("/register")
    public Response register(@Valid @RequestBody Request request){


        // Start Timer:

        Instant startTime = Instant.now();

        Response response = new Response();

        String error = "";
    
        utilities.logStart(request.getServiceRequest().getHeader().getRequestRefID().toString(), 
            "register", request.toString());

        HashMap<String, String> mainservice_request = new HashMap<>();
        


        response.setServiceResponse(new Response.ServiceResponse());
        response.getServiceResponse().setHeader(new Response.ServiceResponse.Header());
        response.getServiceResponse().setBody(new Response.ServiceResponse.Body());
        


        try{

            
            mainservice_request.put("request_ref_id", request.getServiceRequest().getHeader().getRequestRefID());
            
            mainservice_request.put("email", request.getServiceRequest().getBody().getData().get(0).getValue().toString());
            mainservice_request.put("first_name", request.getServiceRequest().getBody().getData().get(1).getValue().toString());
            mainservice_request.put("last_name", request.getServiceRequest().getBody().getData().get(2).getValue().toString());
            mainservice_request.put("contact_no", request.getServiceRequest().getBody().getData().get(3).getValue().toString());
            mainservice_request.put("permission_id", request.getServiceRequest().getBody().getData().get(4).getValue().toString());
            mainservice_request.put("password", request.getServiceRequest().getBody().getData().get(5).getValue().toString());

            response = mainService.registerOperation(mainservice_request);




        }catch(Exception e){



            error=e.toString();

            response.getServiceResponse().getHeader().setResponseCode(responsecode_internal_exception);
            response.getServiceResponse().getHeader().setResponseMsg(responsemsg_failure);
            response.getServiceResponse().getHeader().setDetailedMsg(detailedmsg_internal_exception);


        }finally{

            Instant endTime = Instant.now();

            response.getServiceResponse().getHeader().setResponseRefID(request.getServiceRequest().getHeader().getRequestRefID());

            utilities.logEnd(request.getServiceRequest().getHeader().getRequestRefID().toString(), 
                "register", startTime, endTime, request.toString(), response.toString(), error);

        }


        return response;


    }



    @PostMapping("/deregister")
    public Response deregister(@Valid @RequestBody Request request){

        // Start Timer:

        Instant startTime = Instant.now();

        Response response = new Response();

        String error = "";
    
        utilities.logStart(request.getServiceRequest().getHeader().getRequestRefID().toString(), 
            "deregister", request.toString());

        HashMap<String, String> mainservice_request = new HashMap<>();
        

        
        response.setServiceResponse(new Response.ServiceResponse());
        response.getServiceResponse().setHeader(new Response.ServiceResponse.Header());
        response.getServiceResponse().setBody(new Response.ServiceResponse.Body());
        


        try{

            
            mainservice_request.put("request_ref_id", request.getServiceRequest().getHeader().getRequestRefID());
            mainservice_request.put("email", request.getServiceRequest().getBody().getData().get(0).getValue().toString());
    

            response = mainService.unregisterOperation(mainservice_request);




        }catch(Exception e){



            error=e.toString();

            response.getServiceResponse().getHeader().setResponseCode(responsecode_internal_exception);
            response.getServiceResponse().getHeader().setResponseMsg(responsemsg_failure);
            response.getServiceResponse().getHeader().setDetailedMsg(detailedmsg_internal_exception);


        }finally{

            Instant endTime = Instant.now();

            response.getServiceResponse().getHeader().setResponseRefID(request.getServiceRequest().getHeader().getRequestRefID());

            utilities.logEnd(request.getServiceRequest().getHeader().getRequestRefID().toString(), 
                "deregister", startTime, endTime, request.toString(), response.toString(), error);

        }


        return response;


    }






}

package com.spa.useronboarding.services.operations;



import com.spa.useronboarding.services.commonservices.Utilities;

import com.spa.useronboarding.entities.apis.Response;

import com.spa.useronboarding.services.MainService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.time.Instant;


@Service
public class MainserviceImpl implements MainService {


    // Class injections:

    @Autowired
    DBOperations dbOperations;

    @Autowired
    Utilities utilities;



    // Response injections:


    @Value("${useronboarding.responsecode.success}")
    private String responsecode_success="";

    @Value("${useronboarding.responsemsg.success}")
    private String responsemsg_success="";

    @Value("${useronboarding.detailedmsg.success}")
    private String detailedmsg_success="";



    @Value("${useronboarding.responsemsg.failure}")
    private String responsemsg_failure="";



    @Value("${useronboarding.responsecode.email_not_unique}")
    private String responsecode_email_not_unique="";

    @Value("${useronboarding.responsecode.permission_not_exist}")
    private String responsecode_permission_not_exist="";

    @Value("${useronboarding.responsecode.failed_saving_user}")
    private String responsecode_failed_saving_user="";


    @Value("${useronboarding.responsecode.email_not_present}")
    private String responsecode_email_not_present="";

    @Value("${useronboarding.responsecode.failed_removing_user}")
    private String responsecode_failed_removing_user="";

    @Value("${useronboarding.responsecode.internal_exception}")
    private String responsecode_internal_exception="";



    @Value("${useronboarding.detailedmsg.email_not_unique}")
    private String detailedmsg_email_not_unique="";

    @Value("${useronboarding.detailedmsg.permission_not_exist}")
    private String detailedmsg_permission_not_exist="";

    @Value("${useronboarding.detailedmsg.failed_saving_user}")
    private String detailedmsg_failed_saving_user="";


    @Value("${useronboarding.detailedmsg.email_not_present}")
    private String detailedmsg_email_not_present="";

    @Value("${useronboarding.detailedmsg.failed_removing_user}")
    private String detailedmsg_failed_removing_user="";

    @Value("${useronboarding.detailedmsg.internal_exception}")
    private String detailedmsg_internal_exception="";




    public Response registerOperation(HashMap<String, String> request){

        // Start Timer:

        Instant startTime = Instant.now();

        Response response = new Response();

        String error = "";
    
        utilities.logStart(request.get("request_ref_id"), 
            "registerOperation", request.toString());



        response.setServiceResponse(new Response.ServiceResponse());
        response.getServiceResponse().setHeader(new Response.ServiceResponse.Header());
        response.getServiceResponse().setBody(new Response.ServiceResponse.Body());

    
        try{

            

            // Validate if there's an instance in the db with the same email:

            HashMap<String, String> checkEmailisUnique_response = dbOperations.checkEmailisUnique(request);


            if( checkEmailisUnique_response.get("response_status").equals("success") && 
                    checkEmailisUnique_response.get("email_count").equals("0")){


                // Check if the permission exists:

                HashMap<String, String> checkPermissionExists_response = dbOperations.checkPermissionExists(request);


                if(checkPermissionExists_response.get("response_status").equals("success") &&
                    checkPermissionExists_response.get("permission_count").equals("1")){


                    // Save in the database:

                    HashMap<String, String> saveUser_response = dbOperations.saveUser(request);


                    if(saveUser_response.get("response_status").equals("success")){

                        // Success:

                        response.getServiceResponse().getHeader().setResponseCode(responsecode_success);
                        response.getServiceResponse().getHeader().setResponseMsg(responsemsg_success);
                        response.getServiceResponse().getHeader().setDetailedMsg(detailedmsg_success);


                    }else{

                        // Failure to save into database:

                        response.getServiceResponse().getHeader().setResponseCode(responsecode_failed_saving_user);
                        response.getServiceResponse().getHeader().setResponseMsg(responsemsg_failure);
                        response.getServiceResponse().getHeader().setDetailedMsg(detailedmsg_failed_saving_user);

                    }


                }else{

                    // Permission doesn't exist:


                    response.getServiceResponse().getHeader().setResponseCode(responsecode_permission_not_exist);
                    response.getServiceResponse().getHeader().setResponseMsg(responsemsg_failure);
                    response.getServiceResponse().getHeader().setDetailedMsg(detailedmsg_permission_not_exist);


                }


            }else{

                // Email is already in use:

                response.getServiceResponse().getHeader().setResponseCode(responsecode_email_not_unique);
                response.getServiceResponse().getHeader().setResponseMsg(responsemsg_failure);
                response.getServiceResponse().getHeader().setDetailedMsg(detailedmsg_email_not_unique);


            }

            

        }catch(Exception e){

            error=e.toString();


            response.getServiceResponse().getHeader().setResponseCode(responsecode_internal_exception);
            response.getServiceResponse().getHeader().setResponseMsg(responsemsg_failure);
            response.getServiceResponse().getHeader().setDetailedMsg(detailedmsg_internal_exception);


        }finally{

    

            Instant endTime = Instant.now();

            utilities.logEnd(request.get("request_ref_id"), 
                "registerOperation", startTime, endTime, request.toString(), response.toString(), error);

        }


        return response;


    }



    public Response unregisterOperation(HashMap<String, String> request){

        // Start Timer:

        Instant startTime = Instant.now();

        Response response = new Response();

        String error = "";
    
        utilities.logStart(request.get("request_ref_id"), 
            "unregisterOperation", request.toString());



        response.setServiceResponse(new Response.ServiceResponse());
        response.getServiceResponse().setHeader(new Response.ServiceResponse.Header());
        response.getServiceResponse().setBody(new Response.ServiceResponse.Body());

    
        try{

            

            // Validate whether the email exists

            HashMap<String, String> checkEmailisPresent_response = dbOperations.checkEmailisPresent(request);


            if( checkEmailisPresent_response.get("response_status").equals("success") && 
                    checkEmailisPresent_response.get("email_count").equals("1")){


  

                // Remove user from database:

                HashMap<String, String> removeUser_response = dbOperations.removeUser(request);


                if(removeUser_response.get("response_status").equals("success")){

                    // Success:

                    response.getServiceResponse().getHeader().setResponseCode(responsecode_success);
                    response.getServiceResponse().getHeader().setResponseMsg(responsemsg_success);
                    response.getServiceResponse().getHeader().setDetailedMsg(detailedmsg_success);


                }else{

                    // Failure to save into database:

                    response.getServiceResponse().getHeader().setResponseCode(responsecode_failed_removing_user);
                    response.getServiceResponse().getHeader().setResponseMsg(responsemsg_failure);
                    response.getServiceResponse().getHeader().setDetailedMsg(detailedmsg_failed_removing_user);

                }




            }else{

                // Email not present in db

                response.getServiceResponse().getHeader().setResponseCode(responsecode_email_not_present);
                response.getServiceResponse().getHeader().setResponseMsg(responsemsg_failure);
                response.getServiceResponse().getHeader().setDetailedMsg(detailedmsg_email_not_present);


            }

            

        }catch(Exception e){

            error=e.toString();


            response.getServiceResponse().getHeader().setResponseCode(responsecode_internal_exception);
            response.getServiceResponse().getHeader().setResponseMsg(responsemsg_failure);
            response.getServiceResponse().getHeader().setDetailedMsg(detailedmsg_internal_exception);


        }finally{

    

            Instant endTime = Instant.now();

            utilities.logEnd(request.get("request_ref_id"), 
                "unregisterOperation", startTime, endTime, request.toString(), response.toString(), error);

        }


        return response;


    }
}

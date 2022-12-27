package com.spa.useronboarding.services.operations;


import com.spa.useronboarding.services.commonservices.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;



import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.time.Instant;


@Service
public class DBOperations {


	// Class Injections:

    @Autowired
    Utilities utilities;



	// JDBC injections:

	@Autowired
	private JdbcTemplate jdbc;


	public HashMap<String, String> checkEmailisUnique(HashMap<String, String> request){

        // Start Timer:

        Instant startTime = Instant.now();

        String error = "";
    
        utilities.logStart(request.get("request_ref_id"), 
            "checkEmailisUnique", request.toString());


        HashMap<String, String> response = new HashMap<String, String>();



		try{



			String sql = "SELECT count(*) FROM Users WHERE email = ?";


			int count = jdbc.queryForObject( sql, new Object[] { request.get("email") }, Integer.class);


			response.put("response_status", "success");
			response.put("response_description", "Successfully processed query");


			response.put("email_count", String.valueOf(count));


        }catch(Exception e){

            error=e.toString();

			response.put("response_status", "failure");
			response.put("response_description", "Internal Exception");


        }finally{

            Instant endTime = Instant.now();

            utilities.logEnd(request.get("request_ref_id"), 
                "checkEmailisUnique", startTime, endTime, request.toString(), response.toString(), error);

        }


        return response;


	}


	public HashMap<String, String> checkPermissionExists(HashMap<String, String> request){

        // Start Timer:

        Instant startTime = Instant.now();

        String error = "";
    
        utilities.logStart(request.get("request_ref_id"), 
            "checkPermissionExists", request.toString());


        HashMap<String, String> response = new HashMap<String, String>();



		try{


			String sql = "SELECT count(*) FROM Permissions WHERE permission_id = ?";


			int count = jdbc.queryForObject( sql, new Object[] { request.get("permission_id") }, Integer.class);


			response.put("response_status", "success");
			response.put("response_description", "Successfully processed query");


			response.put("permission_count", String.valueOf(count));



        }catch(Exception e){

            error=e.toString();

			response.put("response_status", "failure");
			response.put("response_description", "Internal Exception");


        }finally{

            Instant endTime = Instant.now();

            utilities.logEnd(request.get("request_ref_id"), 
                "checkPermissionExists", startTime, endTime, request.toString(), response.toString(), error);

        }


        return response;

	}


	public HashMap<String, String> saveUser(HashMap<String, String> request){


        // Start Timer:

        Instant startTime = Instant.now();

        String error = "";
    
        utilities.logStart(request.get("request_ref_id"), 
            "saveUser", request.toString());


        HashMap<String, String> response = new HashMap<String, String>();



		try{


			jdbc.update( "insert into Users (email, first_name, last_name, contact_no, permission_id, password) values (?, ?, ?, ?, ?, ?)",
				request.get("email"),
			    request.get("first_name"),
			    request.get("last_name"),
				request.get("contact_no"),
			    request.get("permission_id"),
			    request.get("password")
			    );


			response.put("response_status", "success");
			response.put("response_description", "Successfully saved user to db");



        }catch(Exception e){

            error=e.toString();

			response.put("response_status", "failure");
			response.put("response_description", "Internal Exception");


        }finally{

            Instant endTime = Instant.now();

            utilities.logEnd(request.get("request_ref_id"), 
                "saveUser", startTime, endTime, request.toString(), response.toString(), error);

        }


        return response;



	}


	public HashMap<String, String> checkEmailisPresent(HashMap<String, String> request){

        // Start Timer:

        Instant startTime = Instant.now();

        String error = "";
    
        utilities.logStart(request.get("request_ref_id"), 
            "checkEmailisPresent", request.toString());


        HashMap<String, String> response = new HashMap<String, String>();



		try{


			String sql = "SELECT count(*) FROM Users WHERE email = ?";


			int count = jdbc.queryForObject( sql, new Object[] { request.get("email") }, Integer.class);


			response.put("response_status", "success");
			response.put("response_description", "Successfully processed query");


			response.put("email_count", String.valueOf(count));


        }catch(Exception e){

            error=e.toString();

			response.put("response_status", "failure");
			response.put("response_description", "Internal Exception");


        }finally{

            Instant endTime = Instant.now();

            utilities.logEnd(request.get("request_ref_id"), 
                "checkEmailisPresent", startTime, endTime, request.toString(), response.toString(), error);

        }


        return response;

	}


	public HashMap<String, String> removeUser(HashMap<String, String> request){


        // Start Timer:

        Instant startTime = Instant.now();

        String error = "";
    
        utilities.logStart(request.get("request_ref_id"), 
            "removeUser", request.toString());


        HashMap<String, String> response = new HashMap<String, String>();



		try{


			jdbc.update( "delete from Users where email=?", request.get("email"));


			response.put("response_status", "success");
			response.put("response_description", "Successfully processed query");



        }catch(Exception e){

            error=e.toString();

			response.put("response_status", "failure");
			response.put("response_description", "Internal Exception");


        }finally{

            Instant endTime = Instant.now();

            utilities.logEnd(request.get("request_ref_id"), 
                "removeUser", startTime, endTime, request.toString(), response.toString(), error);

        }


        return response;



	}



	

}

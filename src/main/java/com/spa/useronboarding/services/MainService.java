package com.spa.useronboarding.services;


import com.spa.useronboarding.entities.apis.Response;


import java.util.HashMap;


public interface MainService {
    public Response registerOperation(HashMap<String, String> request);
    public Response  unregisterOperation(HashMap<String, String> request);

}

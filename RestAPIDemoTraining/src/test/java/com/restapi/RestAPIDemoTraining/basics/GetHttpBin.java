package com.restapi.RestAPIDemoTraining.basics;

import io.restassured.RestAssured;

/**
 * First API script
 *
 */
public class GetHttpBin 
{
    public static void main( String[] args )
    {
    	//prettyPrint() is used to print in console - similar to System.out.println()
        RestAssured.get("http://httpbin.org/get").prettyPrint();
        
    }
}

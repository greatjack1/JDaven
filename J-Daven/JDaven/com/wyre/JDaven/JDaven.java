package com.wyre.JDaven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.*;
/**
 * Created by yaakov on 3/12/17.
 */
public class JDaven {
    //The base url for the GoDaven Api
    private String mBaseUrl = "http://godaven.com/db/davenapi.aspx?";
    //The array to hold the minyanim, intialize it to 20 since thats the max amount the api can return
    private minyanim[] mMinyanArray;

    /**
     * This constructor takes a string containing the name of the shul and returns a list of shuls with their minyanim
     *
     * @param shulName The name of the shul to get minyanim for
     *  @throws IOException If the api cannot be accesed
     */
    public JDaven(String shulName) throws IOException {
        processJson(gDApiRetreiver(mBaseUrl + "name=" + shulName));

    }

    /**
     * This constructor takes a string containing the name of the shul and returns a list of shuls with their minyanim
     *
     * @param shulName     The name of the shul to get minyanim for
     * @param numOfResults The amount of results that you want to receive, max of 20
     *                     @throws IOException If the api cannot be accesed
     */
    public JDaven(String shulName, int numOfResults) throws IOException {
        processJson(gDApiRetreiver(mBaseUrl + "name=" + shulName + "&results=" + numOfResults));
    }

    /**
     * This constructor takes a zipcode as a integer and returns a list of shuls near that zipcode and their minyanim
     *
     * @param zipcode The zipcode to get minyanim nearby from
     *                @throws IOException If the api cannot be accesed
     */
    public JDaven(int zipcode) throws IOException {
        processJson(gDApiRetreiver(mBaseUrl + "zip=" + zipcode));
    }

    /**
     * This constructor takes a zipcode as a integer and returns a list of shuls near that zipcode and their minyanim
     *
     * @param zipcode      The zipcode to get minyanim nearby from
     * @param numOfResults The amount of results that you want to receive, max of 20
     *                     @throws IOException If the api cannot be accesed
     */

    public JDaven(int zipcode, int numOfResults) throws IOException {
        processJson(gDApiRetreiver(mBaseUrl + "zip=" + zipcode + "&results=" + numOfResults));
    }

    /**
     * @param latitude  The latitude to get minyanim nearby
     * @param longitude The longitude to get minyanim nearby
     *                  @throws IOException If the api cannot be accesed
     */
    public JDaven(double latitude, double longitude) throws IOException {
        processJson(gDApiRetreiver(mBaseUrl + "lat=" + latitude + "&lon=" + longitude));
    }

    /**
     * @param latitude     The latitude to get minyanim nearby
     * @param longitude    The longitude to get minyanim nearby
     * @param numOfResults The number of results to retreive, max of 20
     *                     @throws IOException If the api cannot be accesed
     */
    public JDaven(double latitude, double longitude, int numOfResults) throws IOException {

        processJson(gDApiRetreiver(mBaseUrl + "lat=" + latitude + "&lon=" + longitude + "&results=" + numOfResults));
    }

    public minyanim[] getMinyanim() {
        return mMinyanArray;
    }

    ;
    /**
     * This method retreives data from the Go Daven Api
     *
     * @param url The Url to request from the Go Daven Api
     * @return The string response from the Go Daven Api
     */
    private String gDApiRetreiver(String url) throws IOException {
        //first remove all spaces for their escape characters in the url string
        url = url.replace(" ", "%20");
        URL gDUrl = new URL(url);
        URLConnection yc = gDUrl.openConnection();
        //use a buffered reader to read the contents from the stream reader
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String jsonResponse = "";
        String tempLine;
        while ((tempLine = in.readLine()) != null)
            jsonResponse += tempLine;
        in.close();

        return jsonResponse;
    }

    /**
     * This method process json that was returned from the Go Daven Api and stores it in the minyanim list
     * Uses gson to process the Json
     * @param jsonToProcess The String containing the json that should be processed
     */
    private void processJson(String jsonToProcess) {
        //cut off the part that makes it an object so that the json becomes an array
        jsonToProcess = jsonToProcess.substring(29);
        jsonToProcess = jsonToProcess.substring(0, jsonToProcess.length() - 2);
        //fix up the json since the api was designed with bugs, make sure there is [ then a {
        jsonToProcess = jsonToProcess.replace("[", "[{");
        jsonToProcess = jsonToProcess.replace("[{{", "[{");
        //create the Gson instance to process the json
        Gson gson = new Gson();
        try {
            mMinyanArray = gson.fromJson(jsonToProcess, minyanim[].class);
        } catch (Exception ex) {
            //set the minyanim array to null to alert the programmer that we werent able to process any minyanim
            mMinyanArray = null;

        }

    }


}





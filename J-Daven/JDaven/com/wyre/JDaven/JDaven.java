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
    private String mBaseUrl = "http://godaven.com/db/davenapi.aspx?";
    private minyanim[] mMinyanArray = new minyanim[20];

    /**
     * This constructor takes a string containing the name of the shul and returns a list of shuls with their minyanim
     *
     * @param shulName The name of the shul to get minyanim for
     */
    public JDaven(String shulName) throws IOException {
        processJson(gDApiRetreiver(mBaseUrl + "name=" + shulName));

    }

    /**
     * This constructor takes a string containing the name of the shul and returns a list of shuls with their minyanim
     *
     * @param shulName     The name of the shul to get minyanim for
     * @param numOfResults The amount of results that you want to receive, max of 20
     */
    public JDaven(String shulName, int numOfResults) throws IOException {
        processJson(gDApiRetreiver(mBaseUrl + "name=" + shulName + "&results=" + numOfResults));
    }

    /**
     * This constructor takes a zipcode as a integer and returns a list of shuls near that zipcode and their minyanim
     *
     * @param zipcode The zipcode to get minyanim nearby from
     */
    public JDaven(int zipcode) throws IOException {
        processJson(gDApiRetreiver(mBaseUrl + "zip=" + zipcode));
    }

    /**
     * This constructor takes a zipcode as a integer and returns a list of shuls near that zipcode and their minyanim
     *
     * @param zipcode      The zipcode to get minyanim nearby from
     * @param numOfResults The amount of results that you want to receive, max of 20
     */

    public JDaven(int zipcode, int numOfResults) throws IOException {
        processJson(gDApiRetreiver(mBaseUrl + "zip=" + zipcode + "&results=" + numOfResults));
    }

    /**
     * @param latitude  The latitude to get minyanim nearby
     * @param longitude The longitude to get minyanim nearby
     */
    public JDaven(double latitude, double longitude) throws IOException {
        processJson(gDApiRetreiver(mBaseUrl + "lat=" + latitude + "&lon=" + longitude));
    }

    /**
     * @param latitude     The latitude to get minyanim nearby
     * @param longitude    The longitude to get minyanim nearby
     * @param numOfResults The number of results to retreive, max of 20
     */
    public JDaven(double latitude, double longitude, int numOfResults) throws IOException {

        processJson(gDApiRetreiver(mBaseUrl + "lat=" + latitude + "&lon=" + longitude + "&results=" + numOfResults));
    }

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
        jsonToProcess = jsonToProcess.substring(29);
        jsonToProcess = jsonToProcess.substring(0, jsonToProcess.length() - 2);
        jsonToProcess = jsonToProcess.replace("[", "[{");
        jsonToProcess = jsonToProcess.replace("[{{", "[{");
        System.out.println(jsonToProcess);
        Gson gson = new Gson();
        minyanim[] min = gson.fromJson(jsonToProcess, minyanim[].class);
        System.out.println(min[0].getCity());
    }


}




